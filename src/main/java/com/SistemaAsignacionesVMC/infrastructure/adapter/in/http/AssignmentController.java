package com.SistemaAsignacionesVMC.infrastructure.adapter.in.http;

import com.SistemaAsignacionesVMC.application.port.in.AssignmentUseCase;
import com.SistemaAsignacionesVMC.domain.converter.assignment.AssignmentConverter;
import com.SistemaAsignacionesVMC.domain.payload.Assignment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/assignment")
public class AssignmentController {

  private final AssignmentUseCase assignmentUseCase;

  public AssignmentController(AssignmentUseCase assignmentUseCase) {
    this.assignmentUseCase = assignmentUseCase;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Assignment> getAllTasks() {
    return assignmentUseCase.getAllAssignments()
      .stream()
      .map(AssignmentConverter::convert)
      .toList();
  }

  @GetMapping(path = "/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Assignment getTaskById(@PathVariable Long taskId) {
    return AssignmentConverter.convert(assignmentUseCase.findAssignmentById(taskId));
  }
}
