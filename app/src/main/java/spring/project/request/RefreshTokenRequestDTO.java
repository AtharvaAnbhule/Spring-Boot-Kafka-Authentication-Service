
package main.java.spring.project.request;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RefreshTokenRequestDTO {
    private String token;

}
