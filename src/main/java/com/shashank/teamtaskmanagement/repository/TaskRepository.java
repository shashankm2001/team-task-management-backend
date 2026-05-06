package com.shashank.teamtaskmanagement.repository;
import  java.util.*;


import com.shashank.teamtaskmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task>  findByCreatedBy_Id(Long userId);
    List<Task> findByTeam_Id(Long teamId);


}
