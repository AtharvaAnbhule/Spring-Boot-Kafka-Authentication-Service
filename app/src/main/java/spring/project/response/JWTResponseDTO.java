


package main.java.spring.project.response;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JWTResponseDTO { 
    private String accessToken ; 
    private String token;
}
