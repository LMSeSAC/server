package LMSeSAC.LMSeSAC.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefreshResponse {

	private final Integer status = HttpStatus.ACCEPTED.value();

	private String message;
}