import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrochetProject {
    private int rowNum;
    private String projName;
    private List<Note> notes;

    public CrochetProject(String name) {
        rowNum = 1;
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Project name cannot be null or empty.");
        } 
        this.projName = name.trim();
        notes = new ArrayList<>();
    }

    public List<Note> getNotes() {
        return Collections.unmodifiableList(notes);
    }

    public int getRowNum() {
        return rowNum;
    }

    public String getName() {
        return projName;
    }

    /**
     * Add a new note to the list
     * @param content the content of the note to add
     */
    public void addNote(String content) {
        Note note = new Note(rowNum, content);
        notes.add(note);
    }

    /**
     * Remove a note from the list
     * @param note the note to remove
     * @return true if the note is successfully removed, false otherwise
     */
    public boolean removeNote(Note note) {
        return notes.remove(note);
    }

    /**
     * Increment the row number
     */
    public void incrementRow() {
        rowNum++;
    }

    /**
     * Decrement the row number, ensuring it doesn't go below 1
     */
    public void decrementRow() {
        if (rowNum > 1) {
            rowNum--;
        }
    }

    @Override 
    public String toString() {
        return "CrochetProject{" + "rowNum=" + rowNum + ", projName='" + projName + '\'' + ", notes count=" + notes.size() +'}';
    }


}