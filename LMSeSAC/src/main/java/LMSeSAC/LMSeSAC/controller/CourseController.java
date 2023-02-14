package LMSeSAC.LMSeSAC.controller;

import LMSeSAC.LMSeSAC.domain.Course;
import LMSeSAC.LMSeSAC.dto.CourseDTO;
import LMSeSAC.LMSeSAC.response.BasicResponse;
import LMSeSAC.LMSeSAC.service.CourseService;
import LMSeSAC.LMSeSAC.service.UserService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/all")
    public ResponseEntity<BasicResponse> getCourses(Model model) {
        CourseDTO.SearchResponse searchResponse = courseService.findCourses();
        return ResponseEntity.ok(BasicResponse.builder().message("get all success").data(searchResponse).build());
    }

    @GetMapping("/{ID}")
    public ResponseEntity<BasicResponse> getCourseByID(Model model, @PathVariable ObjectId ID) {
        CourseDTO.Response response = courseService.findById(ID);
        return ResponseEntity.ok(BasicResponse.builder().message("get success").data(response).build());
    }
}
