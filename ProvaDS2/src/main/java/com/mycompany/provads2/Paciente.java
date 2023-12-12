/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.provads2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Paciente {
    private String cpf;
    private String nome;
    private Date dataNascimento;
    private String planoSaude;

    // construtor 
    public Paciente(String cpf, String nome, String dataNascimento, String planoSaude) throws EValorInvalidoException {
        this.cpf = cpf;
        this.nome = nome;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            this.dataNascimento = sdf.parse(dataNascimento);
        } catch (ParseException e) {
            throw new EValorInvalidoException("Data de nascimento inválida. Tente novamente com o formato: dd/MM/yyyy");
        }
        this.planoSaude = planoSaude;
    }

   // metodo get para apenas visualização
    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dataNascimento);
    }

    public String getPlanoSaude() {
        return planoSaude;
    }

    public static void main(String[] args) {
        try {
            
            Paciente paciente = new Paciente("12345678901", "Fulano", "01/01/2000", "Plano A");

            System.out.println("CPF: " + paciente.getCpf());
            System.out.println("Nome: " + paciente.getNome());
            System.out.println("Data de Nascimento: " + paciente.getDataNascimento());
            System.out.println("Plano de Saúde: " + paciente.getPlanoSaude());
        } catch (EValorInvalidoException e) {
            System.out.println("Erro ao criar o paciente: " + e.getMessage());
        }
    }
}
