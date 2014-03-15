package elasticsearch.indexing;

import elasticsearch.indexing.domain.Message;
import org.elasticsearch.common.joda.time.LocalDateTime;

public class JsonMessageFormatter {

    private static final String TOPIC = "%%TOPIC%%";
    private static final String POST_DATE = "%%TIMESTAMP%%";
    private static final String READ = "%%READ%%";
    private static final String DURATION = "%%DURATION%%";
    private static final String MESSAGE_TYPE = "%%MESSAGE_TYPE%%";

    private static final String ELASTIC_TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";//2009-12-16T15:12:12


    private static String MESSAGE_DATA_TEMPLATE =
            "{\n" +
                    "    \"topic\" : \"" + TOPIC + "\",\n" +
                    "    \"post_date\" : \"" + POST_DATE + "\",\n" +
                    "    \"message\" : \"trying out Elasticsearch\" , " +
                    "    \"message_type\" : \"" + MESSAGE_TYPE + "\" , " +
                    "    \"read\" : " + READ + " , " +
                    "    \"duration\" : " + DURATION + "\n" +
                    "}";


    public static byte[] format(Message message) {
        return MESSAGE_DATA_TEMPLATE
                .replace(MESSAGE_TYPE, message.type().toString())
                .replace(TOPIC, message.topic().toString())
                .replace(POST_DATE, toTimeStamp(message.startDate()))
                .replace(DURATION, message.duration().toString())
                .replace(READ, message.read().toString())
                .getBytes();
    }

    private static String toTimeStamp(LocalDateTime dateTime) {
        return dateTime.toString(ELASTIC_TIMESTAMP_FORMAT);
    }

}
