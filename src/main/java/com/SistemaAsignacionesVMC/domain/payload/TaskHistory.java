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
public class TaskHistory {
  Long id;

  Long eventId;

  @NotNull
  Task task;

  @NotNull
  Collaborator collaborator;

}
