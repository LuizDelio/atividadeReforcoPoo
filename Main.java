
package edu.br.ifrn.sistemaEscolar.teste;

import edu.br.ifrn.sistemaEscolar.funcoes.*;
import edu.br.ifrn.sistemaEscolar.model.*;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author luizd
 */
public class Main {

    //variaveis
    public static int op;
    public static int opSubMenu = 0;
    public static boolean returnConsul;
    public static boolean menuPrincipal;

    //objetos
    static Scanner sc = new Scanner(System.in);
    static Cadastrar c1 = new Cadastrar();
    

    //coleções
    static ArrayList<Aluno> alunos = new ArrayList<>();
    static ArrayList<Curso> cursos = new ArrayList<>();
    static ArrayList<Disciplina> disciplinas = new ArrayList();
    
    //metodos

    public static void main(String[] args) {
        
        menuPrincipal();

    }
    
    //Menus

    public static int menuPrincipal() {

        System.out.println("=== MENU PRINCIPAL ===\n");

        System.out.println("1 - Gerenciar ALUNOS");
        System.out.println("2 - Gerenciar DISCIPLINAS");
        System.out.println("3 - Gerenciar CURSOS");
        System.out.println("4 - SAIR");

        System.out.println("Escolha a opção: ");
        op = sc.nextInt();

        if (op == 1) {
            subMenu("ALUNOS");

        } else if (op == 2) {
            subMenu("DISCIPLINAS");

        } else if (op == 3) {
            subMenu("CURSOS");

        }
        else {
            while (op == 4){
                break;
            }
        }

        return op;
    }

    public static void subMenu(String obj) {

        System.out.println("\n=== GERENCIAR " + obj + " ===");
        System.out.println("1 - Cadastrar " + obj);
        System.out.println("2 - Consultar " + obj);
        System.out.println("3 - Remover " + obj);
        System.out.println("4 - Atualizar " + obj);
        System.out.println("5 - VOLTAR AO MENU PRINCIPAL");

        System.out.println("Escolha:");
        opSubMenu = sc.nextInt();

        if (obj.equals("ALUNOS")) {
            gerenAluno(opSubMenu);
        }
        if (obj.equals("CURSOS")) {
            gerenCurso();
        }
        if (obj.equals("DISCIPLINAS")) {
            gerenDisciplina();
        }
        if (opSubMenu == 5){
            menuPrincipal();
        }

    }
    
     public static void retornarMenuPrincipal(){
        System.out.println("Retonrar ao menu principal? (s/n)");
        String respostaPmenu = sc.next();

        if(respostaPmenu.equals("s")){
            menuPrincipal();
        }
       
        
    }
    
    //Gerenciar
    
    public static void gerenDisciplina(){
        if (opSubMenu == 1){
            cadastroDisciplina();
            retornarMenuPrincipal();
        }
        else if (opSubMenu == 2){
            consulDisciplina();
            retornarMenuPrincipal();
        }
        else if (opSubMenu == 3){
            //remover
            retornarMenuPrincipal();
        }
    }

    public static void gerenAluno(int opSubMenu) {
        if (opSubMenu == 1) {
            cadastroAluno();
            retornarMenuPrincipal();

        } else if (opSubMenu == 2) {
            consulAluno();
            retornarMenuPrincipal();
        } 
        else if (opSubMenu == 3) {
            //remover
            removerAluno();
            retornarMenuPrincipal();
        }
    
    }
    
    public static void gerenCurso(){
        
        if (opSubMenu == 1){
            cadastroCurso();
            
            retornarMenuPrincipal();
        }
        else if (opSubMenu == 2){
            consulCurso();
            
            retornarMenuPrincipal();
        }
        else if (opSubMenu == 3){
            removerAluno();
            
            retornarMenuPrincipal();
        }
        
        
    }
    
    //Remover

    public static void removerAluno(){
        
        consulAluno();
        
        if (returnConsul == true){
            String matrExis = c1.getMatricula();
            
            System.out.println("Digite a matricula do aluno:");
            String mat = sc.next();
            
            if(mat.equals(matrExis)){
                
              for(Aluno novoAluno : alunos){
                  alunos.remove(novoAluno);
              }
            
            }
        }
        
        consulAluno();
    }
    
    //Cadastro

    public static void cadastroDisciplina(){
        c1.disciplina(disciplinas);
    }
    
    public static void cadastroAluno() {

        c1.aluno(alunos, cursos, disciplinas);
    }

    public static void cadastroCurso() {
        c1.curso(cursos, disciplinas);
    }
    
    //Consultar
    
    public static boolean consulAluno(){
        if (alunos.isEmpty()) {
                System.out.println("Nenhum aluno cadastrado.");
                
                return returnConsul = false;
            } 
        else {
                for (Aluno aluno : alunos) {
                    System.out.println("Dados do ALUNO");
                    System.out.println("Nome: " + aluno.getNome());
                    System.out.println("Idade: " + aluno.getIdade());
                    System.out.println("Matrícula: " + aluno.getMatricula());
                    consulCurso();
                }
                
                return returnConsul = true;
            }
    }
    
    public static void consulCurso(){
        if (cursos.isEmpty()){
            System.out.println("Nenhum curso cadastrado");
        }
        else {
            for (Curso novoCurso : cursos){
                System.out.println("Curso: " + novoCurso.getNome());
                System.out.println("Turno: " + novoCurso.getTurno());
                consulDisciplina();
            }
        }
    }
    
    public static void consulDisciplina(){
        
        System.out.println("-DISCIPLINAS-");
        
        if (disciplinas.isEmpty()){
            System.out.println("Nenhuma disciplina cadastrada!");
        }
        else {
            for(Disciplina d1 : disciplinas){
                System.out.println("Disciplina: " + d1.getNome());
                System.out.println("CH: " + d1.getCargaHoraria());
                System.out.println("Nota: " + d1.getNota());
            }
        }
    }
    
    //Atualizar

}
