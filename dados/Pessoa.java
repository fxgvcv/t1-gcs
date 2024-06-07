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

    public void adicionaIngresso(Ingresso ingresso) {
        this.ingressos.add(ingresso);
    }

    public void visitaAtracao(Atracao atracao, Ingresso ingresso) {
        ingresso.visitarAtracao(atracao);
    }

    public Ingresso consultaIngresso(String data) {
        for (Ingresso ing : ingressos) {
            if (ing.getDia().equals(data)) {
                return ing;
            }
        }
        return null;
    }
}
