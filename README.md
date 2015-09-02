# CompilerUnivali
Example of compiler C#

## Trabalhos de Compiladores

Todos são de caráter individual e deverão ser apresentados em laboratório no horário de aula.
Os trabalhos poderão ser apresentados com uma semana de atraso (exceto o último), porém nesta situação receberão nota máxima de 8.0. O último trabalho somente poderá ser entregue na data definida.


Trabalho 1 (T1) – Analisador Léxico (Peso: 30% da M1) 
Apresentação em: 13/03/2012 
Requisitos
	Deverão ser construídas expressões regulares para identificação dos tokens de uma linguagem de programação. Deverá ser utilizada a ferramenta GALS, a qual será utilizada também para apresentação.
	Os tokens a serem reconhecidos deverão ser, no mínimo:

•	(1 ponto) Palavras Reservadas (se, entao, senao, if, while, enquanto, begin, end, int, float, ...)
•	(1 ponto) Operadores Aritméticos ( +, -, *, / )
•	(1 ponto) Operadores Relacionais (>, <, >=, <=, ==, !=)
•	(1 ponto) Operadores Lógicos (E, OU, NÃO)
•	(1 ponto) Identificadores (nomes de variáveis e programas): Deverão possibilitar nomes que contenham números e o caractere especial “_”.
•	(2 ponto) Valores constantes do tipo: Inteiro, Real e String entre aspas 
•	(2 ponto) Comentários de dois tipos: Comentário de uma linha (//) e comentário de múltiplas linhas (/*... */)
•	(1 ponto) Delimitadores e pontuadores (ponto, ponto e vírgula, dois pontos, colchetes, etc.)

Trabalho 2 (T2) – Editor e Analisador Sintático (Peso: 70% da M1)
Apresentação em: 03/04/2012 
Requisitos
	(3 pontos) Deverá ser construído um editor gráfico possibilite: 
•	Digitar um programa (código fonte);
•	Escolher e carregar um programa;
•	Salvar um programa;
•	Realizar a Análise léxica do programa;
•	Realizar a Análise sintática do programa;
•	Exibir mensagens de erro e depuração.
	O analisador sintático deverá ser construído utilizando a ferramenta GALS para definição da Gramática da Linguagem e deverá conter as seguintes instruções (no mínimo):
•	(1 ponto) Declaração de variáveis simples e múltipla (sem restrição de quantidade)
•	(1 ponto) Blocos de instruções com início e fim.
•	(2 pontos) Três tipos de Laços de Repetição 
•	(0,5 pontos) Desvio condicional simples (sem else)
•	(0,5 pontos) Desvio condicional composto (com else)
•	(1 ponto) Entrada de dados, Saída de dados, Atribuição
•	(1 ponto) Expressões aritméticas relacionais e lógicas sem restrição de tamanho e com possibilidade de uso de parênteses

Trabalho 3 (T3) – Tabela de Símbolos e Variáveis Declaradas (Peso: 50% da M2)
Apresentação em: 24/04/2012 
Requisitos
   Deverão ser acrescentadas ações semânticas a gramática, e estas deverão ser implementadas para possibilitar a realização da gerência da tabela de símbolos e verificação de declaração das variáveis. Os seguintes quesitos serão avaliados:
•	(3 ponto) Inserção das variáveis declaradas na tabela de símbolos com o respectivo  tipo correspondente. Deve ser possível a declaração de diversas variáveis em um mesmo comando;
•	(2 ponto) Verificação se a variável está ou não declarada quando é usada no programa;
•	(1 ponto) Garantir a unicidade das variáveis;
•	(1,5 ponto) Indicar (em avisos) se as variáveis são declaradas e não usadas 
•	(1,5 ponto) Indicar (aviso) de que as variáveis estão sendo usadas sem estar inicializadas.
•	(1 ponto) Deve ser acrescentado na interface um componente para visualização da tabela e de seu conteúdo dinamicamente; A tabela deve ser dinâmica e não pode ter restrições de tamanho.

Trabalho 4 (T4) – Verificação de Tipos (Peso: 50% da M2)
Apresentação em:  22/05/2012 
Requisitos
•	(1 ponto) Apresentar tabela de compatibilidade
•	(4 ponto) Verificar se os tipos em uma atribuição são compatíveis;
•	(2 ponto) Verificar se as expressões nos desvios e laços tem tipo lógico (ou inteiro se for permitido)
•	(3 ponto) Verificar os tipos nas operações (por exemplo, evitar multiplicações de strings)


Trabalho 5 (T5) – Geração de Código Seqüencial (Peso: 50% da M3)
Apresentação em:  12/06/2012 
Requisitos
  - Realizar a geração de código do programa usando o conjunto de instruções do processador BIP; 
  - As seguintes instruções deve ter seu código gerado:
•	(1 ponto) Declarações de variáveis
•	(2 ponto) Entrada de dados
•	(1 ponto) Saída de dados
•	(2 ponto) Atribuições 
•	(2 ponto) Operações aritméticas
•	(1 ponto) O Código gerado deve executar corretamente no Bipide;
•	(1 ponto) Deverá haver na interface do editor um local para exibição do código gerado;
  - Deverá haver um botão na interface do editor para salvar o código gerado em txt;

Trabalho 6 (T6) – Geração de Código Iterativo (Peso: 50% da M3)
Apresentação em: 03/07/2012 
Requisitos
  - Realizar a geração de código do programa para as instruções de laços e desvios; 
  - As seguintes instruções deve ter seu código gerado:
•	(1 ponto) Desvio condicional simples (sem else)
•	(2 ponto) Desvio condicional composto (com else)
•	(1 ponto) Laço de repetição com teste lógico (while)
•	(2 ponto) Laço de repetição com variável de controle (for)
•	(3 ponto) O suporte para aninhamentos de comandos deve ser implementado (ex: laço dentro de laço, desvio dentro de laço, etc...);
•	(1 ponto) O código gerado deverá funcionar no simulador de máquina de pilha;


