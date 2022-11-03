public class App {
    public static void main(String[] args) throws Exception {
        // Cria uma disciplina
        Disciplina poo = new Disciplina("POO", "Programação Orientada a Objetos");
        
        // Cria objetos de três alunos
        Aluno aluno1 = new Aluno(1234, "José da Silva");
        Aluno aluno2 = new Aluno(5555, "Maria Pereira");
        Aluno aluno3 = new Aluno(3123, "Ana Souza");
        
        // Matricula os três alunos na disciplina
        poo.matricularAluno(aluno1);
        poo.matricularAluno(aluno2);
        poo.matricularAluno(aluno3); 
        
        // Exibe os alunos matriculados na disciplina
        System.out.println("Alunos matriculados:");
        for (Aluno a : poo.getAlunosMatriculados()) {
            System.out.println(a.getNome());
        }
        
        // O código abaixo está comentado pois causaria erro de execução, uma vez
        // que o método getAlunosMatriculados retorna uma lista não modificável
        // List<Aluno> alunos = poo.getAlunosMatriculados();
        // alunos.add(aluno1);

    }
}
