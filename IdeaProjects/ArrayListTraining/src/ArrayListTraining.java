import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayListTraining {

    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Child> children = new ArrayList<>();

        Child child1 = new Child();
        Child child2 = new Child();
        Child child3 = new Child();
        Child child4 = new Child();
        Child child5 = new Child();

        child1.setFirstName("Borea");
        child1.setLasName("Jucu");
        child1.setAge(20);

        child2.setFirstName("Jora");
        child2.setLasName("Cardan");
        child2.setAge(44);

        child3.setFirstName("Oleg");
        child3.setLasName("Toloaca");
        child3.setAge(36);

        child4.setFirstName("Victor");
        child4.setLasName("IncaNuiMaladet");
        child4.setAge(1);

        child5.setFirstName("Valera");
        child5.setLasName("Tzarna");
        child5.setAge(2);

        children.add(child1);
        children.add(child2);
        children.add(child3);
        children.add(child4);
        children.add(child5);

        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        integers.add(-10);
        integers.add(-11);
        integers.add(-12);
        integers.add(-13);
        integers.add(-14);
        integers.add(-15);
        integers.add(-16);
        integers.add(-17);
        integers.add(-18);
        integers.add(-19);
        integers.add(-20);

        strings.add("Privet");
        strings.add("nu");
        strings.add("cio");
        strings.add("hui");
        strings.add("neam");

      /*  children.remove(1);
        integers.remove(1);
        strings.remove(1);*/

        children.get(1);
        integers.get(1);
        strings.get(1);

       /* for (Child x: children) {
            System.out.println(x);
        }*/
        children.forEach(System.out::println);

        System.out.println("______________________________________________________________"+"\n");

        /*for (Integer x: integers){
            System.out.println(x);
        }*/
        integers.forEach(System.out::println);

        System.out.println("______________________________________________________________"+"\n");

        /*for (String x: strings){
            System.out.println(x.charAt(0));
        }*/
        strings.forEach(x -> System.out.println(x.charAt(0)));

        System.out.println("______________________________________________________________"+"\n");

        //final int [] count = {0};
        //integers.forEach(x -> count[0] += x);
       // System.out.println(count[0]);

        int count = integers.stream()
                .mapToInt(a -> a)
                .sum();
        System.out.println(count);


      /*  Comparator<Child> byAge = Comparator.comparing(child -> child.getAge());
        children.sort(byAge);
        System.out.println(children.get(0));*/

     /*  for ( Child x: children){
           if (x.getAge() < min.getAge()){
               min = x;
           }
       }*/
        System.out.println("______________________________________________________________"+"\n");

        Child min = children.stream()
                .min(Comparator.comparing(Child::getAge))
                .orElseThrow(NoSuchElementException::new);
        System.out.println(min);

        System.out.println("______________________________________________________________"+"\n");

        List positive = integers.stream().filter(x -> x > 0).collect(Collectors.toList());
        System.out.println(positive);
        List negative = integers.stream().filter(x -> x < 0).collect(Collectors.toList());
        System.out.println(negative);
    }

}
