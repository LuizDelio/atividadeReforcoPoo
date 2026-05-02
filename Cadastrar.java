/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.br.ifrn.sistemaEscolar.funcoes;

import edu.br.ifrn.sistemaEscolar.model.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Cadastrar {
    
    //objetos
    
    static Scanner sc = new Scanner(System.in);
    
    
    //metodos gets e sets
    
    String matricula;

    public static Scanner getSc() {
        return sc;
    }

    public static void setSc(Scanner sc) {
        Cadastrar.sc = sc;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    //metodos de cadastros
    
    public static void aluno(ArrayList<Aluno> alunos, ArrayList<Curso> cursos, ArrayList<Disciplina>disciplinas){
        System.out.println("Digite o nome do aluno:");
        String nome = sc.nextLine();
        
        System.out.println("Digite a idade do aluno:");
        int idade = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Digite a matricula do aluno:");
        String matricula = sc.nextLine();
        
        curso(cursos, disciplinas);
        
        Aluno novoAluno = new Aluno(nome, idade, matricula);
        
        alunos.add(novoAluno);
        
        
    }
   
    
    
    
    public static void curso(ArrayList<Curso> cursos, ArrayList<Disciplina> disciplinas){
        System.out.println("Digite o curso do aluno:");
        String nomeCurso = sc.next();
        
        System.out.println("Digite o turno do curso: (mat ou vesp)");
        String turno = sc.next();

        disciplina(disciplinas);
        
        Curso novoCurso = new Curso (nomeCurso, turno);
        
        cursos.add(novoCurso);
    }
    
    public static void disciplina(ArrayList<Disciplina> disciplinas){
        System.out.println("Digite o nome da disciplina:");
        String nomeDisciplina = sc.next();
        
        System.out.println("Digite a CH:");
        int chDisciplina = sc.nextInt();
        
        System.out.println("Digite a nota da disciplina:");
        double nota = sc.nextDouble();
        
        Disciplina novaDisciplina = new Disciplina(nomeDisciplina, chDisciplina, nota);
        
        disciplinas.add(novaDisciplina);
        
    }
}
