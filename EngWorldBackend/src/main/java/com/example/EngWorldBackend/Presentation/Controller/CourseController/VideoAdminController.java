package com.example.EngWorldBackend.Presentation.Controller.CourseController;

import com.example.EngWorldBackend.DTO.Course.VideoDto;
import com.example.EngWorldBackend.DTO.Course.VideoResponse;
import com.example.EngWorldBackend.Domain.Model.Course.Video;
import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import com.example.EngWorldBackend.Domain.Respones.ResponseUtils;
import com.example.EngWorldBackend.Domain.Service.CourseService.VideoService;
import com.example.EngWorldBackend.Mapper.VideoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.EngWorldBackend.Domain.Respones.ResponseMessages.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin/video")
public class VideoAdminController {

    private final VideoService videoService;

    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllVideo(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
                                                      @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        Page<Video> videos = videoService.getAllVideo(pageNumber, pageSize);
        List<VideoDto> response = new ArrayList<>();

        for (Video video : videos) {
            VideoDto videoDto = VideoMapper.toDTO(video);
            response.add(videoDto);
        }

        VideoResponse videoResponse = VideoMapper.mapToVideoResponse(response, videos);
        return ResponseUtils.buildSuccessResponse(videoResponse, SUCCESS_RESPONSE);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable long id) {
        Optional<Video> optionalVideo = videoService.getVideoById(id);
        if (optionalVideo.isPresent()) {
            Video video = optionalVideo.get();
            VideoDto videoDto = VideoMapper.toDTO(video);
            return ResponseUtils.buildSuccessResponse(videoDto, SUCCESS_RESPONSE);
        } else {
            return ResponseUtils.buildErrorResponse(HttpStatus.NOT_FOUND, NOTFOUND_RESPONSE + id);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseObject> deleteVideoById(@RequestParam long videoId) {
        try {
            videoService.deleteVideoById(videoId);
            return ResponseUtils.buildCreatedResponse(null, DELETE_SUCCESS_RESPONSE);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, "Failed to delete data: " + e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseObject> updateVideoById(@RequestParam long id, @RequestBody Video newVideo) throws Exception {
        try {
            VideoDto videoDto = VideoMapper.toDTO(videoService.updateVideoById(id, newVideo));
            return ResponseUtils.buildCreatedResponse(videoDto, SUCCESS_RESPONSE);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, BAD_REQUEST + e.getMessage());
        }
    }

    @GetMapping("/byCourse/{id}")
    public ResponseEntity<ResponseObject> getAllByCourse(@PathVariable Long id
            , @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber
            , @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        Page<Video> videos = videoService.getVideoByCourse(id, pageNumber, pageSize);
        List<VideoDto> response = new ArrayList<>();

        for (Video video : videos) {
            VideoDto videoDto = VideoMapper.toDTO(video);
            response.add(videoDto);
        }
        VideoResponse videoResponse = VideoMapper.mapToVideoResponse(response, videos);
        return ResponseUtils.buildSuccessResponse(videoResponse, SUCCESS_RESPONSE);
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseObject> uploadVideo(@RequestBody MultipartFile file
            , @RequestParam long courseId
            , @RequestParam String title) {
        try {
            VideoDto videoDto = videoService.uploadVideo(file, courseId, title);
            return ResponseUtils.buildCreatedResponse(videoDto, CREATED_SUCCESS_RESPONES);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, BAD_REQUEST + e.getMessage());
        }

    }
}
