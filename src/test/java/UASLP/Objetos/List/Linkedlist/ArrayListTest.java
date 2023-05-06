package UASLP.Objetos.List.Linkedlist;
import UASLP.Objetos.List.ArrayList.ArrayList;
import UASLP.Objetos.List.exceptions.BadIndexException;
import UASLP.Objetos.List.exceptions.NotNullAllowedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class ArrayListTest {
    @Test
    public void whenListIsCreated_thenIsEmpty(){

        ArrayList<String> list = new ArrayList<>();

        boolean isEmpty = list.isEmpty();
        int size = list.getSize();

        Assertions.assertEquals(size,0);
        Assertions.assertTrue(isEmpty);
    }
    @Test
    public void whenListIsCreated_thenIsJustEmpty() {

        ArrayList<String> list = new ArrayList<>();

        boolean Empty=list.isEmpty();

        Assertions.assertTrue(Empty);
    }
    @Test
    public void whenListIsCreated_thenFirstElementInserted() throws NotNullAllowedException{

        ArrayList<String> list = new ArrayList<>();

        list.addAtFront("1");
        int size= list.getSize();

        Assertions.assertEquals(size,1);
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_thenFirstElementInsertedNull(){

        ArrayList<String> list = new ArrayList<>();

        Assertions.assertThrows(NotNullAllowedException.class,() -> list.addAtFront(null));
        int size= list.getSize();

        Assertions.assertEquals(size,0);
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_thenFirstElementInsertedMoreElements() throws NotNullAllowedException{

        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("3");
        list.addAtFront("2");

        list.addAtFront("1");
        int size= list.getSize();

        Assertions.assertEquals(size,3);
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertEquals("2",list.getAt(1));
    }
    @Test
    public void whenListIsCreated_thenFirstElementInsertedAtTail() {
        ArrayList<String> list = new ArrayList<>();

        list.addAtTail("1");
        int size= list.getSize();

        Assertions.assertEquals(size,1);
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_thenFirstElementInsertedMoreElementsAtTail() {
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("1");
        list.addAtTail("2");

        list.addAtTail("3");
        int size= list.getSize();

        Assertions.assertEquals(size,3);
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertEquals("2",list.getAt(1));
        Assertions.assertEquals("3",list.getAt(2));
    }
    @Test
    public void whenListIsCreated_thenFirstElementIsRemoveWithIndexException() {

        ArrayList<String> list = new ArrayList<>();

        Assertions.assertThrows(BadIndexException.class,() -> list.remove(1));
        int size= list.getSize();

        Assertions.assertEquals(size,0);
    }
    @Test
    public void whenListIsCreated_thenFirstElementIsRemove() throws NotNullAllowedException,BadIndexException{
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("1");

        list.remove(0);
        int size= list.getSize();

        Assertions.assertEquals(size,0);
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_AdddingThreeElements_thenAreRemove() throws NotNullAllowedException,BadIndexException{
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("1");
        list.addAtFront("2");
        list.addAtFront("3");
        list.addAtFront("4");
        list.addAtFront("1");
        list.addAtFront("2");
        list.addAtFront("3");
        list.addAtFront("4");
        list.addAtFront("1");
        list.addAtFront("2");
        list.addAtFront("3");
        list.addAtFront("4");
        list.addAtFront("4");
        list.addAtFront("4");
        list.addAtFront("4");
        list.addAtFront("4");

        list.remove(3);
        list.remove(2);
        list.remove(1);
        list.remove(0);
        list.remove(3);
        list.remove(2);
        list.remove(1);
        list.remove(0);
        list.remove(3);
        list.remove(2);
        list.remove(1);
        list.remove(0);
        list.remove(3);
        int size= list.getSize();

        Assertions.assertEquals(size,3);
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_AdddingElementAndSettingAtIt() throws NotNullAllowedException,BadIndexException{

        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("1");
        list.addAtFront("2");
        list.addAtFront("3");

        list.setAt(2,"4");
        int size= list.getSize();

        Assertions.assertEquals(list.getAt(2),"4");
        Assertions.assertEquals(size,3);
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_AdddingElementsAndRemovingThem() throws NotNullAllowedException{
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("1");
        list.addAtFront("2");
        list.addAtFront("3");
        list.addAtFront("4");

        list.removeAll();
        int size= list.getSize();

        Assertions.assertEquals(size,0);
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_AdddingElementsAndRemovingThemTryingTheException() throws NotNullAllowedException{

        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("1");
        list.addAtFront("2");
        list.addAtFront("3");
        list.addAtFront("4");

        list.removeAllWithValue(null);
        int size= list.getSize();

        Assertions.assertEquals(size,4);
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_AdddingElementsAndRemoveEspecificValues() throws NotNullAllowedException{
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("1");
        list.addAtFront("4");
        list.addAtFront("2");
        list.addAtFront("3");
        list.addAtFront("4");

        list.removeAllWithValue("4");
        int size= list.getSize();

        Assertions.assertEquals(size,3);
        Assertions.assertEquals(list.getAt(0),"3");
        Assertions.assertEquals(list.getAt(1),"2");
        Assertions.assertEquals(list.getAt(2),"1");
        Assertions.assertFalse(list.isEmpty());
    }


    @Test
    public void whenListIsCreated_SettingElementsAndExceptionComeUp(){

        ArrayList<String> list = new ArrayList<>();

        Assertions.assertThrows(BadIndexException.class,() -> list.setAt(1,"5"));

        Assertions.assertTrue(list.isEmpty());
    }
}