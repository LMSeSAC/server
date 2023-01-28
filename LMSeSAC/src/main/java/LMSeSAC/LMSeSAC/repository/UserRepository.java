package LMSeSAC.LMSeSAC.repository;

import LMSeSAC.LMSeSAC.domain.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
}
