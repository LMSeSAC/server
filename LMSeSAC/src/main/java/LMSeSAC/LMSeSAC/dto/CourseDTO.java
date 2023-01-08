package LMSeSAC.LMSeSAC.dto;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
public class CourseDTO {
    private ObjectId id;
    private String c_name;
    private String campus;
    private String category;
    private String institution;
    private String period;
    private String c_code;
}
