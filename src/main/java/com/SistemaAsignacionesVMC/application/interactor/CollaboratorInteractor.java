package com.SistemaAsignacionesVMC.application.interactor;

import com.SistemaAsignacionesVMC.application.interactor.capacity.CollabCapacitiesManager;
import com.SistemaAsignacionesVMC.application.interactor.task.TaskManager;
import com.SistemaAsignacionesVMC.application.port.in.CollaboratorUseCase;
import com.SistemaAsignacionesVMC.application.port.out.AssignHistoryDbPort;
import com.SistemaAsignacionesVMC.application.port.out.CollabCapacityDbPort;
import com.SistemaAsignacionesVMC.application.port.out.CollaboratorDbPort;
import com.SistemaAsignacionesVMC.application.port.out.TaskHistoryDbPort;
import com.SistemaAsignacionesVMC.domain.dtos.CollaboratorDTO;
import lombok.Builder;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Slf4j
@Builder
public class CollaboratorInteractor implements CollaboratorUseCase {

  @NonNull
  private final CollaboratorDbPort collaboratorDbPort;

  @NonNull
  private final CollabCapacityDbPort capacityDbPort;

  @NonNull
  private final AssignHistoryDbPort assignHistoryDbPort;

  @NonNull
  private final TaskHistoryDbPort taskHistoryDbPort;

  @NonNull
  private final CollabCapacitiesManager capacityManager;

  @NonNull
  private final TaskManager taskManager;

  @Transactional
  @Override
  public void createCollaborator(CollaboratorDTO collaborator) {
    CollaboratorDTO savedCollaborator = collaboratorDbPort.saveCollaborator(collaborator);
    capacityManager.createCollabCapacities(collaborator.getTasks(), savedCollaborator.getId());
  }

  @Transactional
  @Override
  public void deleteCollaboratorById(Long collaboratorId) {
    collaboratorDbPort.findCollaboratorById(collaboratorId)
      .ifPresentOrElse(collaborator -> {
          capacityDbPort.deleteAllByCollaboratorId(collaboratorId);
          assignHistoryDbPort.deleteAllAssignHistoriesByCollaboratorId(collaboratorId);
          taskHistoryDbPort.deleteAllTaskHistoriesByCollaboratorId(collaboratorId);
          collaboratorDbPort.deleteCollaboratorById(collaboratorId);
        }, () -> {
          log.error("Collaborator with ID {} does not exist", collaboratorId);
          throw new RuntimeException("Collaborator with ID " + collaboratorId + " does not exist");
        }
      );
  }

  @Transactional
  @Override
  public CollaboratorDTO findCollaboratorById(Long collaboratorId) {
    return collaboratorDbPort.findCollaboratorById(collaboratorId)
      .map(collaboratorDTO -> collaboratorDTO
        .withTasks(taskManager.getTasksByCollaboratorIdAndCapacities(collaboratorId)))
      .orElseThrow(() -> new RuntimeException("Collaborator with ID " + collaboratorId + " does not exist"));
  }

  @Transactional
  @Override
  public List<CollaboratorDTO> getAllCollaborators() {
    return collaboratorDbPort.getAllCollaborators()
      .stream()
      .map(collaboratorDTO -> collaboratorDTO
        .withTasks(taskManager.getTasksByCollaboratorIdAndCapacities(collaboratorDTO.getId())))
      .toList();
  }

  @Transactional
  @Override
  public List<CollaboratorDTO> getCollaboratorsAvailableOnDate(Date date) {
    return collaboratorDbPort.getCollaboratorsWhoAreActiveOnTheDate(date)
      .stream()
      .map(collaboratorDTO -> collaboratorDTO
        .withTasks(taskManager.getTasksByCollaboratorIdAndCapacities(collaboratorDTO.getId())))
      .toList();
  }

  @Transactional
  @Override
  public void updateCollaborator(CollaboratorDTO collaborator, Long collaboratorId) {
    collaboratorDbPort.findCollaboratorById(collaboratorId)
      .orElseThrow(() -> new RuntimeException("Collaborator with ID " + collaboratorId + " does not exist"));
    capacityDbPort.deleteAllByCollaboratorId(collaboratorId);
    collaboratorDbPort.updateCollaborator(collaborator.withId(collaboratorId));
    capacityManager.createCollabCapacities(collaborator.getTasks(), collaboratorId);
  }
}
