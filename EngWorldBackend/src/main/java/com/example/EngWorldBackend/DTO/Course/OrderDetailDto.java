package com.example.EngWorldBackend.DTO.Course;

import com.example.EngWorldBackend.DTO.User.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.EngWorldBackend.Domain.Model.Course.OrderDetail}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto implements Serializable {
    long id;
    LocalDateTime payDate;
    String bankCode;
    long amount;
    String cardType;

    UserDto userDto;
    Long courseId;

    public OrderDetailDto(LocalDateTime payDate, String bankCode, long amount, String cardType, UserDto userDto, long courseid) {
        this.payDate = payDate;
        this.bankCode = bankCode;
        this.amount = amount;
        this.cardType = cardType;
        this.userDto = userDto;
        this.courseId = courseid;
    }
}