package de.yiku.domain;

import java.time.Instant;
@SuppressWarnings("unused")
public class Registered {
    private final Instant date;
    private final int age;

    public Registered(Instant date, int age) {
        this.date = date;
        this.age = age;
    }

    public Instant getDate() {
        return date;
    }

    public int getAge() {
        return age;
    }
}
