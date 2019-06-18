package whatsnew.langandlib.optional;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import whatsnew.langandlib.Book;

public class OptionalStream {

    public static void main(String[] args) {

        // Find all first authors of the books combining Stream::flatMap and Optional::stream
        Stream<Book> books = Book.getBooks();

        Set<String> firstAuthors = books
                .map(book -> book.authors.stream()
                        .findFirst())
                .flatMap(Optional::stream)
                .collect(Collectors.toSet());

        System.out.println(firstAuthors);
    }
}
