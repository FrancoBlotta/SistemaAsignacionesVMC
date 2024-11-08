package com.SistemaAsignacionesVMC.application.interactor;

import com.SistemaAsignacionesVMC.application.interactor.assignment.AssignmentHistoryManager;
import com.SistemaAsignacionesVMC.application.interactor.task.TaskHistoryManager;
import com.SistemaAsignacionesVMC.application.port.in.EventUseCase;
import com.SistemaAsignacionesVMC.application.port.out.AssignHistoryDbPort;
import com.SistemaAsignacionesVMC.application.port.out.EventDbPort;
import com.SistemaAsignacionesVMC.application.port.out.TaskHistoryDbPort;
import com.SistemaAsignacionesVMC.domain.dtos.EventDTO;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Builder
public class EventInteractor implements EventUseCase {

  private final EventDbPort eventDbPort;

  private final AssignHistoryDbPort assignHistoryDbPort;

  private final TaskHistoryDbPort taskHistoryDbPort;

  private final AssignmentHistoryManager assignmentHistoryManager;

  private final TaskHistoryManager taskHistoryManager;

  @Transactional
  @Override
  public void createEvent(EventDTO event) {
    EventDTO savedEvent = eventDbPort.saveEvent(event);
    event.getAssignmentHistory().stream()
      .map(assignmentHistoryDTO -> assignmentHistoryDTO.withEventId(savedEvent.getId()))
      .forEach(assignHistoryDbPort::saveAssignHistory);
    event.getTaskHistory().stream()
      .map(taskHistoryDTO -> taskHistoryDTO.withEventId(savedEvent.getId()))
      .forEach(taskHistoryDbPort::saveTaskHistory);
  }

  @Override
  public void deleteEventById(Long eventId) {
  }

  @Override
  public EventDTO findEventById(Long eventId) {
    return eventDbPort.findEventById(eventId)
      .map(savedEvent -> savedEvent
        .withAssignmentHistory(assignmentHistoryManager.fillAssignmentHistories(savedEvent))
        .withTaskHistory(taskHistoryManager.fillTTaskHistories(savedEvent)))
      .orElseThrow(() -> new RuntimeException("Event with ID " + eventId + " does not exist"));
  }

  @Transactional(readOnly = true)
  @Override
  public List<EventDTO> getAllEvents() {
    return eventDbPort.getAllEvents()
      .stream()
      .map(savedEvent -> savedEvent
        .withAssignmentHistory(assignmentHistoryManager.fillAssignmentHistories(savedEvent))
        .withTaskHistory(taskHistoryManager.fillTTaskHistories(savedEvent))).toList();
  }

  @Override
  public void updateEvent(EventDTO event) {
    eventDbPort.updateEvent(event);
  }
}
