/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class UserInfoHandle {
    private static File file= new File("/home/jadid/All/study/academic/spring 2022/os lab/after mid/src/src/userInfo.csv");
     public static void writeFile(String toappend){
        FileWriter fw;
        BufferedWriter bw;
        String [] parts= toappend.split(",");
         int lines =-1;
        try{
            lines=(int) Files.lines(Path.of("/home/jadid/All/study/academic/spring 2022/os lab/after mid/src/src/userInfo.csv")).count();
        fw= new FileWriter(file,true ) ;
        bw= new BufferedWriter(fw);
        bw.write(parts[0]+","+parts[1]+","+(lines+1)+"\n");
        User.id=""+(lines+1);
        bw.close();
        }
        catch(IOException e){
            System.out.println("file not found");
        }
     }
     public static boolean matchUset(String email, String password) {
         FileReader fr;
         BufferedReader br;            
         String line;

        try{

            fr= new FileReader(file) ;
            br= new BufferedReader(fr);
            while((line=br.readLine())!=null){
                String [] parts= line.split(",");
                if(email.equalsIgnoreCase(parts[0]) && password.equalsIgnoreCase(parts[1])) {
                    User.id=parts[2];
                    return true;
                }

                
            }
            
       
        }
        catch(IOException e ){
            System.out.println("file not found ");
        }
        return false;
     }
     public static boolean isUniqueUser(String email){
         FileReader fr;
         BufferedReader br;
         String line;

         try{

             fr= new FileReader(file) ;
             br= new BufferedReader(fr);
             while((line=br.readLine())!=null){
                 String [] parts= line.split(",");
                 if(email.equalsIgnoreCase(parts[0]) ) {
                     return false;
                 }


             }


         }
         catch(IOException e ){
             System.out.println("file not found ");
         }
         return true;
     }
    public static void main(String[] args) {
     System.out.println(UserInfoHandle.isUniqueUser("abcd@gmail.com"));

        // UserInfoHandle.writeFile("def@gmail.com,kopaSamsu");
    }
}
