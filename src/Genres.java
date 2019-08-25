public enum Genres {

    ACTION("Action"),
    COMEDY("Comedy"),
    DRAMA("Drama"),
    THRILLER("Thriller"),
    SCIFI("Sci-fi");


    private String genres;

    Genres(String genres) {
        this.genres = genres;
    }

    public String getValue() {
        return genres;
    }
}
