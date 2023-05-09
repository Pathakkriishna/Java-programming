import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("Anjit.txt");
//        create a file
        try {
            file.createNewFile();
            System.out.println("New file created");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        write in the file
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("Hello world\n");
            fileWriter.write("Hello world\n");
            fileWriter.write("Hello world\n");
            fileWriter.write("Hello world");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        read from the file
//        for reading character by character
//        try {
//            FileReader fileReader = new FileReader(file);
//            int character =  fileReader.read();
//        while(character != -1) {
//            System.out.print((char)character);
//            character = fileReader.read();
//        }
//        fileReader.close();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
// for reading line by line

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            try {
                String line = bufferedReader.readLine();
                while(line != null) {
//                    System.out.println((bufferedReader.readLine()));
                    System.out.print(line+"\n");
                    line = bufferedReader.readLine();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
