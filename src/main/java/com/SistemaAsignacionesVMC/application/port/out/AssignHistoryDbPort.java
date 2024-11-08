package com.SistemaAsignacionesVMC.application.port.out;

import com.SistemaAsignacionesVMC.domain.dtos.AssignmentHistoryDTO;

import java.util.List;
import java.util.Optional;

public interface AssignHistoryDbPort {
  void deleteAllAssignHistoriesByCollaboratorId(Long collaboratorId);

  void deleteAssignHistoryById(Long assignHistoryId);

  Optional<AssignmentHistoryDTO> findAssignHistoryById(Long assignHistoryId);

  List<AssignmentHistoryDTO> getAllAssignHistories();

  List<AssignmentHistoryDTO> getAllAssignHistoriesByEventId(Long eventId);

  void saveAssignHistory(AssignmentHistoryDTO assignmentHistory);

  void updateAssignHistory(AssignmentHistoryDTO assignmentHistory);
}
