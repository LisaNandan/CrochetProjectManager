import com.google.gson.Gson;

public class Scratch {
    public static void main(String[] args) {
        CrochetProject project = new CrochetProject("Blanket");
        project.addNote("First note");
        Gson gson = new Gson();
        String origString = gson.toJson(project);
        System.out.println("Original String: " + origString);

        CrochetProject deserializedProject = gson.fromJson(origString, CrochetProject.class);
        System.out.println("Deserialized Project: " + deserializedProject);
        System.out.println("First Note Date: " + deserializedProject.getNotes().get(0));

    }
}