package UASLP.Objetos.List.ArrayList;

import UASLP.Objetos.List.Iterator;
import UASLP.Objetos.List.List;
import UASLP.Objetos.List.exceptions.BadIndexException;
import UASLP.Objetos.List.exceptions.NotNullAllowedException;

public class ArrayList<T> implements List<T> {

    private static final int INITIAL_SIZE = 2;
    private T[] arr;
    private int size;
    private ArrayList<T> first;

    public ArrayList(){
        arr = (T[]) new Object[INITIAL_SIZE];
    }

    public void addAtTail (T data){

        if(size == arr.length){
            increaseSize();
        }

        arr[size] = data;
        size++;

    }

    public int getSize(){
        return size;
    }

    private void increaseSize(){
        T[] newArr = (T[]) new Object[arr.length*2];

        System.arraycopy(arr, 0, newArr, 0, arr.length);// copia de systema
        /*for (int i=0; i < arr.length; i++){
            newArr[i]=arr[i];                     //copia manual
        }*/

        arr = newArr;
    }

    public void addAtFront(T data) throws NotNullAllowedException {

        if (data == null){
            throw new NotNullAllowedException();
        }

        if(size == arr.length){
            increaseSize();
        }
        ArrayListIterator<T> iterator = getIteratorAt(size-1);
        int currentIndex = size;

        while (iterator.hasPrevious()){
            arr[currentIndex] = iterator.previous();
            currentIndex--;
        }

        arr[0] = data;

        /*T[] temp =(T[]) new Object[arr.length];

        for (int i=0; i < size; i++){
            temp[i+1]=arr[i];
        }
        temp[0]=data;

        arr=temp;*/

        size++;
    }

    public void remove(int index) throws BadIndexException{

        if(isInvalidIndex(index)){
            throw new BadIndexException();
        }

        for (int i=index; i < size -1; i++){
            arr[i]=arr[i+1];
        }
        size--;

        if (decrease()){
            decreaseSize();
        }
    }

    public void removeAll(){
        arr = (T[])(new Object[INITIAL_SIZE]);
        size = 0;
    }

    public void setAt(int index,T data) throws BadIndexException{

        if(isInvalidIndex(index)){
            throw  new BadIndexException();
        }
        arr[index] = data;
    }
    public T getAt (int index) {
        return (T)arr[index];
    }


    public void removeAllWithValue(T data){
        for (int i = size-1;i >= 0; i--){
            if (arr[i].equals(data)){
                try {
                    remove(i);
                }catch (BadIndexException ignored){
                }
            }
        }
    }

    public ArrayListIterator<T> getIterator (){
        return new ArrayListIterator<>(this);
    }

    private ArrayListIterator<T> getIteratorAt(int index){
        return new ArrayListIterator<>(this,index);
    }

    public boolean isEmpty(){
        return size==0;
    }

    private boolean isInvalidIndex( int index){
        return index >= size || index < 0;
    }
    private boolean decrease(){
        return size < arr.length / 4;
    }

    private void decreaseSize(){
        T []newArr = (T[])(new Object[arr.length / 2]);
        Iterator<T> iterator =getIterator();
        int newIndex = 0;
        while (iterator.hasNext()){
            newArr[newIndex] = iterator.next();
            newIndex++;
        }

        arr = newArr;
    }

}


