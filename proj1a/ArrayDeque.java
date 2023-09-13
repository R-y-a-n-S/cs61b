public class ArrayDeque<T> {
    public T[] baseArr;
    private int size;
    private int front;
    private int back;
    private boolean firstFront = true;
    private boolean firstBack = true;
    private boolean not_resized = true;
    public ArrayDeque() {
        baseArr = (T[]) new Object[8];
        size = 0;
        front = 0;
        back = baseArr.length - 1;
    }
    public void addFirst(T item) {
        //resize
        if (size == baseArr.length) {
            T[] newArr = (T[]) new Object[baseArr.length * 2];
            int ind = 0;
            int tempSize = size;
            int tempback = back;
            if (front == tempback && front == baseArr.length - 1) {
                tempback = getPev(tempback);
            }
            while (tempSize > 0) {
                if (baseArr[tempback] != null) {
                    newArr[ind] = baseArr[tempback];
                    tempback = getPev(tempback);
                    ind ++;
                    tempSize --;
                }
            }
            baseArr = newArr;
            front = size - 1;
            back = 0;
            not_resized = false;
        }

        if (firstFront && not_resized) {
            firstFront = false;
        } else {
            if (front == baseArr.length - 1) front = 0;
            else front++;

        }
        baseArr[front] = item;
        size ++;
    }

    public void addLast(T item) {
        if (size == baseArr.length) {
            T[] newArr = (T[]) new Object[baseArr.length * 2];;
            int ind = 0;
            int tempSize = size;
            int tempback = back;
            if (front == tempback && front == baseArr.length - 1) {
                tempback = getPev(tempback);
            }
            while (tempSize > 0) {
                if (baseArr[tempback] != null) {
                    newArr[ind] = baseArr[tempback];
                    tempback = getPev(tempback);
                    ind ++;
                    tempSize --;
                }
            }

            baseArr = newArr;
            front = size - 1;
            back = 0;
            not_resized = false;
        }
        if (firstBack && not_resized) {
            firstBack = false;
        } else {
            if (back == 0) back = baseArr.length - 1;
            else back --;
        }
        baseArr[back] = item;
        size ++;
    }
    private int getNext (int currentFront) {
        if (currentFront == 0) return baseArr.length - 1;
        return --currentFront;
    }

    private int getPev (int currentBack) {
        if (currentBack == baseArr.length - 1) return 0;
        return ++currentBack;
    }

    public boolean isEmpty() {
        return size == 0;

    }

    public int size() {
        return size;
    }

    public void printDeque() {

        int tempSize = size;
        int tempfront = front;
        if (back == tempfront && back == 0) {
            tempfront = getNext(tempfront);
        }
        while (tempSize > 0) {
            if (baseArr[tempfront] != null) {
                System.out.print(baseArr[tempfront]);
                tempfront = getNext(tempfront);
                tempSize --;
                if (tempSize == 0) {
                    break;
                }
                System.out.print(" ");
            }else {
                tempfront = getNext(tempfront);
            }
        }
    }

    public T removeFirst() {
        if (size == 0) return null;
        T out;

        if (size == 1) {
            if (baseArr[front] != null) {
                out = baseArr[front];
                baseArr[front] = null;
            }
            else {
                out = baseArr[back];
                baseArr[back] = null;
            }
            front = 0;
            back = baseArr.length - 1;
            size --;
            firstBack = true;
            firstFront = true;
            not_resized = true;
            return out;
        }
        if (baseArr[front] == null) front = getNext(front);
        out = baseArr[front];
        baseArr[front] = null;
        size --;
        if (front == 0) {
            front = baseArr.length - 1;
        } else {
            front --;
        }
        return out;
    }

    public T removeLast() {
        if (size == 0) return null;
        T out;

        if (size == 1) {
            if (baseArr[front] != null) {
                out = baseArr[front];
                baseArr[front] = null;
            }
            else {
                out = baseArr[back];
                baseArr[back] = null;
            }
            front = 0;
            back = baseArr.length - 1;
            size --;
            firstBack = true;
            firstFront = true;
            not_resized = true;
            return out;
        }
        if (baseArr[back] == null) back = getPev(back);
        out = baseArr[back];
        baseArr[back] = null;
        if (back == baseArr.length - 1) {
            back = 0;
        } else {
            back ++;
        }
        size --;
        return out;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null; // Index out of bounds
        }
        int tempSize = size;
        int tempfront = front;
        if (back == tempfront && back == 0) {
            tempfront = getNext(tempfront);
        }
        while (index > 0) {
            if (baseArr[tempfront] != null) {
                tempfront = getNext(tempfront);
                index --;

            }else {
                tempfront = getNext(tempfront);
            }
        }
        return baseArr[tempfront];

    }

}
