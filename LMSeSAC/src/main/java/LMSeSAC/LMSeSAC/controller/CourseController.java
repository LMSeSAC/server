package LMSeSAC.LMSeSAC.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
	public ResponseEntity<BasicResponse> getCourses() {
		CourseDTO.SearchResponse searchResponse = courseService.findCourses();
		return ResponseEntity.ok(BasicResponse.builder().message("get all success").data(searchResponse).build());
	}

	@GetMapping("/{id}")
	public ResponseEntity<BasicResponse> getCourseByID(@PathVariable Integer id) {
		CourseDTO.Response response = courseService.findById(id);
		return ResponseEntity.ok(BasicResponse.builder().message("get success").data(response).build());
	}

	@GetMapping("/search")
	public ResponseEntity<BasicResponse> getCourseByName(CourseDTO.SearchRequest searchRequest) {
		CourseDTO.SearchResponse searchResponse = courseService.search(searchRequest);
		return ResponseEntity.ok(BasicResponse.builder().message("get search success").data(searchResponse).build());
	}
}
