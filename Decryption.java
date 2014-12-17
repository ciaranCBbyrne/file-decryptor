/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decryption;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class Decryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
            File file = new File("Document.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
            br.close();
            fr.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
