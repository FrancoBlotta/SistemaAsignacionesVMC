package com.SistemaAsignacionesVMC.application.port.in;

import com.SistemaAsignacionesVMC.domain.dtos.TaskHistoryDTO;

import java.util.List;

public interface TaskHistoryUseCase {
  void createTaskHistory(TaskHistoryDTO taskHistory);

  void deleteTaskHistoryById(Long taskHistoryId);

  TaskHistoryDTO findTaskHistoryById(Long taskHistoryId);

  List<TaskHistoryDTO> getAllTaskHistories();

  void updateTaskHistory(TaskHistoryDTO taskHistory);
}
