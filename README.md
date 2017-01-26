# TextCategory

Projeto envolvendo mineração de texto, o programa recebe como entrada um arquivo em formato .csv .txt, ou similar, pre-processado devendo estar divido em três colunas separadas por “,” na primeira coluna deve ficar o titulo do texto, na segunda a categoria e na terceira o texto em si. É preciso certificar-se de não haver outras virgulas no texto.

O programa usa uma serie de palavras-chave e as relaciona com as diferentes categorias consideradas (tecnologia, economia, etc.).

Cada linha/coluna do arquivo (titulo, categoria e texto) são percorridas individualmente, palavra por palavra, adicionando cada palavra-chave a sua respectiva categoria.

Ao final, o programa mostra para cada usuário a frequência de cada categoria e uma indicação da classificação do texto quanto a sua categoria.

Caso deseje, funcionalidades como imprimir cada categoria, ou imprimir cada texto podem ser ativadas, para isto, basta habilitar alguns trechos de código que estão comentados (desativadas) a partir da linha 121.

Próximas funcionalidades:

•	Permitir ao usuário inserir o arquivo manualmente;

•	Adicionar novas palavras ao dicionário de cada categoria;