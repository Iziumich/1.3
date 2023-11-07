import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileManager {
    private Logger logger;
    private String basePath;

    public FileManager(String basePath, Logger logger) {
        this.basePath = basePath;
        this.logger = logger;
    }

    public void initialize() {
        createFolder(basePath, "src");
        createFolder(basePath, "res");
        createFolder(basePath, "savegames");
        createFolder(basePath, "temp");
        createFolder(basePath + "\\src", "main");
        createFolder(basePath + "\\src", "test");
        createFolder(basePath + "\\res", "drawables");
        createFolder(basePath + "\\res", "vectors");
        createFolder(basePath + "\\res", "icons");
        createFiles(basePath + "\\src\\main", "Main.java");
        createFiles(basePath + "\\src\\main", "Utils.java");
        createFiles(basePath + "\\temp", "temp.txt");
    }

    public void saveGame(String path, GameProgress nameSave) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(nameSave);
            logger.log(nameSave + "- successfully saved");
        } catch (Exception ex) {
            logger.log(" - Dont save! error :" + ex.getMessage());
        }
    }

    public void zipFiles(String zipPath, String[] savePath) {
        try {
            ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zipPath));
            for (String pathToZip : savePath) {
                File file = new File(pathToZip);
                FileInputStream fis = new FileInputStream(file);
                ZipEntry entry = new ZipEntry(file.getName());
                zout.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                int len;
                while ((len = fis.read(buffer)) >= 0) {
                    zout.write(buffer, 0, len);
                }
                fis.close();
                logger.log(file.getName() + " - successfully archived");
            }
            zout.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void createFolder(String path, String name) {
        File folder = new File(path, name);
        if (folder.exists()) {
            logger.log("Folder " + path + "\\" + name + " - already exists");
        } else if (folder.mkdir()) {
            logger.log("Folder " + path + "\\" + name + " -create");
        } else {
            logger.log("Folder " + path + "\\" + name + " - not created");
        }
    }

    public void createFiles(String path, String name) {
        File file = new File(path, name);
        try {
            if (file.exists()) {
                logger.log("File " + path + "\\" + name + " - already exists");
            } else if (file.createNewFile()) {
                logger.log("File " + path + "\\" + name + " -create");
            } else {
                logger.log("File " + path + "\\" + name + " - not created");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            logger.log("Error create file \n" + ex.getMessage());
        }
    }

    public void write(String path, String data) {
        try (FileWriter fw = new FileWriter(basePath + "/" + path)) {
            fw.write(data);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            logger.log("Error write file \n" + ex.getMessage());
        }
    }

    public void delete(String path, String name) {
        File deleteFile = new File(path, name);
        deleteFile.delete();
        logger.log("File " + name + " Deleted");
    }
}
