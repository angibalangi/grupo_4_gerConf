import java.util.ArrayList;

public class GerenciadorDepartamentos {
    private ArrayList<Departamento> departamentos;
    public GerenciadorDepartamentos(){
        departamentos = new ArrayList<>();
        cadastrarDepartamentosIniciais();
    }

    private void cadastrarDepartamentosIniciais() {
        adicionarDepartamento("RH");
        adicionarDepartamento("Compras");
        adicionarDepartamento("Vendas");
        adicionarDepartamento("Expedição");
        adicionarDepartamento("Engenharia");
        adicionarDepartamento("Produção");
    }

    public void adicionarDepartamento(String nome) {
        Departamento d = new Departamento(nome);
        this.departamentos.add(d);
    }

    public Departamento buscarPorNome(String nome) {
        for (Departamento d : this.departamentos) {
            if (d.getNome().equalsIgnoreCase(nome)) {
                return d;
            }
        }
        return null;
    }


    public ArrayList<Departamento> getDepartamentos() {
        return this.departamentos;
    }
}

