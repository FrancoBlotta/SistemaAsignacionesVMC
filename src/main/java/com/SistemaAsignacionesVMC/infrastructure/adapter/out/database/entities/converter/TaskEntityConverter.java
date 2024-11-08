package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.converter;

import com.SistemaAsignacionesVMC.domain.dtos.TaskDTO;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.TaskEntity;

public class TaskEntityConverter {
  public static TaskDTO convert(TaskEntity task) {
    return TaskDTO.builder()
      .id(task.getId())
      .taskName(task.getTaskName())
      .build();
  }

  public static TaskEntity convert(TaskDTO task) {
    return TaskEntity.builder()
      .id(task.getId())
      .taskName(task.getTaskName())
      .build();
  }
}
