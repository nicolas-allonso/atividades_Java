# Árvore Binária de Morse (ABM)

Árvore Binária de Morse implementada em Java, permitindo armazenar caracteres associados a sequências de **pontos (.)** e **traços (-)**. 
Nesse código é possível: inserir e buscar caracteres, encontrar a sequência correspondente a um caractere e visualizar a árvore de forma horizontal.

## Estrutura do código

### 1. Classe No

Representa cada nó da árvore, contendo:
- **info**: caractere armazenado.
- **esquerda**: referência ao filho esquerdo, correspondente ao **ponto (.)**.
- **direita**: referência ao filho direito, correspondente ao **traço (-)**.

O construtor inicializa o nó com um caractere e define seus filhos como **null**.

### 2. Inicialização da árvore

O método **inicializar()** cria a raiz da árvore com o caractere **'?'**, indicando que a estrutura foi inicializada. Esse símbolo representa um caractere não identificado, sendo usado também na parte de inserção para indicar nós cujos valores ainda não foram preenchidos. É importante destacar que caracteres vazios **' '** são diferentes de caracteres **'?'**: um representa um espaço enquanto o outro representa ausência de valor.

### 3. Inserção de caracteres

O método **inserir(String sqn, char info)** recebe uma sequência Morse e o caractere correspondente. Ele verifica se a árvore foi inicializada e chama o método auxiliar recursivo. A recursão permite percorrer a árvore até a posição correspondente à sequência informada.

O método privado **inserir(No no, String sqn, char info, int i)** percorre a sequência caractere por caractere:
- **Ponto (.)**: segue para o filho esquerdo.
- **Traço (-)**: segue para o filho direito.
- Fim da sequência: armazena o caractere no nó atual.

Caso um nó intermediário não exista, ele é criado com o valor **'?'**. Como explicado anteriormente na parte de inicialização, isso serve principalmente para que caracteres com sequências maiores (por exemplo, um **"---"** ou **'O'** inserido após a inicialização da árvore) não quebrem a árvore ao serem inseridos; se isso não existisse, seria possível um caractere com sequência maior estar sob um caractere de sequência menor.

### 4. Impressão da árvore

O método **imprimirArvore()** inicia a impressão a partir da raiz.

O método auxiliar **imprimirArvore(No no, int nivel)** utiliza recursão para percorrer a árvore e exibir os nós com espaçamentos proporcionais ao nível de profundidade. A impressão ocorre na ordem: direita, nó atual e esquerda, facilitando a visualização da estrutura.

### 5. Busca por sequência Morse

O método **buscar(String sqn)** recebe uma ou mais sequências Morse separadas por espaços e retorna um vetor de caracteres correspondentes.

A lógica utiliza **split(\\\s+)** para separar as sequências e percorre a árvore de acordo com cada símbolo: pontos seguem para a esquerda e traços seguem para a direita. Conforme percorre os elementos correspondentes aquelas sequências separadas, o código vai adicionando **char's** a uma string **formada**, que no final é retornada e pode ser exibida ao usuário.

### 6. Busca por caracteres Morse

Há também uma lógica para buscar códigos Morse correspondentes a um caractere, embora esse não faça parte do loop principal do programa. O método **buscarChar(char c)** recebe um caractere e começa a busca por ele pela subárvore da esquerda. Caso não encontre, percorre a subárvore direita. 

Em todo o trajeto, o programa adiciona **'.'** e **'-'** á uma **String** resultante, que no final será retornada, indicando a sequência correspondente aquele caractere.