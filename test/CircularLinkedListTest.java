import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CircularLinkedListTest {
    @Test
    void testEmptyList() {
        CircularLinkedList list = new CircularLinkedList();
        assertEquals("", list.showList());
        assertEquals("", list.showReverseList());
        assertFalse(list.find(0));
        assertFalse(list.remove(0));
        assertFalse(list.find(7));
        assertFalse(list.remove(7));
    }

    @Test
    void testOneItem() {
        CircularLinkedList list = new CircularLinkedList();
        list.addItem(7);
        assertEquals("7", list.showList());
        assertEquals("7", list.showReverseList());
        assertTrue(list.find(7));
        assertTrue(list.remove(7));
        assertEquals("", list.showList());
    }

    @Test
    void testAddingAndFinding() {
        CircularLinkedList list = new CircularLinkedList();
        list.addItem(7);
        list.addItem(3);
        list.addItem(2);
        list.addItem(13);
        assertEquals("7 3 2 13", list.showList());
        assertEquals("13 2 3 7", list.showReverseList());
        assertTrue(list.find(3));
        assertTrue(list.find(7));
        assertFalse(list.find(67));
    }

    @Test
    void testRemoving() {
        CircularLinkedList list = new CircularLinkedList();
        list.addItem(7);
        list.addItem(3);
        list.addItem(2);
        list.addItem(13);
        assertFalse(list.remove(67));
        assertTrue(list.remove(7));
        assertTrue(list.remove(3));
        assertEquals("2 13", list.showList());
    }

    @Test
    void testLongSequence() {
        CircularLinkedList list = new CircularLinkedList();
        list.addItem(1);
        list.addItem(2);
        list.addItem(3);
        list.addItem(4);
        list.addItem(5);
        assertEquals("1 2 3 4 5", list.showList());
        assertEquals("5 4 3 2 1", list.showList());

        assertTrue(list.remove(3));
        assertEquals("1 2 4 5", list.showList());
        assertFalse(list.find(3));

        list.addItem(6);
        list.addItem(2);
        assertEquals("1 2 4 5 6 2", list.showList());

        assertTrue(list.remove(2));
        assertEquals("1 4 5 6 2", list.showList());
        assertTrue(list.find(2));

        assertTrue(list.remove(1));
        assertTrue(list.remove(2));
        assertEquals("4 5 6", list.showList());
        assertEquals("6 5 4", list.showReverseList());

        assertFalse(list.remove(99));

        assertTrue(list.remove(4));
        assertTrue(list.remove(5));
        assertTrue(list.remove(6));
        assertEquals("", list.showList());
        assertEquals("", list.showReverseList());
    }
}
