package com.SistemaAsignacionesVMC.infrastructure.adapter.in.http;

import com.SistemaAsignacionesVMC.application.port.in.TaskUseCase;
import com.SistemaAsignacionesVMC.domain.converter.task.TaskConverter;
import com.SistemaAsignacionesVMC.domain.payload.Task;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

  private final TaskUseCase taskUseCase;

  public TaskController(TaskUseCase taskUseCase) {
    this.taskUseCase = taskUseCase;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Task> getAllTasks() {
    return taskUseCase.getAllTasks()
      .stream()
      .map(TaskConverter::convert)
      .toList();
  }

  @GetMapping(path = "/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Task getTaskById(@PathVariable Long taskId) {
    return TaskConverter.convert(taskUseCase.findTaskById(taskId));
  }
}
