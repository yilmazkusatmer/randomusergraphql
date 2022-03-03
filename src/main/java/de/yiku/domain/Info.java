package de.yiku.domain;
@SuppressWarnings("unused")
public class Info {
    private final String seed;
    private final int results;
    private final int page;
    private final String version;

    public Info(String seed, int results, int page, String version) {
        this.seed = seed;
        this.results = results;
        this.page = page;
        this.version = version;
    }

    public String getSeed() {
        return seed;
    }

    public int getResults() {
        return results;
    }

    public int getPage() {
        return page;
    }

    public String getVersion() {
        return version;
    }
}
