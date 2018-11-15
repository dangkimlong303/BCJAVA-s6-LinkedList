public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.addFirst("a");
        myLinkedList.addFirst("b");
        myLinkedList.add(1,"c");
        myLinkedList.addLast("d");
        myLinkedList.printList();
        myLinkedList.remove(1);
        myLinkedList.printList();
        System.out.println(myLinkedList.indexOf("a"));
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.contains("d"));
        System.out.println(myLinkedList.remove("b"));
    }
}
