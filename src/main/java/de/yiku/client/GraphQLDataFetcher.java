package de.yiku.client;

import de.yiku.domain.Root;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GraphQLDataFetcher {
    private final RestTemplate restTemplate;

    public GraphQLDataFetcher(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public DataFetcher<Root> getRandomUser() {
        return this::getRoot;
    }

    private Root getRoot(DataFetchingEnvironment dataFetchingEnvironment) {
        return this.restTemplate
                .exchange("https://randomuser.me/api/", HttpMethod.GET, null, Root.class)
                .getBody();
    }
}
