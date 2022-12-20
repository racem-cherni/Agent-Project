package com.enexse.agentproject.service;

import com.enexse.agentproject.entity.Agent;
import com.enexse.agentproject.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    AgentRepository agentRepository;

    //Get
    @Override
    public List<Agent> getAllAgents() {

        return agentRepository.findAll();
    }

    @Override
    public Agent getAgent(Long agentId) {
        if (agentRepository.findById(agentId).isPresent())
            return agentRepository.findById(agentId).get();
        return null;
    }


    // DELETE
    @Override
    public void deleteAgent(Long agentId) throws Exception {

        if(!agentRepository.findById(agentId).isPresent()) {
            throw new Exception("agent with id: '" + agentId + "' does not exist");}
        else {
            agentRepository.deleteById(agentId);
        }
    }

    // ADD
    @Override
    public Agent addAgent(Agent agent) throws Exception {
        if (agentRepository.findByName(agent.getName()) != null) {
            throw new Exception("agent with name : << " + agent.getName() + " >> already exist");
        }

        else {
            return agentRepository.save(agent);
        }
    }

    @Override
    public Agent updateAgent(String agentName, Agent agent) throws Exception {

        Agent oldAgent = agentRepository.findByName(agentName);
         if(oldAgent == null ) {
            throw new Exception("agent with name : << " + agentName + " >> does not exist");
        }
           else if (agentRepository.findByName(agent.getName()) != null && !agent.getName().equals(agentName)) {
                throw new Exception("name : <<" + agent.getName() + " >> already belongs to another agent");
        }
        else {
            if(agent.getId()==null) agent.setId(oldAgent.getId());
                return agentRepository.save(agent);
            }
    }
}


