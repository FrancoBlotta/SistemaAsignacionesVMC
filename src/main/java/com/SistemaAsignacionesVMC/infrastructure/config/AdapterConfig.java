package com.SistemaAsignacionesVMC.infrastructure.config;

import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.repositories.EventRepository;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.repositories.AssignmentRepository;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.repositories.TaskRepository;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.repositories.AssignHistoryRepository;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.repositories.CollaboratorRepository;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.repositories.TaskHistoryRepository;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.repositories.CollabCapacityRepository;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.CollaboratorPostgresAdapter;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.CollabCapacityPostgresAdapter;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.TaskHistoryPostgresAdapter;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.EventPostgresAdapter;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.AssignmentPostgresAdapter;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.AssignHistoryPostgresAdapter;
import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.TaskPostgresAdapter;
import com.SistemaAsignacionesVMC.application.port.out.EventDbPort;
import com.SistemaAsignacionesVMC.application.port.out.TaskHistoryDbPort;
import com.SistemaAsignacionesVMC.application.port.out.AssignHistoryDbPort;
import com.SistemaAsignacionesVMC.application.port.out.TaskDbPort;
import com.SistemaAsignacionesVMC.application.port.out.CollabCapacityDbPort;
import com.SistemaAsignacionesVMC.application.port.out.AssignmentDbPort;
import com.SistemaAsignacionesVMC.application.port.out.CollaboratorDbPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdapterConfig {
  @Bean
  public AssignHistoryDbPort assignHistoryDbPort(AssignHistoryRepository assignHistoryRepository) {
    return AssignHistoryPostgresAdapter.of(assignHistoryRepository);
  }

  @Bean
  public AssignmentDbPort assignmentDbPort(AssignmentRepository assignmentRepository) {
    return AssignmentPostgresAdapter.of(assignmentRepository);
  }

  @Bean
  public CollabCapacityDbPort collabCapacityDbPort(CollabCapacityRepository collabCapacityRepository) {
    return CollabCapacityPostgresAdapter.of(collabCapacityRepository);
  }

  @Bean
  public CollaboratorDbPort collaboratorDbPort(CollaboratorRepository collaboratorRepository) {
    return CollaboratorPostgresAdapter.of(collaboratorRepository);
  }

  @Bean
  public EventDbPort eventDbPort(EventRepository eventRepository) {
    return EventPostgresAdapter.of(eventRepository);
  }

  @Bean
  public TaskDbPort taskDbPort(TaskRepository taskRepository) {
    return TaskPostgresAdapter.of(taskRepository);
  }

  @Bean
  public TaskHistoryDbPort taskHistoryDbPort(TaskHistoryRepository taskHistoryRepository) {
    return TaskHistoryPostgresAdapter.of(taskHistoryRepository);
  }
}
