package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database;

import com.SistemaAsignacionesVMC.application.port.out.TaskDbPort;
import com.SistemaAsignacionesVMC.domain.dtos.TaskDTO;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.TaskEntity;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.converter.TaskEntityConverter;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor(staticName = "of")
public class TaskPostgresAdapter implements TaskDbPort {

  private final TaskRepository taskRepository;

  @Override
  public void deleteTaskById(Long taskId) {
    taskRepository.deleteById(taskId);
  }

  @Override
  public Optional<TaskDTO> findTaskById(Long taskId) {
    return taskRepository.findById(taskId)
      .map(TaskEntityConverter::convert);
  }

  @Override
  public List<TaskDTO> getAllTasks() {
    return taskRepository.findAll()
      .stream()
      .map(TaskEntityConverter::convert)
      .collect(Collectors.toList());
  }

  @Override
  public void saveTask(TaskDTO task) {
    TaskEntity taskEntity = TaskEntityConverter.convert(task);
    taskRepository.save(taskEntity);
  }

  @Override
  public void updateTask(TaskDTO task) {
    saveTask(task);
  }
}
