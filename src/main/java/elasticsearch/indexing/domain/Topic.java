package elasticsearch.indexing.domain;

import java.util.Random;

public enum Topic {
    Family,
    Friends,
    Work;

    private static final Random RANDOM = new Random();

    public static Topic random() {
        int randomIndex = RANDOM.nextInt(values().length);
        return values()[randomIndex];
    }
}
