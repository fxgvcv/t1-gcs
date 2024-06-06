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

    public boolean emitirIngresso(Pessoa usuario) {
        if (quantidadeIngressos >= 500) {
            return false;
        }

        String identificador = this.data + " seq " + String.format("%03d", this.quantidadeIngressos);

        double preco = 0;
        if (usuario instanceof Crianca) {
            preco = 80;
        } else if (usuario instanceof Adulto) {
            preco = 100;
        }
        Ingresso ingresso = new Ingresso(preco, data, identificador, usuario);
        usuario.adicionaIngresso(ingresso);
        this.ingressos.add(ingresso);
        this.faturamento += preco;
        this.quantidadeIngressos++;
        return true;
    }
}
