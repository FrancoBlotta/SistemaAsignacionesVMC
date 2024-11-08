package com.SistemaAsignacionesVMC.domain.dtos;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class TaskDTO {
  Long id;

  String taskName;
}
