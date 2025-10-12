package Estr_Pila_cola.Clases_genericas;

public class QueueManual<T> {
    private Object[] items;
    private int front, rear, size;

    public QueueManual(int capacity) {
        items = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Agregar al final de la cola
    public void enqueue(T value) {
        if (size == items.length)
            throw new RuntimeException("Cola llena");
        rear = (rear + 1) % items.length;
        items[rear] = value;
        size++;
    }

    // Quitar el primero de la cola
    public T dequeue() {
        if (isEmpty())
            throw new RuntimeException("Cola vacía");
        T value = (T) items[front];
        items[front] = null; // limpiar referencia
        front = (front + 1) % items.length;
        size--;
        return value;
    }

    // Ver el primero sin quitarlo
    public T front() {
        if (isEmpty())
            throw new RuntimeException("Cola vacía");
        return (T) items[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        front = 0;
        rear = -1;
    }
}
