package UASLP.Objetos.List;

import UASLP.Objetos.List.Linkedlist.LinkedListIterator;

public interface List {
    void setAt(int index,String data);
    void removeAll();
    void removeAllWithValue(String data);
    void remove(int index);
    void addAtTail(String data);
    void addAtFront(String data);
    String getAt(int index);
    int getSize();
    Iterator getIterator();
    boolean isEmpty();

}
