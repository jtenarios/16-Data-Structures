import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Jukebox1 {

    ArrayList<String> songList = new ArrayList<String>();

    public static void main(String[] args) {
        new Jukebox1().go();
    }

    public void go(){
        getSons();
        System.out.println("Antes de ordenar");
        System.out.println(songList);

        System.out.println("Despues de ordenar");
        Collections.sort(songList);
        System.out.println(songList);
    }

    void getSons(){
        try{
            File file = new File("SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while( (line = reader.readLine()) != null ){
                addSong(line);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

     void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        songList.add(tokens[0]);
    }

}
