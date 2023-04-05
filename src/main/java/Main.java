import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        DynArray dynArray = new DynArray(Integer.class);
        dynArray.insert(10, 0);
        dynArray.insert(11, 1);
        dynArray.insert(12, 2);
        dynArray.insert(13, 3);
        dynArray.insert(14, 2);
        dynArray.insert(15, 5);
        dynArray.remove(2);
        System.out.println(dynArray.getItem(0));
    }

}