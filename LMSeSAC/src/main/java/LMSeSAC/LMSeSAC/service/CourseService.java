package LMSeSAC.LMSeSAC.service;

import LMSeSAC.LMSeSAC.domain.Course;
import LMSeSAC.LMSeSAC.dto.CourseDTO;
import LMSeSAC.LMSeSAC.exception.ApiException;
import LMSeSAC.LMSeSAC.exception.ApiExceptionEnum;
import LMSeSAC.LMSeSAC.mapper.CourseMapper;
import LMSeSAC.LMSeSAC.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseDTO.SearchResponse findCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDTO.Response> responseList = new ArrayList<>();

        courses.forEach(course -> responseList.add(CourseMapper.INSTANCE.toResponseDto(course)));

        return CourseDTO.SearchResponse.builder().courses(responseList).build();
    }
    public CourseDTO.Response findById(ObjectId ID) {
        Optional<Course> course = courseRepository.findById(ID);
        if ( course.isEmpty() ) {
            throw new ApiException(ApiExceptionEnum.COURSE_NOT_FOUND_EXCEPTION);
        }

        CourseDTO.Response result = CourseMapper.INSTANCE.toResponseDto(course.get());
        return result;
    }
}
