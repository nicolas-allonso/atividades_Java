# TAD Fila com Merge (Fila.java)

Implementação de um **Tipo Abstrato de Dados (TAD) Fila** em Java, utilizando um vetor de tamanho fixo para armazenar elementos inteiros. O código permite inserir, remover, consultar e imprimir elementos, além de unir duas filas ordenadas por meio do método **merge**.

Nesse código é possível: controlar a capacidade da fila, verificar se está cheia ou vazia, consultar o primeiro e o último elemento e combinar duas filas em uma terceira, mantendo a ordem crescente dos valores.

## Estrutura do código

### 1. Atributos da classe Fila

A classe **Fila** representa a estrutura de dados, contendo:

- **tamanho**: capacidade máxima da fila.
- **dados**: vetor que armazena os elementos inteiros.
- **primeiro**: índice do primeiro elemento da fila.
- **ultimo**: índice do último elemento inserido.
- **capacidade**: quantidade atual de elementos armazenados.

Esses atributos permitem controlar a posição dos elementos e a quantidade de espaço ocupado na fila.

### 2. Inicialização da fila

O construtor **Fila(int tamanho)** recebe a capacidade máxima da fila e inicializa o vetor com esse tamanho.

O índice **primeiro** começa em **0**, enquanto **ultimo** começa em **-1**, indicando que nenhum elemento foi inserido. A variável **capacidade** começa em **0**, representando uma fila vazia.

### 3. Verificação da fila

Os métodos **cheia()** e **vazia()** verificam o estado da estrutura.

- **cheia()**: retorna **true** quando a quantidade de elementos é igual à capacidade máxima.
- **vazia()**: retorna **true** quando não existem elementos armazenados.

Esses métodos são utilizados antes das operações de inserção, remoção e consulta, evitando operações inválidas.

### 4. Inserção de elementos

O método **insere(int elemento)** adiciona um elemento ao final da fila, desde que exista espaço disponível.

O índice **ultimo** é incrementado e, caso alcance o tamanho do vetor, retorna para **0**. Essa lógica permite reutilizar as posições liberadas anteriormente, formando uma **fila circular**.

Após inserir o elemento, a variável **capacidade** é incrementada. Se a fila estiver cheia, o método informa que não foi possível realizar a inserção.

### 5. Remoção de elementos

O método **remove()** retira logicamente o primeiro elemento da fila, seguindo a lógica **FIFO (First In, First Out)**, em que o primeiro elemento inserido é o primeiro a sair.

Para isso, o índice **primeiro** é incrementado e retorna para **0** quando alcança o final do vetor. A variável **capacidade** é decrementada para atualizar a quantidade de elementos armazenados.

O valor não precisa ser apagado do vetor, pois os índices e a capacidade determinam quais posições pertencem à fila.

### 6. Consulta dos elementos

Os métodos **primeiro()** e **ultimo()** retornam, respectivamente, o primeiro e o último elemento da fila.

Antes de retornar um valor, ambos verificam se a fila está vazia. Caso esteja, exibem uma mensagem e retornam **-1** como indicação de ausência de elemento.

### 7. Impressão da fila

O método **imprime()** exibe os elementos da fila na ordem em que devem ser removidos.

A impressão começa no índice **primeiro** e utiliza um laço **while** controlado pela variável **contador**, que percorre a quantidade atual de elementos.

Assim como na inserção e remoção, o índice utilizado para percorrer o vetor retorna para **0** quando chega ao final, permitindo imprimir corretamente os elementos mesmo quando estão distribuídos em posições circulares.

### 8. União das filas com Merge

O método estático **merge(Fila a, Fila b, Fila r)** combina os elementos de duas filas ordenadas, **a** e **b**, em uma terceira fila, **r**, mantendo a ordem crescente dos valores.

A lógica funciona da seguinte maneira:

- **Comparação:** enquanto as duas filas possuem elementos, compara os valores retornados por **primeiro()**.
- **Inserção:** o menor dos dois valores é inserido na fila **r**.
- **Remoção:** após inserir o valor, ele é removido da fila de origem correspondente.
- **Finalização:** quando uma das filas fica vazia, os elementos restantes da outra são transferidos para **r**.

Essa estratégia evita a necessidade de ordenar todos os elementos novamente, pois aproveita a ordenação já existente nas filas de origem. Em caso de valores iguais, o método prioriza o elemento da fila **a**.

**Importante:** para que o resultado permaneça ordenado, as filas de entrada precisam estar previamente organizadas em ordem crescente, e a fila **r** deve ter capacidade suficiente para receber todos os elementos. Ao final, as filas **a** e **b** estarão vazias, pois seus elementos são removidos durante a união.

### 9. Método main

O método **main(String[] args)** demonstra o funcionamento da estrutura.

São criadas três filas: **a**, com capacidade para 4 elementos; **b**, com capacidade para 5 elementos; e **r**, com capacidade para 9 elementos.

Em seguida, são inseridos valores ordenados nas filas **a** e **b**. O programa imprime as filas antes da união, executa o método **merge(a, b, r)** e imprime novamente as três estruturas para demonstrar o resultado.

Ao final, a fila **r** contém os valores das duas filas em ordem crescente, enquanto as filas de origem estão vazias.

# Árvore Binária de Morse (ABM) (Main.java)

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