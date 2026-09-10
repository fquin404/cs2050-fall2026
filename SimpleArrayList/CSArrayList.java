public class CSArrayList<E> implements SimpleList<E> {

    private static final int DEFAULT_CAPACITY = 4;

    private E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public CSArrayList() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(E value) {
        if (size == data.length) { // checks if the array is full
            grow(); // makes the array larger
        }

        data[size] = value; // places the value in the next open space
        size++; // increases the number of stored values
    }

    @Override
    public void add(int index, E value) {
        checkAddIndex(index); // checks if the insertion index is valid

        if (size == data.length) { // checks if the array is full
            grow(); // makes the array larger
        }

        for (int i = size; i > index; i--) { // moves values one space to the right
            data[i] = data[i - 1]; // copies the value from the previous space
        }

        data[index] = value; // places the new value at the chosen index
        size++; // increases the number of stored values
    }

    @Override
    public E get(int index) {
        checkIndex(index); // checks if the index is valid
        return data[index]; // returns the value at the chosen index
    }

    @Override
    public E remove(int index) {
        checkIndex(index); // checks if the index is valid

        E removedValue = data[index]; // saves the value that will be removed

        for (int i = index; i < size - 1; i++) { // moves values one space to the left
            data[i] = data[i + 1]; // copies the next value into the current space
        }

        size--; // decreases the number of stored values
        data[size] = null; // clears the unused array space
        return removedValue; // returns the removed value
    }

    @Override
    public int size() {
        return size; // returns the number of stored values
    }

    @Override
    public boolean isEmpty() {
        return size == 0; // returns true when the list has no values
    }

    /**
     * Returns a simple view of every backing-array slot for debugging.
     */
    public String debugView() {
        StringBuilder view = new StringBuilder();
        view.append("size: ").append(size).append(System.lineSeparator());
        view.append("capacity: ").append(data.length).append(System.lineSeparator());

        for (int index = 0; index < data.length; index++) {
            view.append(index).append(": ").append(data[index]);
            if (index < data.length - 1) {
                view.append(System.lineSeparator());
            }
        }

        return view.toString();
    }

    // Private helper methods may be added by students.

    @SuppressWarnings("unchecked")
    private void grow() { // increases the size of the backing array
        E[] newData = (E[]) new Object[data.length * 2]; // creates an array with twice the space

        for (int i = 0; i < data.length; i++) { // moves through the old array
            newData[i] = data[i]; // copies each value into the new array
        }

        data = newData; // replaces the old array with the new array
    }

    private void checkIndex(int index) { // checks an index used to get or remove
        if (index < 0 || index >= size) { // checks if the index is outside the list
            throw new IndexOutOfBoundsException("Invalid index: " + index); // reports the invalid index
        }
    }

    private void checkAddIndex(int index) { // checks an index used to insert
        if (index < 0 || index > size) { // allows an index from zero through size
            throw new IndexOutOfBoundsException("Invalid index: " + index); // reports the invalid index
        }
    }
}
