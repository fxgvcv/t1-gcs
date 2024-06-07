package dados;

import java.util.ArrayList;

public abstract class Pessoa {
    private String nome;
    private int anoNascimento;
    private ArrayList<Ingresso> ingressos;
    
    public Pessoa(String nome, int anoNascimento) {
        this.ingressos = new ArrayList<Ingresso>();
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
        if (ingressos == null) {
            return null;
        }

        for (Ingresso ing : ingressos) {
            if (ing.getDia().equals(data)) {
                return ing;
            }
        }
        return null;
    }
}
