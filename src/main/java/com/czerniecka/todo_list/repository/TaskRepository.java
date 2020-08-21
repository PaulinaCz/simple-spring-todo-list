package com.czerniecka.todo_list.repository;

import com.czerniecka.todo_list.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository {
    private List<Task> tasks = List.of(new Task(),
                                        new Task(),
                                        new Task());

    public List<Task> getAll() {
        return tasks;
    }

    public Task getById(Integer id) {

        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);

    }
}
