package whatsnew.langandlib.optional;

import java.util.Optional;
import java.util.TreeSet;
import whatsnew.langandlib.Book;

public class OptionalOr {
    public static void main(String... args) {
        Optional<Book> localFallback = Optional.of(Book.getBook());

        // Before Optional.or
        Book bestBookBefore = getBestOffer()
                .orElse(
                        getExternalOffer().orElse(localFallback.get()) // .get() is BAD! But we can't return optional here.
                );


        // With Optional.or
        Optional<Book> bestBook =
                getBestOffer()
                        .or(OptionalOr::getExternalOffer)
                        .or(() -> localFallback);

        System.out.println(bestBook);
    }

    static Optional<Book> getBestOffer() {
        return Optional.empty();
    }

    static Optional<Book> getExternalOffer() {
        return Optional.of(new Book("External Book", new TreeSet<>(), 11.99));
    }
}
