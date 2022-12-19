package com.enexse.agentproject.controller;

import com.enexse.agentproject.entity.Agent;
import com.enexse.agentproject.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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
    public ResponseEntity<?> addAgent(@Valid @RequestBody Agent agent) {
        try {
            agentService.addAgent(agent);
            return new ResponseEntity<>(agent, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{name}")
    public ResponseEntity<?> updateAgent(@PathVariable (value = "name") @NotBlank  String name, @Valid @RequestBody Agent agent) {
        try {
            return new ResponseEntity<>(agentService.updateAgent(name,agent), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteAgent(@PathVariable (value = "id") @NotBlank @Min(1)  Long agentId)  {
        try {
            agentService.deleteAgent(agentId);
            return new ResponseEntity<String>("Agent deleted successfully!.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
