package com.SistemaAsignacionesVMC.application.port.out;

import com.SistemaAsignacionesVMC.domain.dtos.EventDTO;

import java.util.List;
import java.util.Optional;

public interface EventDbPort {
  void deleteEventById(Long eventId);

  Optional<EventDTO> findEventById(Long eventId);

  List<EventDTO> getAllEvents();

  EventDTO saveEvent(EventDTO event);

  void updateEvent(EventDTO event);
}
