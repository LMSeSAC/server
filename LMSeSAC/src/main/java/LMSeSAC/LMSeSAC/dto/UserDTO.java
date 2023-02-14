package LMSeSAC.LMSeSAC.dto;

import org.bson.types.ObjectId;

import lombok.Builder;
import lombok.Data;

public class UserDTO {
	@Data
	@Builder
	public static class Response {
		private ObjectId _id;
		private String uid;
		private String uname;
		private String email;
		private String phone;
		private String utype;
		private String login_type;
	}
}
