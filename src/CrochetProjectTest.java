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
 
    @Test
    void incrementAndDecrementRowChangesRowNum() {
        CrochetProject project = new CrochetProject("Blanket");
        project.incrementRow();
        assertEquals(2, project.getRowNum());
        project.decrementRow();
        assertEquals(1, project.getRowNum());
    }

    @Test
    void removeNoteReturnsTrueForOwnedNote() {
        CrochetProject project = new CrochetProject("Blanket");
        project.addNote("hello");
        Note note = project.getNotes().get(0);
        assertTrue(project.removeNote(note));
        assertEquals(0, project.getNotes().size());
    }

    @Test
    void projectNameIsTrimmed() {
        CrochetProject project = new CrochetProject("   Blanket   ");
        assertEquals("Blanket", project.getName());
    }

    @Test
    void getNotesReturnsUnmodifiableList() {
        CrochetProject project = new CrochetProject("Blanket");
        assertThrows(UnsupportedOperationException.class, () -> project.getNotes().add(new Note(2, "test")));
    }

    @Test
    void changingProjectRowDoesNotChangeExistingNoteRow() {
        CrochetProject project = new CrochetProject("Blanket");
        project.addNote("first note");
        Note note = project.getNotes().get(0);
        project.incrementRow();
        assertEquals(1, note.getRowNum());
    }
}
 
