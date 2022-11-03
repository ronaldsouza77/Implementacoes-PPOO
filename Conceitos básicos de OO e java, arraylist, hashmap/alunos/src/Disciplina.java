import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe que representa uma disciplina da universidade
 * 
 * @author Julio César Alves
 */
public class Disciplina {
    private String sigla;
    private String nome;
    private ArrayList<Aluno> alunos;

    /**
     * Uma disciplina é construída com um nome e uma sigla.
     * A lista de alunos matriculados é criada vazia.
     */
    public Disciplina(String umaSigla, String umNome) {
        sigla = umaSigla;
        nome = umNome;
        alunos = new ArrayList<>();
    }

    /*
     * Retorna a sigla da disciplina
     */
    public String getSigla() {
        return sigla;
    }
    
    /*
     * Retorna o nome da disciplina
     */ 
    public String getNome() {
        return nome;
    }

    /*
     * Indica se um aluno com a matrícula passada foi matriculado na disciplina
     */
    public boolean alunoEstaMatriculado(int matricula) {
        for (Aluno a : alunos) {
                if (a.getMatricula() == matricula) {
                    return true;
            }
        }
        return false;
    }

    /*
     * Matricula um aluno na disciplina
     */
    public boolean matricularAluno(Aluno aluno) {
        // Tratamento para garantir que não pode
        // existir matrícula duplicada na disciplina
        if (!alunoEstaMatriculado(aluno.getMatricula())) {
            alunos.add(aluno);
            return true;
        }
        return false;
    }
    
    /*
     * Retorna a lista de alunos matriculados na disciplina
     */
    public List<Aluno> getAlunosMatriculados() {
        return Collections.unmodifiableList(alunos);
    }
    
    /*
     * Busca um aluno matriculado na disciplina com a matrícula passada
     */
    public Aluno buscarAluno(int matricula) {
        for (Aluno aluno : alunos) {
                if (aluno.getMatricula() == matricula) {
                    return aluno;
            }
        }
        return null;
    }    
    
    /*
     * Busca um aluno matriculado na disciplina pelo seu nome
     */
    public Aluno buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
                if (aluno.getNome().equals(nome)) {
                    return aluno;
            }
        }
        return null;
    }

}
