package UASLP.Objetos.List.Linkedlist;

import UASLP.Objetos.List.Iterator;

public class LinkedListIterator<K> extends Object implements Iterator<K> {//no se sugiere mas de una interfaz por classe
    private Node<K> currentNode;
    LinkedListIterator(Node<K> head){
        currentNode=head;
    }
    public boolean hasNext(){
        return currentNode!=null;
    }
    public K next() {
        K data = currentNode.data;
        currentNode = (Node<K>) currentNode.next;
        return data;
    }

    public boolean hasPrevious() {
        return currentNode != null;
    }

    public Object previous() {
        Object data = currentNode.data;
        currentNode = (Node<K>) currentNode.previous;
        return data;
    }
    public Node<K> getCurrentNode() {
        return currentNode;
    }
}
