import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static StringBuilder log = new StringBuilder();

    public static void main(String[] args) throws IOException {
        File games = new File("D:\\Games");
        games.mkdir();
        if(games.isDirectory()){
            File gamesSrc = createFolder("D:\\Games/src");
            File gamesRes = createFolder("D:\\Games/res");
            File gamesSaveGames = createFolder("D:\\Games/savegames");
            File gamesTmp = createFolder("D:\\Games/tmp");

            if(gamesSrc.isDirectory()){
                File gamesSrcMain = createFolder("D:\\Games/src/main");
                File gamesSrcTest = createFolder("D:\\Games/src/test");

                if(gamesSrcMain.isDirectory()){
                    File gamesSrcMain_main_java =  createFile("D:\\Games/src/main/Main.java");
                    File gamesSrcMain_utils_java = createFile("D:\\Games/src/main/Utils.java");
                }
            }

            if(gamesTmp.isDirectory()){
                File gamesTmp_temp_txt = createFile("D:\\Games/tmp/temp.txt");

                FileWriter writer = new FileWriter(gamesTmp_temp_txt);
                writer.write(log.toString());
                writer.flush();
                writer.close();
            }
        }
    }

    public static File createFile(String travel) throws IOException {
        try {
            File file_java = new File(travel);
            file_java.createNewFile();

            addInLog(travel);
            return file_java;
        }catch (IOException e){
            System.out.println("File crashed!: " + travel);
        }
        return null;
    }

    public static File createFolder(String travel){
        File folder = new File(travel);
        folder.mkdir();
        addInLog(travel);
        return folder;
    }

    public static void addInLog(String travel){
        String nameFile[] = travel.split("/");
        log.append(nameFile[nameFile.length -1] + " Created! ");
    }
}
