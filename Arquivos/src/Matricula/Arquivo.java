
package Matricula;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {
    private File file;
    private FileWriter fileWriter;
    
    Arquivo(String path){
        try{
            file = new File(path);
        }catch(Exception e){
            System.out.println("Não foi possível criar o arquivo.");
        }
    } 
    public void escreverNovo(String entrada){
        if(file.isFile()){
            try{
                fileWriter = new FileWriter(file, true);
                fileWriter.write(entrada);
                fileWriter.flush();
                fileWriter.close();
            }catch(Exception e){
                System.out.println("Erro.");
            }
        }
    }
    public String lerArquivo(){
        String linha="";
        if(file.isFile()){
            try{
                File file = new File("matricula.txt");
                
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                linha = bufferedReader.readLine();
                while(linha != null){
                     System.out.println(linha);
                     linha =bufferedReader.readLine();
                }
                bufferedReader.close();
                
            }catch(Exception e){
                System.out.println("Erro."+e.getMessage());
            }
        }
        return linha;
    }
}
