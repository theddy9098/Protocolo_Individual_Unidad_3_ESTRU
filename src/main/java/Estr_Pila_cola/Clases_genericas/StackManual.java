package Estr_Pila_cola.Clases_genericas;


    public class StackManual<T> {
        private Object[] items;
        private int size;

        public StackManual(int capacity) {
            items = new Object[capacity];
            size = 0;
        }

        // Agregar un elemento
        public void push(T value) {
            if (size == items.length)
                throw new RuntimeException("Pila llena");
            items[size++] = value;
        }

        // Quitar el último elemento agregado
        public T pop() {
            if (isEmpty())
                throw new RuntimeException("Pila vacía");
            T value = (T) items[--size];
            items[size] = null; // limpiar referencia
            return value;
        }

        // Ver el último elemento sin quitarlo
        public T peek() {
            if (isEmpty())
                throw new RuntimeException("Pila vacía");
            return (T) items[size - 1];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void clear() {
            size = 0;
        }
    }


