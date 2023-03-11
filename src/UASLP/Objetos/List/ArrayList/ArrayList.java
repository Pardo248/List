package UASLP.Objetos.List.ArrayList;

import UASLP.Objetos.List.List;

public class ArrayList implements List {

    private static final int INITIAL_SIZE = 2;
    private String[] arr;
    private int size;

    public ArrayList(){
        arr = new String[INITIAL_SIZE];
    }

    public void addAtTail (String data){

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
        String[] newArr = new String[arr.length*2];

        //System.arraycopy(arr, 0, newArr, 0, arr.length); copia de systema
        for (int i=0; i < arr.length; i++){
            newArr[i]=arr[i];                     //copia manual
        }

        arr = newArr;
    }

    public void addAtFront(String data){

        if(size == arr.length){
            increaseSize();
        }

        String[] temp = new String[arr.length];

        for (int i=0; i < size; i++){
            temp[i+1]=arr[i];
        }
        temp[0]=data;

        arr=temp;

        size++;
    }

    public void remove(int index){

        for (int i=index; i < size; i++){
            arr[i]=arr[i+1];
        }
        size--;
    }

    public void removeAll(){
        for (int i=0; i < size; i++){
            arr[i]=null;
        }
        size = 0;
    }

    public void setAt(int index,String data){

        if(index < size) {
            arr[index] = data;
        }
    }

    public String getAt (int index) {
        if (index < size) {
            return arr[index];
        }else{
            return null;
        }
    }

    public void removeAllWithValue(String data){
        for (int i = 0;i < size; i++){
            if (arr[i] == data){
                remove(i);
            }
        }
    }

    public ArrayListIterator getIterator (){
        return new ArrayListIterator(arr[0]);
    }

    public boolean isEmpty(){
        return size==0;
    }

}
