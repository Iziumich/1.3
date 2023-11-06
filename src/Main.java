import java.io.*;
import java.io.File;

public class Main {
    public static void main(String[] args) throws IndexOutOfBoundsException {
        String path = "D:/Games/";
        StringBuilder sb = new StringBuilder();
        File src = new File(path, "src");
        sb.append("Folder 'src' create: ").append(src.mkdir()).append("\n");
        File res = new File(path, "res");
        sb.append("Folder 'res' create: ").append(res.mkdir()).append("\n");
        File savegames = new File(path, "savegames");
        sb.append("Folder 'savegames' create: ").append(savegames.mkdir()).append("\n");
        File temp = new File(path, "temp");
        sb.append("Folder 'temp' create: ").append(temp.mkdir()).append("\n");
        File main = new File(src, "main");
        sb.append("Folder 'main' create: ").append(main.mkdir()).append("\n");
        File test = new File(src, "test");
        sb.append("Folder 'test' create: ").append(test.mkdir()).append("\n");
        File drawables = new File(res, "drawables");
        sb.append("Folder 'drawables' create: ").append(drawables.mkdir()).append("\n");
        File vectors = new File(res, "vectors");
        sb.append("Folder 'vectors' create: ").append(vectors.mkdir()).append("\n");
        File icons = new File(res, "icons");
        sb.append("Folder 'icons' create: ").append(icons.mkdir()).append("\n");
        File mainFile = new File(main, "Main.java");
        File utils = new File(main, "Utils.java");
        File tempFile = new File(temp, "temp.txt");
        try {
            sb.append("File 'main' create: ").append(mainFile.createNewFile()).append("\n");
            sb.append("File 'utils' create: ").append(utils.createNewFile()).append("\n");
            sb.append("File 'temp' create: ").append(tempFile.createNewFile()).append("\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage()); 
            sb.append("Error create file ").append(ex.getMessage());
        }
        String logs = sb.toString();
        try (FileWriter fw = new FileWriter(tempFile)) {
            fw.write(logs);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
