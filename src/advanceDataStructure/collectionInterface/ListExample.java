package src.advanceDataStructure.collectionInterface;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//List Interface is implemented by ArrayList, LinkedList, Vector and Stack
public class ListExample {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);//Adding object in arraylist
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        int a[]={5,6,7};
        arrayList.addAll(IntStream.of(a).boxed().collect(Collectors.toList()));
        int b[] = {8,9};
        arrayList.addAll(1,IntStream.of(b).boxed().collect(Collectors.toList()));  //specific index

        System.out.println("Traversing list through for loop");
        for(int i=0;i<arrayList.size();i++)
        {
            System.out.print(arrayList.get(i)+" ");   //from specific index
        }

        System.out.println("\nTraversing list through for smart loop");
        for(Integer tempInt:arrayList)
        {
            System.out.print(tempInt+" ");   //from specific index
        }

        System.out.println("\nArrayList Iterator");
        Iterator itr = arrayList.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next() + " ");
        }

        System.out.println("\nArrayList Lambda for each");
        arrayList.forEach(System.out::print);


        System.out.println("\nRemoving elements");
        arrayList.removeAll(IntStream.of(b).boxed().collect(Collectors.toList())); //remove all
        arrayList.remove(0); //remove from index
        arrayList.removeIf(x -> x==6); //conditional remove
        arrayList.forEach(System.out::print);



        System.out.println("\nconvert arraylist of number to int[]");
        //convert arraylist of number to int[]
        int convertedArrayList[] = arrayList.stream().mapToInt(Integer::intValue).toArray();
        System.out.print(Arrays.toString(convertedArrayList));

        System.out.println("Removing all elements");
        arrayList.clear();
        System.out.println(arrayList);

        List<Integer> linkedList = new LinkedList<>();
        List<Integer> vector = new Vector<>();
        List<Integer> stack = new Stack<>();



    }
}
