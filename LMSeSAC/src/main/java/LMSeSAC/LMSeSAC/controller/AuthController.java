package LMSeSAC.LMSeSAC.controller;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import LMSeSAC.LMSeSAC.domain.User;
import LMSeSAC.LMSeSAC.dto.AuthDTO;
import LMSeSAC.LMSeSAC.dto.auth.Token;
import LMSeSAC.LMSeSAC.mapper.UserMapper;
import LMSeSAC.LMSeSAC.response.BasicResponse;
import LMSeSAC.LMSeSAC.service.AuthService;
import LMSeSAC.LMSeSAC.service.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {
	private final UserService userService;
	private final AuthService authService;

	@PostMapping("/login")
	public ResponseEntity<BasicResponse> login(@RequestBody AuthDTO.Request request) {
		User user = userService.getUserByID(request);
		Token token = authService.login(user, request);

		HttpHeaders responseHeaders = setHeader(token, true);

		return new ResponseEntity<>(
			BasicResponse.builder().message("login success").data(UserMapper.INSTANCE.toResponseDto(user)).build(),
			responseHeaders, HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<BasicResponse> register(@Valid @RequestBody AuthDTO.RegisterRequest request) {
		User user = userService.register(request);
		return ResponseEntity.ok(
			BasicResponse.builder().message("register success").data(UserMapper.INSTANCE.toResponseDto(user)).build());
	}

	private HttpHeaders setHeader(Token token, boolean isRefresh) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("X-AUTH-TOKEN", token.getAccessToken());

		if (isRefresh) {
			ResponseCookie responseCookie = ResponseCookie.from("X-REFRESH-COOKIE", token.getRefreshToken())
				.httpOnly(true)
				.secure(true)
				.path("/")
				.build();
			responseHeaders.set(HttpHeaders.SET_COOKIE, responseCookie.toString());
		}

		return responseHeaders;
	}
}
