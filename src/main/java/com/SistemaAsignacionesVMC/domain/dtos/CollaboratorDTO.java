package com.SistemaAsignacionesVMC.domain.dtos;

import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;
import java.util.List;

@Value
@Builder
@Jacksonized
public class CollaboratorDTO {
  @With
  Long id;

  String name;

  String lastname;

  String phone;

  String email;

  String gender;

  Boolean isInactive;

  Date initDateAbsence;

  Date endDateAbsence;

  @With
  List<TaskDTO> tasks;
}
