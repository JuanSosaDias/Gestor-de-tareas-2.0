import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TaskStorage {
    private static final Path FILE_PATH = Path.of("tasks.txt");

    public static void save(List<String> lines) throws IOException {
        Files.write(FILE_PATH, lines);
    }

    public static List<String> load() throws IOException {
        if (Files.exists(FILE_PATH)) {
            return Files.readAllLines(FILE_PATH);
        }
        return List.of();
    }
}
