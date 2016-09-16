/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula;

/**
 *
 * @author Cleiston
 */
public class Matricula {
    private int matricula;
    private String dataMatricula;
    Aluno aluno;
    Curso curso;
    
    public int getIdAluno(){
        return this.aluno.getCodigo();
    }
    
    public int getIdCurso(){
        return this.curso.getCodigo();
    }

    
    public void matricular(int matricula, Aluno aluno, Curso curso){
        this.aluno = aluno;
        this.curso = curso;
        System.out.printf("\n**************************\nMatrícula: %d\nAluno: %s\nCurso: %s\n**************************\n\n", matricula, aluno.getNome(), curso.getNome());
    }
    
    public String obterDados(){
        return "Matricula: " + matricula + ", Aluno: " + aluno.getNome() + ", Curso" + curso.getNome() + "\n";
    }
    
    /**
     * @return the matricula
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the dataMatricula
     */
    public String getDataMatricula() {
        return dataMatricula;
    }

    /**
     * @param dataMatricula the dataMatricula to set
     */
    public void setDataMatricula(String dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
    
    
}
