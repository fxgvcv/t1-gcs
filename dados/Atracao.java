package dados;

public class Atracao {
    private String nome;
    private int visitas;
    
    public Atracao(String nome) {
        this.nome = nome;
        this.visitas = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVisitas() {
        return visitas;
    }

    public void visitado() {
        this.visitas++;
    }
}
