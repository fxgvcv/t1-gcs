package app;

import java.util.ArrayList;
import java.util.Scanner;

import dados.*;

public class ParqueDeDiversao {
    private Scanner entrada;
    private ArrayList<Bilheteria> bilheterias;
    private ArrayList<Atracao> atracoes;
    private ArrayList<Pessoa> pessoas;

    public ParqueDeDiversao() {
        this.entrada = new Scanner(System.in);
        this.bilheterias = new ArrayList<Bilheteria>();
        this.atracoes = new ArrayList<Atracao>();
        this.pessoas = new ArrayList<Pessoa>();

        // Cria atrações default
        this.atracoes.add(new Atracao("Montanha Russa"));
        this.atracoes.add(new Atracao("Carrossel"));
        this.atracoes.add(new Atracao("Roda Gigante"));
        this.atracoes.add(new Atracao("Barco Viking"));
        this.atracoes.add(new Atracao("Carro-Choque"));
        this.atracoes.add(new Atracao("Trem-fantasma"));

        // Cria algumas pessoas default
        this.pessoas.add(new Adulto("João", 2000, 123));
        this.pessoas.add(new Crianca("Maria", 2005, (Adulto) this.pessoas.get(0)));
        this.pessoas.add(new Adulto("José", 1995, 456));
        this.pessoas.add(new Adulto("Daniel", 1980, 789));
    }

    public void executa() {
        System.out.println("Executando sistema de gestão de parque de diversão");
        System.out.println("Digite 1 para registrar um visitante");
        System.out.println("Digite 2 para gerar uma lista de visitantes");
        System.out.println("Digite 3 para emitir um ingresso");
        System.out.println("Digite 4 para consultar um visitante");
        System.out.println("Digite 5 para consultar o faturamento de um mês");
        System.out.println("Digite 6 para consultar a quantidade de visitas nas atrações");
        System.out.println("Digite 7 para registrar uma visita de um visitante à uma atração");
        System.out.println("Digite 8 para sair");
        int opcao = entrada.nextInt();
        switch (opcao) {
            case 1:
                registraVisitante();
                break;
            case 2:
                geraListaVisitantes();
                break;
            case 3:
                emiteIngresso();
                break;
            case 4:
                consultaVisitante();
                break;
            case 5:
                consultaFaturamento();
                break;
            case 6:
                consultaAtracao();
                break;
            case 7:
                registraVisita();
                break;
            case 8:
                System.out.println("Saindo do sistema");
                return;
            default:
                break;
        }
    }

    public void registraVisitante() {
        System.out.println("Digite o nome do visitante");
        String nome = entrada.next();
        System.out.println("Digite o ano de nascimento do visitante");
        int anoNascimento = entrada.nextInt();

        // Calcula a idade do visitante
        int idade = 2024 - anoNascimento;

        if (idade >= 18) {
            int telefone = entrada.nextInt();
            this.pessoas.add(new Adulto(nome, anoNascimento, telefone));
            return;
        } else {
            System.out.println("Digite o telefone do responsável");
            int telefone = entrada.nextInt();
            Adulto responsavel = procuraResponsavel(telefone);
            if (responsavel == null) {
                System.out.println("Responsável não cadastrado");
                return;
            }
            this.pessoas.add(new Crianca(nome, anoNascimento, responsavel));
            return;
        }
    }

    public Adulto procuraResponsavel(int telefone) {
        System.out.println("Digite o nome do visitante");
        for (Pessoa p : pessoas) {
            if (p instanceof Adulto && ((Adulto) p).getTelefone() == telefone) {
                System.out.println("Visitante encontrado");
                return (Adulto) p;
            }
        }
        System.out.println("Visitante não encontrado");
        return null;
    }
}