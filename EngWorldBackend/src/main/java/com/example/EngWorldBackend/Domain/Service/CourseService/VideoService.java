package com.example.EngWorldBackend.Domain.Service.CourseService;

import com.example.EngWorldBackend.DTO.Course.VideoDto;
import com.example.EngWorldBackend.Domain.Exception.VideoNotFoundException;
import com.example.EngWorldBackend.Domain.Model.Course.Course;
import com.example.EngWorldBackend.Domain.Model.Course.Video;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface VideoService {
    Video createVideo(Video newVideo);

    Optional<Video> getVideoById(Long videoId);

    void deleteVideoById(Long videoId);

    Page<Video> getVideoByCourse(Long courseId, int pageNumber, int pageSize);

    Video updateVideoById(Long videoId, Video newVideo) throws VideoNotFoundException;

    Course addCourseToVideo(Course course);

    Page<Video> getAllVideo(int pageNumber, int pageSize);

    VideoDto uploadVideo(MultipartFile file, Long courseId, String title);
}
