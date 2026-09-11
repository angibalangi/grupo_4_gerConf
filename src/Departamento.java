import java.util.ArrayList;
public class Departamento {

    private String nome;
    private ArrayList<Funcionario> funcionarios;

    public Departamento(String nome){
        this.nome = nome;
        this.funcionarios = new ArrayList<>();
    }

    public ArrayList<Funcionario> getFuncionarios(){
        return this.funcionarios;
    }

    public String getNome(){
        return this.nome;
    }
    public void cadastroFuncionario(String nomeFuncionario, String matriculaFuncionario){
        Funcionario f = new Funcionario(nomeFuncionario,matriculaFuncionario, this);
        this.funcionarios.add(f);
    }
}
