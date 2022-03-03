package de.yiku.client;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Component
public class GraphQLProvider {
    private final GraphQLDataFetcher dataFetcher;
    private GraphQL graphQL;

    public GraphQLProvider(GraphQLDataFetcher dataFetcher) {
        this.dataFetcher = dataFetcher;
    }

    @PostConstruct
    public void init() throws IOException {
        File schema = ResourceUtils.getFile("classpath:schema.graphql");
        String sdl = null;
        try {
            byte[] fileData = Files.readAllBytes(schema.toPath());
            sdl = new String(fileData, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("result", dataFetcher.getRandomUser()))
                .build();
    }

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }
}