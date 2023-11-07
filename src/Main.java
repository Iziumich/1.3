public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();
        FileManager fileManager = new FileManager("C:\\Users\\pad\\IdeaProjects\\DZ\\Games", logger);
        fileManager.initialize();
        GameProgress gameProgress1 = new GameProgress(90, 5, 4, 65);
        GameProgress gameProgress2 = new GameProgress(70, 8, 6, 140);
        GameProgress gameProgress3 = new GameProgress(30, 1, 9, 453);
        String savePath = "C:\\Users\\pad\\IdeaProjects\\DZ\\Games\\savegames\\";
        fileManager.saveGame(savePath + "save1.dat", gameProgress1);
        fileManager.saveGame(savePath + "save2.dat", gameProgress2);
        fileManager.saveGame(savePath + "save3.dat", gameProgress3);
        String[] save = new String[]{savePath + "save1.dat", savePath + "save2.dat", savePath + "save3.dat"};
        fileManager.zipFiles(savePath + "save.zip", save);
        // fileManager.delete(savePath,"save1.dat");
        // fileManager.delete(savePath,"save2.dat");
        // fileManager.delete(savePath,"save3.dat");
        fileManager.write("temp\\temp.txt", logger.getLog());
    }
}
