package elasticsearch.indexing;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import static java.lang.System.out;

public class MessageIndexer {

    private static final int REQUESTS_PER_BULK_INSERT = 100000;
    private static final int NUMBER_OF_BULK_INSERTS = 1;

    private final Client client;
    private ElasticSearchEnvironment env;

    public MessageIndexer(ElasticSearchEnvironment env) {
        this.env = env;
        this.client = new TransportClient()
                .addTransportAddress(new InetSocketTransportAddress(env.server(), env.port()));
    }


    private void indexData() {
        for (int n = 0; n < NUMBER_OF_BULK_INSERTS; n++) {
            BulkRequestBuilder bulkRequestBuilder = new BulkMessageIndexRequestBuilder(client, env)
                                                                        .buildFor(REQUESTS_PER_BULK_INSERT);
            bulkRequestBuilder.execute().actionGet();
        }
    }

    public static void main(String[] args) throws Exception {
        MessageIndexer injector = new MessageIndexer(ElasticSearchEnvironment.Local);

        long startTime = System.currentTimeMillis();

        injector.indexData();

        out.println(System.currentTimeMillis() - startTime + "ms " +
                "to add " + REQUESTS_PER_BULK_INSERT * NUMBER_OF_BULK_INSERTS + " entries");
    }


}
