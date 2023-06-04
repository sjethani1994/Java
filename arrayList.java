import java.util.ArrayList;

public class arrayList {
    public static void main(String[] args) {
          // Array List :- Resizeable array. It belongs to interface called list
          ArrayList<String> arrList = new ArrayList<>();
          arrList.add("Sumit");
          arrList.add("Jethani");
          System.out.println(arrList);
          arrList.remove(1);
          System.out.println(arrList);
  
          // Set
          arrList.set(0, "Varsha");
          System.out.println(arrList);
    }
}
