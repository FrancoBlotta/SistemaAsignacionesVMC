package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.repositories;

import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
