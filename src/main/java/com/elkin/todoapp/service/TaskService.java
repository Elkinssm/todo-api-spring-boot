package com.elkin.todoapp.service;

import com.elkin.todoapp.mapper.TaskInDTOToTask;
import com.elkin.todoapp.persistence.entity.Task;
import com.elkin.todoapp.persistence.repository.TaskRepository;
import com.elkin.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO) {
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }
}
