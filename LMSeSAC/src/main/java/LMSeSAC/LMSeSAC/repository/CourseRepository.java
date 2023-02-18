package LMSeSAC.LMSeSAC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import LMSeSAC.LMSeSAC.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
