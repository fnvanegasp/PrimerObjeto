/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class Ejecucion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cancion c = new Cancion("Friday I'm In Love");
        c.sonar();
        
        Cancion c2 = new Cancion();
        c2.sonar();
    }
    
}

