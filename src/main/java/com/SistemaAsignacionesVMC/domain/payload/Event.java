package com.SistemaAsignacionesVMC.domain.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

@ToString
@Value
@Builder
@Jacksonized
public class Event {
  Long id;

  @NotNull
  Date eventDate;

  @Length(max = 200)  // Default = 0
  @NotEmpty
  String eventTittle;

  @NotEmpty
  List<AssignmentHistory> assignmentHistory;

  @NotEmpty
  List<TaskHistory> taskHistory;
}


