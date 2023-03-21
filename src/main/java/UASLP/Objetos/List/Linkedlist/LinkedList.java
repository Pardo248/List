package UASLP.Objetos.List.Linkedlist;

import UASLP.Objetos.List.Iterator;
import UASLP.Objetos.List.List;

public class LinkedList implements List {
    private Node<String> head;
    private Node<String> tail;
    private int size;

    public void addAtTail(String data){
        Node node = new Node();

        node.data = data;
        node.previous = tail;

        if( isEmpty() ){
            head = node;
        }else{
            tail.next = node;
        }

        tail = node;
        size++;
    }
    public void addAtFront(String data){
        Node node = new Node();

        node.data = data;
        node.next = head;

        if(isEmpty()){
            head = node;
            tail = node;
        }else{
            node.next = node;
        }

        size++;
    }

    public void remove(int index){
        Node temp=head;

        int i = 0;

        while(temp != null && i != index){
            temp = temp.next;
            i++;
        }

        if(temp != null){
            if(temp.next == null){
                temp.previous.next = null;
            }
            else {
                if(temp.previous!=null){
                    temp.previous.next=temp.next;
                }else{
                    head=temp.next;
                }
            }

            size--;
        }
    }

    public void removeAll(){
        Node temp=head;

        while(temp != null){
            Node nextNode = temp.next;
            temp.previous = null;
            temp.next = null;
            temp.data = null;
            temp = nextNode;
        }
        head=null;
        tail=null;
        size =0;
    }

    public void setAt(int index,String data){
        Node temp = head;
        int i = 0;

        while(temp != null && i != index){
            temp = temp.next;
            i++;
        }

        if(temp != null){
            temp.data=data;
        }
    }

    public String getAt (int index){
        if(index <0 ||index >= size){
            return null;
        }
        Node<String> currentNode = head;

        for (int currentIndex = 0; currentIndex < index ; currentIndex++){
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    public void removeAllWithValue(String data){
        Node temp=head;

        while(temp != null && temp.data != data){
            temp=temp.next;
        }

        if(temp != null){
            if(temp.previous!=null){
                temp.previous.next=temp.next;
            }else{
                head=temp.next;
            }
            if(temp.next!=null){
                temp.next.previous=temp.previous;
            }
            size --;
        }
    }

    public int getSize(){
        return size;
    }

    public Iterator getIterator (){
        return new LinkedListIterator(head);
    }

    public boolean isEmpty() {
        return head == null || tail == null;
    }

}
