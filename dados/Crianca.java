package dados;

public class Crianca extends Pessoa {
    private Adulto responsavel;

    public Crianca(String nome, int anoNascimento, Adulto responsavel) {
        super(nome, anoNascimento);
        this.responsavel = responsavel;
    }

    public Adulto getResponsavel() {
        return responsavel;
    }
}
