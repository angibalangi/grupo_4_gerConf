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

    @Override
    public String toString() {
        return String.format("Nome: %s | Matricula: %s | Departamento: %s",
                this.nome,
                this.matricula,
                this.departamento.getNome());
    }
}
