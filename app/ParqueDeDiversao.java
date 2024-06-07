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

    public Bilheteria procuraBilheteria(String data) {
        for (Bilheteria b : bilheterias) {
            if (b.getData().equals(data)) {
                return b;
            }
        }
        Bilheteria b = new Bilheteria(data);
        bilheterias.add(b);
        return b;
    }

    public Pessoa procuraVisitante(String nome) {
        for (Pessoa p : pessoas) {
            if (p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;
    }

    public Atracao procuraAtracao(String nome) {
        for (Atracao a : atracoes) {
            if (a.getNome().equals(nome)) {
                return a;
            }
        }
        return null;
    }
    
    public void consultaAtracao() {
        System.out.println("Digite o nome da atração");
        String nome = entrada.next();
        Atracao a = procuraAtracao(nome);
        if (a == null) {
            System.out.println("Atração não encontrada");
            return;
        }
        int visitas = a.getVisitas();
        System.out.println("Atração: " + a.getNome() + " - Visitas: " + visitas);
    }

    public void consultaVisitante() {
        System.out.println("Digite o nome do visitante");
        String nome = entrada.next();

        Pessoa visitante = procuraVisitante(nome);
        if (visitante == null) {
            System.out.println("Visitante não encontrado");
            return;
        }

        if (visitante instanceof Adulto) {
            System.out.println("Nome: " + visitante.getNome() + " - Ano de Nascimento: " + visitante.getAnoNascimento() + " - Telefone: " + ((Adulto) visitante).getTelefone());
        } else {
            System.out.println("Nome: " + visitante.getNome() + " - Ano de Nascimento: " + visitante.getAnoNascimento() + " - Responsável: " + ((Crianca) visitante).getResponsavel().getNome());
        }

        ArrayList<Ingresso> ingressosVisitante = visitante.getIngressos();


        // Arrumar, pois precisa somar as atracoes para todos os ingressos
        for (Ingresso i : ingressosVisitante) {
            i.getVisitasAtracoes().forEach((a, v) -> {
                System.out.println("Atração: " + a.getNome() + " - Visitas: " + v);
            });
        }
    }
  
    public void consultaFaturamento() {
        System.out.println("Digite o mês e o ano (mm/aaaa)");
        String data = entrada.next();

        double faturamento = 0;
        for (Bilheteria b : bilheterias) {
            if (b.getData().substring(3).equals(data)) {
                faturamento += b.getFaturamento();
            }
        }
        System.out.println("Faturamento do mês " + data + ": " + faturamento);
     }

    public void emiteIngresso() {
        System.out.println("Digite o nome do visitante");
        String nome = entrada.next();
        System.out.println("Digite o dia do ingresso (dd/mm/aaaa)");
        String dia = entrada.next();

        Pessoa visitante = procuraVisitante(nome);
        if (visitante == null) {
            System.out.println("Visitante não encontrado");
            return;
        }

        Bilheteria bilheteria = procuraBilheteria(dia);

        if (bilheteria.emitirIngresso(visitante)) {
            System.out.println("Ingresso emitido com sucesso");
        } else {
            System.out.println("Limite de ingressos atingido");
        }
    }
    
    public void geraListaVisitantes() {
        for (Pessoa p : pessoas) {
            if (p instanceof Adulto) {
                System.out.println("Nome: " + p.getNome() + " - Ano de Nascimento: " + p.getAnoNascimento() + " - Telefone: " + ((Adulto) p).getTelefone());
            } else {
                System.out.println("Nome: " + p.getNome() + " - Ano de Nascimento: " + p.getAnoNascimento() + " - Responsável: " + ((Crianca) p).getResponsavel().getNome());
            }
        }
    }

    public void registraVisita() {
        System.out.println("Digite o nome do visitante");
        String nome = entrada.next();
        System.out.println("Digite o nome da atração");
        String nomeAtracao = entrada.next();
        System.out.println("Digite o dia da visita (dd/mm/aaaa)");
        String dia = entrada.next();

        Pessoa visitante = procuraVisitante(nome);
        if (visitante == null) {
            System.out.println("Visitante não encontrado");
            return;
        }

        Atracao a = procuraAtracao(nomeAtracao);
        if (a == null) {
            System.out.println("Atração não encontrada");
            return;
        }

        Ingresso i = visitante.consultaIngresso(dia);
        if (i == null) {
            System.out.println("Ingresso não encontrado");
            return;
        }

        visitante.visitaAtracao(a, i);
        System.out.println("Visita registrada com sucesso");
    }
}