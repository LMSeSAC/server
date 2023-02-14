package LMSeSAC.LMSeSAC.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import LMSeSAC.LMSeSAC.domain.User;
import LMSeSAC.LMSeSAC.dto.AuthDTO;
import LMSeSAC.LMSeSAC.mapper.UserMapper;
import LMSeSAC.LMSeSAC.response.BasicResponse;
import LMSeSAC.LMSeSAC.service.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {
	private final UserService userService;

	@PostMapping("/login")
	public ResponseEntity<BasicResponse> login(@RequestBody AuthDTO.Request request) {
		User user = userService.getUserByID(request);

		return ResponseEntity.ok(
			BasicResponse.builder().message("login success").data(UserMapper.INSTANCE.toResponseDto(user)).build());
	}

	@PostMapping("/register")
	public ResponseEntity<BasicResponse> register(@Valid @RequestBody AuthDTO.RegisterRequest request) {
		User user = userService.register(request);
		return ResponseEntity.ok(
			BasicResponse.builder().message("register success").data(UserMapper.INSTANCE.toResponseDto(user)).build());
	}
}
