package FileHandling.Ser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Ser implements Serializable {
    int id;
    String name;

    Ser(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println(id + " " + name);
    }

    public static void main(String args[]) throws IOException {
        Ser s = new Ser(1, "Yaswanth");
        s.display();

        FileOutputStream fos = new FileOutputStream("C:\\Users\\yaswa\\.m2\\repository\\classworlds\\classworlds\\Anonymous\\src\\FileHandling\\FHCopy.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(s);

        oos.close();
        fos.close();
    }
}