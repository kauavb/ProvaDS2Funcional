/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provads2;

import java.util.Date;


public abstract class Consulta {
    private Paciente paciente;
    private Date dataAtendimento;
    private String localAtendimento;
    private double valorConsulta;

    public Consulta(Paciente paciente, Date dataAtendimento, String localAtendimento, double valorConsulta)throws EValorInvalidoException {
        this.paciente = paciente;
        this.localAtendimento = localAtendimento;
        if (valorConsulta < 0) {
            throw new EValorInvalidoException("Valor de consulta inválido");
        }
        this.valorConsulta = valorConsulta;
        if (dataAtendimento == null) {
        throw new EValorInvalidoException("Data de atendimento invalida");
    }
        this.dataAtendimento = dataAtendimento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public String getLocalAtendimento() {
        return localAtendimento;
    }

    protected double getValorConsulta() {
        return valorConsulta;
    }

    public void exibirInformacoes() {
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Data de Atendimento: " + dataAtendimento);
        System.out.println("Local de Atendimento: " + localAtendimento);
        System.out.println("Valor da Consulta: " + valorConsulta);
    }
}
