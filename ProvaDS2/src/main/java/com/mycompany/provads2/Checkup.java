/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provads2;

import java.util.Date;

public class Checkup extends Consulta {
    private double valorAdicionalExames;

    public Checkup(Paciente paciente, Date dataAtendimento, String localAtendimento, double valorConsulta,
                   double valorAdicionalExames) throws EValorInvalidoException {
        super(paciente, dataAtendimento, localAtendimento, valorConsulta);
        if (valorAdicionalExames < 0) {
            throw new EValorInvalidoException("Valor adicional de exames inválido");
        }
        this.valorAdicionalExames = valorAdicionalExames;
    }

    public double getValorAdicionalExames() {
        return valorAdicionalExames;
    }

//    public double getValorConsulta() {
//        if (getPaciente().temPlanoSaudeSenaiMed()) {
//            return super.getValorConsulta() + valorAdicionalExames * 0.82;
//        } else {
//            return super.getValorConsulta() + valorAdicionalExames;
//        }
//    }
}
