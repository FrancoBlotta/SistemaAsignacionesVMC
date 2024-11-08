package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.repositories;

import com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities.CollaboratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CollaboratorRepository extends JpaRepository<CollaboratorEntity, Long> {
  List<CollaboratorEntity> findAllByIsInactiveIsFalse();

  @Query("SELECT c FROM CollaboratorEntity c WHERE ?1 NOT BETWEEN c.initDateAbsence AND c.endDateAbsence")
  List<CollaboratorEntity> findAllCollaboratorsAvailableOnDate(Date date);
}
