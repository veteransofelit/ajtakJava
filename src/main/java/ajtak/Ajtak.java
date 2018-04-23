/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajtak;

import java.io.IOException;
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
        ReaderTxt mistnost = new ReaderTxt("textovka.txt","01");
        Scanner sc = new Scanner (System.in);
        String exit = "a";
        
        while (!exit.equals("domu")){
            System.out.println("Ahoj právě jsi v místnosti " + mistnost.readLines("roomName"));
            System.out.println("a můžeš jít do místností " + mistnost.readLines("roomExit") + " a nebo domu");
            System.out.println("Kam cheš jít?");
            exit = sc.nextLine();
            if (mistnost.readLines("roomExit").matches("(.*)" + exit + "(.*)")){
                mistnost.setRoomNo(exit);
            } else if (exit.equalsIgnoreCase("domu")){
                System.out.println("Rozhodl jsi se jit domu...");
            } else {
                System.out.println("Nepoznal jsem kam chceš jít zkus to znovu");
            }         
            System.out.println("");
        }
        
        System.out.println("Užij si den");

    }
    
}
