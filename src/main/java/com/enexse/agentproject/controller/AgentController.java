package com.enexse.agentproject.controller;

import com.enexse.agentproject.entity.Agent;
import com.enexse.agentproject.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class AgentController {

    @Autowired
    AgentService agentService ;

    @GetMapping("/agents")
    private List<Agent> getAllAgents()
    {
        return agentService.getAllAgents();
    }

    @PostMapping("/agent")
    public ResponseEntity<Agent> addAgent(@RequestBody Agent agent) {
        try {
            agentService.addAgent(agent);
            return new ResponseEntity<>(agent, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{name}")
    public ResponseEntity<Agent> updateAgent(@PathVariable (value = "name") String name,@RequestBody Agent agent) {
        try {
            return new ResponseEntity<>(agentService.updateAgent(name,agent), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteAgent(@PathVariable (value = "id") Long agentId) throws ClassNotFoundException {
       Agent agent = agentService.getAgent(agentId);
       if (agent == null){
           return new ResponseEntity<String>("Agent not existed!.", HttpStatus.NOT_FOUND    );
       }
        return new ResponseEntity<String>("Agent deleted successfully!.", HttpStatus.OK);
    }

}
