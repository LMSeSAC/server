package LMSeSAC.LMSeSAC.dto;

import java.util.List;

import org.bson.types.ObjectId;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDTO {
	@Data
	@Builder
	public static class Request {

	}

	@Data
	@Builder
	public static class Response {
		private ObjectId _id;
		private String cname;
		private String campus;
		private String category;
		private String institution;
		private String period;
		private String ccode;
	}

	@Data
	@Builder
	public static class SearchResponse {
		private List<Response> courses;
	}
}
