package com.SistemaAsignacionesVMC.domain.dtos;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class CollaboratorCapacityDTO {
  Long id;

  Long collaboratorId;

  Long taskId;
}
