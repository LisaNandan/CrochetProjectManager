import java.time.Instant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Scratch {
    public static void main(String[] args) {
        CrochetProject project = new CrochetProject("Blanket");
        project.addNote("First note");
        Gson gson =  new GsonBuilder().registerTypeAdapter(Instant.class, new InstantAdapter().nullSafe()).create(); //Learning how to use the adapter to serialize and deserialize Instant objects
        String origString = gson.toJson(project);
        System.out.println("Original String: " + origString);

        CrochetProject deserializedProject = gson.fromJson(origString, CrochetProject.class);
        System.out.println("Deserialized Project: " + deserializedProject);
        System.out.println("First Note Date: " + deserializedProject.getNotes().get(0));


        //Load origString back into a project and compare the original note's getCreatedAt() with the loaded note's using equals. What does it print?
        System.out.println("Original Note Date vs Deserialized: " + project.getNotes().get(0).getCreatedAt().equals(deserializedProject.getNotes().get(0).getCreatedAt()));
        
        //Edit the date in a copy of the JSON to "banana" and load that. Which exception comes out, and what does its message say?
        //String modifiedJson = origString.replace(project.getNotes().get(0).getCreatedAt().toString(), "banana");
        //System.out.println(modifiedJson.equals(origString));
        //CrochetProject modifiedProject = gson.fromJson(modifiedJson, CrochetProject.class);
        //System.out.println("Modified Project: " + modifiedProject);
        //System.out.println("First Note Date: " + modifiedProject.getNotes().get(0).getCreatedAt());

        //Does "constructor ran" print during fromJson? (A temporary print in CrochetProject's constructor.)
        //What happens when you load JSON with "rowNum":-3? Use the lesson you just applied: build the changed string, print whether it differs from the original, then load it.
        String negativeRowJson = origString.replace("\"rowNum\":1", "\"rowNum\":-3");
        System.out.println(negativeRowJson.equals(origString));
        CrochetProject negativeRowProject = gson.fromJson(negativeRowJson, CrochetProject.class);
        System.out.println("Negative Row Project: " + negativeRowProject);
        System.out.println("Good project valid? " + deserializedProject.isValid());
        System.out.println("Negative row project valid? " + negativeRowProject.isValid());
    }
}