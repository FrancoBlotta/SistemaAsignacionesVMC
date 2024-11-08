package com.SistemaAsignacionesVMC.application.interactor.task;

import com.SistemaAsignacionesVMC.application.port.out.CollaboratorDbPort;
import com.SistemaAsignacionesVMC.application.port.out.TaskDbPort;
import com.SistemaAsignacionesVMC.application.port.out.TaskHistoryDbPort;
import com.SistemaAsignacionesVMC.domain.dtos.CollaboratorDTO;
import com.SistemaAsignacionesVMC.domain.dtos.EventDTO;
import com.SistemaAsignacionesVMC.domain.dtos.TaskDTO;
import com.SistemaAsignacionesVMC.domain.dtos.TaskHistoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public class TaskHistoryManager {

  private final TaskHistoryDbPort taskHistoryDbPort;

  private final CollaboratorDbPort collaboratorDbPort;

  private final TaskDbPort taskDbPort;

  /**
   * Fill task histories.
   * @param event
   * @return
   */
  @Transactional(readOnly = true)
  public List<TaskHistoryDTO> fillTTaskHistories(EventDTO event) {
    return taskHistoryDbPort.getAllTaskHistoriesByEventId(event.getId())
      .stream()
      .map(savedTaskHistory -> {
        TaskDTO savedTask = taskDbPort.findTaskById(savedTaskHistory.getTask().getId())
          .orElseThrow(() -> new RuntimeException("Task with ID " + savedTaskHistory.getTask().getId() + " does not exist"));
        CollaboratorDTO collaborator = collaboratorDbPort.findCollaboratorById(savedTaskHistory.getCollaborator().getId())
          .orElseThrow(() -> new RuntimeException("Collaborator with ID " + savedTaskHistory.getCollaborator().getId() + " does not exist"));
        return savedTaskHistory.withTask(savedTask).withCollaborator(collaborator);
      }).toList();
  }
}
