package textcategory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Wilk Oliveira
 */
public class TextCategory {

    public static void main(String[] args) {
    
        File wikipediaDataset = new File("C:\\Users\\Wilk Oliveira\\Documents\\GitHub\\TextCategory\\files\\wikipediadataset.csv"); // Pega o arquivo .csv a ser trabalhado
        
        /**
         * Deixa todo o código dentro de try-catch para controlar erros nativos de arquivo não encontrado
         */      
        try{
            
            String linhasDoArquivo = new String(); // Cria String "linhasDoArquivo"
            
            Scanner leitor = new Scanner(wikipediaDataset); // Criar um leitor parar ler o arquivo recebido
                    
                    /**
                     * Enquanto o arquivo tiver uma nova linha, continua fazendo sua leitura linha por linha
                     */
                    while (leitor.hasNext()){
                        
                        linhasDoArquivo = leitor.nextLine(); // Variavel "linhasDoArquivo" recebe proxíma linha disponível no arquivo
                        
                        String[] txtEntreVirgula = linhasDoArquivo.split(","); // Cria um vetor com uma semparação de coluna cada ","
                        
                        System.out.println(txtEntreVirgula[0]);
                        
                    }
            
        } catch (FileNotFoundException ex) {
            
        }
        
    }
}