package com.shashank.teamtaskmanagement.controller;

import com.shashank.teamtaskmanagement.dto.CreateTaskRequest;
import com.shashank.teamtaskmanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.shashank.teamtaskmanagement.entity.Task;
import java.util.*;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody CreateTaskRequest request)
    {
        return  taskService.createTask(request);
    }
    @GetMapping("/user/{userId}")
    public List<Task> getTasksByUser(@PathVariable Long userId)
    {
        return  taskService.getTasksByUser(userId);
    }

    @PostMapping("/{taskId}/status")
    public Task updateStatus(@PathVariable Long taskId, @RequestParam String status) {
        return taskService.updateStatus(taskId, status);
    }
}
