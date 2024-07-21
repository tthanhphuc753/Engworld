package com.example.EngWorldBackend.Mapper;

import com.example.EngWorldBackend.DTO.Course.OrderDetailDto;
import com.example.EngWorldBackend.Domain.Model.Course.Course;
import com.example.EngWorldBackend.Domain.Model.Course.OrderDetail;
import com.example.EngWorldBackend.Domain.Model.User.User;
import com.example.EngWorldBackend.Persistence.DAO.CourseRepository;
import com.example.EngWorldBackend.Persistence.DAO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailMapper {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;

    public static OrderDetailDto toDTO(OrderDetail orderDetail) {
        OrderDetailDto dto = new OrderDetailDto();
        dto.setId(orderDetail.getId());
        dto.setAmount(orderDetail.getAmount());
        dto.setBankCode(orderDetail.getBankCode());
        dto.setPayDate(orderDetail.getPayDate());
        return dto;
    }

    public OrderDetail toEntity(OrderDetailDto dto) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setAmount(dto.getAmount());
        orderDetail.setBankCode(dto.getBankCode());
        orderDetail.setCardType(dto.getCardType());
        orderDetail.setPayDate(dto.getPayDate());
        User user = userRepository.findById(dto.getUserDto().getUserID()).orElse(null);
        orderDetail.setUser(user);
        Course course = courseRepository.findById(dto.getCourseId()).orElse(null);
        orderDetail.setCourse(course);
        return orderDetail;
    }

//    public static CourseResponse mapToOrderDetailResponse(List<OrderDetailDto> orderDetailDtos, Page<OrderDetail> orderDetails) {
//        O courseResponse = new CourseResponse();
//        courseResponse.setContent(orderDetailDtos);
//        courseResponse.setPageNumber(courses.getNumber());
//        courseResponse.setPageSize(courses.getSize());
//        courseResponse.setTotalElements(courses.getTotalElements());
//        courseResponse.setTotalPages(courses.getTotalPages());
//        courseResponse.setLast(courses.isLast());
//
//        return courseResponse;
//    }
}
