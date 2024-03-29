import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

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

    static Film addNewFilmToFile(List<String> film) {
        Film newFilm = new FilmBuilder()
                .title(film.get(0))
                .year(Integer.parseInt(film.get(1)))
                .director(film.get(2))
                .genres(Genres.valueOf(film.get(3)))
                .build();
        return newFilm;
    }

    static void readFilmFromFile(Path path) {
        try {
            Film film;
            for (String line : Files.readAllLines(path)) {
                String[] elements = line.split(" - ");
                film = new FilmBuilder()
                        .title(elements[0])
                        .year(Integer.parseInt(elements[1]))
                        .director(elements[2])
                        .genres(Genres.valueOf(elements[3]))
                        .build();
                System.out.println(film.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return title + " - "
                + year + " - "
                + director + " - "
                + genres;
    }
}
