package com.SistemaAsignacionesVMC.application.interactor;

import com.SistemaAsignacionesVMC.application.port.in.TaskUseCase;
import com.SistemaAsignacionesVMC.application.port.out.TaskDbPort;
import com.SistemaAsignacionesVMC.domain.dtos.TaskDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class TaskInteractor implements TaskUseCase {

  private final TaskDbPort taskDbPort;

  @Transactional(readOnly = true)
  @Override
  public TaskDTO findTaskById(Long taskId) {
    return taskDbPort.findTaskById(taskId)
      .orElseThrow(() -> new RuntimeException("Task with ID " + taskId + " does not exist"));
  }

  @Transactional(readOnly = true)
  @Override
  public List<TaskDTO> getAllTasks() {
    return taskDbPort.getAllTasks();
  }
}
