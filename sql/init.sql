CREATE DATABASE IF NOT EXISTS sistemaasignaciones;
CREATE TABLE sistemaasignaciones.usuario
(
    id                BIGINT auto_increment NOT NULL,
    nombre            varchar(150) NOT NULL,
    apellido          varchar(150) NOT NULL,
    email             varchar(100) NOT NULL,
    password          varchar(200) NOT NULL,
    CONSTRAINT usuario_pk PRIMARY KEY (id)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE sistemaasignaciones.`assignment`
(
    id              BIGINT auto_increment NOT NULL,
    assignment_name varchar(160) NOT NULL,
    CONSTRAINT assignment_pk PRIMARY KEY (id)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
AUTO_INCREMENT=8;

INSERT INTO sistemaasignaciones.`assignment` (id, assignment_name)
VALUES (1, 'Palabras de apertura'),
       (2, 'Temática'),
       (3, 'Escenificación'),
       (4, 'Palabras de cierre'),
       (5, 'Discursos'),
       (6, 'Lector'),
       (7, 'Ayudante');


CREATE TABLE sistemaasignaciones.task
(
    id        BIGINT auto_increment NOT NULL,
    task_name varchar(160) NOT NULL,
    CONSTRAINT task_pk PRIMARY KEY (id)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
AUTO_INCREMENT=6;

INSERT INTO sistemaasignaciones.`task` (`id`, `task_name`)
VALUES (1, 'Acomodador'),
       (2, 'Técnico de sonido'),
       (3, 'Audio'),
       (4, 'Video'),
       (5, 'Plataforma');

CREATE TABLE sistemaasignaciones.collaborator
(
    id                BIGINT auto_increment NOT NULL,
    name              varchar(150) NOT NULL,
    lastname          varchar(150) NOT NULL,
    phone             varchar(100) NULL,
    email             varchar(200) NOT NULL,
    gender            varchar(1)   NOT NULL,
    is_inactive       BOOL         NOT NULL,
    end_date_absence  DATETIME     NOT NULL,
    init_date_absence DATETIME     NOT NULL,
    CONSTRAINT collaborator_pk PRIMARY KEY (id),
    CONSTRAINT fullyname_unique UNIQUE KEY (name,lastname)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE sistemaasignaciones.`event`
(
    `id`           bigint       NOT NULL AUTO_INCREMENT,
    `event_date`   datetime     NOT NULL,
    `event_tittle` varchar(200) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE sistemaasignaciones.task_history
(
    id              BIGINT auto_increment NOT NULL,
    task_id         BIGINT NOT NULL,
    event_id        BIGINT NOT NULL,
    collaborator_id BIGINT NOT NULL,
    CONSTRAINT task_history_pk PRIMARY KEY (id),
    CONSTRAINT task_history_event_FK FOREIGN KEY (event_id) REFERENCES sistemaasignaciones.event (id),
    CONSTRAINT task_history_collaborator_FK FOREIGN KEY (collaborator_id) REFERENCES sistemaasignaciones.collaborator (id),
    CONSTRAINT task_history_task_FK FOREIGN KEY (task_id) REFERENCES sistemaasignaciones.task (id)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE sistemaasignaciones.assignment_history
(
    id              BIGINT NOT NULL,
    event_id        BIGINT NOT NULL,
    assignment_id   BIGINT NOT NULL,
    collaborator_id BIGINT NOT NULL,
    is_assistant    BOOL   NOT NULL,
    CONSTRAINT assignment_history_pk PRIMARY KEY (id),
    CONSTRAINT assignment_history_event_FK FOREIGN KEY (event_id) REFERENCES sistemaasignaciones.event (id),
    CONSTRAINT assignment_history_assignment_FK FOREIGN KEY (assignment_id) REFERENCES sistemaasignaciones.`assignment` (id),
    CONSTRAINT assignment_history_collaborator_FK FOREIGN KEY (collaborator_id) REFERENCES sistemaasignaciones.collaborator (id)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE sistemaasignaciones.collaborator_capacity
(
    id              BIGINT auto_increment NOT NULL,
    task_id         BIGINT NOT NULL,
    collaborator_id BIGINT NOT NULL,
    CONSTRAINT collaborator_capacity_pk PRIMARY KEY (id),
    CONSTRAINT collaborator_capacity_task_FK FOREIGN KEY (task_id) REFERENCES sistemaasignaciones.task (id),
    CONSTRAINT collaborator_capacity_collaborator_FK FOREIGN KEY (collaborator_id) REFERENCES sistemaasignaciones.collaborator (id)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;