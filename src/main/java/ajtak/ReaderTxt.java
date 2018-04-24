/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajtak;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stanislav_vo
 */
public class ReaderTxt {
    
    private String path;
    
    public ReaderTxt(String path){
        this.path = path;
    }
    
    public HashMap<String, Room> getMap() throws IOException {
        HashMap<String, Room> result = new HashMap<String, Room>();
        Class cls = ReaderTxt.class;
        ClassLoader cLoader = cls.getClassLoader();
        InputStreamReader reader = null;
        
        try {
            reader = new InputStreamReader(cLoader.getResourceAsStream(path));
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line, tmp;
            String arr[];
            String roomNo = "";
            Room r = null;
            while ((line = bufferedReader.readLine()) != null){
                if (line.length() == 0)
                    continue;
                
                tmp = line.substring(0, 2);
                if (!tmp.equals(roomNo)) {
                    if (r != null) {
                        result.put(roomNo, r);
                    }
                    roomNo = tmp;
                    r = new Room();
                    r.setId(roomNo);
                }
                
                tmp = line.substring(3);
                
                arr = tmp.split("\t\t");
                if (arr.length < 2)
                        continue;
                arr[0] = arr[0].trim();
                arr[1] = arr[1].trim();
                
                if (arr[0].equals("roomName")) {
                    r.setName(arr[1]);
                } else
                if (arr[0].equals("roomDesc")) {
                    r.setDescription(arr[1]);
                } else
                if (arr[0].equals("roomEqip")) {
                    r.setEquipment(arr[1]);
                } else
                if (arr[0].equals("roomExit")) {
                    r.setExit(arr[1]);
                }
            }
            
            if (r != null) {
                result.put(roomNo, r);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReaderTxt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (reader != null){
                reader.close();
            }
        }
        return result;
    }
}
