package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.converter;


import com.SistemaAsignacionesVMC.domain.dtos.CollaboratorDTO;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.CollaboratorEntity;

public class CollaboratorEntityConverter {
  public static CollaboratorDTO convert(CollaboratorEntity collaborator) {
    return CollaboratorDTO.builder()
      .id(collaborator.getId())
      .name(collaborator.getName())
      .lastname(collaborator.getLastname())
      .phone(collaborator.getPhone())
      .email(collaborator.getEmail())
      .gender(collaborator.getGender())
      .isInactive(collaborator.getIsInactive())
      .initDateAbsence(collaborator.getInitDateAbsence())
      .endDateAbsence(collaborator.getEndDateAbsence())
      .build();
  }

  public static CollaboratorEntity convert(CollaboratorDTO collaborator) {
    return CollaboratorEntity.builder()
      .id(collaborator.getId())
      .name(collaborator.getName())
      .lastname(collaborator.getLastname())
      .phone(collaborator.getPhone())
      .email(collaborator.getEmail())
      .gender(collaborator.getGender())
      .isInactive(collaborator.getIsInactive())
      .initDateAbsence(collaborator.getInitDateAbsence())
      .endDateAbsence(collaborator.getEndDateAbsence())
      .build();
  }
}
