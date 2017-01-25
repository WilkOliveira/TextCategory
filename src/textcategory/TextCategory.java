package textcategory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Wilk Oliveira
 */
public class TextCategory {

    public static void main(String[] args) {
    
        File wikipediaDataset = new File("C:\\Users\\Wilk\\Documents\\GitHub\\TextCategory\\files\\test.csv"); // Pega o arquivo .csv a ser trabalhado
        String linhasDoArquivo;
        Map<String,Integer> mapPalavras;
        int i = 1;
        int technologyCategory = 0, EnergyCategory = 0, ConsumerCategory = 0, FinancialCategory =0; // Armazenarão quantidade de repetições de palavras em cada categoria
        
        /**
         * Deixa todo o código dentro de try-catch para controlar erros nativos de arquivo não encontrado
         */      
        try{
            
            linhasDoArquivo = new String(); // Cria String "linhasDoArquivo"
            Scanner arquivo = new Scanner(wikipediaDataset); // Criar um leitor parar ler o arquivo recebido
            mapPalavras = new HashMap<String,Integer>(); // Para armazenar as palavras
                    
                    /**
                     * Enquanto o arquivo tiver uma nova linha, continua fazendo sua leitura linha por linha
                     */
                    while (arquivo.hasNext()){
                        
                        linhasDoArquivo = arquivo.nextLine(); // Variavel "linhasDoArquivo" recebe proxíma linha disponível no arquivo
                        String[] txtEntreVirgula = linhasDoArquivo.split(","); // Cria um vetor de Strings com uma semparação de coluna cada ","
                        
                        /**
                         * Usa expressão regular pegar caracteres especiais
                         * Faz sentido quando pensamos em textos em português
                         */
                        Pattern p = Pattern.compile("(\\d+)|([a-záéíóúçãõôê]+)");
                        Matcher m = p.matcher(linhasDoArquivo);
                        
                        /**
                         * Contador de frenquência de palavras
                         */
                        
                        while(m.find())
                        {
                            String token = m.group(); // Pega uma palavra
                            Integer freq = mapPalavras.get(token); // Identifica se a palavra já foi mapeada
				
                                /**
                                 * Se palavra existir, atualiza a frequencia, 
                                 * Senão, cria um novo id e insere a palavra nesse id com frequência = 1 
                                 * - PRECISO PEGAR SOMENTE A FREQUÊNCIA DE PALAVRAS ESPECIFICAS RELACIONADAS A CADA CATEGORIA E ARMAZENAR NAS VARIAVEIS QUE JÁ FORAM CRIADAS
                                 * - POR EXEMPLO, SE APARECE A PALAVRA "computer" ou "mobile" ou "device",  INCREMENTAR A VARIAVÉL "technologyCategory" E ASSIM POR DIANTE
                                 */
				if (freq != null) {
					mapPalavras.put(token, freq+1);
				}
				else {
					mapPalavras.put(token,1);
				}
                        }
                        
                        System.out.println("- Texto " +i +" -");
                        
                        for (Map.Entry<String, Integer> entry : mapPalavras.entrySet())
                        {
                            System.out.println(entry.getKey() + "\t frequência = " + entry.getValue());
                        }
                        
                        i++;
                        
                        /**
                         * Conta a quantidade de palavras em cada coluna/linha
                         */
                        StringTokenizer title=new StringTokenizer(txtEntreVirgula[0]);
                        StringTokenizer category=new StringTokenizer(txtEntreVirgula[1]);
                        StringTokenizer text=new StringTokenizer(txtEntreVirgula[2]);
                        
                            
                        /**
                         * Imprime os valores de cada coluna/linha (sepaadas por ",")
                         */
                        //System.out.println(txtEntreVirgula[0]);
                        //System.out.println(txtEntreVirgula[1]);
                        //System.out.println(txtEntreVirgula[2]);
                        /**
                         * Imprime a quantidade de palavras em cada coluna/linha
                         */
                        //System.out.println(title.countTokens());
                        //System.out.println(category.countTokens());
                        //System.out.println(text.countTokens());
                         
                    }

        } catch (FileNotFoundException ex) {
            
        }
        
    }
}