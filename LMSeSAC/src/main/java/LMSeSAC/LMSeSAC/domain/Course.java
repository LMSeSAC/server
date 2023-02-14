package LMSeSAC.LMSeSAC.domain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "Course")
public class Course {
	private ObjectId _id;
	private String cname;
	private String campus;
	private String category;
	private String institution;
	private String period;
	private String ccode;
}
