package com.shashank.teamtaskmanagement.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.time.LocalDateTime;

@Getter
@Setter

public class CreateTaskRequest {
    private String name;
    private String description;

    private String priority;
    private String status;

    private LocalDateTime dueDate;

    private Long createdByUserId;

    private List<Long> assignedUserIds;

    private Long teamId;
    private Long sprintId;


}
