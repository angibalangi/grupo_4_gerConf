import java.util.List;

public class Funcionario {
    private String nome;
    private String matricula;
    private Departamento departamento;

    public Funcionario (String nome, String matricula, Departamento departamento){
        this.nome = nome;
        this.matricula = matricula;
        this.departamento = departamento;
    }

    public String getNome(){
        return this.nome;
    }

    public String getMatricula(){
        return this.matricula;
    }

    public Departamento getDepartamento(){
        return this.departamento;
    }
    
    public static void listarFuncionarios(List<Funcionario> funcionarios) {
        if (funcionarios == null || funcionarios.isEmpty()) {
            throw new IllegalArgumentException("Nenhum funcionário cadastrado para exibição.");
        }

        System.out.println("\n-------LISTA DE FUNCIONÁRIOS-------");
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println((i + 1) + ". " + funcionarios.get(i));
        }
        System.out.println("------------------------------\n");
    }

    @Override
    public String toString() {
        return String.format("Nome: %s | Matricula: %s | Departamento: %s",
                this.nome,
                this.matricula,
                this.departamento.getNome());
    }
}
