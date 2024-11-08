package com.SistemaAsignacionesVMC.application.port.out;

import com.SistemaAsignacionesVMC.domain.dtos.TaskDTO;

import java.util.List;
import java.util.Optional;

public interface TaskDbPort {
  void deleteTaskById(Long taskId);

  Optional<TaskDTO> findTaskById(Long taskId);

  List<TaskDTO> getAllTasks();

  void saveTask(TaskDTO task);

  void updateTask(TaskDTO task);
}
