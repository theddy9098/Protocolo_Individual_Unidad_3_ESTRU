package Estr_Pila_cola;

import Estr_Pila_cola.Clases_genericas.QueueManual;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Deque<Integer> pila = new ArrayDeque<>(10);
        QueueManual<Integer> cola = new QueueManual<>(10);


        pila.push(5); cola.enqueue(5);
        pila.push(8); cola.enqueue(8);
        pila.push(6); cola.enqueue(6);
        pila.push(1); cola.enqueue(1);
        pila.push(4); cola.enqueue(4);


        System.out.println("\nElementos en la cola :");
        while (!cola.isEmpty()) {
            System.out.println(cola.dequeue());
        }
        System.out.println("\n");

        System.out.println("El tamaño de la pila es: "+pila.size());
        System.out.println("La pila esta vacia:"+pila.isEmpty());
        System.out.println("El ultimo numero es: "+pila.peek());
        System.out.println("Se remueve el ultimo numero: "+pila.pop());
        System.out.println("\n");

        int[] arr = new int[pila.size()];
        Deque<Integer> copia = new ArrayDeque<>(pila.size());
        int index = pila.size() - 1;

        while (!pila.isEmpty()) {
            int valor = pila.pop();
            arr[index--] = valor;
            copia.push(valor);
        }


        while (!copia.isEmpty()) {
            pila.push(copia.pop());
        }

        System.out.println("Elementos del arreglo:");
        for (int i:arr) {
            System.out.println(i);

        }
        System.out.println("\n");
        System.out.println("El orden del arreglo de pila es: "+detectarOrden(arr));
        for( int i:arr)
            System.out.println(i);
        if (esAritmetica(arr)) {
            System.out.println("El arreglo es una progresión aritmética.");
        } else if (esGeometrica(arr)) {
            System.out.println("El arreglo es una progresión geométrica.");
        } else {
            System.out.println("El arreglo no cumple ninguna progresión.");
        }


        }



    public static String detectarOrden(int[] arr) {
        boolean ascendente = IntStream.range(0, arr.length - 1)
                .allMatch(i -> arr[i] <= arr[i + 1]);

        boolean descendente = IntStream.range(0, arr.length - 1)
                .allMatch(i -> arr[i] >= arr[i + 1]);

        if (ascendente) return "Ascendente";
        else if (descendente) return "Descendente";
        else return "Desordenado";
    }

    public static boolean esAritmetica(int[] arr) {
        if (arr.length < 2) return false;
        return IntStream.range(1, arr.length - 1)
                .allMatch(i -> arr[i + 1] - arr[i] == arr[1] - arr[0]);
    }


    public static boolean esGeometrica(int[] arr) {
        if (arr.length < 2 || arr[0] == 0) return false;
        return IntStream.range(1, arr.length - 1)
                .allMatch(i -> arr[i] != 0 && (double) arr[i + 1] / arr[i] == (double) arr[1] / arr[0]);
    }
}
