package elasticsearch.indexing.domain;

import org.elasticsearch.common.joda.time.LocalDateTime;
import org.elasticsearch.common.joda.time.format.DateTimeFormat;

import java.util.Random;

public class Message {
    private static final Random RANDOM = new Random();

    private final MessageType type;
    private final Topic topic;
    private final LocalDateTime startDate;
    private final Integer duration;
    private final Boolean read;

    public Message(MessageType type, Topic topic, LocalDateTime startDate) {
        this.type = type;
        this.topic = topic;
        this.startDate = startDate;
        duration = type.randomDuration();
        read = RANDOM.nextBoolean();
    }

    public static Message newMessage() {
        return new Message(MessageType.random(), Topic.random(), randomDate());
    }

    public MessageType type() {
        return type;
    }

    public Topic topic() {
        return topic;
    }

    public LocalDateTime startDate() {
        return startDate;
    }

    public Integer duration() {
        return duration;
    }

    public static LocalDateTime randomDate() {
        LocalDateTime dateTime = LocalDateTime.parse("2014-03-01",
                DateTimeFormat.forPattern("yyyy-MM-dd"));
        return dateTime.plusDays(RANDOM.nextInt(30))
                .plusHours(RANDOM.nextInt(24))
                .plusMinutes(RANDOM.nextInt(60))
                .plusSeconds(RANDOM.nextInt(60))
                .plusMillis(RANDOM.nextInt(1000));
    }

    public Boolean read() {
        return read;
    }
}
