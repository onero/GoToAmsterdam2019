package whatsnew.process;

public class KillOtherProcess {

    public static void main(String... args) throws Exception {

        ProcessHandle siriProcess =
                ProcessHandle.allProcesses()
                        .filter(h -> h.info().commandLine().map(cmd -> cmd.contains("Siri")).orElse(false))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("No matching handle found"));

        System.out.println(siriProcess.info());

        siriProcess.onExit()
                .thenAccept(h -> System.out.println("Nuked Siri!!!"));

        boolean shutdown = siriProcess.destroy();

        siriProcess.onExit().join();
        System.out.println("Shutdown: " + shutdown);


    }

}
