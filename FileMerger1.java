import java.io.*;

public class FileMerger1 {

    public static void main(String[] args) throws IOException {
        Console con = System.console();

        if (con == null) {
            System.out.println("Console is not available. Please run the program from the command line. ");
            return;
        }
        
        int n= Integer.parseInt(con.readLine("Enter the number of files to be merged  "));
        String[] names = new String[n];

        // Read file names and store them in the array
        for (int i = 0; i < n; i++) {
            names[i] = con.readLine("Enter file name " + (i + 1) + ": ");
        }
        String outputname= con.readLine("Enter name of output file  ");
        
        for(int i=0;i<n;i++) {
            FileInputStream fis= new FileInputStream(names[i]);
            BufferedInputStream bis= new BufferedInputStream(fis);
            FileOutputStream fos= new FileOutputStream(outputname,true);
            BufferedOutputStream bos= new BufferedOutputStream(fos);
            int ch;
            while((ch=bis.read())!=-1) {
                bos.write(ch);
            } 
            bis.close();
            bos.close();
          }  
        



    }
}    