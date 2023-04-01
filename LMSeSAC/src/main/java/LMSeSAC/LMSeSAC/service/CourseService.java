package LMSeSAC.LMSeSAC.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import LMSeSAC.LMSeSAC.domain.Course;
import LMSeSAC.LMSeSAC.dto.CourseDTO;
import LMSeSAC.LMSeSAC.exception.ApiException;
import LMSeSAC.LMSeSAC.exception.ApiExceptionEnum;
import LMSeSAC.LMSeSAC.mapper.CourseMapper;
import LMSeSAC.LMSeSAC.repository.CourseRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {

	@Autowired
	private final CourseRepository courseRepository;

	public CourseDTO.SearchResponse findCourses() {
		List<Course> courses = courseRepository.findAll();
		List<CourseDTO.Response> responseList = new ArrayList<>();

		courses.forEach(course -> responseList.add(CourseMapper.INSTANCE.toResponseDto(course)));

		return CourseDTO.SearchResponse.builder().courses(responseList).build();
	}

	public CourseDTO.Response findById(Integer ID) {
		Optional<Course> course = courseRepository.findById(ID);
		if (course.isEmpty()) {
			throw new ApiException(ApiExceptionEnum.COURSE_NOT_FOUND_EXCEPTION);
		}

		CourseDTO.Response result = CourseMapper.INSTANCE.toResponseDto(course.get());
		return result;
	}

	public CourseDTO.SearchResponse search(CourseDTO.SearchRequest request) {
		Pageable page = PageRequest.of(request.getPage() - 1, 12, Sort.by("id").descending());
		Page<Course> courses =
			courseRepository.findAllByNameContaining(request.getName(), page);
		List<CourseDTO.Response> courseList = new ArrayList<>();

		courses.forEach(course -> courseList.add(CourseMapper.INSTANCE.toResponseDto(course)));
		return CourseDTO.SearchResponse.builder().courses(courseList).build();
	}
}
