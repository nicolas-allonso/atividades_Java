import java.util.Scanner;

class ABM {

    class No {

        char info;
        No direita;
        No esquerda;

        public No(char info) {
            this.info = info;
            this.direita = null;
            this.esquerda = null;
        }

    }

    No raiz = null;

    public void inicializar() {
        System.out.println("Árvore inicializada");
        this.raiz = new No('?'); 
    }

    public void inserir(String sqn, char info) {
        if (raiz != null) {
            raiz = inserir(raiz, sqn, info, 0);
        } else {
            System.out.println("Favor inicializar a árvore primeiro.");
        }
    }
    private No inserir(No no, String sqn, char info, int i) {

        if (i == sqn.length()) {
            no.info = info;
            return no;
        }

        if (i < sqn.length()) {
            if (sqn.charAt(i) == '.') {
                
                if (no.esquerda == null) {
                    no.esquerda = new No('?');
                }
                
                no.esquerda = inserir(no.esquerda, sqn, info, i + 1);
                
            } else if (sqn.charAt(i) == '-') {
                if (no.direita == null) {
                    no.direita = new No('?');
                }
                no.direita = inserir(no.direita, sqn, info, i + 1);
            } 

            else {
                System.out.println("Entrada inválida. Favor somente utilizar - e .");
                return no;
            }    
        
        }

        return no;

    }

    public void imprimirArvore(No no, int nivel) {
        if (no == null) {
            return;
        }

        imprimirArvore(no.direita, nivel + 1);

        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }

        System.out.println(no.info);
        imprimirArvore(no.esquerda, nivel + 1);
    }
    public void imprimirArvore() {
        imprimirArvore(raiz, 0);
    }

    public char[] buscar(String sqn) {

        No atual = raiz;
        String[] sqns_formadas = sqn.split("\\s+");
        char[] formada = new char[sqns_formadas.length];

        while (atual != null) {

            for (int i = 0; i < sqns_formadas.length; i++) {
                for (int j = 0; j < sqns_formadas[i].length(); j++)
                    if (sqns_formadas[i].charAt(j) == '.') {
                        if (atual.esquerda != null) {atual = atual.esquerda;}
                        else {
                            System.out.println("O elemento não foi encontrado. Talvez essa sequência não corresponda ao caractere ou ele não tenha sido inserido ainda.");
                            return new char[0];
                        }
                    } 
                    else if (sqns_formadas[i].charAt(j) == '-') {
                        if (atual.direita != null) {atual = atual.direita;}
                        else {
                            System.out.println("O elemento não foi encontrado. Talvez essa sequência não corresponda ao caractere ou ele não tenha sido inserido ainda.");
                            return new char[0];
                        }
                    }
                    else {
                        System.out.println("Símbolo inválido de busca.");
                        return new char[0];
                    }

                formada[i] = atual.info;
                atual = raiz;

            }

            atual = null;

        }

        return formada;

    }

    public String buscarChar(char c) {
        String resultado = buscarChar(raiz, c, "");
        if (resultado == null) {
            return "Caractere não encontrado na árvore";
        }
        return "Sequência encontrada para " + c + ": " + resultado;
    }
    private String buscarChar(No no, char c, String caminho) {
        if (no == null) {
            return null;
        }
        
        if (no.info == c) {
            return caminho;
        }

        String sqn_esq = buscarChar(no.esquerda, c, caminho + ".");
        if (sqn_esq != null) {
            return sqn_esq;
        }

        return buscarChar(no.direita, c, caminho + "-");
    }

}

class Main {

    public static void main(String[] args) {
        ABM arvore = new ABM();

        Scanner scanner = new Scanner(System.in);

        arvore.inserir(".", 'E');
        arvore.inicializar();

        arvore.inserir(".", 'E');
        arvore.inserir("-", 'T');

        arvore.inserir("..", 'I');
        arvore.inserir(".-", 'A');
        arvore.inserir("-.", 'N');
        arvore.inserir("--", 'M');

        arvore.inserir("...", 'S');
        arvore.inserir("..-", 'U');
        arvore.inserir(".-.", 'R');
        arvore.inserir(".--", 'W');
        arvore.inserir("-..", 'D');
        arvore.inserir("-.-", 'K');
        arvore.inserir("--.", 'G');
        arvore.inserir("---", 'O');

        arvore.inserir("....", 'H');
        arvore.inserir("...-", 'V');
        arvore.inserir("..-.", 'F');
        arvore.inserir("..--", ' ');
        arvore.inserir(".-..", 'L');
        arvore.inserir(".-.-", ' ');
        arvore.inserir(".--.", 'P');
        arvore.inserir(".---", 'J');
        arvore.inserir("-...", 'B');
        arvore.inserir("-..-", 'X');
        arvore.inserir("-.-.", 'C');
        arvore.inserir("-.--", 'Y');
        arvore.inserir("--..", 'Z');
        arvore.inserir("--.-", 'Q');
        arvore.inserir("---.", ' ');
        arvore.inserir("----", ' ');

        arvore.inserir(".....", '5');
        arvore.inserir("....-", '4');
        arvore.inserir("...-.", ' ');
        arvore.inserir("...--", '3');
        arvore.inserir("..-..", ' ');
        arvore.inserir("..-.-", ' ');
        arvore.inserir("..--.", ' ');
        arvore.inserir("..---", '2');

        arvore.inserir(".-...", ' ');
        arvore.inserir(".-..-", ' ');
        arvore.inserir(".-.-.", '+');
        arvore.inserir(".-.--", ' ');

        arvore.inserir(".--..", ' ');
        arvore.inserir(".--.-", ' ');
        arvore.inserir(".---.", ' ');
        arvore.inserir(".----", '1');

        arvore.inserir("-....", '6');
        arvore.inserir("-...-", '=');
        arvore.inserir("-..-.", '/');
        arvore.inserir("-..--", ' ');

        arvore.inserir("-.-..", ' ');
        arvore.inserir("-.--.", ' ');
        arvore.inserir("-.---", ' ');

        arvore.inserir("--...", '7');
        arvore.inserir("--..-", ' ');
        arvore.inserir("--.-.", ' ');
        arvore.inserir("--.--", ' ');

        arvore.inserir("---..", '8');
        arvore.inserir("---.-", ' ');
        arvore.inserir("----.", '9');
        arvore.inserir("-----", '0');

        arvore.imprimirArvore();

        System.out.println(arvore.buscarChar('A'));
        System.out.println(arvore.buscarChar('&'));
        System.out.println(arvore.buscarChar(' '));
        System.out.println(arvore.buscarChar('3'));

        System.out.println();

        while (true) {
            System.out.println("Digite a mensagem em morse que quer buscar: ");

            String entrada = scanner.nextLine();

            System.out.println(arvore.buscar(entrada));

        }

    }
}