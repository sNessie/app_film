public class Film {
    private String title;
    private int year;
    private String director;
    private Genres genres;

    private Film(FilmBuilder filmBuilder) {
        this.title = filmBuilder.title;
        this.year = filmBuilder.year;
        this.director = filmBuilder.director;
        this.genres = filmBuilder.genres;

    }

    public static class FilmBuilder {
        private String title;
        private int year;
        private String director;
        private Genres genres;

        public FilmBuilder title(String title) {
            this.title = title;
            return this;
        }

        public FilmBuilder year(int year) {
            this.year = year;
            return this;
        }

        public FilmBuilder director(String director) {
            this.director = director;
            return this;
        }

        public FilmBuilder genres(Genres genres) {
            this.genres = genres;
            return this;
        }

        public Film build() {
            return new Film(this);
        }

    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", director='" + director + '\'' +
                ", genres=" + genres +
                '}';
    }
}
