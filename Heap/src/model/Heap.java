package model;

class ArrayQueue {

    protected Flight[] a;
    protected int max;
    protected int first, last;

    public ArrayQueue() {
        this(10);
    }

    public Flight[] getA() {
        return a;
    }

    public void setA(Flight[] a) {
        this.a = a;
    }

    public ArrayQueue(int max1) {
        max = max1;
        a = new Flight[max];
        first = last = -1;
    }

    public boolean isEmpty() {
        return (first == -1);
    }

    public boolean isFull() {
        return ((first == 0
                && last == max - 1) || first == last + 1);
    }

    private boolean grow() {
        int i, j;
        int max1 = max + max / 2;
        Flight[] a1 = new Flight[max1];
        if (a1 == null) {
            return (false);
        }
        if (last >= first) {
            for (i = first; i <= last; i++) {
                a1[i - first] = a[i];
            }
        } else {
            for (i = first; i < max; i++) {
                a1[i - first] = a[i];
            }
            i = max - first;
            for (j = 0; j <= last; j++) {
                a1[i + j] = a[j];
            }
        }
        a = a1;
        first = 0;
        last = max - 1;
        max = max1;
        return (true);
    }

    void enqueue(Flight x) {
        if (isFull() && !grow()) {
            return;
        }
        if (last == max - 1 || last == -1) {
            a[0] = x;
            last = 0;
            if (first == -1) {
                first = 0;
            }
        } else {
            a[++last] = x;
        }
    }

    Flight front() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return (a[first]);
    }

    public Flight dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        Flight x = a[first];
        if (first == last) // only one element
        {
            first = last = -1;
        } else if (first == max - 1) {
            first = 0;
        } else {
            first++;
        }
        return (x);
    }
}

public class Heap {

    ArrayQueue data = new ArrayQueue();
    int length = 0;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int PARENT(int i) {
        return (i - 1) / 2;
    }

    public int LEFT(int i) {
        return 2 * i + 1;
    }

    public int RIGHT(int i) {
        return 2 * (i + 1);
    }

    public void heapify(Flight[] flights, int n) {
        for (int i = 1; i < n; i++) {
            Flight x = flights[i];
            int s = i;
            while (s > 0 && x.compareTo(flights[PARENT(s)]) > 0) {
                flights[s] = flights[PARENT(s)];
                s = PARENT(s);
            }
            flights[s] = x;
        }
    }

    public void insert(Flight a) {
        data.enqueue(a);
        length++;
        heapify(data.getA(), length);
    }

    // thuật toán sort và heapify này thuận tiện cho việc lấy ra giá trị max sau đó sẽ bỏ nó vào cuối mảng rồi tận dụng lấy ra dùng sau 
    public void sort(Flight[] flights) {
        int n = length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(flights, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            Flight temp = flights[0];
            flights[0] = flights[i];
            flights[i] = temp;
            heapify(flights, i, 0);
        }
    }

    public void heapify(Flight[] flights, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && flights[l].compareTo(flights[largest]) > 0) {
            largest = l;
        }
        if (r < n && flights[r].compareTo(flights[largest]) > 0) {
            largest = r;
        }
        if (largest != i) {
            Flight swap = flights[i];
            flights[i] = flights[largest];
            flights[largest] = swap;

            heapify(flights, n, largest);
        }
    }

    public Flight getMax() {
        length--;
        Flight temp = data.getA()[0];
        data.getA()[0] = data.getA()[length];
        data.getA()[length] = temp;
        heapify(data.getA(), length, 0);
        return temp;
    }

    //print check phần tử đầu tiên là max
    public void print() {
        for (int i = 0; i < length; i++) {
            System.out.println(data.getA()[i]);
        }
    }

    public void printPriority() {
        sort(data.getA());
        print();
    }

}
