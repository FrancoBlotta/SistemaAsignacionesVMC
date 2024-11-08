package com.SistemaAsignacionesVMC.domain.converter.collaborator;

import com.SistemaAsignacionesVMC.domain.converter.task.TaskDtoConverter;
import com.SistemaAsignacionesVMC.domain.dtos.CollaboratorDTO;
import com.SistemaAsignacionesVMC.domain.payload.Collaborator;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollaboratorDtoConverter {
  public static CollaboratorDTO convert(Collaborator collaborator) {
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
      .tasks(Optional.ofNullable(collaborator.getTasks())
        .map(tasks -> tasks.stream()
          .map(TaskDtoConverter::convert)
          .collect(Collectors.toList()))
        .orElse(Collections.emptyList()))
      .build();
  }
}
