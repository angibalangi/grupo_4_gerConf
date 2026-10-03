import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main (String args[]) {
       
        Departamento rh = new Departamento("RH");
        Departamento compras = new Departamento("Compras");
        Departamento vendas = new Departamento("Vendas");
        Departamento expedicao = new Departamento("Expedição");
        Departamento engenharia = new Departamento("Engenharia");
        Departamento producao = new Departamento("Produção");

        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Ana Silva", "MAT001", rh));
        funcionarios.add(new Funcionario("Bruno Souza", "MAT002", rh));

        funcionarios.add(new Funcionario("Carla Dias", "MAT003", compras));

        funcionarios.add(new Funcionario("Daniel Alves", "MAT004", vendas));
        funcionarios.add(new Funcionario("Eduarda Lima", "MAT005", vendas));

        funcionarios.add(new Funcionario("Felipe Melo", "MAT006", expedicao));

        funcionarios.add(new Funcionario("Gabriela Rocha", "MAT007", engenharia));
        funcionarios.add(new Funcionario("Henrique Costa", "MAT008", engenharia));

        funcionarios.add(new Funcionario("Isabela Martins", "MAT009", producao));
        funcionarios.add(new Funcionario("João Pedro", "MAT010", producao));

    }
}
