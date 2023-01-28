package LMSeSAC.LMSeSAC.service;

import LMSeSAC.LMSeSAC.domain.Course;
import LMSeSAC.LMSeSAC.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> findCourses() {
        return courseRepository.findAll();
    }
}
