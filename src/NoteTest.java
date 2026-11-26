import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Instant;

class NoteTest {
 
    @Test
    void constructorAcceptsRowOne() {
        Note note = new Note(1, "start");
        assertEquals(1, note.getRowNum());
        assertEquals("start", note.getContent());
    }
 
    @Test
    void constructorRejectsRowZero() {
        assertThrows(IllegalArgumentException.class, () -> new Note(0, "x"));
    }
 
    @Test
    void constructorRejectsNullContent() {
        assertThrows(IllegalArgumentException.class, () -> new Note(4, null));
    } 

    @Test
    void constructorAcceptsEmptyContent() {
        Note note = new Note(4, "");
        assertEquals("", note.getContent());
    }
 
    @Test
    void setContentWithNullKeepsOldContent() {
        Note note = new Note(4, "original");
        note.setContent(null);
        assertEquals("original", note.getContent());
    }
 
    // TODO: setContent("") changes the content to empty
    @Test
    void setContentWithEmptyStringChangesContent() {
        Note note = new Note(4, "original");
        note.setContent("");
        assertEquals("", note.getContent());
    }
    // TODO: setContent with a normal string changes the content, and the row number stays the same
    @Test
    void setContentWithNormalStringChangesContent() {
        Note note = new Note(4, "original");
        note.setContent("updated");
        assertEquals("updated", note.getContent());
        assertEquals(4, note.getRowNum());
    }
    // TODO: createdAt falls between an Instant captured before and one captured after construction
    //       (hint: isBefore / isAfter, and think about whether the boundaries are inclusive)
    @Test 
    void createdAtFallsBetweenInstantBounds() {
        Instant before = Instant.now();
        Note note = new Note(4, "test");
        Instant after = Instant.now();
        assertTrue(!note.getCreatedAt().isBefore(before) && !note.getCreatedAt().isAfter(after));
    }
}
 