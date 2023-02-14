package LMSeSAC.LMSeSAC.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasicResponse {
    private final Integer status = HttpStatus.OK.value();

    private String message;
    private Object data;
}
