/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.jarkom;

import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class udpheader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
          
        Scanner input = new Scanner(System.in);  
 
        System.out.print("UDP Header : ");            
        String UDPHeader = input.nextLine();
        System.out.println(" ");

        
        System.out.println("Source Port Number (Hexadesimal) "+ UDPHeader.substring(0, 4) + " atau Desimal " + konversiHexadecimal(UDPHeader.substring(0, 4)));
        System.out.println("Destination Port Number (Hexadesimal) "+ UDPHeader.substring(4, 8) + " atau Desimal " + konversiHexadecimal(UDPHeader.substring(4, 8)));
        System.out.println("Total lenght of the user datagram (Hexadesimal)"+ UDPHeader.substring(8,12)+" atau total panjang UDP paket adalah " + konversiHexadecimal(UDPHeader.substring(8, 12)) +" bytes");
     }
     public static int konversiHexadecimal(String hex) {  
          
        int Desimal=0;  
          
        for (int i = 0; i < hex.length(); i++) {   
             char hexChar = hex.charAt(i);  
             Desimal = Desimal * 16 + hexCharKeDesimal(hexChar);  
             }  
        return Desimal;  
   }  
   public static int hexCharKeDesimal(char char1) {  
        if (char1 >= 'A' && char1 <= 'F')  {
             return 10 + char1 - 'A';  
        }else{ 
             return char1- '0';  
        }  
    }
}

     
