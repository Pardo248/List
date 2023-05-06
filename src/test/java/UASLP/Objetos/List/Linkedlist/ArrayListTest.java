package UASLP.Objetos.List.Linkedlist;
import UASLP.Objetos.List.ArrayList.ArrayList;
import UASLP.Objetos.List.exceptions.BadIndexException;
import UASLP.Objetos.List.exceptions.NotNullAllowedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
public class ArrayListTest {
    @Test
    public void whenListIsCreated_thenIsEmpty(){
        //inicialiacion
        ArrayList<String> list = new ArrayList<>();
        //ejecucion
        boolean isEmpty = list.isEmpty();
        int size = list.getSize();
        //validacion
        Assertions.assertEquals(size,0);
        Assertions.assertTrue(isEmpty);
    }
    @Test
    public void whenListIsCreated_thenIsJustEmpty() throws NotNullAllowedException{
        //inicialiacion
        ArrayList<String> list = new ArrayList<>();
        //ejecucion
        boolean Empty=list.isEmpty();
        //validacion
        Assertions.assertTrue(Empty);
    }
    @Test
    public void whenListIsCreated_thenFirstElementInserted() throws NotNullAllowedException,BadIndexException{
        //inicialiacion
        ArrayList<String> list = new ArrayList<>();
        //ejecucion
        list.addAtFront("1");
        int size= list.getSize();
        //validacion
        Assertions.assertEquals(size,1);
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_thenFirstElementInsertedNull() throws NotNullAllowedException{
        //inicialiacion
        ArrayList<String> list = new ArrayList<>();
        //ejecucion
        //list.addAtFront(null); //sustituido por lambda
        Assertions.assertThrows(NotNullAllowedException.class,() -> list.addAtFront(null));
        int size= list.getSize();
        //validacion
        Assertions.assertEquals(size,0);
        //Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_thenFirstElementInsertedMoreElements() throws NotNullAllowedException,BadIndexException{
        //inicialiacion
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("3");
        list.addAtFront("2");
        //ejecucion
        list.addAtFront("1"); //sustituido por lambda
        //Assertions.assertThrows(NotNullAllowedException.class,() -> list.addAtFront(null));
        int size= list.getSize();
        //validacion
        Assertions.assertEquals(size,3);
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertEquals("2",list.getAt(1));
        ///Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_thenFirstElementInsertedAtTail() throws NotNullAllowedException,BadIndexException{
        //inicialiacion
        ArrayList<String> list = new ArrayList<>();
        //ejecucion
        list.addAtTail("1");
        int size= list.getSize();
        //validacion
        Assertions.assertEquals(size,1);
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_thenFirstElementInsertedMoreElementsAtTail() throws NotNullAllowedException,BadIndexException{
        //inicialiacion
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("1");
        list.addAtTail("2");
        //ejecucion
        list.addAtTail("3"); //sustituido por lambda
        //Assertions.assertThrows(NotNullAllowedException.class,() -> list.addAtFront(null));
        int size= list.getSize();
        //validacion
        Assertions.assertEquals(size,3);
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertEquals("2",list.getAt(1));
        Assertions.assertEquals("3",list.getAt(2));
        ///Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_thenFirstElementIsRemoveWithIndexException() throws BadIndexException{
        //inicialiacion
        ArrayList<String> list = new ArrayList<>();
        //list.addAtFront("1");
        //ejecucion
        //list.addAtFront(null); //sustituido por lambda
        Assertions.assertThrows(BadIndexException.class,() -> list.remove(1));
        int size= list.getSize();
        //validacion
        Assertions.assertEquals(size,0);
        //Assertions.assertEquals("1",list.getAt(0));
        //Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_thenFirstElementIsRemove() throws NotNullAllowedException,BadIndexException{
        //inicialiacion
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("1");
        //ejecucion
        //list.addAtFront(null); //sustituido por lambda
        //Assertions.assertThrows(BadIndexException.class,() -> list.remove(1));
        list.remove(0);
        int size= list.getSize();
        //validacion
        Assertions.assertEquals(size,0);
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_AdddingThreeElements_thenAreRemove() throws NotNullAllowedException,BadIndexException{
        //inicialiacion
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
        //
        //ejecucion
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
        //validacion
        Assertions.assertEquals(size,3);
        Assertions.assertFalse(list.isEmpty());//
    }
    @Test
    public void whenListIsCreated_AdddingElementAndSettingAtIt() throws NotNullAllowedException,BadIndexException{
        //inicialiacion
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("1");
        list.addAtFront("2");
        list.addAtFront("3");
        //ejecucion
        list.setAt(2,"4");
        int size= list.getSize();
        //validacion
        Assertions.assertEquals(list.getAt(2),"4");
        Assertions.assertEquals(size,3);
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_AdddingElementsAndRemovingThem() throws NotNullAllowedException,BadIndexException{
        //inicialiacion
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("1");
        list.addAtFront("2");
        list.addAtFront("3");
        list.addAtFront("4");
        //ejecucion
        list.removeAll();
        int size= list.getSize();
        //validacion
        Assertions.assertEquals(size,0);
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_AdddingElementsAndRemovingThemTryingTheException() throws NotNullAllowedException,BadIndexException{
        //inicialiacion
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("1");
        list.addAtFront("2");
        list.addAtFront("3");
        list.addAtFront("4");
        //ejecucion
        list.removeAllWithValue(null);
        int size= list.getSize();
        //validacion
        Assertions.assertEquals(size,4);
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void whenListIsCreated_AdddingElementsAndRemoveEspecificValues() throws NotNullAllowedException,BadIndexException{
        //inicialiacion
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("1");
        list.addAtFront("4");
        list.addAtFront("2");
        list.addAtFront("3");
        list.addAtFront("4");
        //ejecucion
        list.removeAllWithValue("4");
        int size= list.getSize();
        //validacion
        Assertions.assertEquals(size,3);
        Assertions.assertEquals(list.getAt(0),"3");
        Assertions.assertEquals(list.getAt(1),"2");
        Assertions.assertEquals(list.getAt(2),"1");
        Assertions.assertFalse(list.isEmpty());
    }
    //Assertions.assertThrows(BadIndexException.class,() -> list.remove(1));
    /*@Test
    public void whenListIsCreated_AdddingElementsAndRemoveEspecificValuesButExceptionComeUp() throws BadIndexException,NotNullAllowedException{
        //inicialiacion
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("0");
        list.addAtFront("1");
        list.removeAllWithValue("1");
        //ejecucion
        Assertions.assertThrows(BadIndexException.class,() -> list.removeAllWithValue("1"));
        //validacion
        Assertions.assertFalse(list.isEmpty());
    }*/
    ///checar
    /*@Test
    public void GetIteratorToSeeIfItsOk() throws BadIndexException,NotNullAllowedException{
        //inicialiacion
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("0");
        list.addAtFront("1");
        //ejecucion
        Assertions.assertEquals(list.getIterator(),2);
        //validacion
        Assertions.assertFalse(list.isEmpty());
    }*/
    @Test
    public void whenListIsCreated_SettingElementsAndExceptionComeUp() throws BadIndexException{
        //inicialiacion
        ArrayList<String> list = new ArrayList<>();
        //ejecucion
        Assertions.assertThrows(BadIndexException.class,() -> list.setAt(1,"5"));
        //validacion
        Assertions.assertTrue(list.isEmpty());
    }
}