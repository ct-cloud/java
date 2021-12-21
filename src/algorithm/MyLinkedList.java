package algorithm;


public class MyLinkedList<E> {
    private Node first;
    private Node last;
    private int size;

    public void add(E e){
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null){
            first = newNode;
        }
        else{
            l.next = newNode;
        }
        size++;
    }


    public static class Node<E>{
        private Node prev;
        private Node next;
        private E element;

        Node(Node prev, E element, Node next){
            this.prev = prev;
            this.element = element;
            this.next = next;
        }


    }
}
