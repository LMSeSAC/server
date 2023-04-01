package LMSeSAC.LMSeSAC.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import LMSeSAC.LMSeSAC.domain.User;
import LMSeSAC.LMSeSAC.dto.AuthDTO;
import LMSeSAC.LMSeSAC.dto.auth.Token;
import LMSeSAC.LMSeSAC.exception.ApiException;
import LMSeSAC.LMSeSAC.exception.ApiExceptionEnum;
import LMSeSAC.LMSeSAC.utils.JwtProvider;
import LMSeSAC.LMSeSAC.utils.RedisClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	@Value("${spring.jwt.redis_token_expiration_time")
	private Long redisTokenExpirationTime;
	private final PasswordEncoder passwordEncoder;

	private final JwtProvider jwtProvider;
	private final RedisClient redisClient;

	public Token login(User user, AuthDTO.Request request) {
		if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			Token token = generateToken(user.getId(), user.getUserid());
			session(token.getAccessToken(), user.getId());
			return token;
		} else {
			throw new ApiException(ApiExceptionEnum.LOGIN_FAIL_EXCEPTION);
		}
	}

	public Token generateToken(int id, String userId) {
		Token token = new Token();
		token.setAccessToken(jwtProvider.generateAccessToken(id, userId));
		token.setRefreshToken(jwtProvider.generateRefreshToken(id, userId));

		return token;
	}

	private void session(String token, int id) {
		redisClient.setValue(token, Integer.toString(id), redisTokenExpirationTime);
	}
}
