package elasticsearch.indexing.domain;

import java.util.Random;

public enum MessageType {
    Email(10000),
    Sms(1000),
    Whatsapp(3000);

    private final int maximumDurationMillis;
    private static final Random RANDOM = new Random();

    MessageType(int maximumDurationMillis) {
        this.maximumDurationMillis = maximumDurationMillis;
    }

    public static MessageType random() {
        int randomIndex = RANDOM.nextInt(values().length);
        return values()[randomIndex];
    }

    public Integer randomDuration() {
        return RANDOM.nextInt(maximumDurationMillis);
    }

}
