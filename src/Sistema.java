public class Sistema {
    public static void main (String[] args){
        Departamento dep1 = new Departamento("Financeiro");
        Departamento dep2 = new Departamento("Recursos Humanos");
        dep1.cadastroFuncionario("Joana","100");
        dep2.cadastroFuncionario("Pedro","200");
    }
}
