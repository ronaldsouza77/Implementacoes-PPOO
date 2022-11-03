
/**
 * Classe que representa um aluno da universidade.
 * 
 * @author Julio César Alves
 */
public class Aluno {
    // número de matrícula do aluno
    private int matricula;
    // nome do aluno
    private String nome;
    
    /**
     * Um objeto aluno é criado com um número de matrícula e um nome
     */
    public Aluno(int umaMatricula, String umNome) {
        matricula = umaMatricula;
        nome = umNome;
    }
    
    /**
     * Retorna a matrícula do Aluno
     */
    public int getMatricula() {
        return matricula;
    }
    
    /**
     * Retorna o nome do Aluno
     */
    public String getNome() {
        return nome;
    }
}
