package FileHandling;

import java.io.*;
import java.util.Scanner;

public class FHBasics {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        String path = "C:\\Users\\yaswa\\.m2\\repository\\classworlds\\classworlds\\Anonymous\\src\\FileHandling\\FH.txt";

//        File f = new File(path);
//
//        FileWriter fw = new FileWriter(f, true);
//
//        BufferedWriter bw = new BufferedWriter(fw);
//
       System.out.println("Enter Something:");
       String data = sc.nextLine();
//
//        bw.write(data);
//        bw.write(" Hello World");
//
//        bw.close();
//        sc.close();
//        File f = new  File(path);
//        FileReader fr = new FileReader(f);
//        BufferedReader br = new BufferedReader(fr);
//        int ch;
//        while((ch = br.read())!= -1)
//        {
//            System.out.println((char)ch);
//        }
//        br.close();
//        fr.close();
        String outpath = "C:\\Users\\yaswa\\.m2\\repository\\classworlds\\classworlds\\Anonymous\\src\\FileHandling\\FHCopy.txt";

        FileInputStream fis = new FileInputStream(path);
        FileOutputStream fos = new FileOutputStream(outpath);

        int ch;

        while ((ch = fis.read()) != -1) {
            fos.write(ch);
        }

        fis.close();
        fos.close();

        System.out.println("File copied successfully.");
    }
}