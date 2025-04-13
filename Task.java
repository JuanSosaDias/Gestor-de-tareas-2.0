public class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public void complete() {
        this.completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return (completed ? "[✓] " : "[ ] ") + description;
    }

    public String toFileFormat() {
        return completed + ";" + description;
    }

    public static Task fromFileFormat(String line) {
        String[] parts = line.split(";", 2);
        Task task = new Task(parts[1]);
        if (Boolean.parseBoolean(parts[0])) {
            task.complete();
        }
        return task;
    }
}
