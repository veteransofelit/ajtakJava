/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajtak;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author jaroslav_b
 */
public class ReaderTxtTest {
    
    @Test
    public void testGetMap() throws IOException, ParseException {
        Class cls = ReaderTxtTest.class;
        ClassLoader cLoader = cls.getClassLoader();
        InputStream is = cLoader.getResourceAsStream("textovkaTest.txt");
        HashMap<String, Room> map = ReaderTxt.getMap(is);
        is.close();
        
        assertEquals("Room count", 1, map.size());
        Room r = map.get("01");
        assertEquals("getId", "01", r.getId());
        assertEquals("getName", "Name", r.getName());
        assertEquals("getDescription", "Description", r.getDescription());
        assertEquals("getEquipment", "Equipment", r.getEquipment());
        assertEquals("getExit", "00", r.getExit());
    }
}
