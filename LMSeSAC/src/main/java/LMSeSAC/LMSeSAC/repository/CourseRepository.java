package LMSeSAC.LMSeSAC.repository;

import LMSeSAC.LMSeSAC.domain.Course;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, ObjectId> {
}
