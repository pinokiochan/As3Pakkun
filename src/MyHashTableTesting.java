import java.util.Random;

public class MyHashTableTesting {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(random.nextInt(10000), "Name" + i);
            Student value = new Student(random.nextInt(10000), "Student" + i);
            table.put(key, value);
        }

        int[] bucketCounts = new int[table.getChainArray().length];
        for (int i = 0; i < table.getChainArray().length; i++) {
            MyHashTable<MyTestingClass, Student>.HashNode<MyTestingClass, Student> node = table.getChainArray()[i];
            while (node != null) {
                bucketCounts[i]++;
                node = node.getNext();
            }
        }
        for (int i = 0; i < bucketCounts.length; i++) {
            System.out.println("Bucket " + i + ": " + bucketCounts[i] + " elements");
        }
    }
}