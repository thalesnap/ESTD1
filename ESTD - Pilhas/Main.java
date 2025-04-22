public class Main {
    public static void main(String[] args) {
        System.out.println("-- EDITOR DE TEXTO --");
        EditorTexto editor = new EditorTexto(10);
        editor.inserirTexto("Oi");
        editor.inserirTexto(" Tudo bem?");
        editor.desfazer();
        editor.refazer();
        editor.inserirTexto(" Como você está?");
        editor.refazer(); 
        editor.desfazer();
        editor.desfazer();
        editor.desfazer();
        editor.desfazer();

        System.out.println("-- FILA DE IMPRESSÃO --");
        Fila filaImpressao = new Fila(5);
        filaImpressao.enfileirar(new Documento("Relatório", 300));
        filaImpressao.enfileirar(new Documento("Prova", 100));
        filaImpressao.enfileirar(new Documento("Trabalho", 250));
        filaImpressao.enfileirar(new Documento("Jogo", 600));

        filaImpressao.mostrarFila();
        System.out.println("Imprimindo: " + filaImpressao.desenfileirar());
        filaImpressao.mostrarFila();
    }
}

class Pilha {
    private String[] elementos;
    private int topo;

    public Pilha(int capacidade) {
        elementos = new String[capacidade];
        topo = -1;
    }

    public void empilhar(String elemento) {
        if (topo < elementos.length - 1) {
            topo++;
            elementos[topo] = elemento;
        } else {
            System.out.println("Pilha cheia!");
        }
    }


    public String desempilhar() {
        if (!estaVazia()) {
            String removido = elementos[topo];
            topo--;
            return removido;
        }
        return null;
    }

    public boolean estaVazia() {
        return topo == -1;
    }


    public String topo() {
        return estaVazia() ? null : elementos[topo];
    }
}

class EditorTexto {
    private Pilha pilhaDesfazer;
    private Pilha pilhaRefazer;
    private String textoAtual;

    public EditorTexto(int capacidade) {
        pilhaDesfazer = new Pilha(capacidade);
        pilhaRefazer = new Pilha(capacidade);
        textoAtual = "";
    }

    public void inserirTexto(String novoTexto) {
        pilhaDesfazer.empilhar(textoAtual); 
        pilhaRefazer = new Pilha(10);
        textoAtual += novoTexto;
        mostrarTexto();
    }

    public void desfazer() {
        if (!pilhaDesfazer.estaVazia()) {
            pilhaRefazer.empilhar(textoAtual);
            textoAtual = pilhaDesfazer.desempilhar();
        } else {
            System.out.println("Nada para desfazer.");
        }
        mostrarTexto();
    }


    public void refazer() {
        if (!pilhaRefazer.estaVazia()) {
            pilhaDesfazer.empilhar(textoAtual);
            textoAtual = pilhaRefazer.desempilhar();
        } else {
            System.out.println("Nada para refazer.");
        }
        mostrarTexto();
    }

    public void mostrarTexto() {
        System.out.println("Texto atual: \"" + textoAtual + "\"");
    }
}

class Fila {
    private Documento[] elementos;
    private int inicio, fim, tamanho;

    public Fila(int capacidade) {
        elementos = new Documento[capacidade];
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }


    public void enfileirar(Documento doc) {
        if (tamanho < elementos.length) {
            elementos[fim] = doc;
            fim = (fim + 1) % elementos.length;
            tamanho++;
        } else {
            System.out.println("Fila cheia!");
        }
    }

 
    public Documento desenfileirar() {
        if (!estaVazia()) {
            Documento doc = elementos[inicio];
            inicio = (inicio + 1) % elementos.length;
            tamanho--;
            return doc;
        }
        return null;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void mostrarFila() {
        System.out.println("Fila de impressão:");
        for (int i = 0; i < tamanho; i++) {
            Documento doc = elementos[(inicio + i) % elementos.length];
            System.out.println("- " + doc);
        }
    }
}

class Documento {
    private String nome;
    private int tamanho;

    public Documento(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    public String toString() {
        return nome + " (" + tamanho + "mb)";
    }
}
