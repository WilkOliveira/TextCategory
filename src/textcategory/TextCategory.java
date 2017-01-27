package textcategory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Wilk Oliveira
 */
public class TextCategory {

    public static void main(String[] args) {

        File wikipediaDataset = new File("C:\\Users\\Wilk Oliveira\\Documents\\GitHub\\TextCategory\\files\\test.csv"); // Pega o arquivo .csv a ser trabalhado
        String linhasDoArquivo;
        Map<String, Integer> mapPalavras;
        int i = 1;
        Integer technologyCategory, energyCategory, consumerCategory, financialCategory; // Armazenarão quantidade de repetições de palavras em cada categoria

        /**
         * Deixa todo o código dentro de try-catch para controlar erros nativos
         * de arquivo não encontrado
         */
        try {

            linhasDoArquivo = new String(); // Cria String "linhasDoArquivo"
            Scanner arquivo = new Scanner(wikipediaDataset); // Criar um leitor parar ler o arquivo recebido
            mapPalavras = new HashMap<String, Integer>(); // Para armazenar as palavras

            /**
             * Enquanto o arquivo tiver uma nova linha, continua fazendo sua
             * leitura linha por linha
             */
            while (arquivo.hasNext()) {

                linhasDoArquivo = arquivo.nextLine(); // Variavel "linhasDoArquivo" recebe proxíma linha disponível no arquivo
                String[] txtEntreVirgula = linhasDoArquivo.split(","); // Cria um vetor de Strings com uma semparação de coluna cada ","

                /**
                 * Usa expressão regular pegar caracteres especiais Faz sentido
                 * quando pensamos em textos em português
                 */
                Pattern p = Pattern.compile("(\\d+)|([a-záéíóúçãõôê]+)");
                Matcher m = p.matcher(linhasDoArquivo);

                mapPalavras.put("technology", 0);
                mapPalavras.put("energy", 0);
                mapPalavras.put("consumer", 0);
                mapPalavras.put("financial", 0);

                /**
                 * Contador de frenquência de palavras
                 */
                while (m.find()) {
                    String token = m.group(); // Pega uma palavra

                    String cat = null; //categoria ainda não definida

                    /**
                     * Armazena as palavras relacionadas a categoria tecnologia
                     */
                    if (token.equals("technology") || token.equals("computer") || token.equals("informatics") || token.equals("mobile") || token.equals("computing") || token.equals("microsoft") || token.equals("apple") || token.equals("microsoft")) {
                        cat = "technology";
                    } else if (token.equals("energy") || token.equals("power") || token.equals("electricity") || token.equals("voltage") || token.equals("electric")) {
                        cat = "energy";
                    } else if (token.equals("consumer") || token.equals("money") || token.equals("consumerism") || token.equals("sale") || token.equals("buyer") || token.equals("shopper")) {
                        cat = "consumer";
                    } else if (token.equals("financial") || token.equals("exchange") || token.equals("banck") || token.equals("economy") || token.equals("economic") || token.equals("banking")) {
                        cat = "financial";
                    }

                    if (cat != null) {
                        if (mapPalavras.containsKey(cat)) {
                            Integer value = mapPalavras.get(cat);
                            mapPalavras.put(cat, value + 1);
                        } else {
                            mapPalavras.put(cat, 1);
                        }
                    }
                }

                // Recupera o valor de cada categoria 
                technologyCategory = mapPalavras.get("technology");
                energyCategory = mapPalavras.get("energy");
                consumerCategory = mapPalavras.get("consumer");
                financialCategory = mapPalavras.get("financial");

                System.out.println("- Texto " + i + " -");

                /**
                 * Analisa a frequencia e imprimi a classificação
                 */
                if (technologyCategory > energyCategory && technologyCategory > consumerCategory && technologyCategory > financialCategory) {
                    System.out.println("Este texto aborda o tema tecnologia");
                } else if (energyCategory > technologyCategory && energyCategory > consumerCategory && energyCategory > financialCategory) {
                    System.out.println("Este texto aborda o tema energia");
                } else if (consumerCategory > technologyCategory && consumerCategory > energyCategory && consumerCategory > financialCategory) {
                    System.out.println("Este texto aborda o tema consumo");
                } else if (financialCategory > technologyCategory && financialCategory > energyCategory && financialCategory > consumerCategory) {
                    System.out.println("Este texto aborda o tema financeiro");
                } else {
                    System.out.println("Não foi possível classificar este texto");
                }

                for (Map.Entry<String, Integer> entry : mapPalavras.entrySet()) {
                    System.out.println(entry.getKey() + "\t frequência = " + entry.getValue());
                }

                System.out.println("");
                i++;

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
