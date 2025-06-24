package com.familycircle.controller;

import com.familycircle.model.BondingTask;
import com.familycircle.model.User;
import com.familycircle.service.BondingTaskService;
import com.familycircle.service.BondingPointService;
import com.familycircle.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class BondingTaskController {

    @Autowired
    private BondingTaskService bondingTaskService;

    @Autowired
    private BondingPointService bondingPointService;

    @GetMapping
    public String showTaskForm(Model model) {
        model.addAttribute("task", new BondingTask());
        return "bonding-task";
    }

    @PostMapping
    public String submitTask(@ModelAttribute("task") BondingTask task,
                             @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User currentUser = userDetails.getUser();
        task.setUser(currentUser);
        task.setDate(LocalDate.now());
        task.setCompleted(false);
        bondingTaskService.saveTask(task);
        return "redirect:/home";
    }

    @GetMapping("/list")
    public String listTasks(Model model,
                            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User currentUser = userDetails.getUser();
        List<BondingTask> tasks = bondingTaskService.getTasksForUser(currentUser);
        model.addAttribute("tasks", tasks);
        return "bonding-task-list";
    }

    @PostMapping("/complete/{taskId}")
    public String completeTask(@PathVariable Long taskId,
                               @AuthenticationPrincipal UserDetailsImpl userDetails) {
        bondingTaskService.markTaskCompleted(taskId);
        User currentUser = userDetails.getUser();
        bondingPointService.addPoints(currentUser, 15, "Completed Task");
        return "redirect:/tasks/list";
    }
}
