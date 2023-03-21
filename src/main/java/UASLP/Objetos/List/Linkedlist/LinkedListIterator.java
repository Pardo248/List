package UASLP.Objetos.List.Linkedlist;

import UASLP.Objetos.List.Iterator;

public class LinkedListIterator extends Object implements Iterator {

    private Node<String> currentNode;

    LinkedListIterator (Node head){
        currentNode = head;
    }
    public boolean hasNext(){
        return currentNode != null;
    }
    public String next(){
        String data = currentNode.data;

        currentNode = currentNode.next;

        return data;
    }
}
