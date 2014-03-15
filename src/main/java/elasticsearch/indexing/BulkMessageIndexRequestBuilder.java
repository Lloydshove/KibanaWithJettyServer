package elasticsearch.indexing;

import elasticsearch.indexing.domain.Message;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.client.Client;

public class BulkMessageIndexRequestBuilder {
    private final Client client;
    private ElasticSearchEnvironment env;

    public BulkMessageIndexRequestBuilder(Client client, ElasticSearchEnvironment env) {
        this.client = client;
        this.env = env;
    }

    public BulkRequestBuilder buildFor(int requestsPerBulkInsert) {
        BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();
        for (int i = 0; i < requestsPerBulkInsert; i++) {
            bulkRequestBuilder.add(buildRandomIndexRequest(client).request());
        }
        return bulkRequestBuilder;
    }

    private IndexRequestBuilder buildRandomIndexRequest(Client client) {
        IndexRequestBuilder requestBuilder = client.prepareIndex(env.indexName(), env.documentType());
        return requestBuilder.setSource(JsonMessageFormatter.format(Message.newMessage()));
    }

}
