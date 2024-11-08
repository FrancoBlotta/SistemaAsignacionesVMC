package com.SistemaAsignacionesVMC.application.port.in;

import com.SistemaAsignacionesVMC.domain.dtos.AssignmentHistoryDTO;

import java.util.List;

public interface AssignHistoryUseCase {
  void createAssignHistory(AssignmentHistoryDTO assignmentHistory);

  void deleteAssignHistoryById(Long assignHistoryId);

  AssignmentHistoryDTO findTaskAssignHistoryId(Long assignHistoryId);

  List<AssignmentHistoryDTO> getAllAssignHistories();

  void updateAssignHistory(AssignmentHistoryDTO assignmentHistory);
}
