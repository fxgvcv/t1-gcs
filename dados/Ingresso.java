package dados;

import java.util.HashMap;

public class Ingresso {
    private double preco;
    private String dia, identificador;
    private Pessoa usuario;
    private HashMap<Atracao, Integer> visitasAtracoes;

    public Ingresso(double preco, String dia, String identificador, Pessoa usuario) {
        visitasAtracoes = new HashMap<Atracao, Integer>();
        this.preco = preco;
        this.dia = dia;
        this.identificador = identificador;
        this.usuario = usuario;
    }

    public double getPreco() {
        return preco;
    }

    public String getDia() {
        return dia;
    }

    public String getIdentificador() {
        return identificador;
    }

    public Pessoa getUsuario() {
        return usuario;
    }

    public HashMap<Atracao, Integer> getVisitasAtracoes() {
        return visitasAtracoes;
    }

    public void visitarAtracao(Atracao atracao) {
        atracao.visitado();
        if (visitasAtracoes.containsKey(atracao)) {
            visitasAtracoes.put(atracao, visitasAtracoes.get(atracao) + 1);
        } else {
            visitasAtracoes.put(atracao, 1);
        }
    }
}
