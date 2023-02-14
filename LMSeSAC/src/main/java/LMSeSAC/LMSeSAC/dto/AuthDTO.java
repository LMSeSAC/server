package LMSeSAC.LMSeSAC.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Builder;
import lombok.Data;

public class AuthDTO {
	@Data
	@Builder
	public static class Request {
		/*
		@NotBlank(message = "이메일 주소를 입력해주세요.")
		@Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",
			message = "이메일 형식에 맞게 입력해주세요.")
		private String email;
		 */
		@NotNull(message = "아이디를 입력해주세요.")
		private String uid;

		@NotNull(message = "비밀번호를 입력해주세요.")
		@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z]).{8,}",
			message = "비밀번호는 영어 소문자, 숫자를 포함하여 최소 8글자 이상이어야 합니다.")
		private String password;
	}

	@Data
	@Builder
	public static class RegisterRequest {
		@NotBlank(message = "이메일 주소를 입력해주세요.")
		@Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",
			message = "이메일 형식에 맞게 입력해주세요.")
		private String email;
		@NotNull(message = "아이디를 입력해주세요.")
		private String uid;
		@NotNull(message = "이름을 입력해주세요.")
		private String uname;
		@NotNull(message = "전화번호를 입력해주세요.")
		private String phone;
		private String utype;
		private String login_type;
		@NotNull(message = "비밀번호를 입력해주세요.")
		@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z]).{8,}",
			message = "비밀번호는 영어 소문자, 숫자를 포함하여 최소 8글자 이상이어야 합니다.")
		private String password;
	}

	@Data
	@Builder
	public static class Response {
		private String email;
		private String uname;
		private String utype;

	}
}
