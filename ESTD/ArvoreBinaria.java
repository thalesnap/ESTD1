public class ArvoreBinaria<T extends Comparable<T>> {
    private NoBinario<T> raiz;

    public void inserir(T valor) {
        raiz = inserirRec(raiz, valor);
    }

    private NoBinario<T> inserirRec(NoBinario<T> no, T valor) {
        if (no == null) return new NoBinario<>(valor);
        if (valor.compareTo(no.valor) < 0)
            no.esquerdo = inserirRec(no.esquerdo, valor);
        else
            no.direito = inserirRec(no.direito, valor);
        return no;
    }

    public void imprimirPorNivel() {
        if (raiz == null) return;
        java.util.Queue<NoBinario<T>> fila = new java.util.LinkedList<>();
        fila.add(raiz);
        int nivel = 0;
        while (!fila.isEmpty()) {
            int tamanho = fila.size();
            System.out.print("Nível " + nivel + ": ");
            for (int i = 0; i < tamanho; i++) {
                NoBinario<T> atual = fila.poll();
                System.out.print(atual.valor + " ");
                if (atual.esquerdo != null) fila.add(atual.esquerdo);
                if (atual.direito != null) fila.add(atual.direito);
            }
            System.out.println();
            nivel++;
        }
    }

    public boolean estaDesbalanceada() {
        return verificaDesbalanceamento(raiz) == -1;
    }

    private int verificaDesbalanceamento(NoBinario<T> no) {
        if (no == null) return 0;
        int esq = verificaDesbalanceamento(no.esquerdo);
        int dir = verificaDesbalanceamento(no.direito);
        if (esq == -1 || dir == -1 || Math.abs(esq - dir) > 1) return -1;
        return Math.max(esq, dir) + 1;
    }

    public void emOrdem() {
        emOrdem(raiz);
    }

    private void emOrdem(NoBinario<T> node) {
        if (node != null) {
            emOrdem(node.esquerdo);
            System.out.println(node.valor);
            emOrdem(node.direito);
        }
    }
}