package LMSeSAC.LMSeSAC.domain;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection="Course")
public class Course {
    private ObjectId id;
    private String c_name;
    private String campus;
    private String category;
    private String institution;
    private String period;
    private String c_code;
}
