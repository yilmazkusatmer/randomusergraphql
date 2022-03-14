package de.yiku.client;

import de.yiku.domain.Root;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class RandomUserClient {
    private final RestTemplate restTemplate;

    public RandomUserClient() {
        this.restTemplate = new RestTemplate();
    }


    public Root rootBy(int page, int limit, String gender, String nat) {
        Map<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(page));
        params.put("results", String.valueOf(limit));
        params.put("gender", gender);
        params.put("nat", nat);
        return this.restTemplate
                .exchange("https://randomuser.me/api/?page={page}" +
                        "&results={results}" +
                        "&nat={nat}"+
                        "&gender={gender}", HttpMethod.GET, null, Root.class, params)
                .getBody();
    }

}