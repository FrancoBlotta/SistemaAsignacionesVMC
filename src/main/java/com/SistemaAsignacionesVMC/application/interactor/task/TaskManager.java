package com.SistemaAsignacionesVMC.application.interactor.task;

import com.SistemaAsignacionesVMC.application.port.out.CollabCapacityDbPort;
import com.SistemaAsignacionesVMC.application.port.out.TaskDbPort;
import com.SistemaAsignacionesVMC.domain.dtos.CollaboratorCapacityDTO;
import com.SistemaAsignacionesVMC.domain.dtos.TaskDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class TaskManager {

  private final TaskDbPort taskDbPort;

  private final CollabCapacityDbPort capacityDbPort;

  /**
   * Get tasks by collaborator ID and capacities.
   * @param collaboratorId
   * @return
   */
  @Transactional(readOnly = true)
  public List<TaskDTO> getTasksByCollaboratorIdAndCapacities(Long collaboratorId) {
    return capacityDbPort.getAllCollabCapacitiesByCollabId(collaboratorId).stream()
      .map(CollaboratorCapacityDTO::getTaskId)
      .map(taskId -> taskDbPort.findTaskById(taskId)
        .orElseThrow(() -> new RuntimeException("Task with ID " + taskId + " does not exist")))
      .toList();
  }
}
