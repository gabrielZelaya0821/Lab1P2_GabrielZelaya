package lab1p2_gabrielzelaya;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Lab1P2_GabrielZelaya {

    public static void main(String[] args) throws ParseException {
        menu();
    }
    
    public static void menu() throws ParseException{
        Scanner entrada = new Scanner(System.in);
        int menu;
        do{
            System.out.println("----------Menú----------"); 
            System.out.println("(1)Ejercicio1 (2)Ejercicio2 (3)Ejercicio3 (4)Salir");
            menu = entrada.nextInt();
            switch (menu){
                case 1 -> ejercicio1();
                case 2 -> ejercicio2();
                case 3 -> ejercicio3();
                case 4 -> {
                }
                default -> System.out.println("Número no es válido");
            }
        }while(menu!=4);
    }
    
    public static void ejercicio1(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de discos: ");
        int discos = entrada.nextInt();
        System.out.println("(1)Origen (2)Auxilar (3)Destino");
        hanoi(discos,1,2,3);
    }
    
    public static void hanoi(int discos,int origen,int auxiliar,int destino){
        if (discos == 1){
             System.out.println("Mover disco 1 de "+origen+" a "+destino);
        }else{
            hanoi(discos - 1,origen,destino,auxiliar);
            System.out.println("Mover disco "+discos+" de "+origen+" a "+auxiliar);
            hanoi(discos - 1,auxiliar,origen,destino);
        }
    }
    
    public static void ejercicio2() throws ParseException{
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese palabras separadas por comas");
        String str = entrada.nextLine();
        String[] datos = str.split(",");
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (String dato : datos) {
            if (dato.contains("/") && dato.length() == 10) {
                Date fecha = sdf.parse(dato);
                System.out.println(fecha);
            }
        }
    }
    
    public static void ejercicio3(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese un núemro: ");
        int num = entrada.nextInt();
        System.out.println(pi(num,0,0));
    }
    
    public static double pi(int limite,int n,double resultado){
        if (n == limite) {
            return 4 * resultado;
        } else {
            resultado += Math.pow(-1,n) / ((2*n) + 1);
            return pi(limite,n+1,resultado);
        }
    }
    
}
