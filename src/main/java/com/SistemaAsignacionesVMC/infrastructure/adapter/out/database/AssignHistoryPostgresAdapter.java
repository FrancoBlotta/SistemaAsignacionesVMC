package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database;

import com.SistemaAsignacionesVMC.application.port.out.AssignHistoryDbPort;
import com.SistemaAsignacionesVMC.domain.dtos.AssignmentHistoryDTO;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.AssignmentHistoryEntity;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.converter.AssignHistoryEntityConverter;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.repositories.AssignHistoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(staticName = "of")
public class AssignHistoryPostgresAdapter implements AssignHistoryDbPort {

  private final AssignHistoryRepository assignHistoryRepository;

  @Override
  public void deleteAllAssignHistoriesByCollaboratorId(Long collaboratorId) {
    assignHistoryRepository.deleteAllByCollaboratorId(collaboratorId);
  }

  @Override
  public void deleteAssignHistoryById(Long assignHistoryId) {
    assignHistoryRepository.deleteById(assignHistoryId);
  }

  @Override
  public Optional<AssignmentHistoryDTO> findAssignHistoryById(Long assignHistoryId) {
    return assignHistoryRepository.findById(assignHistoryId)
      .map(AssignHistoryEntityConverter::convert);
  }

  @Override
  public List<AssignmentHistoryDTO> getAllAssignHistories() {
    return assignHistoryRepository.findAll()
      .stream()
      .map(AssignHistoryEntityConverter::convert)
      .toList();
  }

  @Override
  public List<AssignmentHistoryDTO> getAllAssignHistoriesByEventId(Long eventId) {
    return assignHistoryRepository.findAllByEventId(eventId)
      .stream()
      .map(AssignHistoryEntityConverter::convert)
      .toList();
  }

  @Override
  public void saveAssignHistory(AssignmentHistoryDTO assignmentHistory) {
    AssignmentHistoryEntity assignmentHistoryEntity = AssignHistoryEntityConverter.convert(assignmentHistory);
    assignHistoryRepository.save(assignmentHistoryEntity);
  }

  @Override
  public void updateAssignHistory(AssignmentHistoryDTO assignmentHistory) {
    saveAssignHistory(assignmentHistory);
  }
}
