package de.yiku.domain;

import java.util.ArrayList;
@SuppressWarnings("unused")
public class Root {
    private final ArrayList<Result> results;
    private final Info info;

    public Root(ArrayList<Result> results, Info info) {
        this.results = results;
        this.info = info;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public Info getInfo() {
        return info;
    }
}
