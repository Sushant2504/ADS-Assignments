import java.util.*;
import java.io.*;




public class Fileinfo{
    public Fileinfo(String string) {
        //TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        
        File f = new File("C:\\Users\\hp\\Desktop\\ADS-practical\\File.txt");
        //to read from the file
        if(f.exists()){
            System.out.println("File Name: " + f.getName());
            System.out.println("File Location: "+f.getAbsolutePath());
            System.out.println("File Writable: "+f.getName());
            System.out.println("File Size: "+ f.length());
        }else{
            System.out.println("File doesn't exist");
        }


        //to write into the file

        try{
            FileWriter fw = new FileWriter("C:\\Users\\hp\\Desktop\\ADS-practical\\File.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println("Hello W   orld");
            pw.close();
        }catch(IOException e){
            System.out.println("Error");
        }

        //to read text from the file

        try{
            FileReader fr = new FileReader("C:\\Users\\hp\\Desktop\\ADS-practical\\File.txt");
            BufferedReader br = new BufferedReader(fr);
            String s;
            while((s = br.readLine())!= null){
                System.out.println(s);
            }
            br.close();
        }catch(IOException e){
            System.out.println("exception is"+e);
        }
    }

    
}