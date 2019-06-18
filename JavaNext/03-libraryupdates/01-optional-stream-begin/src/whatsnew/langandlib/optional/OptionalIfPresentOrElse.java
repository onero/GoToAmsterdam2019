package whatsnew.langandlib.optional;

import java.util.Optional;
import whatsnew.langandlib.Book;

public class OptionalIfPresentOrElse {

    public static void main(String... args) {
        Optional<Book> full = Optional.of(Book.getBook());

        // Before ifPresentOrElse
        full.ifPresent(System.out::println);

        if (full.isPresent()) {
            System.out.println(full.get());
        } else {
            printNothing();
        }

        // With ifPresentOrElse
        full.ifPresentOrElse(System.out::println,
                             OptionalIfPresentOrElse::printNothing);

        Optional.empty().ifPresentOrElse(System.out::println,
                                         OptionalIfPresentOrElse::printNothing);


    }

    private static void printNothing() {
        System.out.println("Nothing here");

    }

}
