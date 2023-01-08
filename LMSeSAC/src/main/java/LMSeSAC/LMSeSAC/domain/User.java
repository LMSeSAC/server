package LMSeSAC.LMSeSAC.domain;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection="User")
public class User {
    private ObjectId id;
    private String u_id;
    private String u_name;
    private String password;
    private String email;
    private String phone;
    private String u_type;
    private String login_type;
}
