package com.shashank.teamtaskmanagement.repository;

import com.shashank.teamtaskmanagement.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {

}
