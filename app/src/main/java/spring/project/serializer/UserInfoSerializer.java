
package main.java.spring.project.serializer;

import authservice.model.UserInfoDto;
import org.apache.kafka.common.serialization.Serializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class UserInfoSerializer implements Serializer<UserInfoDto> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // No configuration needed for this serializer
    }

    @Override
    public byte[] serialize(String arg0, UserInfoDto isKey) {
        byte[] retVal = null;
        objectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsBytes(isKey).getBytes();

        } catch (Exception e) {
            ex.printStackTrace();
        }

        return retVal;
    }

    @Override
    public void close() {
    };
}
