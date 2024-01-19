import java.io.*;

public class FileSplitter1 {

    public static void main(String[] args) {
        Console con = System.console();

        if (con == null) {
            System.out.println("Console is not available. Please run the program from the command line.");
            return;
        }

        String inputFileName = con.readLine("Enter the input file name: ");
        long splitSize = Long.parseLong(con.readLine("Enter the split size in bytes: "));

        splitFile(inputFileName, splitSize);
    }

    private static void splitFile(String inputFileName, long splitSize) {
        try (FileInputStream fis = new FileInputStream(inputFileName)) {
            byte[] buffer = new byte[(int) splitSize];
            int bytesRead;

            int fileNumber = 1;

            while ((bytesRead = fis.read(buffer)) != -1) {
                String outputFileName = getOutputFileName(inputFileName, fileNumber);
                try (FileOutputStream fos = new FileOutputStream(outputFileName)) {
                    fos.write(buffer, 0, bytesRead);
                }

                fileNumber++;
            }

            System.out.println("File split successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getOutputFileName(String inputFileName, int fileNumber) {
        int dotIndex = inputFileName.lastIndexOf(".");
        String extension = "";
        
        if (dotIndex != -1) {
            extension = inputFileName.substring(dotIndex);
        }
        
        return inputFileName.replaceFirst("\\..*", "") + fileNumber + extension;
    }
    
}
