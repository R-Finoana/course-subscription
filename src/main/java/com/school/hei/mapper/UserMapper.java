package com.school.hei.mapper;

import com.school.hei.model.User;
import com.school.hei.repository.model.JUser;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toModel(JUser entity){
        return User.builder()
                .id(entity.getId())
                .firstName(entity.getFirst_name())
                .lastName(entity.getLast_name())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .build();
    }

    public JUser toEntity(User model){
        return JUser.builder()
                .id(model.getId())
                .first_name(model.getFirstName())
                .last_name(model.getLastName())
                .username(model.getUsername())
                .email(model.getEmail())
                .build();
    }
}
