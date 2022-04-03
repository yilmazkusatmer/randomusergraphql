package de.yiku.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Root {
    @JsonProperty("results")
    @JsonAlias("users")
    private List<User> users;
    private Info info;
}
