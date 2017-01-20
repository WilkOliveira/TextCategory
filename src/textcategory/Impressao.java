System.out.println("Escolha o que você deseja fazer no sistema:\n\n"
	+ "1: Imprimir todos os títulos do arquivo\n"
	+ "2: Imprimir todos os textos do arquivo\n"
	+ "3: Imprimir a quantidade de palavras de cada texto do arquivo\n");
Scanner leitor = new Scanner(System.in);
int op = leitor.nextInt();

if (op == 1) {
	System.out.println(txtEntreVirgula[0]);
} 
else if (op == 2) {
	System.out.println(txtEntreVirgula[2]);
} 
else if (op == 3) {
	System.out.println(text.countTokens());
}