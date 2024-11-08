package com.SistemaAsignacionesVMC.domain.converter.event;

import com.SistemaAsignacionesVMC.domain.converter.history.assignment.AssignHistoryDtoConverter;
import com.SistemaAsignacionesVMC.domain.converter.history.task.TaskHistoryDtoConverter;
import com.SistemaAsignacionesVMC.domain.dtos.EventDTO;
import com.SistemaAsignacionesVMC.domain.payload.Event;

import java.util.stream.Collectors;

public class EventDtoConverter {
  public static EventDTO convert(Event event) {
    return EventDTO.builder()
      .id(event.getId())
      .eventDate(event.getEventDate())
      .eventTittle(event.getEventTittle())
      .taskHistory(event.getTaskHistory().stream()
        .map(TaskHistoryDtoConverter::convert)
        .collect(Collectors.toList()))
      .assignmentHistory(event.getAssignmentHistory().stream()
        .map(AssignHistoryDtoConverter::convert)
        .collect(Collectors.toList()))
      .build();
  }
}
