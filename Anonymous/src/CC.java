import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CC {
    public static void main(String[] args) {

        Comparator<Integer> com = new Comparator<Integer>() {

            @Override
            public int compare(Integer i, Integer j) {

                if (i % 10 > j % 10) {
                    return 1;
                }
                else if (i % 10 == j % 10) {
                    return 0;
                }

                return -1;
            }
        };

        ArrayList<Integer> al = new ArrayList<>();

        al.add(65);
        al.add(81);
        al.add(72);
        al.add(11);
        al.add(10);
        al.add(23);
        al.add(54);

        Collections.sort(al, com);

        System.out.println("After Sorting: " + al);
    }
}