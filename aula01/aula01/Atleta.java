public class Atleta{
    private int pais;
    private String modalidade;
    private boolean medalistaOlimpico;

    public abstract void competir(String modalidade) {
        System.out.println("É especialista em " + modalidade);
    }
    
    public void competirPor(int pais){
        System.out.println("O atleta compete por " + pais);        
    }
    
}