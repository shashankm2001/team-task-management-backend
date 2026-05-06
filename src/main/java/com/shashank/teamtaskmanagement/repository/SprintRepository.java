package com.shashank.teamtaskmanagement.repository;

import com.shashank.teamtaskmanagement.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintRepository extends JpaRepository<Sprint,Long> {
}
