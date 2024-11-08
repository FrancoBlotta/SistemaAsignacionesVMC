package com.SistemaAsignacionesVMC.application.port.out;

import com.SistemaAsignacionesVMC.domain.dtos.CollaboratorDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CollaboratorDbPort {
  void deleteCollaboratorById(Long collaboratorId);

  Optional<CollaboratorDTO> findCollaboratorById(Long collaboratorId);

  List<CollaboratorDTO> getAllCollaborators();

  List<CollaboratorDTO> getCollaboratorsWhoAreActiveOnTheDate(Date date);

  CollaboratorDTO saveCollaborator(CollaboratorDTO collaborator);

  void updateCollaborator(CollaboratorDTO collaborator);
}
