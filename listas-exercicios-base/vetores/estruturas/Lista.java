package estruturas;

public class Lista {

    public No inicio;

    public void Lista() {
        this.inicio = null;
    }

    public void adicionarAoInicio(int valor) {
        No no = new No(valor);

        if (this.inicio == null) {
            this.inicio = no;
            return;
        }

        this.inicio.anterior = no;

        no.proximo = this.inicio;
        this.inicio = no;
    }

    public void mostrarNos() {
        Iterador iterador = this.getIterador();
        
        while (iterador.getAtual() != null) {
            iterador.display();
        }
    }

    public void remover(int valor) {
        No noAux = this.inicio;

        while (noAux != null && noAux.dado != valor) {
            noAux = noAux.proximo;
        }

        if (noAux == null) {
            System.out.println("Valor não encontrado");
            return;
        }

        noAux.anterior.proximo = noAux.proximo;
        noAux.proximo.anterior = noAux.anterior;
    }

    public Iterador getIterador() {
        return new Iterador(this, this.inicio);
    }

    //1. Adicionar ao final da lista
    public void adicionarAoFinal(int valor) {
        No novoNo = new No(valor);
        
        if (this.inicio == null) {
            this.inicio = novoNo;
            return;
        }
    
        No atual = this.inicio;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }
    
        atual.proximo = novoNo;
        novoNo.anterior = atual;
    }

    //2. Contar Nos
    public int contarNos() {
        int contador = 0;
        No atual = this.inicio;
        
        while (atual != null) {
            contador++;
            atual = atual.proximo;
        }
        
        return contador;
    }
    
    // 4. Inserir após um valor informado
    public void inserirAposValor(int valor, int novoValor) {
        No atual = inicio;
        while (atual != null && atual.dado != valor) {
            atual = atual.proximo;
        }
        if (atual == null) {
            System.out.println("Valor " + valor + " não encontrado.");
            return;
        }
        No novoNo = new No(novoValor);
        novoNo.proximo = atual.proximo;
        novoNo.anterior = atual;
        if (atual.proximo != null) {
            atual.proximo.anterior = novoNo;
        }
        atual.proximo = novoNo;
    }


	
}
