package com.czerniecka.todo_list.controller;

import com.czerniecka.todo_list.model.Task;
import com.czerniecka.todo_list.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public String getTaskById(Model model,
                              @PathVariable String id){

        Task task = taskService.getById(Integer.parseInt(id));

        if(task == null){
            model.addAttribute("errorMessage", "Task not found");
        }

        model.addAttribute("task", task);

        return "task-view";

    }

    @GetMapping("/tasks")
    public String getAllTasks(Model model){

        List<Task> tasks = taskService.getAllTasks();

        model.addAttribute("tasks", tasks);


        return "tasks-list";

    }
}
