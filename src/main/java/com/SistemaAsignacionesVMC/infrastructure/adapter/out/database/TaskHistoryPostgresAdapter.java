package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database;

import com.SistemaAsignacionesVMC.application.port.out.TaskHistoryDbPort;
import com.SistemaAsignacionesVMC.domain.dtos.TaskHistoryDTO;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.TaskHistoryEntity;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.converter.TaskHistoryEntityConverter;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.repositories.TaskHistoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor(staticName = "of")
public class TaskHistoryPostgresAdapter implements TaskHistoryDbPort {

  private final TaskHistoryRepository taskHistoryRepository;

  @Override
  public void deleteAllTaskHistoriesByCollaboratorId(Long collaboratorId) {
    taskHistoryRepository.deleteAllByCollaboratorId(collaboratorId);
  }

  @Override
  public void deleteTaskHistoryById(Long taskHistoryId) {
    taskHistoryRepository.deleteById(taskHistoryId);
  }

  @Override
  public Optional<TaskHistoryDTO> findTaskHistoryById(Long taskHistoryId) {
    return taskHistoryRepository.findById(taskHistoryId)
      .map(TaskHistoryEntityConverter::convert);
  }

  @Override
  public List<TaskHistoryDTO> getAllTaskHistories() {
    return taskHistoryRepository.findAll()
      .stream()
      .map(TaskHistoryEntityConverter::convert)
      .collect(Collectors.toList());
  }

  @Override
  public List<TaskHistoryDTO> getAllTaskHistoriesByEventId(Long eventId) {
    return taskHistoryRepository.findAllByEventId(eventId)
      .stream()
      .map(TaskHistoryEntityConverter::convert)
      .collect(Collectors.toList());
  }

  @Override
  public void saveTaskHistory(TaskHistoryDTO taskHistory) {
    TaskHistoryEntity taskHistoryEntity = TaskHistoryEntityConverter.convert(taskHistory);
    taskHistoryRepository.save(taskHistoryEntity);
  }

  @Override
  public void updateTaskHistory(TaskHistoryDTO taskHistory) {
    saveTaskHistory(taskHistory);
  }
}
