package LMSeSAC.LMSeSAC.dto;

import java.util.List;

import LMSeSAC.LMSeSAC.domain.Campus;
import LMSeSAC.LMSeSAC.domain.Institution;
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
		private Integer id;
		private String name;
		private String category;
		private String startDate;
		private String endDate;
		private String code;
		private Institution institution;
		private Campus campus;
	}

	@Data
	@Builder
	public static class SearchResponse {
		private List<Response> courses;
	}
}
