package com.SistemaAsignacionesVMC.domain.dtos;

import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class AssignmentHistoryDTO {
  Long id;

  @With
  Long eventId;

  @With
  AssignmentDTO assignment;

  @With
  CollaboratorDTO collaborator;

  @With
  Boolean isAssistant;
}
