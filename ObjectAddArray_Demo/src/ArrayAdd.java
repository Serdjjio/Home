import java.util.Iterator;

public class ArrayAdd {

    private Object [] arr;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    ArrayAdd() {
        arr = new Object[DEFAULT_CAPACITY];
    }

    ArrayAdd(int capacity) {
        arr = new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int indexOf(Object person) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == person) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object person) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] == person) {
                return i;
            }
        }
        return -1;
    }

    public Object get(int index) {
        if (index < size) {
            return arr[index];
        }
        return -1;
    }

    public Object set(int index, Object person) {
        Object oldValue = -1;
        if (index < size) {
            oldValue = arr[index];
            arr[index] = person;
        }
        return oldValue;
    }

    public boolean add(Object person) {
        ensureCapacity();
        arr[size] = person;
        size++;
        return true;
    }

    public boolean addAll(Object[] arrToAdd) {
        for (int i = 0; i < arrToAdd.length - 1; i++) {
            ensureCapacity();
            arr[size] = arrToAdd[i];
            size++;
        }
        return true;
    }

    public boolean addAll(int index, Object [] arrToAdd){
        if(index==size -1){
            addAll(arrToAdd);
            return true;

        }

        if(index>=size || index<0){
            System.out.println("Index out of range");
            return false;

        }

        Object []oldArr = copyArray(size);

        for(int i = 0; i<arrToAdd.length;i++){
            ensureCapacity();
            arr[i+index] = arrToAdd[i];
            size ++;
        }

        for (int i = 0; i<oldArr.length - index; i++){
            arr[index+arrToAdd.length+i]=oldArr[index+i];
        }
        return true;
    }

    public boolean removeRange(int fromIndex, int toIndex){
        if(!(toIndex>fromIndex || fromIndex>=0 || fromIndex<size ||toIndex<size)){
            System.out.println("Index out of range");
            return false;
        }
        Object []oldArr = copyArray(size);
        for(int i=0, j=0; i<size; i++){
            if(i<fromIndex || i>=toIndex){
                arr[j]=oldArr[i];
                j++;
            }
        }
        size = size - (toIndex - fromIndex);
        return true;
    }

    public boolean addAtPosition(int index, Object person) {
        if (index >= size) {
            return false;
        }
        ensureCapacity();
        Object[] oldArr = copyArray(size);
        size++;
        arr[index] = person;
        for (int i = index + 1; i < size; i++) {
            arr[i] = oldArr[i - 1];
        }
        return true;
    }

    public Object remove(Object person) {
        int foundIndex = indexOf(person);
        if (foundIndex == -1) {
            return -1;
        }
        Object[] oldArr = copyArray(size);
        Object oldValue = arr[foundIndex];
        size--;
        for (int i = foundIndex; i < size; i++) {
            arr[i] = oldArr[i + 1];
        }
        return oldValue;
    }

    private void ensureCapacity() {
        if (size == arr.length) {
            int newSize = arr.length * 2;
            arr = copyArray(newSize);
        }
    }

    private Object[] copyArray(int newSize) {
        Object[] newArr = new Object[newSize];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println((i+1)+ " - "+arr[i]);
        }
    }
}