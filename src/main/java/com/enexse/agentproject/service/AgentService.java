package com.enexse.agentproject.service;

import com.enexse.agentproject.entity.Agent;

import java.util.List;

public interface AgentService {

    void deleteAgent(Long agentId);

    Agent addAgent(Agent agent) throws Exception;

    Agent updateAgent(String agentName, Agent agent) throws Exception;

    List<Agent> getAllAgents();

    Agent getAgent(Long agentId);
}
