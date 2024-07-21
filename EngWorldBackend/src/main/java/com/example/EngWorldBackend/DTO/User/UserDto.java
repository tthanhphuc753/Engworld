package com.example.EngWorldBackend.DTO.User;

import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.example.EngWorldBackend.Domain.Model.User.User}
 */
@Data
public class UserDto implements Serializable {
    Long userID;
    String firstName;
    String lastName;
    String email;
}