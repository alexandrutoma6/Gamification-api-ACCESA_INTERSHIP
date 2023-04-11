package com.alex.service;
import com.alex.exceptions.ValidationQuestException;
import com.alex.exceptions.ValidationUserException;
import com.alex.model.NewStatus;
import com.alex.model.dto.AssignmentDto;
import com.alex.model.dto.QuestDto;
import com.alex.model.dto.AccountUserDto;
import com.alex.model.entity.Assignment;
import com.alex.model.entity.Quest;
import com.alex.model.entity.AccountUser;
import com.alex.repository.AssignmentRepository;
import com.alex.repository.QuestRepository;
import com.alex.repository.AccountUserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamificationService {
    private final AssignmentRepository assignmentRepository;
    private final AccountUserRepository userRepository;
    private final QuestRepository questRepository;
    public GamificationService(AccountUserRepository userRepository, QuestRepository questRepository, AssignmentRepository repository) {
        this.userRepository = userRepository;
        this.questRepository = questRepository;
        this.assignmentRepository = repository;
    }


    //GET
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }
    public List<AccountUser> getAllUsers() {
        return userRepository.findAll();
    }
    public List<Quest> getAllQuests(){
        return questRepository.findAll();
    }



    //POST
    public AccountUser addUser(AccountUserDto request) {
        validateUser(request);
        return userRepository.save(new AccountUser(request.name(),request.tokens()));
    }
    public Quest addQuest(QuestDto request) {
        validateQuest(request);
        return questRepository.save(new Quest(request.requirement(), request.reward()));
    }
    public Assignment addAssignment(AssignmentDto request) {
        //validateAssignment(request);
        return assignmentRepository.save(new Assignment(request.user(),request.quest(),request.status()));
    }



    //DELETE
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
    public void deleteQuest(Integer id){
        questRepository.deleteById(id);
    }
    public void deleteAssignment(Integer id){
        assignmentRepository.deleteById(id);
    }



    //PUT
    public Assignment updateAssignment(NewStatus newStatus, Integer id){
        Optional<Assignment> optionalAssignment = assignmentRepository.findById(id);
        if(optionalAssignment.isPresent()){
            Assignment updatedAssignment = optionalAssignment.get();
            updatedAssignment.setStatus(newStatus.newStatus());
            if(newStatus.newStatus().equals("done")){
                updatedAssignment.getUser().setTokens
                        ((updatedAssignment.getUser().getTokens()) + (updatedAssignment.getQuest().getReward()));
            }
            assignmentRepository.save(updatedAssignment);
            return updatedAssignment;
        }
        return null;
    }



    //EXCEPTIONS
    private void validateUser(@NotNull AccountUserDto request) {
        if(request.name().length()<3 || request.name().isBlank()||request.tokens()<0)
            throw new ValidationUserException("Please provide new name or tokens");
    }
    private void validateQuest(@NotNull QuestDto request) {
        if(request.requirement().length()<3 || request.reward()<10)
            throw new ValidationQuestException("Please provide new requirement or reward");
    }
    /*
    private void validateAssignment(AssignmentDto request) {
        if(request.status()!="In progress")
            throw new ValidationAssignmentException("Assignment must start by being ''in progress''! Please provide new status");
    }*/
}
