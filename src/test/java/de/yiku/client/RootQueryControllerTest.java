package de.yiku.client;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.yiku.domain.Name;
import de.yiku.domain.Root;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.graphql.boot.test.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

import java.io.File;
import java.io.IOException;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;

@GraphQlTest(RootQueryController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RootQueryControllerTest {


    private final String query  = "{\n" +
            "  root{\n" +
            "    results {\n" +
            "      name {\n" +
            "        first\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}";

    @Value("classpath:Root.json")
    Resource resourceFile;

    @Autowired
    private GraphQlTester graphQlTester;

    @MockBean
    private RandomUserClient randomUserClient;

    private Root root;

    @BeforeAll
    public void setUp() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        File jsonTestFile = resourceFile.getFile();
        this.root = mapper.readValue(jsonTestFile, Root.class);
    }

    @Test
    void should_have_size_one()  {
        given(this.randomUserClient.root(anyInt(), anyInt(), anyString()))
                .willReturn(this.root);

        this.graphQlTester.query(query)
                .execute()
                .path("data.root")
                .entity(Root.class)
                .satisfies(root -> assertThat(root.getResults()).hasSize(1));
    }

    @Test
    void should_return_correct_name() {
        given(this.randomUserClient.root(anyInt(), anyInt(), anyString()))
                .willReturn(this.root);

        this.graphQlTester.query(query)
                .execute()
                .path("data.root.results[0].name")
                .entity(Name.class)
                .satisfies(name -> assertThat(name.getFirst()).isEqualTo("Elizabeth"));

    }

}
