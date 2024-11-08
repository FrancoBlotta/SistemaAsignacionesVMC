package com.SistemaAsignacionesVMC.domain.payload;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class CollaboratorCapacity {
  Long id;

  Long collaboratorId;

  Long taskId;
}
