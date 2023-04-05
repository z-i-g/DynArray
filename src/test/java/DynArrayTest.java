import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynArrayTest {
    DynArray dynArray = new DynArray(Integer.class);

    @Test
    public void insert_thenCapacityIsNotExceeded() {
        dynArray.insert(1, 0);
        assertEquals(1, dynArray.count);
        assertEquals(16, dynArray.capacity);
    }

    @Test
    public void insert_thenCapacityIsExceeded() {
        for (int i = 0; i < 17; i++) {
            dynArray.insert(i, i);
        }
        assertEquals(17, dynArray.count);
        assertEquals(32, dynArray.capacity);
    }

    @Test
    public void insert_thenInsertAnInvalidPosition() {
        assertThrows(IllegalArgumentException.class, () -> dynArray.insert(1, -1));
        assertThrows(IllegalArgumentException.class, () -> dynArray.insert(1, 1));
        dynArray.insert(1, 0);
        assertThrows(IllegalArgumentException.class, () -> dynArray.insert(1, 2));
    }

    @Test
    public void insert_thenInsertInTheMiddle() {
        dynArray.insert(1, 0);
        dynArray.insert(2, 1);
        dynArray.insert(3, 2);
        dynArray.insert(4, 1);

        assertEquals(1, dynArray.array[0]);
        assertEquals(4, dynArray.array[1]);
        assertEquals(2, dynArray.array[2]);
        assertEquals(3, dynArray.array[3]);
        assertEquals(4, dynArray.count);
        assertEquals(16, dynArray.capacity);
    }

    @Test
    public void remove_thenCapacityIsNotChange() {
        dynArray.insert(1, 0);
        dynArray.insert(2, 1);
        dynArray.remove(0);
        assertEquals(1, dynArray.count);
        assertEquals(16, dynArray.capacity);
        assertEquals(2, dynArray.array[0]);
    }

    @Test
    public void remove_thenCapacityIsChange() {
        for (int i = 0; i < 17; i++) {
            dynArray.insert(i, i);
        }
        assertEquals(17, dynArray.count);
        assertEquals(32, dynArray.capacity);

        dynArray.remove(2);
        assertEquals(16, dynArray.count);
        assertEquals(32, dynArray.capacity);

        dynArray.remove(3);
        assertEquals(15, dynArray.count);
        assertEquals(21, dynArray.capacity);
    }

    @Test
    public void remove_thenRemoveAnInvalidPosition1() {
        assertThrows(IllegalArgumentException.class, () -> dynArray.remove(-1));
        assertThrows(IllegalArgumentException.class, () -> dynArray.remove(1));
    }

    @Test
    public void remove_thenRemoveInTheMiddle() {
        dynArray.insert(1, 0);
        dynArray.insert(2, 1);
        dynArray.insert(3, 2);
        dynArray.insert(4, 3);
        dynArray.remove(2);

        assertEquals(1, dynArray.array[0]);
        assertEquals(2, dynArray.array[1]);
        assertEquals(4, dynArray.array[2]);
        assertEquals(3, dynArray.count);
        assertEquals(16, dynArray.capacity);
    }

    @Test
    public void append_thenCapacityIsNotChangeAndOneItem() {
        dynArray.append(1);

        assertEquals(1, dynArray.count);
        assertEquals(16, dynArray.capacity);
    }

    @Test
    public void append_thenCapacityIsNotChangeAndSomeItem() {
        dynArray.append(1);
        dynArray.append(2);
        dynArray.append(3);

        assertEquals(3, dynArray.count);
        assertEquals(16, dynArray.capacity);
        assertEquals(1, dynArray.array[0]);
        assertEquals(2, dynArray.array[1]);
        assertEquals(3, dynArray.array[2]);
    }

    @Test
    public void append_thenCapacityIsChange() {
        for (int i = 0; i < 16; i++) {
            dynArray.insert(i, i);
        }
        assertEquals(16, dynArray.count);
        assertEquals(16, dynArray.capacity);

        dynArray.append(17);
        assertEquals(17, dynArray.count);
        assertEquals(32, dynArray.capacity);
    }
}