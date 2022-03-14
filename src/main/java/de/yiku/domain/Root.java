package de.yiku.domain;

import java.util.ArrayList;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Root {
    private ArrayList<Result> results;
    private Info info;
}
