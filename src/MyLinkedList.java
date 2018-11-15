public class MyLinkedList<E> {
    Node<E> head = null;
    Node<E> tail = null;
    int size = 0;

    public MyLinkedList(E e) {
        head = new Node<>(e);
    }

    public MyLinkedList() {
    }



    public class Node<E>{
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return this.element;
        }
    }

    public void addFirst(E e){
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;
        if (tail == null){
            tail = head;
        }
    }

    public void addLast(E e){
        if (tail == null){
            addFirst(e);
        }else {
            Node<E> newNode = new Node<>(e);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public E remove(int index){
        Node<E> current = head;
        for (int i=0; i < index-1; i++){
            current = current.next;
        }
        Node<E> temp;
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else if (index == size-1){
            temp = current.next;
            tail = current;
            tail.next = null;
        } else if (index == 0){
            temp = current;
            head = current.next;
        } else {
            temp = current.next;
            current.next = current.next.next;
        }
        size--;
        return temp.element;
    }

    public boolean remove(E e){
        boolean remove = false;
        Node<E> current = head;
        int i;
        if (current.element.equals(e)){
            remove = true;
            head = current.next;
            size--;
        } else {
            for (i=1; i < size; i++){
                if (current.next.element.equals(e)){
                    remove = true;
                    current.next = current.next.next;
                    size--;
                    break;
                }
                current = current.next;
            }
        }
        return remove;
    }

    int indexOf(E e){
        Node<E> current = head;
        int i;
        for (i=0; i < size; i++){
            if (current.element.equals(e)){
                break;
            }
            current = current.next;
        }
        return i;
    }

    public void add(int index, E e){
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }else if (size == 0 || index == 0){
            addFirst(e);
        } else if (index == size){
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++){
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }
    public boolean contains(E e){
        boolean contains = false;
        Node<E> current = head;
        int i;
        for (i=0; i < size; i++){
            if (current.element.equals(e)){
                contains = true;
                break;
            }
            current = current.next;
        }
        return contains;
    }

    public E get(int index){
        Node<E> current = head;
        for (int i=1; i < index; i++){
            current = current.next;
        }
        return current.next.element;
    }

    public E getFirst(){
        return head.element;
    }
    public E getLast(){
        return tail.element;
    }

    public void printList() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.print(temp.element + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
