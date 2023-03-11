package UASLP.Objetos.List.ArrayList;


import UASLP.Objetos.List.Iterator;

public class ArrayListIterator extends Object implements Iterator{

    private String currentNode;

    ArrayListIterator (String head){
        currentNode = head;
    }

    public boolean hasNext(){
        return currentNode != null;
    }

    public String next(){

        String data = currentNode;

        return data;
    }
}
