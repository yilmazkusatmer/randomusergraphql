package de.yiku.client;

import de.yiku.domain.Root;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;




@Controller
public class RootQueryController {
    private final RandomUserClient client;

    public RootQueryController(RandomUserClient client) {
        this.client = client;
    }

    @QueryMapping
    public Root root(@Argument  int page, @Argument int limit, @Argument String gender) {
        return client.root(page, limit, gender);
    }

}
