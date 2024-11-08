package com.SistemaAsignacionesVMC.domain.payload;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.hibernate.validator.constraints.Length;

@ToString
@Value
@Builder
@Jacksonized
public class Task {
  Long id;

  @Length(max = 160)  // Default = 0
  @NotEmpty
  String taskName;
}
