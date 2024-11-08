package com.SistemaAsignacionesVMC.domain.converter.task;

import com.SistemaAsignacionesVMC.domain.dtos.TaskDTO;
import com.SistemaAsignacionesVMC.domain.payload.Task;

public class TaskConverter {
  public static Task convert(TaskDTO task) {
    return Task.builder()
      .id(task.getId())
      .taskName(task.getTaskName())
      .build();
  }
}
