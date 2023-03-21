package UASLP.Objetos.List.ArrayList;


import UASLP.Objetos.List.Iterator;

public class ArrayListIterator<T> extends Object implements Iterator{

    private T currentNode;

    ArrayListIterator (T head){
        currentNode = head;
    }

    public boolean hasNext(){
        return currentNode != null;
    }

    public T next(){

        T data = currentNode;

        return data;
    }
}
