package com.SistemaAsignacionesVMC.infrastructure.adapter.in.http;

import com.SistemaAsignacionesVMC.application.port.in.EventUseCase;
import com.SistemaAsignacionesVMC.domain.converter.event.EventConverter;
import com.SistemaAsignacionesVMC.domain.converter.event.EventDtoConverter;
import com.SistemaAsignacionesVMC.domain.dtos.EventDTO;
import com.SistemaAsignacionesVMC.domain.payload.Event;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

  private final EventUseCase eventUseCase;

  public EventController(EventUseCase eventUseCase) {
    this.eventUseCase = eventUseCase;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public void createEvent(@Valid @RequestBody Event event) {
    EventDTO eventDTO = EventDtoConverter.convert(event);
    eventUseCase.createEvent(eventDTO);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Event> getAllEvents() {
    return eventUseCase.getAllEvents()
      .stream()
      .map(EventConverter::convert)
      .collect(Collectors.toList());
  }
}
