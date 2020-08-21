package com.czerniecka.todo_list.repository;

import com.czerniecka.todo_list.model.Task;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class TaskRepository {
    private List<Task> tasks = List.of(new Task(1, "Ecommerce project", "Create book store app",
                                                LocalDateTime.now(), LocalDateTime.now().plusWeeks(2)),
                                        new Task(2, "Bug fix", "Fix memory leak bug",
                                                LocalDateTime.now(), LocalDateTime.now().plusDays(3)),
                                        new Task(1, "Presentation", "Create presentation of app for client",
                                                LocalDateTime.now(), LocalDateTime.now().plusWeeks(1)));

    public List<Task> getAll() {
        return tasks;
    }

    public Task getById(Integer id) {

        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);

    }

    public Task addTask(Task task) {
        task.setId(tasks.size() + 1);
        tasks.add(task);

        return task;
    }
}
