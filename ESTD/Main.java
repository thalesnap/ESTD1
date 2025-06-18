public class Main {
    public static void main(String[] args) {
        ArvoreBinaria<Aluno> arvore = new ArvoreBinaria<>();
        arvore.inserir(new Aluno("Ana", 123));
        arvore.inserir(new Aluno("Felipe", 456));
        arvore.inserir(new Aluno("Carlos", 234));
        arvore.inserir(new Aluno("Diana", 345));
        arvore.inserir(new Aluno("Eduardo", 111));

        System.out.println("Árvore por nível:");
        arvore.imprimirPorNivel();

        System.out.println("\nAlunos em ordem de matrícula:");
        arvore.emOrdem();

        System.out.println("\nÁrvore está desbalanceada? " + (arvore.estaDesbalanceada() ? "Sim" : "Não"));
    }
    
}