package whatsnew.langandlib.stream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FindGitConflict {

    private static final String CONFLICT_START = "<<<<<<<";
    private static final String CONFLICT_END = ">>>>>>>";

    public static void main(String... args) throws Exception {
       Stream<String> diffLines = Files.lines(Paths.get("resources/index.html"));

       // Use Stream::dropWhile/takeWhile to extract the conflict and print it (excluding begin/end markers of the conflict)
       diffLines.dropWhile(l -> !l.contains(CONFLICT_START))
               .skip(1)
               .takeWhile(l -> !l.contains(CONFLICT_END))
               .forEach(System.out::println);

       // Will not work for multiple conflicts, since it will only be evaluated once?
    }



}
