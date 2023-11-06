import java.io.*;
import java.io.File;

public class Main {
    public static void main(String[] args) throws IndexOutOfBoundsException {
        String path = "C:/Users/pad/IdeaProjects/DZ/Games";
        StringBuilder sbLog = new StringBuilder();
        createFolder(path, "src", sbLog);
        createFolder(path, "res", sbLog);
        createFolder(path, "savegames", sbLog);
        createFolder(path, "temp", sbLog);
        createFolder(path + "/src/", "main", sbLog);
        createFolder(path + "/src/", "test", sbLog);
        createFolder(path + "/res/", "drawables", sbLog);
        createFolder(path + "/res/", "vectors", sbLog);
        createFolder(path + "/res/", "icons", sbLog);
        createFiles(path + "/src/main/", "Main.java", sbLog);
        createFiles(path + "/src/main/", "Utils.java", sbLog);
        createFiles(path + "/temp/", "temp.txt", sbLog);

        String logs = sbLog.toString();
        try (FileWriter fw = new FileWriter(path + "/temp/temp.txt")) {
            fw.write(logs);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void createFolder(String path, String name, StringBuilder sb) {
        File folder = new File(path, name);
        if (folder.exists()) {
            logs(sb, path, name, " - already exists");
        } else if (folder.mkdir()) {
            logs(sb, path, name, " - created");
        } else {
            logs(sb, path, name, " - not created");
        }
    }
    public static void logs(StringBuilder temp, String path, String name, String status) {
        String type = "File ";
        if (folderOrFile(path, name)) {
            type = "Folder ";
        }
        temp.append(type).append(name).append(status).append("\n");
    }
    public static Boolean folderOrFile(String path, String name) {
        File test = new File(path + "/" + name);
        return test.isDirectory();
    }
    public static void createFiles(String path, String name, StringBuilder sb) {
        File file = new File(path, name);
        try {
            if (file.exists()) {
                logs(sb, path, name, " - already exists");
            } else if (file.createNewFile()) {
                logs(sb, path, name, " - created");
            } else {
                logs(sb, path, name, " - not created");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            sb.append("Error create file ").append(ex.getMessage());
        }
    }
}
