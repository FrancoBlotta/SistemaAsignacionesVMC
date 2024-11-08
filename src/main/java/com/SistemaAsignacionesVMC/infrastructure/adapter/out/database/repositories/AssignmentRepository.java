package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.repositories;

import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.AssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<AssignmentEntity, Long> {
}
