import java.nio.file.Path;

public class CorruptSaveException extends Exception {
    private final Path backupFile;
    public CorruptSaveException(String message, Path backupFile) {
        super(message);
        this.backupFile = backupFile;
    }

    public Path getBackupFile() {
        return backupFile;
    }
    
    
}
