package com.SistemaAsignacionesVMC.application.port.in;

import com.SistemaAsignacionesVMC.domain.dtos.CollaboratorDTO;

import java.util.Date;
import java.util.List;

public interface CollaboratorUseCase {
  void createCollaborator(CollaboratorDTO collaborator);

  void deleteCollaboratorById(Long collaboratorId);

  CollaboratorDTO findCollaboratorById(Long collaboratorId);

  List<CollaboratorDTO> getAllCollaborators();

  List<CollaboratorDTO> getCollaboratorsAvailableOnDate(Date date);

  void updateCollaborator(CollaboratorDTO collaborator, Long collaboratorId);
}