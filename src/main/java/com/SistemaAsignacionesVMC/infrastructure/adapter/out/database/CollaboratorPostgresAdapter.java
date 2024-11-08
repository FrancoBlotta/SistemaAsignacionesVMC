package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database;

import com.SistemaAsignacionesVMC.application.port.out.CollaboratorDbPort;
import com.SistemaAsignacionesVMC.domain.dtos.CollaboratorDTO;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.CollaboratorEntity;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.converter.CollaboratorEntityConverter;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.repositories.CollaboratorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor(staticName = "of")
public class CollaboratorPostgresAdapter implements CollaboratorDbPort {

  private final CollaboratorRepository collaboratorRepository;

  @Override
  public void deleteCollaboratorById(Long collaboratorId) {
    collaboratorRepository.deleteById(collaboratorId);
  }

  @Override
  public Optional<CollaboratorDTO> findCollaboratorById(Long collaboratorId) {
    return collaboratorRepository.findById(collaboratorId)
      .map(CollaboratorEntityConverter::convert);
  }

  @Override
  public List<CollaboratorDTO> getAllCollaborators() {
    return collaboratorRepository.findAll()
      .stream()
      .map(CollaboratorEntityConverter::convert)
      .collect(Collectors.toList());
  }

  @Override
  public List<CollaboratorDTO> getCollaboratorsWhoAreActiveOnTheDate(Date date) {
    return collaboratorRepository.findAllCollaboratorsAvailableOnDate(date)
      .stream()
      .map(CollaboratorEntityConverter::convert)
      .collect(Collectors.toList());
  }

  @Override
  public CollaboratorDTO saveCollaborator(CollaboratorDTO collaborator) {
    CollaboratorEntity collaboratorEntity = CollaboratorEntityConverter.convert(collaborator);
    return CollaboratorEntityConverter.convert(collaboratorRepository.save(collaboratorEntity));
  }

  @Override
  public void updateCollaborator(CollaboratorDTO collaborator) {
    saveCollaborator(collaborator);
  }
}
