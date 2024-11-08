package com.SistemaAsignacionesVMC.application.interactor.capacity;


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
public class CollabCapacitiesManager {

  private final TaskDbPort taskDbPort;

  private final CollabCapacityDbPort capacityDbPort;

  /**
   * Create collaborator capacities.
   * @param tasks
   * @param collaboratorId
   */
  @Transactional
  public void createCollabCapacities(List<TaskDTO> tasks, Long collaboratorId) {
    tasks.forEach(task -> capacityDbPort
      .saveCollabCapacity(CollaboratorCapacityDTO.builder()
        .collaboratorId(collaboratorId)
        .taskId(taskDbPort.findTaskById(task.getId())
          .orElseThrow(() -> new RuntimeException("Task with ID " + task.getId() + " does not exist"))
          .getId())
        .build()));
  }
}
