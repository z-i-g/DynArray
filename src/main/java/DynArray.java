

public class DynArray<T> {

    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz)
    {
        clazz = clz;
        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        T[] tempArray = array;
        array = (T[]) Array.newInstance(this.clazz, new_capacity);
        if (count > 0) {
            System.arraycopy(tempArray, 0, array, 0, count);
        }
        capacity = new_capacity;
    }

    public T getItem(int index)
    {
        if (indexIsOutOfAcceptableLimits(index))
            throw new IndexOutOfBoundsException();
        return array[index];
    }

    public void append(T itm)
    {
        if (capacity == count) {
            makeArray(capacity * 2);
        }
        array[count] = itm;
        count++;
    }

    public void insert(T itm, int index)
    {
        if (indexIsOutOfAcceptableLimits(index))
            throw new IllegalArgumentException();
        if (capacity == count) {
            makeArray(capacity * 2);
        }
        if (count != index) {
            for (int i = index; i <= count; i++) {
                T temp = array[i];
                array[i] = itm;
                itm = temp;
            }
        } else {
            array[index] = itm;
        }
        count++;
    }

    public void remove(int index)
    {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();
        if (index == count - 1) {
            array[index] = null;
        } else {
            for (int i = index; i <= count; i++) {
                array[i] = array[i + 1];
            }
        }
        count--;
        if ((double)capacity/count > 2) {
            int newCapacity = (int) (capacity/1.5);
            makeArray(Math.max(newCapacity, 16));
        }
    }

    private boolean indexIsOutOfAcceptableLimits(int index) {
        return index > count || index < 0;
    }

}
