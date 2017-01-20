package textcategory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Wilk Oliveira
 */
public class TextCategory {

    public static void main(String[] args) {
    
        File wikipediaDataset = new File("C:\\Users\\Wilk Oliveira\\Documents\\GitHub\\TextCategory\\files\\test.csv"); // Pega o arquivo .csv a ser trabalhado
        
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
                        StringTokenizer title=new StringTokenizer(txtEntreVirgula[0]);
                        StringTokenizer category=new StringTokenizer(txtEntreVirgula[1]);
                        StringTokenizer text=new StringTokenizer(txtEntreVirgula[2]);
                        
                        System.out.println(txtEntreVirgula[0]);
                        System.out.println(txtEntreVirgula[1]);
                        System.out.println(txtEntreVirgula[2]);
                        System.out.println(title.countTokens());
                        System.out.println(category.countTokens());
                        System.out.println(text.countTokens());
                        
                    }
            
        } catch (FileNotFoundException ex) {
            
        }
        
    }
}