import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    /*
     * Napisz program, który będzie zapisywał obejrzane filmy
     * i zapisze je do pliku. User będzie mógł podać wiele filmów naraz.
     * Film będzie zawierał: tytuł (String), rok produkcji (int), reżysera(String), gatunek (enum)
     * Program będzie posiadał funkcję odczytu pliku do konsoli.
     * Obsłuż wyjątki podczas próby wpisania niewłaściwych danych w konsoli java.
     * dodatkowe: zaimplementuj poznany wzorzec projektowy. Jaki? Decyzja nalezy do ciebie
     */

    public static void main(String[] args) {
        new Main();
    }

    private Scanner scanner;
    private Path path;

    public Main() {
        scanner = new Scanner(System.in);
        System.out.println("Witaj! Podaj adres email:  ");
        String email = scanner.nextLine();
        String name = email.replace("@", "").replace(".", "");
        path = Paths.get(Constans.PATH + name + ".txt");
        start();
    }

    private void start() {
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String command;
        do {
            System.out.println("1 - dodawanie nowego filmu");
            System.out.println("2 - wyświetlanie obejrzanych filmów");
            System.out.println("Wpisz polecenie");
            command = scanner.nextLine();
            parseChoice(command);
        } while (!command.equals("exit"));
    }

    private void parseChoice(String command) {
        switch (command) {
            case "1": {
                addFilm();
                break;
            }

            case "2": {
                Film.readFilmFromFile(path);
                break;
            }
            case "exit": {
                System.exit(0);
                break;
            }
            default:
                System.out.println("Komdenda niepoprawna");
                break;
        }
    }

    private void showFilms() {
        System.out.println("działa");
    }

    private void addFilm() {
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
            Film newfilm = Film.addNewFilmToFile(film);
            try {
                Files.write(path, (newfilm.toString() + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}

