
package spring.project.eventProducer;

import org.springframework.stereotype.Service;

@Service

public class userInfoProducer {
    private final KafkaTemplate<String, UserInfoDto> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")
    private static final String TOPIC_NAME;

    @Autowired
    userInfoProducer(KafkaTemplate<String, UserInfoDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEventToKafka(UserInfoDto userInfoDto) {
        Message<UserInfoDto> message = MessageBuilder
                .withPayload(userInfoDto)
                .setHeader(KafkaHeaders.TOPIC, TOPIC_NAME)
                .build();
        kafkaTemplate.send(message);
    }

    // the producer from the userinfodto to kafka will be serialize means converting
    // in thew forms of the bits and when kafka to the userService it is deserialize
    // .
}
