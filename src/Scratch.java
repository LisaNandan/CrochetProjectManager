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


        System.out.println("Original Note Date vs Deserialized: " + project.getNotes().get(0).getCreatedAt().equals(deserializedProject.getNotes().get(0).getCreatedAt()));
        
        //String modifiedJson = origString.replace(project.getNotes().get(0).getCreatedAt().toString(), "banana");
        //System.out.println(modifiedJson.equals(origString));
        //CrochetProject modifiedProject = gson.fromJson(modifiedJson, CrochetProject.class);
        //System.out.println("Modified Project: " + modifiedProject);
        //System.out.println("First Note Date: " + modifiedProject.getNotes().get(0).getCreatedAt());

        String negativeRowJson = origString.replace("\"rowNum\":1", "\"rowNum\":-3");
        System.out.println(negativeRowJson.equals(origString));
        CrochetProject negativeRowProject = gson.fromJson(negativeRowJson, CrochetProject.class);
        System.out.println("Negative Row Project: " + negativeRowProject);
        System.out.println("Good project valid? " + deserializedProject.isValid());
        System.out.println("Negative row project valid? " + negativeRowProject.isValid());
    }
}