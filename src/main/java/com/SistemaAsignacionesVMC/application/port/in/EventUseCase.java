package com.SistemaAsignacionesVMC.application.port.in;

import com.SistemaAsignacionesVMC.domain.dtos.EventDTO;

import java.util.List;

public interface EventUseCase {
  void createEvent(EventDTO event);

  void deleteEventById(Long eventId);

  EventDTO findEventById(Long eventId);

  List<EventDTO> getAllEvents();

  void updateEvent(EventDTO event);
}
