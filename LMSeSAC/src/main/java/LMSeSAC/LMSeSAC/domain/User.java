package LMSeSAC.LMSeSAC.domain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "User")
public class User {
	private ObjectId _id;
	private String uid;
	private String uname;
	private String password;
	private String email;
	private String phone;
	private String utype;
	private String login_type;
}
