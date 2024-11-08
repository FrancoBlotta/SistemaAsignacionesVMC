package com.SistemaAsignacionesVMC.application.port.out;

import com.SistemaAsignacionesVMC.domain.dtos.TaskHistoryDTO;

import java.util.List;
import java.util.Optional;

public interface TaskHistoryDbPort {
  void deleteAllTaskHistoriesByCollaboratorId(Long collaboratorId);

  void deleteTaskHistoryById(Long taskHistoryId);

  Optional<TaskHistoryDTO> findTaskHistoryById(Long taskHistoryId);

  List<TaskHistoryDTO> getAllTaskHistories();

  List<TaskHistoryDTO> getAllTaskHistoriesByEventId(Long eventId);

  void saveTaskHistory(TaskHistoryDTO taskHistory);

  void updateTaskHistory(TaskHistoryDTO taskHistory);
}
