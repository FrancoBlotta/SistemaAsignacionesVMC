package com.SistemaAsignacionesVMC.infrastructure.adapter.in.http;

import com.SistemaAsignacionesVMC.application.port.in.CollaboratorUseCase;
import com.SistemaAsignacionesVMC.domain.converter.collaborator.CollaboratorConverter;
import com.SistemaAsignacionesVMC.domain.converter.collaborator.CollaboratorDtoConverter;
import com.SistemaAsignacionesVMC.domain.dtos.CollaboratorDTO;
import com.SistemaAsignacionesVMC.domain.payload.Collaborator;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/collaborator")
public class CollaboratorController {

  private final CollaboratorUseCase collaboratorUseCase;

  public CollaboratorController(CollaboratorUseCase collaboratorUseCase) {
    this.collaboratorUseCase = collaboratorUseCase;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public void createCollaborator(@Valid @RequestBody Collaborator collaborator) {
    CollaboratorDTO collaboratorDTO = CollaboratorDtoConverter.convert(collaborator);
    collaboratorUseCase.createCollaborator(collaboratorDTO);
  }

  @PutMapping(path = "/{collaboratorId}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateCollaborator(@Valid @RequestBody Collaborator collaborator, @PathVariable Long collaboratorId) {
    CollaboratorDTO collaboratorDTO = CollaboratorDtoConverter.convert(collaborator);
    collaboratorUseCase.updateCollaborator(collaboratorDTO, collaboratorId);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Collaborator> getAllCollaborators() {
    return collaboratorUseCase.getAllCollaborators()
      .stream()
      .map(CollaboratorConverter::convert)
      .collect(Collectors.toList());
  }

  @GetMapping(path = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Collaborator> getCollaboratorsAvailableOnDate(@RequestParam Date date) {
    return collaboratorUseCase.getCollaboratorsAvailableOnDate(date)
      .stream()
      .map(CollaboratorConverter::convert)
      .collect(Collectors.toList());
  }

  @GetMapping(path = "/{collaboratorId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Collaborator getCollaboratorById(@PathVariable Long collaboratorId) {
    return CollaboratorConverter.convert(collaboratorUseCase.findCollaboratorById(collaboratorId));
  }

  @DeleteMapping(path = "/{collaboratorId}")
  public void deleteCollaboratorById(@PathVariable Long collaboratorId) {
    collaboratorUseCase.deleteCollaboratorById(collaboratorId);
  }
}
