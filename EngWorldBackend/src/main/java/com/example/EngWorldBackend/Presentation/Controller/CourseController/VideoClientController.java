package com.example.EngWorldBackend.Presentation.Controller.CourseController;

import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client/video")
public class VideoClientController {

    private final VideoAdminController videoAdminController;

    @GetMapping("/get")
    public ResponseEntity<ResponseObject> getAllVideo(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        return videoAdminController.getAllVideo(pageNumber, pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findVideoById(@PathVariable long id) {
        return videoAdminController.getById(id);
    }

    @GetMapping("/byCourse/{id}")
    public ResponseEntity<ResponseObject> getAllByCourse(@PathVariable Long id
            , @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber
            , @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        return videoAdminController.getAllByCourse(id, pageNumber, pageSize);
    }
}
