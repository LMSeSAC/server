package LMSeSAC.LMSeSAC.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import LMSeSAC.LMSeSAC.domain.User;
import LMSeSAC.LMSeSAC.dto.AuthDTO;
import LMSeSAC.LMSeSAC.exception.ApiException;
import LMSeSAC.LMSeSAC.exception.ApiExceptionEnum;
import LMSeSAC.LMSeSAC.mapper.UserMapper;
import LMSeSAC.LMSeSAC.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	@Autowired
	private final PasswordEncoder passwordEncoder;

	public User getUserByID(AuthDTO.Request request) {
		User requestUser = UserMapper.INSTANCE.toEntity(request);
		Optional<User> user = userRepository.findByUid(requestUser.getUid());

		user.orElseThrow(() -> new ApiException(ApiExceptionEnum.LOGIN_FAIL_EXCEPTION));

		if (passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
			return user.get();
		} else {
			throw new ApiException(ApiExceptionEnum.LOGIN_FAIL_EXCEPTION);
		}
	}

	public User register(AuthDTO.RegisterRequest request) {
		Optional<User> user = userRepository.findByEmail(request.getEmail());
		if (user.isPresent()) {
			throw new ApiException(ApiExceptionEnum.EMAIL_DUPLICATION_EXCEPTION);
		}

		request.setPassword(passwordEncoder.encode(request.getPassword()));
		request.setUtype("TEACHER");
		request.setLogin_type("GENERAL");

		User cUser = UserMapper.INSTANCE.toEntityRegister(request);
		return userRepository.save(cUser);
	}
}
