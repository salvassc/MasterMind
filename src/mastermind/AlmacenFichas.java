package mastermind;

public class AlmacenFichas {
    
    char[] almacenFichas = new char[6];
    
    public AlmacenFichas() {
        almacenFichas[0] = 'r';
        almacenFichas[1] = 'b';
        almacenFichas[2] = 'y';
        almacenFichas[3] = 'g';
        almacenFichas[4] = 'o';
        almacenFichas[5] = 'p';
    }
    
    public char[] getAlmacenFichas() {
        return almacenFichas;
    }
    
    public void setAlmacenFichas(char[] almacenFichas) {
        this.almacenFichas = almacenFichas;
    }
    
    public char obtenerFicha(int index){
        return almacenFichas[index];
    }
    
    public String listarTodasFichas(){
        String listadoFichas = "";
        
        for(int i = 0; i < almacenFichas.length; i++)
            listadoFichas += almacenFichas[i];
        
        return listadoFichas;
    }
    
}
