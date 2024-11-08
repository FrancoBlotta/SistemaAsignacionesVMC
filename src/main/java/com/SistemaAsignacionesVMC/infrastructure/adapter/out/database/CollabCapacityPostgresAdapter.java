package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database;

import com.SistemaAsignacionesVMC.application.port.out.CollabCapacityDbPort;
import com.SistemaAsignacionesVMC.domain.dtos.CollaboratorCapacityDTO;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.CollaboratorCapacityEntity;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.converter.CollabCapacityEntityConverter;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.repositories.CollabCapacityRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(staticName = "of")
public class CollabCapacityPostgresAdapter implements CollabCapacityDbPort {

  private final CollabCapacityRepository collabCapacityRepository;

  @Override
  public void deleteAllByCollaboratorId(Long collaboratorId) {
    collabCapacityRepository.deleteAllByCollaboratorId(collaboratorId);
  }

  @Override
  public void deleteCollabCapacityById(Long collabCapacityId) {
    collabCapacityRepository.deleteAllByCollaboratorId(collabCapacityId);
  }

  @Override
  public Optional<CollaboratorCapacityDTO> findCollabCapacityByCollabId(Long collaboratorId) {
    return collabCapacityRepository.findByCollaboratorId(collaboratorId)
      .map(CollabCapacityEntityConverter::convert);
  }

  @Override
  public Optional<CollaboratorCapacityDTO> findCollabCapacityById(Long collabCapacityId) {
    return collabCapacityRepository.findById(collabCapacityId)
      .map(CollabCapacityEntityConverter::convert);
  }

  @Override
  public List<CollaboratorCapacityDTO> getAllCollabCapacities() {
    return collabCapacityRepository.findAll()
      .stream()
      .map(CollabCapacityEntityConverter::convert)
      .toList();
  }

  @Override
  public List<CollaboratorCapacityDTO> getAllCollabCapacitiesByCollabId(Long collaboratorId) {
    return this.collabCapacityRepository.findAllByCollaboratorId(collaboratorId)
      .stream()
      .map(CollabCapacityEntityConverter::convert)
      .toList();
  }

  @Override
  public void saveCollabCapacity(CollaboratorCapacityDTO collaboratorCapacity) {
    CollaboratorCapacityEntity collaboratorCapacityEntity = CollabCapacityEntityConverter.convert(collaboratorCapacity);
    collabCapacityRepository.save(collaboratorCapacityEntity);
  }

  @Override
  public void updateCollabCapacity(CollaboratorCapacityDTO collaboratorCapacity) {
    saveCollabCapacity(collaboratorCapacity);
  }
}
