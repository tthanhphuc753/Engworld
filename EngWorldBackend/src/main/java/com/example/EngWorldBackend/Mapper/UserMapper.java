package com.example.EngWorldBackend.Mapper;

import com.example.EngWorldBackend.DTO.Course.OrderDetailDto;
import com.example.EngWorldBackend.DTO.User.UserDto;
import com.example.EngWorldBackend.Domain.Model.Course.Course;
import com.example.EngWorldBackend.Domain.Model.Course.OrderDetail;
import com.example.EngWorldBackend.Domain.Model.User.User;
import com.example.EngWorldBackend.Persistence.DAO.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDto toDTO(User user) {
        UserDto dto = new UserDto();
        dto.setEmail(user.getEmail());
        dto.setLastName(user.getLastName());
        dto.setUserID(user.getUserID());
        dto.setFirstName(user.getFirstName());
        return dto;
    }


}
