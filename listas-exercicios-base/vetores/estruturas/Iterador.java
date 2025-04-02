package estruturas;

public class Iterador {
    
    Lista lista;
    No atual;

    public Iterador(Lista lista, No atual) {
        this.lista = lista;
        this.atual = atual;
    }

    public Boolean haProximo() {
        return this.atual.proximo != null;
    }

    public Boolean haAnterior() {
        return this.atual.anterior != null;
    }

    public void proximo() {
        this.atual = atual.proximo;
    }

    public int getDadoAnterior() {
        return this.atual.anterior.dado;
    }

    public int getDadoProximo() {
        return this.atual.proximo.dado;
    }

    public int getDado() {
        return this.atual.dado;
    }

    public No getAtual() {
        return this.atual;
    }

    public void resetar() {
        this.atual = this.lista.inicio;
    }

    public void display() {
        if (this.haAnterior()) {
            System.out.print("Anterior -> " + this.getDadoAnterior() + " | ");
        }

        System.out.print("No " + this.getDado());
        
        if (this.haProximo()) {
            System.out.println(" | Proximo -> " + this.getDadoProximo());
        }
        System.out.println("");
        this.proximo();
    }
    //1. Inserir após o atual
    public void inserirAposAtual(int valor) {
        No novoNo = new No(valor);
        
        novoNo.proximo = this.atual.proximo;
        novoNo.anterior = this.atual;
        
        if (this.atual.proximo != null) {
            this.atual.proximo.anterior = novoNo;
        }
    
        this.atual.proximo = novoNo;
    }
    
    // 2. Remover após o atual

 
    //3. Inserir antes do atual
    public void inserirAntesDoAtual(int valor) {
        No novoNo = new No(valor);
        
        novoNo.proximo = this.atual;
        novoNo.anterior = this.atual.anterior;
    
        if (this.atual.anterior != null) {
            this.atual.anterior.proximo = novoNo;
        }
    
        this.atual.anterior = novoNo;
    }
    // 4. Remover antes do atual

    
}
