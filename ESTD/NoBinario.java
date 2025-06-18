class NoBinario<T> {
    T valor;
    NoBinario<T> esquerdo, direito;

    public NoBinario(T valor) {
        this.valor = valor;
        this.esquerdo = null;
        this.direito = null;
    }

    public T getValor() {
        return valor;
    }

    public NoBinario<T> getEsquerdo() {
        return esquerdo;
    }

    public NoBinario<T> getDireito() {
        return direito;
    }
}