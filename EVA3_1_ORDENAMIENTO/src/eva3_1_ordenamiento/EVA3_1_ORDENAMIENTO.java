package eva3_1_ordenamiento;

public class EVA3_1_ORDENAMIENTO {

    public static void main(String[] args) {
        int[] original = new int[10];
        int[] selection = new int[10];
        int[] insertion = new int[10];
        int[] bubble = new int[10];
        int[] quick = new int[10];
        long ini, fin, tiempo;

        //Arreglo Original
        llenarArreglo(original);
        imprimirArreglo(original);
        selection = copiarArreglo(original);

        //Selection Sort
        System.out.println("***** SELECTION SORT *****");
        ini = System.nanoTime();
        selectionSort(selection);
        fin = System.nanoTime();
        imprimirArreglo(selection);
        tiempo = fin - ini;
        System.out.println("T = " + tiempo);

        // Insertion Sort
        insertion = copiarArreglo(original);
        System.out.println("***** INSERTION SORT *****");
        ini = System.nanoTime();
        insertionSort(insertion);
        fin = System.nanoTime();
        imprimirArreglo(insertion);
        tiempo = fin - ini;
        System.out.println("T = " + tiempo);

        // Bubble Sort
        bubble = copiarArreglo(original);
        System.out.println("***** BUBBLE SORT *****");
        ini = System.nanoTime();
        bubbleSort(bubble);
        fin = System.nanoTime();
        imprimirArreglo(bubble);
        tiempo = fin - ini;
        System.out.println("T = " + tiempo);

        // Quick Sort
        quick = copiarArreglo(original);
        System.out.println("***** QUICK SORT *****");
        ini = System.nanoTime();
        quickSort(quick, 0, quick.length - 1);
        fin = System.nanoTime();
        imprimirArreglo(quick);
        tiempo = fin - ini;
        System.out.println("T = " + tiempo);
    }

    public static void llenarArreglo(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (int) (Math.random() * 100);
        }
    }

    public static void imprimirArreglo(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            System.out.print("[" + datos[i] + "]");
        }
        System.out.println("");
    }

    public static int[] copiarArreglo(int[] datos) {
        int[] nuevo = new int[datos.length];
        for (int i = 0; i < datos.length; i++) {
            nuevo[i] = datos[i];
        }
        return nuevo;
    }

    public static void selectionSort(int[] datos) {
        for (int i = 0; i < datos.length - 1; i++) {
            int min = i; // posición del valor mínimo
            for (int j = i + 1; j < datos.length; j++) {
                if (datos[j] < datos[min]) {
                    min = j; // se encontró un valor menor
                }
            }
            // Intercambio
            int temp = datos[i];
            datos[i] = datos[min];
            datos[min] = temp;
        }
    }

    public static void insertionSort(int[] datos) {
        for (int i = 1; i < datos.length; i++) {
            int temp = datos[i];
            int insP = i;

            for (int anterior = i - 1; anterior >= 0; anterior--) {
                if (datos[anterior] > temp) {
                    datos[insP] = datos[anterior];
                    insP--;
                } else {
                    break;
                }
            }
            datos[insP] = temp;
        }
    }

    public static void bubbleSort(int[] datos) {
    for (int i = 0; i < datos.length; i++) {
        // El bucle interno debe ir hasta 'length - 1'
        for (int j = 0; j < datos.length - 1; j++) { 
            // Comparamos elementos ADYACENTES
            if (datos[j] > datos[j + 1]) { // <-- ESTA ES LA LÍNEA CORREGIDA
                int temp = datos[j];
                datos[j] = datos[j + 1];
                datos[j + 1] = temp;
            }
        }
    }
}

    public static void quickSort(int[] datos, int ini, int fin) {
        quicksortRecu(datos, 0, datos.length - 1);

    }
//ALGORITMO RECURSIVO

    public static void quicksortRecu(int[] datos, int ini, int fin) {
//ELEGIR PIVOTE --> PARA NUESTRO EJEMPLO, PRIMER ELEMENTO
//MOVER LOS INDICES
//ENCONTAR VALORES E INTERCAMBIAR
//SE CRUZAN?
//SI --> INTERCAMBIAR PIVOTE, TERMINAR
//SI --> REPETIR DESDE MOVER INDICES
//LLAMADA RECURSIVA A CADA PARTE DEL ARREGLO
//A LADO IZQ Y DER DEL PIVOTE

        if (ini < fin) {
            int pivote = datos[ini];
            int i = ini + 1;
            int j = fin;

            while (i <= j) {
                while (i <= fin && datos[i] <= pivote) {
                    i++;
                }
                while (j >= ini && datos[j] > pivote) {
                    j--;
                }
                if (i < j) {
                    int temp = datos[i];
                    datos[i] = datos[j];
                    datos[j] = temp;
                }
            }

            // Intercambiar el pivote con el elemento en j
            datos[ini] = datos[j];
            datos[j] = pivote;

            // Llamadas recursivas para cada mitad
            quicksortRecu(datos, ini, j - 1); // izquierda
            quicksortRecu(datos, j + 1, fin); // derecha
        }
    }
}
