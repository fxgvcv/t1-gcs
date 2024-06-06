package dados;

import java.util.ArrayList;

public class Bilheteria {
    private ArrayList<Ingresso> ingressos;
    private int quantidadeIngressos;
    private String data;
    private double faturamento;

    public Bilheteria(String data) {
        this.quantidadeIngressos = 0;
        this.data = data;
        this.ingressos = new ArrayList<Ingresso>();
    }

    public int getQuantidadeIngressos() {
        return quantidadeIngressos;
    }

    public String getData() {
        return data;
    }

    public double getFaturamento() {
        return faturamento;
    }
}
