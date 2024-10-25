package com.github.umarshabazov.testscheduler.controller;


import com.github.umarshabazov.testscheduler.entities.TaskEntity;
import com.github.umarshabazov.testscheduler.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskRepository taskRepository;

    @Autowired
    TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping("/create")
    public ResponseEntity <TaskEntity> createTask (@RequestBody TaskEntity task) {
        TaskEntity savedTask = taskRepository.save(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);

    }
}
