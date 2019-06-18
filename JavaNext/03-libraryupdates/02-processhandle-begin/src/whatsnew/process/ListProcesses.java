package whatsnew.process;

import java.time.Instant;
import java.util.Comparator;

public class ListProcesses {
    public static void main(String... args) {
        ProcessHandle.allProcesses()
                .map(ProcessHandle::info)
                .sorted(Comparator.comparing(info ->
                                                     info.startInstant().orElse(Instant.MAX)))
                .forEach(ListProcesses::printInfo);

        ProcessHandle.current().destroyForcibly();

    }

    private static void printInfo(ProcessHandle.Info info) {
        boolean startInstantAndCommandArePresent = info.startInstant().isPresent() && info.command().isPresent();

        if(startInstantAndCommandArePresent) {
            System.out.println("Started at: " + info.startInstant().get() +
                                       ", Command: " + info.command().get());
        }

    }
}
