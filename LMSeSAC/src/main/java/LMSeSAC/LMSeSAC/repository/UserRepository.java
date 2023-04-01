package LMSeSAC.LMSeSAC.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import LMSeSAC.LMSeSAC.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserid(String userId);

	Optional<User> findByEmail(String email);
}
