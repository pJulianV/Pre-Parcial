
import java.io.*;
import java.util.*;

public class Main {

    // PARTE 2 - Punto 2: Acceso directo — muestra una línea específica del archivo por número

    static void mostrarLineaDirecta(File file, int num) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(file));
        String line;
        int cur = 1;
        boolean found = false;
        while ((line = r.readLine()) != null) {
            if (cur++ == num) {
                System.out.println("Línea " + num + ": " + line);
                found = true;
                break;
            }
        }
        r.close();
        if (!found) System.out.println("Número de línea fuera de rango.");
    }

    // PARTE 4 - Punto 7: Recursividad — cuenta estudiantes con nota >= 90

    static int contarNotasAltas(List<String[]> lista, int i) {
        if (i == lista.size()) return 0;
        int nota = Integer.parseInt(lista.get(i)[2].trim());
        return (nota >= 90 ? 1 : 0) + contarNotasAltas(lista, i + 1);
    }

    // PARTE 3 - Punto 4: Mezcla directa — fusiona dos bloques ya ordenados
    static int[] mezclaDirecta(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length)
            res[k++] = (a[i] <= b[j]) ? a[i++] : b[j++];
        while (i < a.length) res[k++] = a[i++];
        while (j < b.length) res[k++] = b[j++];
        return res;
    }

    // PARTE 3 - Punto 5: Detección de corridas naturales (secuencias ya ordenadas)
    static List<int[]> corridasNaturales(int[] arr) {
        List<int[]> corridas = new ArrayList<>();
        int inicio = 0;
        while (inicio < arr.length) {
            int fin = inicio + 1;
            while (fin < arr.length && arr[fin] >= arr[fin - 1]) fin++;
            corridas.add(Arrays.copyOfRange(arr, inicio, fin));
            inicio = fin;
        }
        return corridas;
    }

    public static void main(String[] args) throws IOException {
        // PARTE 1: Verificar/crear archivo y leer contenido (acceso secuencial)
        System.out.println("¡Hola! Este programa trabaja con un archivo llamado estudiantes.txt.");
        File file = new File("estudiantes.txt");
        if (!file.exists()) {
            BufferedWriter w = new BufferedWriter(new FileWriter(file));
            w.write("Nombre,Edad,Nota\nAna,21,89\nLuis,23,92\nMarta,20,95\nCarlos,22,85\n");
            w.close();
            System.out.println("No encontré el archivo, así que lo creé con algunos registros de ejemplo.");
        } else {
            System.out.println("Archivo encontrado: leyendo su contenido...");
        }

        List<String[]> estudiantes = new ArrayList<>();
        System.out.println("\nContenido del archivo");
        System.out.println("Estos son los estudiantes registrados:");
        BufferedReader r = new BufferedReader(new FileReader(file));
        String line; boolean header = true;
        while ((line = r.readLine()) != null) {
            System.out.println(line);
            if (header) { header = false; continue; }
            String[] c = line.split(",");
            if (c.length == 3) estudiantes.add(c);
        }
        r.close();

        // PARTE 2 - Punto 2: Acceso directo mediante función separada
        Scanner sc = new Scanner(System.in);
        System.out.print("\n¿Qué línea te gustaría ver? Ingresa el número: ");
        int num = sc.nextInt();
        mostrarLineaDirecta(file, num);
        System.out.println("Gracias por usar la consulta directa.");

        // PARTE 3 - Punto 4: Mezcla directa
        int[] b1 = {10, 30, 50, 70}, b2 = {20, 40, 60, 80};
        System.out.println("\n  Ahora hacemos una mezcla directa con dos bloques  ");
        System.out.println("Bloque 1: " + Arrays.toString(b1));
        System.out.println("Bloque 2: " + Arrays.toString(b2));
        System.out.println("La combinación ordenada queda así: " + Arrays.toString(mezclaDirecta(b1, b2)));

        // PARTE 3 - Punto 5: Corridas naturales
        int[] arr = {3, 5, 7, 2, 4, 8, 1, 6};
        List<int[]> corridas = corridasNaturales(arr);
        System.out.println("\n  Buscando corridas naturales en " + Arrays.toString(arr) + "  ");
        for (int i = 0; i < corridas.size(); i++)
            System.out.println("  Corrida " + (i + 1) + ": " + Arrays.toString(corridas.get(i)));

        // PARTE 4 - Punto 7: Contar recursivamente (análisis en informe.md)
        System.out.println("\n  Contando con recursividad  ");
        System.out.println("Aquí vemos cuántos estudiantes tienen nota de 90 o más:");
        System.out.println("Total: " + contarNotasAltas(estudiantes, 0));

        sc.close();
    }
}