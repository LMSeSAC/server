package LMSeSAC.LMSeSAC.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import LMSeSAC.LMSeSAC.domain.User;

public interface UserRepository extends MongoRepository<User, ObjectId> {
	Optional<User> findByUid(String uid);

	Optional<User> findByEmail(String email);
}
