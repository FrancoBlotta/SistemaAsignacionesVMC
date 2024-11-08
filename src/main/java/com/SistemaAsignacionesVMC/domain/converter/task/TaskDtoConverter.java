package com.SistemaAsignacionesVMC.domain.converter.task;

import com.SistemaAsignacionesVMC.domain.dtos.TaskDTO;
import com.SistemaAsignacionesVMC.domain.payload.Task;

public class TaskDtoConverter {
  public static TaskDTO convert(Task task) {
    return TaskDTO.builder()
      .id(task.getId())
      .taskName(task.getTaskName())
      .build();
  }
}
