package com.alex.controller;

import com.alex.model.NewStatus;
import com.alex.model.dto.AssignmentDto;
import com.alex.model.dto.QuestDto;
import com.alex.model.dto.AccountUserDto;
import com.alex.model.entity.Assignment;
import com.alex.model.entity.Quest;
import com.alex.model.entity.AccountUser;
import com.alex.model.mappers.GamificationMapper;
import com.alex.service.GamificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gamification")
public class GamificationController {
    private final GamificationService service;
    private final GamificationMapper mapper;

    public GamificationController(GamificationService service, GamificationMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/assignments")
    public List<AssignmentDto> getAssignments(){
        return service.getAllAssignments().stream()
                .map(assigment -> mapper.assignmentToDto(assigment))
                .toList();
    }
    @GetMapping("/users")
    public List<AccountUserDto> getUsers(){
        return service.getAllUsers().stream()
                .map(user -> mapper.userToDto(user))
                .toList();
    }
    @GetMapping("/quests")
    public List<QuestDto> getQuests(){
        return service.getAllQuests().stream()
                .map(quest -> mapper.questToDto(quest))
                .toList();
    }


    @PostMapping("/quests")
    public Quest createQuest(@RequestBody QuestDto request){return service.addQuest(request);}
    @PostMapping("/users")
    public AccountUser createUser(@RequestBody AccountUserDto request){return service.addUser(request);}
    @PostMapping("/assignments")
    public Assignment createAssignment(@RequestBody AssignmentDto request){return service.addAssignment(request);}


    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable("userId") Integer id){
        service.deleteUser(id);
        return "User Deleted";
    }
    @DeleteMapping("/quests/{questId}")
    public String deleteQuest(@PathVariable("questId") Integer id){
        service.deleteQuest(id);
        return "Quest Deleted";
    }
    @DeleteMapping("/assignments/{assignmentId}")
    public String deleteAssignment(@PathVariable("assignmentId") Integer id){
        service.deleteAssignment(id);
        return "Assignment Deleted";
    }


    @PutMapping("/assignments/{assignmentId}")
    public Assignment updateAssignment(@PathVariable("assignmentId") Integer id,@RequestBody NewStatus newStatus){
        return service.updateAssignment(newStatus,id);
    }



}
