package com.SistemaAsignacionesVMC.application.port.in;

import com.SistemaAsignacionesVMC.domain.dtos.TaskDTO;

import java.util.List;

public interface TaskUseCase {
  TaskDTO findTaskById(Long taskId);

  List<TaskDTO> getAllTasks();
}
