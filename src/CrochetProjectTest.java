import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CrochetProjectTest {
 
    @Test
    void newProjectStartsAtRowOneWithNoNotes() {
        CrochetProject project = new CrochetProject("Blanket");
        assertEquals(1, project.getRowNum());
        assertTrue(project.getNotes().isEmpty());
    }
 

    @Test
    void decrementAtRowOneStaysAtRowOne() {
        CrochetProject project = new CrochetProject("Blanket");
        project.decrementRow();
        assertEquals(1, project.getRowNum());
    }
 
    @Test
    void constructorRejectsBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new CrochetProject("   "));
    }
 
    @Test
    void addNoteUsesCurrentRow() {
        CrochetProject project = new CrochetProject("Blanket");
        project.incrementRow();
        project.addNote("hello");
        assertEquals(1, project.getNotes().size());
        assertEquals(2, project.getNotes().get(0).getRowNum());
    }
 
    @Test
    void removeNoteReturnsFalseForUnknownNote() {
        CrochetProject project = new CrochetProject("Blanket");
        Note stranger = new Note(4, "not in this project");
        assertFalse(project.removeNote(stranger));
    }
 
    // TODO: incrementRow raises the row by one, and decrementRow lowers it again
    @Test
    void incrementAndDecrementRowChangesRowNum() {
        CrochetProject project = new CrochetProject("Blanket");
        project.incrementRow();
        assertEquals(2, project.getRowNum());
        project.decrementRow();
        assertEquals(1, project.getRowNum());
    }
    //removeNote returns true for a note the project owns, and the list shrinks by one
    @Test
    void removeNoteReturnsTrueForOwnedNote() {
        CrochetProject project = new CrochetProject("Blanket");
        project.addNote("hello");
        Note note = project.getNotes().get(0);
        assertTrue(project.removeNote(note));
        assertEquals(0, project.getNotes().size());
    }
    // TODO: a name with surrounding spaces is stored trimmed (check getProjName(); rename if yours differs)
    @Test
    void projectNameIsTrimmed() {
        CrochetProject project = new CrochetProject("   Blanket   ");
        assertEquals("Blanket", project.getName());
    }
    // TODO: getNotes().add(...) throws, because the list is read-only
    //       (hint: which exception does an unmodifiable list throw? assertThrows needs the class)
    @Test
    void getNotesReturnsUnmodifiableList() {
        CrochetProject project = new CrochetProject("Blanket");
        assertThrows(UnsupportedOperationException.class, () -> project.getNotes().add(new Note(2, "test")));
    }
    // TODO: changing the project's row afterward does not change an existing note's row
    @Test
    void changingProjectRowDoesNotChangeExistingNoteRow() {
        CrochetProject project = new CrochetProject("Blanket");
        project.addNote("first note");
        Note note = project.getNotes().get(0);
        project.incrementRow();
        assertEquals(1, note.getRowNum());
    }
}
 
