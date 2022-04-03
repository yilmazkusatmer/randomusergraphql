package de.yiku.client;

import de.yiku.domain.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class RootQueryController {
    private final RandomUserClient client;

    public RootQueryController(RandomUserClient client) {
        this.client = client;
    }

    @QueryMapping(value = "root")
    public Root fetchRoot(@Argument int page, @Argument int limit, @Argument String gender) {
        return client.fetchRoot(page, limit, gender);
    }

}
