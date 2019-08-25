public enum Genres {

    ACTION("action"),
    COMEDY("comedy"),
    DRAMA("drama"),
    THRILLER("thriller"),
    SCIFI("scifi");


    private String genres;

    Genres(String genres) {
        this.genres = genres;
    }

    public String getValue() {
        return genres;
    }

}
