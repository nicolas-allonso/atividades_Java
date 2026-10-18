public class Fila {

    private int tamanho;
    private int[] dados;
    private int primeiro;
    private int ultimo;
    private int capacidade;

    Fila(int tamanho) {
        this.tamanho = tamanho;
        this.dados = new int[tamanho];
        this.primeiro = 0;
        this.ultimo = -1;
        this.capacidade = 0;
    }

    boolean cheia() {
        if (capacidade == tamanho) {
            return true;
        } else {
            return false;
        }
    }

    boolean vazia() {
        if (capacidade == 0) {
            return true;
        } else {
            return false;
        }
    }

    void insere(int elemento) {
        if (cheia() == true) {
            System.out.println("Fila cheia. Nao foi possivel inserir o valor: " + elemento);
        } else {
            ultimo = ultimo + 1;
            if (ultimo == tamanho) {
                ultimo = 0;
            }
            dados[ultimo] = elemento;
            capacidade = capacidade + 1;
        }
    }

    void remove() {
        if (vazia() == true) {
            System.out.println("Fila vazia. Nao ha elemento para remover.");
        } else {
            primeiro = primeiro + 1;
            if (primeiro == tamanho) {
                primeiro = 0;
            }
            capacidade = capacidade - 1;
        }
    }

    int primeiro() {
        if (vazia() == true) {
            System.out.println("Fila vazia. Nao ha primeiro elemento.");
            return -1;
        } else {
            return dados[primeiro];
        }
    }

    int ultimo() {
        if (vazia() == true) {
            System.out.println("Fila vazia. Nao ha ultimo elemento.");
            return -1;
        } else {
            return dados[ultimo];
        }
    }

    void imprime() {
        if (vazia() == true) {
            System.out.println("Fila vazia.");
        } else {
            int indice = primeiro;
            int contador = 0;
            while (contador < capacidade) {
                System.out.print(dados[indice] + " ");
                indice = indice + 1;
                if (indice == tamanho) {
                    indice = 0;
                }
                contador = contador + 1;
            }
            System.out.println();
        }
    }

    static void merge(Fila a, Fila b, Fila r) {
        while (a.vazia() == false && b.vazia() == false) {
            if (a.primeiro() <= b.primeiro()) {
                r.insere(a.primeiro());
                a.remove();
            } else {
                r.insere(b.primeiro());
                b.remove();
            }
        }
        while (a.vazia() == false) {
            r.insere(a.primeiro());
            a.remove();
        }
        while (b.vazia() == false) {
            r.insere(b.primeiro());
            b.remove();
        }
    }

    public static void main(String[] args) {
        Fila a = new Fila(4);
        Fila b = new Fila(5);
        Fila r = new Fila(9);

        a.insere(12);
        a.insere(35);
        a.insere(52);
        a.insere(64);

        b.insere(5);
        b.insere(15);
        b.insere(23);
        b.insere(55);
        b.insere(75);

        System.out.print("Fila A: ");
        a.imprime();
        System.out.print("Fila B: ");
        b.imprime();
        System.out.print("Fila R: ");
        r.imprime();

        merge(a, b, r);

        System.out.print("Fila A: ");
        a.imprime();
        System.out.print("Fila B: ");
        b.imprime();
        System.out.print("Fila R: ");
        r.imprime();
    }
}
