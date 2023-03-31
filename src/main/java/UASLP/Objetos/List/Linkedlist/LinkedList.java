package UASLP.Objetos.List.Linkedlist;

import UASLP.Objetos.List.Iterator;
import UASLP.Objetos.List.List;
import UASLP.Objetos.List.exceptions.BadIndexException;
import UASLP.Objetos.List.exceptions.NotNullAllowedException;

public class LinkedList<T> implements List<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private Node<T> currentNode;
    private int size = 0;

    public Node<T> getCurrentNode(){
        return currentNode;
    }

    public void addAtTail(T data){
        Node<T> node = new Node<>(data);
        node.previous = tail;

        if( isEmpty() ){
            head = node;
        }else{
            tail.next = node;
        }

        tail = node;
        size++;
    }
    public void addAtFront( T data) throws NotNullAllowedException{

        if(data == null){
            throw new NotNullAllowedException();
        }

        Node<T> node = new Node<>(data);

        node.next = head;

        if(isEmpty()){
            tail = node;
        }else{
            head.previous = node;
        }
        head = node;
        size++;
    }

    public void remove(int index) throws BadIndexException {

        if(isInvalidIndex(index)){
            throw new BadIndexException();
        }
        LinkedListIterator<T> iterator = (LinkedListIterator<T>) getIterator();
        int currentIndex = 0;
        while (iterator.hasNext() && currentIndex != index){
            iterator.next();
            currentIndex++;
        }
        deleteNode(iterator.getCurrentNode());
        size--;
    }

    public void removeAll(){
        LinkedListIterator<T> iterator = (LinkedListIterator<T>) getIterator();

        while (iterator.hasNext()){
            Node<T> T = iterator.getCurrentNode();
            iterator.next();
            deleteNode(T);
        }
        size =0;
    }

    public void setAt(int index,T data){

        if (isInvalidIndex(index)){
            return;
        }
        LinkedListIterator<T> iterator = (LinkedListIterator<T>) getIterator();
        int i = 0;

        while(iterator.hasNext() && i != index){
            iterator.next();
            i++;
        }

        iterator.getCurrentNode().data = data;
    }

    public T getAt (int index){
        if(isInvalidIndex(index)){
            return null;
        }
        LinkedListIterator<T> iterator = (LinkedListIterator<T>) getIterator();

        int i =0;

        while(iterator.hasNext() && i != index){
            iterator.next();
            i++;
        }
        return iterator.next();
    }

    public void removeAllWithValue(T data){
        LinkedListIterator<T> iterator = (LinkedListIterator<T>) getIterator();

        while(iterator.hasNext()){
            Node<T> temp = iterator.getCurrentNode();
            if (temp.data.equals(data)){
                deleteNode(temp);
                size--;
            }
            iterator.next();
        }

    }

    public int getSize(){
        return size;
    }

    public Iterator<T> getIterator (){
        return new LinkedListIterator<>(head);
    }

    public boolean isEmpty() {
        return head == null || tail == null;
    }

    private void deleteNode(Node<T> node) {
        if(node == null) {
            return;
        }
        if(head == node && tail == node){
            head = null;
            tail = null;
            return;
        }
        if(head == node) {
            head = head.next;
            head.previous = null;
            return;
        }
        if(tail == node) {
            tail = tail.previous;
            tail.next = null;
            return;
        }
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }
    private boolean isInvalidIndex(int index){
        return index >= size || index < 0;
    }

}
