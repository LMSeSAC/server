package LMSeSAC.LMSeSAC.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Token {

	private String accessToken;
	private String refreshToken;
}