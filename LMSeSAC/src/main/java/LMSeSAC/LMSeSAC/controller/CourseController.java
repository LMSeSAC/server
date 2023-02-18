package LMSeSAC.LMSeSAC.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import LMSeSAC.LMSeSAC.dto.CourseDTO;
import LMSeSAC.LMSeSAC.response.BasicResponse;
import LMSeSAC.LMSeSAC.service.CourseService;
import lombok.RequiredArgsConstructor;

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
	public ResponseEntity<BasicResponse> getCourseByID(Model model, @PathVariable Integer ID) {
		CourseDTO.Response response = courseService.findById(ID);
		return ResponseEntity.ok(BasicResponse.builder().message("get success").data(response).build());
	}
}
