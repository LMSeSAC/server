package LMSeSAC.LMSeSAC.dto;

import lombok.Builder;
import lombok.Data;

public class UserDTO {
	@Data
	@Builder
	public static class Response {
		private Integer id;
		private String userid;
		private String name;
		private String email;
		private String phone;
		private String type;
		private String role;
	}
}
