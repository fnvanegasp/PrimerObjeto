/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class Quiz {
    public static void main(String[] args){
        java.util.Scanner teclado = new java.util.Scanner(System.in);
        boolean centinela = true;
        int opcion = 0;
        int personasIngresadas = 0;
        int[] votacion = null;
        int[] edad = null;
        int[] estadoCivil = null;
        int[] calificacion = null;
        int filtroEstadoCivil = 0;
        int filtroEdad = 0;
        int indicador = 0;
        
        System.out.println("Ingrese la cantidad máxima de Personas a participar en las votaciones");
        int tamañoMaximo = teclado.nextInt();
        
        edad = new int[tamañoMaximo];
        estadoCivil = new int[tamañoMaximo];
        calificacion = new int[tamañoMaximo];
        
        while(centinela == true){
            opcion = menu();
            
            if (opcion == 1){
                if(personasIngresadas < tamañoMaximo){
                    votacion = ingresarVotacion();
                    edad[personasIngresadas] = votacion[0];
                    estadoCivil[personasIngresadas] = votacion[1];
                    calificacion[personasIngresadas] = votacion[2];
                    personasIngresadas = personasIngresadas + 1;
                } else {
                    System.out.println("Ya participaron todos las personas posibles");
                }
            } else {
                if (opcion == 2){
                    System.out.println("Sobre que estado civil desea hacer el filtro");
                    filtroEstadoCivil = teclado.nextInt();
                    System.out.println("Sobre que rango de edad desea hacer el filtro");
                    filtroEdad = teclado.nextInt();
                    ReporteParcial(edad,estadoCivil,calificacion,personasIngresadas - 1,filtroEdad,filtroEstadoCivil);
                } else {
                    ReporteFinal(personasIngresadas,calificacion);
                }
            }
            System.out.println("Si desea finalizar presione 0, para continuar presione 1");
            indicador = teclado.nextInt();
            if(indicador == 0){
                centinela = false;
            }
        }
        
        System.out.println("Se ha finalizado la ejecución del proceso de elecciones");
    }
    
public static int menu(){
    java.util.Scanner teclado = new java.util.Scanner(System.in);
        System.out.println("Seleccione la opcion a ejecutar 1. Ingresar Votacion. 2. Reporte Parcial. 3. Reporte Final Elecciones");
        int opcion = teclado.nextInt();
    return opcion;
}

public static void ReporteParcial(int[]edad, int[]estadoCivil, int[]calificacion, int tamaño, int filtroEdad, int filtroEstadoCivil){
    System.out.println("Reporte Parcial");
    double promedio = 0;
    int total = 0;
    int numCumpleFiltro = 0;
    
    for(int i = 0; i < tamaño; i++){
        if(estadoCivil[i] == filtroEstadoCivil && edad[i] == filtroEdad){
            numCumpleFiltro = numCumpleFiltro + 1;
            total = total + calificacion[i];
        }   
    }
    promedio = (total/numCumpleFiltro);
    System.out.println("Resultados Parcial: " + " Votaron " + numCumpleFiltro +" Personas con Estado Civil " + filtroEstadoCivil + " Y en rango de edad de " + filtroEdad + " con promedio total de " + promedio);
}

public static void ReporteFinal(int tamaño, int[]calificacion){
    System.out.println("Reporte final");
    int total = 0;
    for(int i = 0; i < tamaño; i++){
        total = total + calificacion[i];
    }
    total = (total / tamaño);
    System.out.println("Resultado Final" + " Numero de encuestados actuales " + tamaño + " Promedio Votacion " + total);
}

public static int[] ingresarVotacion(){
    
    int[] votacion = new int[3];
    java.util.Scanner teclado = new java.util.Scanner(System.in);
    
    System.out.println("Ingrese Rango de edad: Presione 1 si tiene menos de 18 años, 2. si tiene entre 18 y 55. 3. Si tiene más de 55" );
    votacion[0] = teclado.nextInt();
    
    System.out.println("Situacion Civil: Presione 1 si es soltero, 2 Si es casado");
    votacion[1] = teclado.nextInt();
    
    System.out.println("Ingrese calificación del curso entre 0 y 10");
    votacion[2] = teclado.nextInt();
    
    return votacion;
}
}

