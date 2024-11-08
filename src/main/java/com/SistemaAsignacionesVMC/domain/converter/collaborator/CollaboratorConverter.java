package com.SistemaAsignacionesVMC.domain.converter.collaborator;

import com.SistemaAsignacionesVMC.domain.converter.task.TaskConverter;
import com.SistemaAsignacionesVMC.domain.dtos.CollaboratorDTO;
import com.SistemaAsignacionesVMC.domain.payload.Collaborator;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollaboratorConverter {
  public static Collaborator convert(CollaboratorDTO collaborator) {
    return Collaborator.builder()
      .id(collaborator.getId())
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
          .map(TaskConverter::convert)
          .collect(Collectors.toList()))
        .orElse(Collections.emptyList()))
      .build();
  }
}
