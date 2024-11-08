package com.SistemaAsignacionesVMC.domain.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

@ToString
@Value
@Builder
@Jacksonized
public class Collaborator {
  Long id;

  @NotEmpty
  @Length(max = 150)  // Default = 0
  String name;

  @NotEmpty
  @Length(max = 150)  // Default = 0
  String lastname;

  @Length(max = 100)  // Default = 0
  String phone;

  @Email
  @Length(max = 200)  // Default = 0
  String email;

  @Length(max = 1)    // Default = 0
  @Pattern(regexp = "^(M|F)$")
  String gender;

  @NotNull
  Boolean isInactive;

  @NotNull
  Date initDateAbsence;

  @NotNull
  Date endDateAbsence;

  @NotEmpty
  List<Task> tasks;
}
