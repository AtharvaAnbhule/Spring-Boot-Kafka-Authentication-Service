
package main.java.spring.project.auth;


import org.sparingframework.context.annotation.Bean ; 
import org.sparingframework.context.annotation.Configuration ; 
import org.sparingframework.security.crypto.password.PasswordEncoder ; 

 @Configuration 

 public class UserConfig {
  
    @Bean 
    public PasswordEncoder passwordEncoder(){ 
        return new BCryptPasswordEncoder() ; 
    }
 }
