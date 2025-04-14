/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.sort.matriz;
import uni.aed.sort.Sort;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author jemd2
 */
public class MatrizApp {
    private int[] serie;
    private int[][] matriz;
    private Sort forOrder;
    private int n;
    private Scanner sc;
    
    public MatrizApp(){
        serie = null;
        matriz = null;
        forOrder = new Sort();
        sc = new Scanner(System.in);
        n = 0;
    }
    
    public int[] generarSerie(){
        this.serie = new int[100];
        Random rand = new Random();
        for(int i=0; i<100; i++){
            serie[i] = 200 - rand.nextInt(100);
        }
        return serie;
    }
    
    public void visualizarSerie(){
        System.out.print("Serie implementada: ");
        for(int i=0; i<100; i++){
            System.out.printf(serie[i] + " ");
            if(i+1%10==0) System.out.println();
        }
        
    }
    
    public void ordenarSerie() {
        if (serie == null) {
            System.out.println("Sin serie");
            return;
        }
        
        forOrder.quickSort(serie,0,99);
        System.out.println("Serie ordenada");
    }
    
    
    /**
     * Carga la matriz con los mayores elementos de la serie
     * en el último cuadrante (n/4 x n/4)
     */
    public void cargarMatriz() {
        if (serie == null) {
            System.out.println("Sin Matriz");
            return;
        }
        
        System.out.print("Ingrese el tamaño de la matriz: ");
        n = sc.nextInt();
        
        matriz = new int[n][n];
        // Inicializar toda la matriz con ceros
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = 0;
            }
        }
        
        // Calcular el tamaño del último cuadrante (n/4 x n/4)
        int quadrantSize = n / 4;
        int startRow = n - quadrantSize;
        int startCol = n - quadrantSize;
        
        // Llenar el último cuadrante con los mayores elementos de la serie
        int serieIndex = serie.length - 1;  // Comenzar desde el elemento más grande
        
        for (int i = startRow; i < n; i++) {
            for (int j = startCol; j < n; j++) {
                if (serieIndex >= 0) {
                    matriz[i][j] = serie[serieIndex--];
                }
            }
        }
        
        System.out.println("Matriz cargada");
    }
    
    public void visualizarMatriz() {
        if (matriz == null) {
            System.out.println("No haymatriz");
            return;
        }
        
        System.out.println("Matriz " + n + "x" + n + ":");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d ", matriz[i][j]); 
            }
            System.out.println();
        }
    }
 
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Generar Serie");
            System.out.println("2. Ordenar Serie");
            System.out.println("3. Visualizar Serie");
            System.out.println("4. Cargar Matriz");
            System.out.println("5. Visualizar Matriz");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opcion: ");
            
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    generarSerie();
                    break;
                case 2:
                    ordenarSerie();
                    break;
                case 3:
                    visualizarSerie();
                    break;
                case 4:
                    cargarMatriz();
                    break;
                case 5:
                    visualizarMatriz();
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
    }
    
    public static void main(String[] args) {
        MatrizApp app = new MatrizApp();
        app.mostrarMenu();
    }
}
