/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajtak;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author stanislav_vo
 */
public class Ajtak {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Class cls = Ajtak.class;
        ClassLoader cLoader = cls.getClassLoader();
        InputStream is = cLoader.getResourceAsStream("textovka.txt");
        HashMap<String, Room> map = ReaderTxt.getMap(is);
        is.close();
        
        Scanner sc = new Scanner (System.in);
        Room room = map.get("01");
        
        while (!room.getId().equals("00")){
            System.out.println("Ahoj právě jsi v místnosti " + room.getName());
            System.out.println(room.getDescription().replace("\\n", "\n"));
            System.out.println("\nMůžeš jít do místností:");
            String[] rooms = room.getExit().split(",");

            System.out.println("  (00) Domů");
            for (String roomStr : rooms) {
                Room r = map.get(roomStr);
                System.out.println("  (" + r.getId() + ") " + r.getName());
            }            

            System.out.println("Kam cheš jít?");
            System.out.print(">");
            String exit = sc.nextLine();
            if (exit.equalsIgnoreCase("00")){
                System.out.println("Rozhodl jsi se jit domu...");
                room = new Room();
                room.setId("00");
            } else
            if (room.getExit().matches("(.*)" + exit + "(.*)")){
                room = map.get(exit); 
            } else {
                System.out.println("");
                System.out.println("Nepoznal jsem kam chceš jít zkus to znovu");
            }         
            System.out.println("");
        }
        System.out.println("Užij si den");

    }
    
}
