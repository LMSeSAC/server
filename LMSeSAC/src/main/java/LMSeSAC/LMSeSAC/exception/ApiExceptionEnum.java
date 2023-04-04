package LMSeSAC.LMSeSAC.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.ToString;

/*
API 예외 처리를 정의합니다.
 */
@Getter
@ToString
public enum ApiExceptionEnum {
	// General Exception
	BAD_REQUEST_EXCEPTION(HttpStatus.BAD_REQUEST, "요청 변수를 확인해주세요."),
	UNAUTHORIZED_EXCEPTION(HttpStatus.UNAUTHORIZED, "인증이 실패하였습니다."),
	ACCESS_DENIED_EXCEPTION(HttpStatus.FORBIDDEN, "제한된 접근입니다."),
	NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "요청한 자원이 없습니다."),
	DUPLICATION_VALUE_EXCEPTION(HttpStatus.CONFLICT, "이미 존재하는 값입니다."),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버가 응답하지 않습니다."),

	// Custom Exception
	USER_NOT_FOUND_EXCEPTION(HttpStatus.BAD_REQUEST, "올바른 유저를 찾을 수 없습니다."),
	LOGIN_FAIL_EXCEPTION(HttpStatus.BAD_REQUEST, "아이디 또는 비밀번호가 틀립니다."),
	EMAIL_DUPLICATION_EXCEPTION(HttpStatus.BAD_REQUEST, "중복된 이메일입니다."),
	COURSE_NOT_FOUND_EXCEPTION(HttpStatus.BAD_REQUEST, "해당하는 강좌를 찾을 수 없습니다."),

	// Token Exception
	EXPIRED_TOKEN_EXCEPTION(HttpStatus.UNAUTHORIZED, "만료된 토큰입니다."),
	EXPIRED_REFRESH_TOKEN_EXCEPTION(HttpStatus.UNAUTHORIZED, "만료된 토큰입니다. 회원가입을 다시 시도하십시오."),
	NO_EXPIRED_TOKEN_EXCEPTION(HttpStatus.BAD_REQUEST, "만료되지 않은 토큰입니다."),
	MALFORED_TOKEN_EXCEPTION(HttpStatus.BAD_REQUEST, "위조된 토큰입니다."),
	NOT_FOUND_TOKEN_EXCEPTION(HttpStatus.NOT_FOUND, "비어있는 토큰입니다.");
	private final HttpStatus httpStatus;
	private final Integer status;
	private final String message;

	ApiExceptionEnum(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.status = httpStatus.value();
		this.message = message;
	}
}