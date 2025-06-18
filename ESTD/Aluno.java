public class Aluno implements Comparable<Aluno> {
    private final String nome;
    private final int matricula;

    public Aluno(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() { return nome; }
    public int getMatricula() { return matricula; }

    @Override
    public int compareTo(Aluno outro) {
        return Integer.compare(this.matricula, outro.matricula);
    }

    @Override
    public String toString() {
        return nome + " (" + matricula + ")";
    }
}