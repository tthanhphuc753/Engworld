package com.example.EngWorldBackend.DTO.Course;

import com.example.EngWorldBackend.Domain.Model.Course.Course;
import lombok.Data;

import java.io.Serializable;

@Data
public class VideoDto implements Serializable {
    Long videoId;
    String title;
    String videoPath;
    CourseDto courseDto;

}
