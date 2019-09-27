package mastermind;

import java.util.ArrayList;

public class CombinacionPropuesta extends Combinacion{
    
    ArrayList<Character> combinacionPropuesta;
    
    public CombinacionPropuesta (ArrayList<Character> combinacionPropuesta){
        this.combinacionPropuesta = combinacionPropuesta;
    }
    
    public ArrayList<Character> getCombinacionPropuesta (){
        return combinacionPropuesta;
    }
    
    public void setCombinacionPropuesta (ArrayList<Character> combinacionPropuesta){
        this.combinacionPropuesta = combinacionPropuesta;
    }
    
    public char obtenerElementoCombinacionPropuesta(int index){
        return combinacionPropuesta.get(index);
    }
    
    public boolean comprobarCombinacionPropuesta() {
        if (comprobarTamanyoCombinacion(combinacionPropuesta) && comprobarFichasRepetidas(combinacionPropuesta) && comprobarColorFichas(combinacionPropuesta))
            return true;
        else 
            return false;
    }
    
    public boolean comprobarTamanyoCombinacion(ArrayList<Character> matrizCombinacionPropuesta) {
        if (matrizCombinacionPropuesta.size() == 4)
            return true;
        else {
            System.out.println("Wrong proposed combination length");
            return false;
        }
    }
    
    public boolean comprobarFichasRepetidas(ArrayList<Character> matrizCombinacionPropuesta) {
        int contadorElementos = 0;
        
        for (int i = 0; i < matrizCombinacionPropuesta.size(); i++){
            for (int j = 1 + contadorElementos; j < matrizCombinacionPropuesta.size(); j++){
                if(matrizCombinacionPropuesta.get(i).equals(matrizCombinacionPropuesta.get(j))){
                    System.out.println("Repeated colors");
                    return false;
                }
            }
            contadorElementos++;
        }
        return true;
    }
    
    public boolean comprobarColorFichas(ArrayList<Character> matrizCombinacionPropuesta){
        int contadorFichasErroneas = 0;
        AlmacenFichas almacen = new AlmacenFichas();
        
        for(int i = 0; i < matrizCombinacionPropuesta.size(); i++){
            for(int j = 0; j < almacen.getAlmacenFichas().length; j++){
                if(matrizCombinacionPropuesta.get(i) != almacen.obtenerFicha(j))
                    contadorFichasErroneas++;
            }
            if(contadorFichasErroneas == 6){
                System.out.println("Wrong colors, they must be: " + almacen.listarTodasFichas());
                return false;
            }
            else
                contadorFichasErroneas = 0;
        }
        return true;      
    }
}
