package UASLP.Objetos.List.ArrayList;

import UASLP.Objetos.List.Iterator;

public class ArrayListIterator<H> extends Object implements Iterator<H>{
    private int currentIndex;
    private final ArrayList<H> list;

    ArrayListIterator(ArrayList<H> list){
        this.list=list;
        currentIndex=0;
    }
    ArrayListIterator(ArrayList<H> list, int index){
        this.list = list;
        currentIndex = index;
    }

    public boolean hasNext(){
        return currentIndex<list.getSize();
    }

    public H next(){

        H data= (H) list.getAt(currentIndex);
        currentIndex++;
        return data;
    }
    public boolean hasPrevious() {
        return currentIndex >= 0;
    }
    public H previous() {
        H data = list.getAt(currentIndex);
        currentIndex--;
        return data;
    }
}
