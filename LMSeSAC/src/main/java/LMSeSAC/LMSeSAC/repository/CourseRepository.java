package LMSeSAC.LMSeSAC.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import LMSeSAC.LMSeSAC.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	Page<Course> findAllByNameContaining(String name, Pageable pageable);
}
