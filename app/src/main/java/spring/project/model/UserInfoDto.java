
package main.java.spring.project.model;

import main.java.spring.project.entities.UserInfo;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) 

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoDto extends UserInfo {
    private String username;
    private String password;
    private Long phoneNumber;
    private String email;
}
