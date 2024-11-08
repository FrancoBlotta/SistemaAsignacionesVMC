package com.SistemaAsignacionesVMC.infrastructure.adapter.out.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "collaborator", uniqueConstraints = {
  @UniqueConstraint(columnNames = {"name", "lastname"})
})
public class CollaboratorEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(nullable = false, length = 150)
  String name;

  @Column(nullable = false, length = 150)
  String lastname;

  @Column(length = 100)
  String phone;

  @Column(nullable = false, length = 200)
  String email;

  @Column(nullable = false, length = 1)
  String gender;

  @Column(nullable = false, name = "is_inactive")
  Boolean isInactive;

  @Column(nullable = false, name = "init_date_absence")
  Date initDateAbsence;

  @Column(nullable = false, name = "end_date_absence")
  Date endDateAbsence;
}

