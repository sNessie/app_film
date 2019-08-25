import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Person {

    static void exist() {
        System.out.println("Witaj! Podaj adres email:  ");
        Scanner input = new Scanner(System.in);
        String email = input.nextLine();
        String name = email.replace("@", "").replace(".", "");
        Path path = Paths.get(Constans.PATH + name);
        System.out.println("Czy chcesz dodać nowy film? T/N");
        String answer = input.nextLine();
        while (!answer.equals("N") ) {
            Film film = Film.addFilm();
            try {
                if (!Files.exists(path)) {
                    Files.createFile(path);
                }
                Files.write(path, (film.toString() + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Czy chcesz dodać nowy film? T/N");
            answer = input.nextLine();
        }
    }


}
