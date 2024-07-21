package com.example.EngWorldBackend.Mapper;

import com.example.EngWorldBackend.DTO.Course.VideoDto;
import com.example.EngWorldBackend.DTO.Course.VideoResponse;
import com.example.EngWorldBackend.Domain.Model.Course.Video;
import com.example.EngWorldBackend.Persistence.DAO.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class VideoMapper {

    @Autowired
    private CourseRepository courseRepository;

    public static VideoDto toDTO(Video video) {
        VideoDto dto = new VideoDto();
        dto.setVideoId(video.getId());
        dto.setTitle(video.getTitle());
        dto.setVideoPath(video.getVideoPath());
        dto.setCourseDto(CourseMapper.toDTO(video.getCourse()));
        return dto;
    }

    public Video toEntity(VideoDto dto) {
        Video video = new Video();
        video.setId(dto.getVideoId());
        courseRepository.findById(dto.getCourseDto().getCourseId()).ifPresent(video::setCourse);
        video.setVideoPath(dto.getVideoPath());
        return video;
    }

    public static VideoResponse mapToVideoResponse(List<VideoDto> videoDtos, Page<Video> videos) {
        VideoResponse videoResponse = new VideoResponse();
        videoResponse.setContent(videoDtos);
        videoResponse.setPageNumber(videos.getNumber());
        videoResponse.setPageSize(videos.getSize());
        videoResponse.setTotalElements(videos.getTotalElements());
        videoResponse.setTotalPages(videos.getTotalPages());
        videoResponse.setLast(videos.isLast());

        return videoResponse;
    }
}
