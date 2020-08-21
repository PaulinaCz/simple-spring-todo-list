package com.czerniecka.todo_list.controller;

import com.czerniecka.todo_list.model.Task;
import com.czerniecka.todo_list.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = {"/", "/index"})
    public String displayStartPage(Model model) {
        model.addAttribute("pageTitle", "Tasks");

        return "index";
    }

    @GetMapping("/task/{id}")
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

    @GetMapping("/task/add")
    public String addTaskForm(Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        model.addAttribute("addTask", true);

        return "add-edit-task";
    }

    @PostMapping("/task/add")
    public String addTask(Model model,
                            @ModelAttribute("task") Task task){

        task = taskService.addTask(task);

        return "redirect:/task/" + task.getId();
    }

    @GetMapping("/task/edit/{taskId}")
    public String editTask(Model model,
                           @PathVariable Integer taskId){

        Task task = taskService.getById(taskId);

        if(task == null){
            model.addAttribute("errorMessage", "Task not found");
        }

        model.addAttribute("task", task);
        model.addAttribute("addTask", false);

        return "add-edit-task";

    }
}
