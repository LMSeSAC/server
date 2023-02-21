package LMSeSAC.LMSeSAC.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import LMSeSAC.LMSeSAC.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	Page<Course> findAllByCourseContaining(String course, Pageable pageable);
}
