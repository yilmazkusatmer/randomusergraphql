package de.yiku.domain;
@SuppressWarnings("unused")
public class Id {
    private final String name;
    private final String value;

    public Id(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
