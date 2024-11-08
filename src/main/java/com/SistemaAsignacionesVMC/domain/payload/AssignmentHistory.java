package com.SistemaAsignacionesVMC.domain.payload;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@ToString
@Value
@Builder
@Jacksonized
public class AssignmentHistory {
  Long id;

  Long eventId;

  @NotNull
  Assignment assignment;

  @NotNull
  Collaborator collaborator;

  @NotNull
  Boolean isAssistant;
}
