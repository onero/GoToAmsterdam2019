package whatsnew.langandlib.stream;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import whatsnew.langandlib.Book;

public class NewCollectors {

    private static final int MIN_COST_OF_BOOK = 10;

    public static void main(String... args) {
        Stream<Book> books = Book.getBooks();

        // Group books by author(s), with for each entry in the resulting Map a collection of the authors' books costing more than 10
        // Hint: take a look at Collectors::groupingBy and Collectors::filtering
        Map<Set<String>, Set<Book>> booksByAuthors =
                books.collect
                        (groupingBy(Book::getAuthors,
                                    filtering(b -> b.getPrice() > MIN_COST_OF_BOOK,
                                              toSet())
                         )
                        );
        System.out.println(booksByAuthors);

        books = Book.getBooks();
        // Collect all authors that sell books at a given price
        // Hint: take a look at Collectors::groupingBy and Collectors::flatMapping
        Map<Double, Set<String>> authorsSellingForPrice =
                books.collect(
                        groupingBy(Book::getPrice,
                                   flatMapping(b -> b.getAuthors().stream(),
                                               toSet())
                        )
                );
        System.out.println(authorsSellingForPrice);
    }
}
