package de.yiku.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Dob {
    private Instant date;
    private int age;
}
