package com.shashank.teamtaskmanagement.repository;

import com.shashank.teamtaskmanagement.entity.TeamMembers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamMemberRepository extends JpaRepository<TeamMembers,Long>
{
    List<TeamMembers> findByUserId(Long userId);

    List<TeamMembers> findByTeamId(Long teamId);
}
