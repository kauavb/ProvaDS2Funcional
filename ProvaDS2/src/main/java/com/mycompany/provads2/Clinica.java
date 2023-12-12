/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provads2;

import java.util.ArrayList;
import java.util.List;

public class Clinica {
    private String nome;
    private String endereco;
    private String cnpj;
    private double valorConsultaSimples;
    private double valorConsultaCheckup;
    private List<String> atendimentosRealizados;
    
    public Clinica(String nome, String endereco, String cnpj, double valorConsultaSimples, double valorConsultaCheckup)
            throws EValorInvalidoException {
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
        if (valorConsultaSimples < 0 || valorConsultaCheckup < 0) {
            throw new EValorInvalidoException("Valores de consulta inválidos.");
        }
        this.valorConsultaSimples = valorConsultaSimples;
        this.valorConsultaCheckup = valorConsultaCheckup;
        this.atendimentosRealizados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public List<String> getAtendimentosRealizados() {
        return atendimentosRealizados;
    }

    // Métodos para alterar valores das consultas
    public void setValorConsultaSimples(double novoValor) throws EValorInvalidoException {
        if (novoValor < 0) {
            throw new EValorInvalidoException("Valor de consulta simples inválido. Tente Novamente");
        }
        this.valorConsultaSimples = novoValor;
    }

    public void setValorConsultaCheckup(double novoValor) throws EValorInvalidoException {
        if (novoValor < 0) {
            throw new EValorInvalidoException("Valor de consulta check-up inválido.Tente Novamente");
        }
        this.valorConsultaCheckup = novoValor;
    }

     public void alterarValores(double novoValorConsultaSimples, double novoValorConsultaCheckup) throws EValorInvalidoException {
        setValorConsultaSimples(novoValorConsultaSimples);
        setValorConsultaCheckup(novoValorConsultaCheckup);
    }
     
    public double getValorTotal() {
        double valorTotal = 0;
        for (String atendimento : atendimentosRealizados) {
            if (atendimento.equals("CONSULTA")) {
                valorTotal += valorConsultaSimples;
            } else if (atendimento.equals("CHECKUP")) {
                valorTotal += valorConsultaCheckup;
            }
        }
        return valorTotal;
    }

    public double realizarAtendimento(String tipoConsulta) {
        if (tipoConsulta.equals("CONSULTA") || tipoConsulta.equals("CHECKUP")) {
            atendimentosRealizados.add(tipoConsulta);
            if (tipoConsulta.equals("CONSULTA")) {
                return valorConsultaSimples;
            } else {
                return valorConsultaCheckup;
            }
        } else {
            throw new EAtendimentoNaoRegistradoException("Tipo de consulta não registrado.");
        }
    }

    // Exemplo de utilização
//    public static void main(String[] args) {
//        try {
//            Clinica minhaClinica = new Clinica("Clinica XYZ", "Rua ABC", "123456789", 50.0, 100.0);
//            minhaClinica.realizarAtendimento("CONSULTA");
//            minhaClinica.realizarAtendimento("CHECKUP");
//
//            System.out.println("Valor total dos atendimentos: " + minhaClinica.getValorTotal());
//        } catch (EValorInvalidoException | EAtendimentoNaoRegistradoException e) {
//            System.err.println("Erro: " + e.getMessage());
//        }
//    }
}
