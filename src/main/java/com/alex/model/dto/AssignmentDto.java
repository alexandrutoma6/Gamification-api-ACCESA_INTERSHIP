package com.alex.model.dto;

import com.alex.model.entity.Quest;
import com.alex.model.entity.AccountUser;

public record AssignmentDto(
        Integer id,
        AccountUser user,
        Quest quest,
        String status
) {
}
