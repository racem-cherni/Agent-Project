package com.enexse.agentproject.repository;

import com.enexse.agentproject.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AgentRepository extends JpaRepository<Agent, Long> {
    Agent findByName(String name);
}
