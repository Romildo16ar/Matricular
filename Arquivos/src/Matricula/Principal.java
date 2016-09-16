
package Matricula;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;

public class Principal {

    
    public void stringDados(ArrayList<Aluno> aluno, ArrayList<Curso> curso){
    
    }
    public void menu(){
                
        System.out.println("---------------------------------------------------");
                System.out.println("1.Cadastrar de Curso:");
                System.out.println("2.Cadastrar de Aluno:");
                System.out.println("3.Matricular:");
                System.out.println("4.Guardar no Arquivo.");
                System.out.println("5.Buscar no Arquivo");
                System.out.println("6.Guardar no Banco.");
                System.out.println("7.Buscar Aluno no Banco");     
        System.out.println("---------------------------------------------------");
    }
    
    
    public static void main(String[] args) {
       
        Principal principal = new Principal();
        Scanner scanner = new Scanner(System.in);
       
        ArrayList<Aluno> aluno = new ArrayList<Aluno>();
        ArrayList<Curso> curso = new ArrayList<Curso>();
        ArrayList<Matricula> matricula = new ArrayList<Matricula>();
        Arquivo arquivo;
        
        int opcao = -1;
        int idAluno=0, idMatricula=0, idCurso=0;

        do{
            principal.menu();
            System.out.println("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            
                 if (opcao == 1){  
                    System.out.println("Digite o nome do curso: ");
                    scanner.nextLine();
                    String nomeCurso = scanner.nextLine();
                    System.out.println("Digite a carga horária do curso: ");
                    int cargaHorariaCurso = Integer.valueOf(scanner.nextLine());
                    curso.add(new Curso(idCurso++, nomeCurso, cargaHorariaCurso));
                
                }else if(opcao == 2){
                    System.out.println("Nome do Aluno: ");
                    scanner.nextLine();
                    String nomeAluno = scanner.nextLine();
                    System.out.println("CPF do Aluno: ");
                    String cpfAluno = scanner.nextLine();
                    aluno.add(new Aluno(idAluno++, nomeAluno, cpfAluno));
                
                }else if(opcao == 3){
                    System.out.println("\nCódigo\t\tCurso\t\tCarga Horária");
                    for(Curso c : curso){
                        System.out.println(c.getCodigo() + "\t\t" + c.getNome() + "\t\t" + c.getCargaHoraria());
                    }
                    System.out.println("\nDigite código do curso");
                    scanner.nextLine();
                    int codCurso = scanner.nextInt();
                    System.out.println("\nCódigo\t\tNome Aluno\t\tCPF");
                    for(Aluno a : aluno){
                        System.out.println(a.getCodigo() + "\t\t" + a.getNome() + "\t\t" + a.getCPF());
                    }
                    System.out.println("\nDigite código do aluno");
                    int codAluno = scanner.nextInt();
                    matricula.add(new Matricula());
                    matricula.get(idMatricula).matricular(idMatricula++, aluno.get(codAluno), curso.get(codCurso));                    
                
                }else if(opcao == 4){
                    arquivo = new Arquivo("matricula.txt");
                    String dados = "";
                    for(Matricula m : matricula){
                          dados += m.obterDados();
                    }
                    arquivo.escreverNovo(dados);
                    System.out.println(dados);
                
                }else if(opcao == 5){
                    arquivo =new Arquivo("matricula.txt");
                    arquivo.lerArquivo();
               
                    }else if(opcao == 6){
                         try{
                            String insereAluno= "INSERT INTO `aluno`(`Id`, `Nome`, `Email`, `Cpf`) VALUES (?,?,?,?)";
                            for(Aluno a : aluno){
                                PreparedStatement ps = ConexaoBD.conexao().prepareStatement(insereAluno);
                                ps.setInt(1, a.getCodigo());
                                ps.setString(2, a.getNome());
                                ps.setString(3, a.getEmail());
                                ps.setString(4, a.getCPF());
                                ps.executeUpdate();
                            }
                            
                            String insereCurso= "INSERT INTO `curso`(`Id`, `Nome`, `Carga_horaria`) VALUES (?,?,?)";
                            for(Curso c : curso){
                                PreparedStatement ps = ConexaoBD.conexao().prepareStatement(insereCurso);
                                ps.setInt(1, c.getCodigo());
                                ps.setString(2, c.getNome());
                                ps.setInt(3, c.getCargaHoraria());
                            
                                ps.executeUpdate();
                            }
                            
                            String insereMatricula= "INSERT INTO `matricula`(`Id`, `IdAluno`, `IdCurso`) VALUES (?,?,?)";
                            for(Matricula m : matricula){
                                PreparedStatement ps = ConexaoBD.conexao().prepareStatement(insereMatricula);
                                ps.setInt(1, m.getMatricula() );
                                ps.setInt(2, m.getIdAluno());
                                ps.setInt(3, m.getIdCurso());
                                
                                ps.executeUpdate();
                            }
                         }catch(SQLException e){
                            System.out.println("Erro ao inserir dados"+e.getMessage());
                         }
                         
                   }else if(opcao == 7){
                         try{
                             PreparedStatement ps = ConexaoBD.conexao().prepareStatement("SELECT `Id`, `Nome`, `Email`, `Cpf` FROM `aluno` WHERE 1");
                             ResultSet rs = ps.executeQuery();
                             while(rs.next()){
                                 System.out.println(rs.getString("Id") + " " + rs.getString("Nome"));
                             }
                         }catch(SQLException e){
                             System.out.println("Erro ao inserir dados"+e.getMessage());
                         }
                         
                }else if(opcao == 8){
                   opcao = 0;
                
            } 
        
        }while(opcao != 0);                 
    }
}
