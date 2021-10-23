package taller_mecanica;

public class RC_Caja_Herramientas {
    
    //CONSTANTES
    public static final int CAPACIDAD = 5;
    
    //CONTENEDOR
    private Integer[] caja;
    
    public RC_Caja_Herramientas() {
        this.caja = new Integer[CAPACIDAD];
        
        for(int i = 1; i <= CAPACIDAD; i++){
            this.caja[i-1]=i;
        }
    }
    
    public synchronized void dejarHerramienta() throws InterruptedException {
   
        //AÑADIMOS COCHE AL ÁREA DE ESPERA
        
        int numeroHerramienta = getCount(); //Miramos el numero de herramientas en la caja
        
        caja[numeroHerramienta] = numeroHerramienta++;//Añadimos una herramienta a la caja
        
        //ECOS
        System.out.println("Añade la herramienta numero "+numeroHerramienta+""
                + " a la caja");
        System.err.println("La caja de Herramientas tiene "+numeroHerramienta+" herramientas");
    }
    
    public synchronized void cogerHerramienta() throws InterruptedException{
        int numeroHerramienta = getCount();
        
        caja[numeroHerramienta-1] = null;
        
    }
    
    public int getCount(){
        int numeroHerramientas = 0;
        for(int j=0; j<caja.length; j++){
            if(caja[j] != null){
                numeroHerramientas++;
            }
        }
        
        return numeroHerramientas;
    } 
    
    
    
}
