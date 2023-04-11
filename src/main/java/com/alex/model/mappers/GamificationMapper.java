package com.alex.model.mappers;

import com.alex.model.dto.QuestDto;
import com.alex.model.dto.AccountUserDto;
import com.alex.model.entity.Assignment;
import com.alex.model.dto.AssignmentDto;
import com.alex.model.entity.Quest;
import com.alex.model.entity.AccountUser;
import org.springframework.stereotype.Component;

@Component
public class GamificationMapper {

    //ASSIGNMENT
    public AssignmentDto assignmentToDto(Assignment assignment){
        return new AssignmentDto(assignment.getId(),assignment.getUser(),assignment.getQuest(),assignment.getStatus());
    }
    public Assignment assignmentToDataBase(AssignmentDto assignmentDto){
        return new Assignment(assignmentDto.id(),assignmentDto.user(),assignmentDto.quest(),assignmentDto.status());
    }

    //USER
    public AccountUserDto userToDto(AccountUser user){
        return new AccountUserDto(user.getId(), user.getName(), user.getTokens());
    }
    public AccountUser userToDataBase(AccountUserDto userDto){
        return new AccountUser(userDto.id(),userDto.name(), userDto.tokens());
    }

    //QUEST
    public QuestDto questToDto(Quest quest){
        return new QuestDto(quest.getId(),quest.getRequirement(),quest.getReward());
    }
    public Quest questToDataBase(QuestDto questDto){
        return new Quest(questDto.id(),questDto.requirement(), questDto.reward());
    }
}
