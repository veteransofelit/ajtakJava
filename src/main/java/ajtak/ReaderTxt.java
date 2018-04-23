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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stanislav_vo
 */
public class ReaderTxt {
    
    private String path;
    private String roomNo;
    
    public ReaderTxt(String path,String roomNo){
        this.path = path;
        this.roomNo = roomNo;
    }
/*    
    public String readAll() throws FileNotFoundException, IOException{
        String content = null;
        FileReader reader = null;
        File file = new File (path);
        
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(ReaderTxt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (reader != null){
                reader.close();
            }
        }
        return content;
        
    }
*/    
    public String readLines(String param) throws IOException{
        Class cls = ReaderTxt.class;
        ClassLoader cLoader = cls.getClassLoader();
        String contentLines = null;
        InputStreamReader reader = null;
        
        try {
            reader = new InputStreamReader(cLoader.getResourceAsStream(path));
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null){
                if (param.equals("all")){
                    if (line.startsWith(roomNo)){
                       stringBuffer.append(line);
                       stringBuffer.append ("\n");                    
                    }
                } else {
                    if (line.startsWith(roomNo+"."+param)){
                       stringBuffer.append(line.replace(roomNo+"."+param,"").trim());
                       //stringBuffer.append ("\n");                     
                    }
                }
            }
            reader.close();
            contentLines = stringBuffer.toString();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReaderTxt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (reader != null){
                reader.close();
            }
        }
        return contentLines;
    }

    /**
     * @param roomNo the roomNo to set
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }
            
    
}
