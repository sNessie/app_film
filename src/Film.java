import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    static Film addFilm() {
        List<String> film = new ArrayList<>(4);
        System.out.println("Podaj tytuł filmu");
        Scanner input = new Scanner(System.in);
        film.add(input.nextLine());
        System.out.println("Podaj rok produkcji");
        film.add(input.nextLine());
        System.out.println("Podaj dyrektora");
        film.add(input.nextLine());
        System.out.println("Wybierz kategorię:");
        for (Genres g : Genres.values()) {
            System.out.println(g);
        }
        film.add(input.nextLine().toUpperCase());
        Film newFilm = new FilmBuilder()
                .title(film.get(0))
                .year(Integer.parseInt(film.get(1)))
                .director(film.get(2))
                .genres(Genres.valueOf(film.get(3)))
                .build();

        return newFilm;
    }

    @Override
    public String toString() {
        return title + " - "
                + year + " - "
                + director + " - "
                + genres;
    }
}
