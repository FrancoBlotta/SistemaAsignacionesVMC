package com.SistemaAsignacionesVMC.application.config;

import com.SistemaAsignacionesVMC.application.port.out.EventDbPort;
import com.SistemaAsignacionesVMC.application.port.out.TaskHistoryDbPort;
import com.SistemaAsignacionesVMC.application.port.out.AssignHistoryDbPort;
import com.SistemaAsignacionesVMC.application.port.out.TaskDbPort;
import com.SistemaAsignacionesVMC.application.port.out.CollabCapacityDbPort;
import com.SistemaAsignacionesVMC.application.port.out.AssignmentDbPort;
import com.SistemaAsignacionesVMC.application.port.out.CollaboratorDbPort;
import com.SistemaAsignacionesVMC.application.interactor.AssignmentInteractor;
import com.SistemaAsignacionesVMC.application.interactor.CollaboratorInteractor;
import com.SistemaAsignacionesVMC.application.interactor.EventInteractor;
import com.SistemaAsignacionesVMC.application.interactor.TaskInteractor;
import com.SistemaAsignacionesVMC.application.interactor.assignment.AssignmentHistoryManager;
import com.SistemaAsignacionesVMC.application.interactor.capacity.CollabCapacitiesManager;
import com.SistemaAsignacionesVMC.application.interactor.task.TaskHistoryManager;
import com.SistemaAsignacionesVMC.application.interactor.task.TaskManager;
import com.SistemaAsignacionesVMC.application.port.in.AssignmentUseCase;
import com.SistemaAsignacionesVMC.application.port.in.CollaboratorUseCase;
import com.SistemaAsignacionesVMC.application.port.in.EventUseCase;
import com.SistemaAsignacionesVMC.application.port.in.TaskUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
  @Bean
  public AssignmentHistoryManager assignmentHistoryManager(
    AssignHistoryDbPort assignHistoryDbPort,
    CollaboratorDbPort collaboratorDbPort,
    AssignmentDbPort assignmentDbPort) {
    return new AssignmentHistoryManager(assignHistoryDbPort, collaboratorDbPort, assignmentDbPort);
  }

  @Bean
  public AssignmentUseCase assignmentUseCase(AssignmentDbPort assignmentDbPort) {
    return new AssignmentInteractor(assignmentDbPort);
  }

  @Bean
  public CollabCapacitiesManager capacitiesManager(
    TaskDbPort taskDbPort,
    CollabCapacityDbPort collabCapacityDbPort) {
    return new CollabCapacitiesManager(taskDbPort, collabCapacityDbPort);
  }

  @Bean
  public CollaboratorUseCase collaboratorUseCase(
    CollaboratorDbPort collaboratorDbPort,
    CollabCapacityDbPort collabCapacityDbPort,
    AssignHistoryDbPort assignHistoryDbPort,
    TaskHistoryDbPort taskHistoryDbPort,
    CollabCapacitiesManager capacitiesManager,
    TaskManager taskManager) {
    return CollaboratorInteractor.builder()
      .collaboratorDbPort(collaboratorDbPort)
      .capacityDbPort(collabCapacityDbPort)
      .assignHistoryDbPort(assignHistoryDbPort)
      .taskHistoryDbPort(taskHistoryDbPort)
      .capacityManager(capacitiesManager)
      .taskManager(taskManager)
      .build();
  }

  @Bean
  public EventUseCase eventUseCase(
    EventDbPort eventDbPort,
    AssignHistoryDbPort assignHistoryDbPort,
    TaskHistoryDbPort taskHistoryDbPort,
    AssignmentHistoryManager assignmentHistoryManager,
    TaskHistoryManager taskHistoryManager) {
    return EventInteractor.builder()
      .eventDbPort(eventDbPort)
      .assignHistoryDbPort(assignHistoryDbPort)
      .taskHistoryDbPort(taskHistoryDbPort)
      .assignmentHistoryManager(assignmentHistoryManager)
      .taskHistoryManager(taskHistoryManager)
      .build();
  }

  @Bean
  public TaskHistoryManager taskHistoryManager(
    TaskHistoryDbPort taskHistoryDbPort,
    CollaboratorDbPort collaboratorDbPort,
    TaskDbPort taskDbPort) {
    return new TaskHistoryManager(taskHistoryDbPort, collaboratorDbPort, taskDbPort);
  }

  @Bean
  public TaskManager taskManager(
    TaskDbPort taskDbPort,
    CollabCapacityDbPort capacityDbPort
  ) {
    return new TaskManager(taskDbPort, capacityDbPort);
  }

  @Bean
  public TaskUseCase taskUseCase(TaskDbPort taskDbPort) {
    return new TaskInteractor(taskDbPort);
  }
}
