package com.czerniecka.todo_list.service;

import com.czerniecka.todo_list.model.Task;
import com.czerniecka.todo_list.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {

        return taskRepository.getAll();

    }

    public Task getById(Integer id) {
        return taskRepository.getById(id);
    }
}
