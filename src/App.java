// import java.time.Instant;
// import java.time.ZoneId;
// import java.time.format.DateTimeFormatter;
// import java.util.Locale;
// import java.time.format.FormatStyle;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // Instant now = Instant.now();
        // //System.out.println(now);
        // DateTimeFormatter formatter = DateTimeFormatter
        //         .ofLocalizedDate(FormatStyle.MEDIUM)
        //         .withLocale(Locale.getDefault())
        //         .withZone(ZoneId.systemDefault());
        // String formattedDate = formatter.format(now);
        // System.out.println(formattedDate);

        //Testing Note class

        //Testing why the time prints a question mark on my console between the time and the AM/PM. 
        // I think it has to do with the encoding of my console. 
        // I will print out the character codes for each character in the time string to see what is going on.
        Note note = new Note(1, "test");
        String time = note.formatCreatedTime();

        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);
            System.out.println(i + ": '" + c + "' = " + (int) c);
        }

        System.out.println("\n\nTesting Note class:");
        Note note1 = new Note(1, "This is the first note.");
        System.out.println(note1);
        Note note2 = new Note(2, "This is the second note.");   
        System.out.println(note2);
        System.out.println();

        System.out.println("Note 1 created on: " + note1.formatCreatedDate() + " at " + note1.formatCreatedTime());
        System.out.println("Note 2 created on: " + note2.formatCreatedDate() + " at " + note2.formatCreatedTime());
        System.out.println();

        System.out.println("Note 1 row number: " + note1.getRowNum());  
        System.out.println("Note 2 row number: " + note2.getRowNum());
        System.out.println();

        note1.setContent("Updated content for the first note.");
        System.out.println("Updated Note 1: " + note1);
        note2.setContent("Updated content for the second note.");
        System.out.println("Updated Note 2: " + note2);
        System.out.println();
        
        System.out.println("Note 1 content: " + note1.getContent());
        System.out.println("Note 2 content: " + note2.getContent());

       
        //Note invalidNote = new Note(0, "This note has an invalid row number."); // This should throw an exception
   
        Note invalidNote2 = new Note(1, null); // This should throw an exception
        
        // // Testing CrochetProject class
        System.out.println("\n\nTesting CrochetProject class:");

        CrochetProject project = new CrochetProject("My Crochet Project");
        project.addNote("This is the first note for the project.");
        project.incrementRow();
        project.addNote("This is the second note for the project.");
        project.incrementRow();
        project.addNote("This is the third note for the project.");

        System.out.println("Notes in the project prior to removal:");
        for (Note n : project.getNotes()) {
            System.out.println(n);
        } 

        project.removeNote(project.getNotes().get(1)); // Remove the second note
        
        System.out.println("Notes in the project:");
        for (Note n : project.getNotes()) {
            System.out.println(n);
        }

        project.decrementRow();
        System.out.println("Current row number: " + project.getRowNum());

        project.addNote("This is a new note after decrementing the row number and removing a note.");
        
        System.out.println("Notes in the project after adding a new note:");
        for (Note n : project.getNotes()) {
            System.out.println(n);
        } 

        System.out.println("Current project name: " + project.getName());
        System.out.println("\n\nNotes List: " + project.getNotes());
        
    }
}
