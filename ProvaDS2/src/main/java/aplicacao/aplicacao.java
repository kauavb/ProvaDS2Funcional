/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacao;

import com.mycompany.provads2.Clinica;
import com.mycompany.provads2.Paciente;
import com.mycompany.provads2.Consulta;
import com.mycompany.provads2.Checkup;
import com.mycompany.provads2.EAtendimentoNaoRegistradoException;
import com.mycompany.provads2.EValorInvalidoException;
import java.util.Scanner;

public class aplicacao {
     public static void main(String[] args) throws EValorInvalidoException {
         Clinica clinica = new Clinica("Senai Med", "Av Dendezeiros, 188, Bonfim", "", 80.0, 120.0);
         Scanner scanner = new Scanner(System.in);

     try {
            while (true) {
                System.out.println("Escolha uma das alternativas");
                System.out.println("k - Realizar atendimento");
                System.out.println("a - Consultar a média de valor");
                System.out.println("u - Alterar o valor da consulta simples ou o adicional para exames");

                String opcao = scanner.next().toLowerCase();

                switch (opcao) {
                    case "k":
                        realizarAtendimento(scanner, clinica);
                        break;
                    case "a":
                        consultarMediaValorAtendimentos(clinica);
                        break;
                    case "u":
                        alterarValoresConsulta(scanner, clinica);
                        break;
                    default:
                        System.out.println("Opção não pre-definida. Tente novamente.");
                }
            }
        } catch (EAtendimentoNaoRegistradoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void realizarAtendimento(Scanner scanner, Clinica clinica) throws EAtendimentoNaoRegistradoException {
        System.out.println("Qual a sua consulta? Simples ou Check-up?:");
        String tipoAtendimento = scanner.next();
        System.out.println("Informe o CPF do paciente:");
        String cpf = scanner.next();
        System.out.println("Informe o nome do paciente:");
        String nome = scanner.next();
        System.out.println("Informe a data de nascimento (formato dd/MM/yyyy):");
        String dataNascimento = scanner.next();
        System.out.println("Informe o plano de saúde do paciente:");
        String planoSaude = scanner.next();
        System.out.println("Informe a data do atendimento (formato dd/MM/yyyy):");
        String dataAtendimento = scanner.next();
        System.out.println("Informe o local do atendimento:");
        String localAtendimento = scanner.next();

        try {
            Paciente paciente = new Paciente(cpf, nome, dataNascimento, planoSaude);
            double valorAtendimento = clinica.realizarAtendimento("CONSULTA");
            System.out.println("Atendimento realizado com sucesso. Valor do atendimento: " + valorAtendimento);
        } catch (EValorInvalidoException e) {
            throw new EAtendimentoNaoRegistradoException("Não foi possível realizar o atendimento: " + e.getMessage());
        }
    }
     
      private static void consultarMediaValorAtendimentos(Clinica clinica) {
        double media = clinica.getValorTotal() / clinica.getAtendimentosRealizados().size();
        System.out.println("Média de valor dos atendimentos realizados: " + media);
    }

    private static void alterarValoresConsulta(Scanner scanner, Clinica clinica) throws EValorInvalidoException {
        System.out.println("Informe o novo valor da consulta simples:");
        double novoValorConsultaSimples = scanner.nextDouble();
        System.out.println("Informe o novo valor adicional para exames:");
        double novoValorAdicionalExames = scanner.nextDouble();

        clinica.alterarValores(novoValorConsultaSimples, novoValorAdicionalExames);
        System.out.println("Valores alterados com sucesso.");
    }

} 


