import UASLP.Objetos.List.ArrayList.ArrayList;
import UASLP.Objetos.List.Linkedlist.LinkedList;
import UASLP.Objetos.List.Linkedlist.LinkedListIterator;
import UASLP.Objetos.List.List;

public class Main {
    public static void main(String[] args) {

        List lista1 = new LinkedList();
        List lista = new ArrayList();

        //ArrayList lista = new ArrayList();

        lista.addAtTail("juan");
        lista.addAtTail("Diego");
        for (int i = 0; i < lista.getSize(); i++){
            System.out.println(lista.getAt(i));
        }
        lista.addAtFront("Alondra");

        for (int i = 0; i < lista.getSize(); i++){
            System.out.println(lista.getAt(i));
        }

        lista.remove(1);

        lista.removeAll();

        lista.setAt(0,"mariano");

        lista.removeAllWithValue("juan");

        System.out.println(lista.getSize());

        for (int i = 0; i < lista.getSize(); i++){
            System.out.println(lista.getAt(i));
        }

    }

}