package dados;

public class Adulto extends Pessoa {
    private int telefone;

    public Adulto(String nome, int anoNascimento, int telefone) {
        super(nome, anoNascimento);
        this.telefone = telefone;
    }

    public int getTelefone() {
        return telefone;
    }
}
