package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database;

import com.SistemaAsignacionesVMC.application.port.out.EventDbPort;
import com.SistemaAsignacionesVMC.domain.dtos.EventDTO;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.EventEntity;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.converter.EventEntityConverter;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.repositories.EventRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor(staticName = "of")
public class EventPostgresAdapter implements EventDbPort {

  private final EventRepository eventRepository;

  @Override
  public void deleteEventById(Long eventId) {
    eventRepository.deleteById(eventId);
  }

  @Override
  public Optional<EventDTO> findEventById(Long eventId) {
    return eventRepository.findById(eventId)
      .map(EventEntityConverter::convert);
  }

  @Override
  public List<EventDTO> getAllEvents() {
    return eventRepository.findAll()
      .stream()
      .map(EventEntityConverter::convert)
      .collect(Collectors.toList());
  }

  @Override
  public EventDTO saveEvent(EventDTO event) {
    EventEntity eventEntity = EventEntityConverter.convert(event);
    return EventEntityConverter.convert(eventRepository.save(eventEntity));
  }

  @Override
  public void updateEvent(EventDTO event) {
    saveEvent(event);
  }
}
