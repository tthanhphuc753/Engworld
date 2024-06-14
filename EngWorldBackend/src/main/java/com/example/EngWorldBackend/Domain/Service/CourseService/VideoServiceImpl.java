package com.example.EngWorldBackend.Domain.Service.CourseService;

import com.example.EngWorldBackend.DTO.Course.VideoDto;
import com.example.EngWorldBackend.Domain.Exception.CourseNotFoundException;
import com.example.EngWorldBackend.Domain.Exception.VideoNotFoundException;
import com.example.EngWorldBackend.Domain.Model.Course.Course;
import com.example.EngWorldBackend.Domain.Model.Course.Video;
import com.example.EngWorldBackend.Domain.Service.S3.AwsS3Service;
import com.example.EngWorldBackend.Mapper.VideoMapper;
import com.example.EngWorldBackend.Persistence.DAO.CourseRepository;
import com.example.EngWorldBackend.Persistence.DAO.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;
    private final CourseRepository courseRepository;
    private final AwsS3Service awsS3Service;
    private final CourseService courseService;

    @Override
    public Video createVideo(Video newVideo) {
        return videoRepository.save(newVideo);
    }

    @Override
    public Optional<Video> getVideoById(Long videoId) {
        return videoRepository.findById(videoId);
    }

    @Override
    public void deleteVideoById(Long videoId) {
        try {
            Video video = videoRepository.findById(videoId)
                    .orElseThrow(() -> new EntityNotFoundException("Video not found with id: " + videoId));

            String key = awsS3Service.extractKeyFromVideoPath(video.getVideoPath());
            awsS3Service.deleteVideoFromS3(key);
            videoRepository.deleteById(videoId);

        } catch (EmptyResultDataAccessException e) {
            throw new VideoNotFoundException("Video with ID: " + videoId + " does not exist");
        }
    }

    @Override
    public Page<Video> getVideoByCourse(Long courseId, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + courseId));
        return videoRepository.findByCourse(course, pageable);
    }

    @Override
    public Video updateVideoById(Long videoId, Video newVideo) throws VideoNotFoundException {
        Optional<Video> videoOptional = videoRepository.findById(videoId);
        if (videoOptional.isPresent()) {
            Video existingVideo = videoOptional.get();
            existingVideo.setVideoPath(newVideo.getVideoPath());
            existingVideo.setTitle(newVideo.getTitle());
            existingVideo.setCourse(addCourseToVideo(newVideo.getCourse()));
            return videoRepository.save(existingVideo);
        } else {
            throw new VideoNotFoundException("Video not found with id: " + videoId);
        }
    }

    @Override
    public Course addCourseToVideo(Course course) {
        return courseRepository.findById(course.getCourseId())
                .orElseThrow(() -> new CourseNotFoundException("Category not found with id: " + course.getCourseId()));
    }


    @Override
    public Page<Video> getAllVideo(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return videoRepository.findAll(pageable);
    }

    @Override
    public VideoDto uploadVideo(MultipartFile file, Long courseId, String title) {

        Optional<Course> optionalCourse = courseService.getCourseById(courseId);
        Course course = null;

        if (optionalCourse.isPresent()) {
            course = optionalCourse.get();
        }


        Video video = new Video();
        String videoPath = awsS3Service.uploadFile(file);
        video.setVideoPath(videoPath);
        video.setTitle(title);
        video.setCourse(course);

        videoRepository.save(video);
        return VideoMapper.toDTO(video);
    }

}
