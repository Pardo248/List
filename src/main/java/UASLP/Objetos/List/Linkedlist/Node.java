package UASLP.Objetos.List.Linkedlist;

class Node<O> {
    O data;
    Node<O> next;
    Node<O> previous;
    Node() {
        data = null;
    }
    Node(Object data) {
        this.data =  (O)data;
    }

}
