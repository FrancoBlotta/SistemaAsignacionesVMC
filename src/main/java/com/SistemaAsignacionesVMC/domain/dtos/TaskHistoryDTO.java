package com.SistemaAsignacionesVMC.domain.dtos;

import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class TaskHistoryDTO {
  Long id;

  @With
  TaskDTO task;

  @With
  CollaboratorDTO collaborator;

  @With
  Long eventId;
}
