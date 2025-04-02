import estruturas.Iterador;
import estruturas.Lista;
import estruturas.Vetor;


public class VetorApp {
    public static void main(String[] args) {
        Vetor vetor = new Vetor(10);
        int[] valores = {2, 7, 9, 12, 16, 21, 27, 33, 42, 54};
        for (int valor : valores) {
            vetor.adicionar(valor);
        }

        System.out.println("Vetor original:");
        vetor.mostrarElementos();

        //1. Busca binaria
        System.out.println("Questao 1");
        System.out.println("Busca binária pelo valor 16:");
        vetor.buscaBinaria(16);

        System.out.println("Busca binária pelo valor 100:");
        vetor.buscaBinaria(100);

        System.out.println("\n---\n");

        //2. Inserir no início do vetor
        System.out.println("Questao 2");
        System.out.println("Inserindo 99 no início do vetor:");
        vetor.inserirNoInicio(99);
        vetor.mostrarElementos();


        //Lista
        Lista lista = new Lista();
        for (int valor : valores) {
            lista.adicionarAoFinal(valor);
        }

        System.out.println("Lista original:");
        lista.mostrarNos();


        System.out.println("\n---\n");

        // 1. Inserir no final da lista
        System.out.println("Lista Questao 1");
        System.out.println("Inserindo 100 no final da lista:");
        lista.adicionarAoFinal(100);
        lista.mostrarNos();

        System.out.println("\n---\n");

        //2. Contar Nos
        System.out.println("Lista Questao 2");
        System.out.println("Número de nós na lista: " + lista.contarNos());

        System.out.println("\n---\n");

        // 4. Inserir após um valor informado
        System.out.println("Lista Questao 4");
        System.out.println("Inserindo 55 após o valor 33:");
        lista.inserirAposValor(33, 55);
        lista.mostrarNos();

        System.out.println("\n---\n");


    
        Iterador iterador = lista.getIterador();

        // 1. Inserir após o atual
        System.out.println("Iterador Questao 1");
        System.out.println("Inserindo 77 após o nó atual:");
        iterador.inserirAposAtual(77);
        lista.mostrarNos();

        System.out.println("\n---\n");

        
        // 2. Remover após o atual //Nao Consegui


        // 3. Inserir antes do atual
        System.out.println("Iterador Questao 3");
        System.out.println("Inserindo 88 antes do nó atual:");
        iterador.inserirAntesDoAtual(88);
        lista.mostrarNos();

        
        // 4. Remover antes do atual // Nao Consegui

    }
}
