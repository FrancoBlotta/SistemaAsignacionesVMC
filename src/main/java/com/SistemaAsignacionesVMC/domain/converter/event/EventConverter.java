package com.SistemaAsignacionesVMC.domain.converter.event;

import com.SistemaAsignacionesVMC.domain.converter.history.assignment.AssignHistoryConverter;
import com.SistemaAsignacionesVMC.domain.converter.history.task.TaskHistoryConverter;
import com.SistemaAsignacionesVMC.domain.dtos.EventDTO;
import com.SistemaAsignacionesVMC.domain.payload.Event;

import java.util.stream.Collectors;

public class EventConverter {
  public static Event convert(EventDTO event) {
    return Event.builder()
      .id(event.getId())
      .eventDate(event.getEventDate())
      .eventTittle(event.getEventTittle())
      .taskHistory(event.getTaskHistory().stream()
        .map(TaskHistoryConverter::convert)
        .collect(Collectors.toList()))
      .assignmentHistory(event.getAssignmentHistory().stream()
        .map(AssignHistoryConverter::convert)
        .collect(Collectors.toList()))
      .build();
  }
}
