package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.converter;

import com.SistemaAsignacionesVMC.domain.dtos.EventDTO;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.EventEntity;

public class EventEntityConverter {
  public static EventEntity convert(EventDTO event) {
    return EventEntity.builder()
      .id(event.getId())
      .eventDate(event.getEventDate())
      .eventTittle(event.getEventTittle())
      .build();
  }

  public static EventDTO convert(EventEntity event) {
    return EventDTO.builder()
      .id(event.getId())
      .eventDate(event.getEventDate())
      .eventTittle(event.getEventTittle())
      .build();
  }
}
