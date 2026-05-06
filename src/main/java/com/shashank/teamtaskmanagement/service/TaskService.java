package com.shashank.teamtaskmanagement.service;

import com.shashank.teamtaskmanagement.dto.CreateTaskRequest;
import com.shashank.teamtaskmanagement.entity.Priority;
import com.shashank.teamtaskmanagement.entity.TaskStatus;
import com.shashank.teamtaskmanagement.entity.User;
import com.shashank.teamtaskmanagement.repository.TaskRepository;
import com.shashank.teamtaskmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.shashank.teamtaskmanagement.entity.Task;
import java.util.*;


@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;


    public Task createTask(CreateTaskRequest request)
    {
        User createdBy = userRepository.findById(request.getCreatedByUserId()).
                orElseThrow(()-> new RuntimeException("User Not found"));


        List<User> assignedUser = userRepository.findAllById(request.getAssignedUserIds());

        Task task = new Task();
        task.setName(request.getName());
        task.setDescription(request.getDescription());
        task.setDueDate(request.getDueDate());
        task.setCreatedBy(createdBy);
        task.setAssignedUser(assignedUser);

        task.setPriority(Priority.valueOf(request.getPriority().toUpperCase()));
        task.setStatus(TaskStatus.valueOf(request.getStatus()));

        return taskRepository.save(task);

    }
    public List<Task> getTasksByUser(Long  userId)
    {
        return taskRepository.findByCreatedBy_Id(userId);
    }

    public Task updateStatus(Long taskId,String status)
    {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task now found"));
        task.setStatus(TaskStatus.valueOf(status));
        return taskRepository.save(task);



    }


}
