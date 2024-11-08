package com.SistemaAsignacionesVMC.domain.dtos;

import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;
import java.util.List;

@Value
@Builder
@Jacksonized
public class EventDTO {
  Long id;

  Date eventDate;

  String eventTittle;

  @With
  List<AssignmentHistoryDTO> assignmentHistory;

  @With
  List<TaskHistoryDTO> taskHistory;
}
