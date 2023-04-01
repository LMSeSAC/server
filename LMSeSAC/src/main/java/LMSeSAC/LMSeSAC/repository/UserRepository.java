package LMSeSAC.LMSeSAC.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import LMSeSAC.LMSeSAC.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserid(String userId);

	Optional<User> findByEmail(String email);
}
