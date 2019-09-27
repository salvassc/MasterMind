package mastermind;

import java.util.ArrayList;
import java.util.Scanner;

public class Tablero {
    
    char[][] matrizTablero;
    
    public Tablero() {
        matrizTablero = new char[10][4];   
    }
    
    public char obtenerElementoMatrizTablero(int fila, int columna){
        return matrizTablero[fila][columna];
    }
    
    public void iniciarJuego() {
        CombinacionPropuesta combinacionPropuestaUsuario;
        int reintentosCombinacionPropuesta = 0;
        
        System.out.println("----- MASTERMIND -----");
        System.out.println("****");
        
        while(reintentosCombinacionPropuesta < 10){
            do{
                System.out.print("Propose a combination: ");
                combinacionPropuestaUsuario = new CombinacionPropuesta(leerCombinacionUsuario());
            }while(!combinacionPropuestaUsuario.comprobarCombinacionPropuesta());
            
            anyadirCombinacionPropuestaAlTablero(combinacionPropuestaUsuario, reintentosCombinacionPropuesta);
            mostrarInformaciónTablero(reintentosCombinacionPropuesta);
            reintentosCombinacionPropuesta++;
        }
        
    }
    
    public void mostrarInformaciónTablero(int filasCompletas){
        boolean primeraFila = true;
        
        System.out.println(filasCompletas+1 + " attempt(s):");
        System.out.println("****");
        for(int i = 0; i <= filasCompletas; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(obtenerElementoMatrizTablero(i, j));
            }
            System.out.print(" --> \n" );
        }
    }
    
    public void anyadirCombinacionPropuestaAlTablero(CombinacionPropuesta combinacionPropuestaUsuario, int fila){
        for(int i = 0; i < 4; i++)
            matrizTablero[fila][i] = combinacionPropuestaUsuario.obtenerElementoCombinacionPropuesta(i);    
    }
    
    public ArrayList<Character> leerCombinacionUsuario() {
        ArrayList<Character> combinacionPosibleUsuario = new ArrayList<>();
        
        Scanner leerCombinacionUsuario = new Scanner(System.in);
        String combinacionObtenida = leerCombinacionUsuario.nextLine();
              
        //Troceo cadena obtenida y la almaceno en un array
        for(int i = 0; i < combinacionObtenida.length(); i++){
            combinacionPosibleUsuario.add(combinacionObtenida.charAt(i));
        }
        
        return combinacionPosibleUsuario;
    }
    
    
    
}
