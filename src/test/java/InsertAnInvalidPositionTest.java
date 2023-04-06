import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InsertAnInvalidPositionTest {
    DynArray dynArray = new DynArray(Integer.class);

    @Test
    public void insert_thenInsertAnInvalidPosition2() {
        for (int i = 0; i < 1048; i++) {
            dynArray.insert(i, i);
        }
        assertEquals(1048, dynArray.count);
        assertEquals(2048, dynArray.capacity);

        assertThrows(IndexOutOfBoundsException.class, () -> dynArray.insert( 4096, 4096));
        assertEquals(1048, dynArray.count);
        assertEquals(2048, dynArray.capacity);
    }
}