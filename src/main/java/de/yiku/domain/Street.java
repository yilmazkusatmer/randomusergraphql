package de.yiku.domain;
@SuppressWarnings("unused")
public class Street{
    private final int number;
    private final String name;

    public Street(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}