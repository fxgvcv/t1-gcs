package dados;

import java.util.ArrayList;

public abstract class Pessoa {
    private String nome;
    private int anoNascimento;
    private ArrayList<Ingresso> ingressos;
    
    public Pessoa(String nome, int anoNascimento) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public ArrayList<Ingresso> getIngressos() {
        return ingressos;
    }
}
