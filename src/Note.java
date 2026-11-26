import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Note {
    private int rowNum;
    private String content;
    private Instant createdAt;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(Locale.getDefault())
                .withZone(ZoneId.systemDefault());

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter
        .ofLocalizedTime(FormatStyle.SHORT)
        .withLocale(Locale.getDefault())
        .withZone(ZoneId.systemDefault());

    public Note(int rowNum, String content) {
        if (checkRowNum(rowNum)) {
            this.rowNum = rowNum;
        } else {
            throw new IllegalArgumentException("Row number must be greater than or equal to 1.");
        }

        if (checkContent(content)) {
            this.content = content;
        } else {
            throw new IllegalArgumentException("Content cannot be null.");
        }

        createdAt = Instant.now();
    }

    public int getRowNum() {
        return rowNum;
    }

    public String getContent() {
        return content;
    }

     public Instant getCreatedAt() {
        return createdAt;
    }

    public void setContent(String content) {
        if (checkContent(content)) {
            this.content = content;
        }
    }

     public String formatCreatedDate() {
        return DATE_FORMATTER.format(createdAt);
    }

    public String formatCreatedTime() {
        return TIME_FORMATTER.format(createdAt);
    }

    @Override 
    public String toString() {
        return "\nNote: " + content + "\nCreated On: " + formatCreatedDate() + " at " + formatCreatedTime() + "\nRow Number: " + rowNum;
    }


    //Private helpers

    private boolean checkRowNum(int rowNum) {
        return rowNum >= 1;
    }

    private boolean checkContent(String content) {
        return content != null;
    }
}