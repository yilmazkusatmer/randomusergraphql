package de.yiku.domain;
@SuppressWarnings("unused")
public class Name{
    private final String title;
    private final String first;
    private final String last;

    public Name(String title, String first, String last) {
        this.title = title;
        this.first = first;
        this.last = last;
    }

    public String getTitle() {
        return title;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
}


