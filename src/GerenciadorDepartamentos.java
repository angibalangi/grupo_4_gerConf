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

    public String listarDepartamentos() {
        if (this.departamentos.isEmpty()) {
            return "Nenhum departamento cadastrado.";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.departamentos.size(); i++) {
            sb.append(i + 1)
              .append(" - ")
              .append(this.departamentos.get(i))
              .append("\n");
        }

        return sb.toString();
    }

    public void adicionarDepartamento(String nome) {
        Departamento d = new Departamento(nome);
        this.departamentos.add(d);
    }

    // isso aqui retorna null quando n acha
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

