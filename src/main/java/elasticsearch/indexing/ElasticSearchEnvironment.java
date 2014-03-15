package elasticsearch.indexing;

public enum ElasticSearchEnvironment {

    Local("localhost", 9300, "messages_with_read", "messages");

    private final String elasticServer;
    private final int elasticPort;
    private final String indexName;
    private final String documentType;

    ElasticSearchEnvironment(String elasticServer, int elasticPort, String indexName, String documentType) {
        this.elasticServer = elasticServer;
        this.elasticPort = elasticPort;
        this.indexName = indexName;
        this.documentType = documentType;
    }


    public String server() {
        return elasticServer;
    }

    public int port() {
        return elasticPort;
    }

    public String indexName() {
        return indexName;
    }

    public String documentType() {
        return documentType;
    }
}
