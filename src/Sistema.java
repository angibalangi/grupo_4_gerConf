import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    private ArrayList<Departamento> departamentos;
    private Funcionario funcionarioAtual;

    public Sistema(ArrayList<Departamento> departamentos) {
        this.departamentos = departamentos;
        this.funcionarioAtual = null;
    }

    public void selecionarFuncionario() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        for (Departamento departamento : departamentos) {
            funcionarios.addAll(departamento.getFuncionarios());
        }

        if (funcionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione o funcionário que está usando o sistema:");

        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println((i + 1) + " - " + funcionarios.get(i));
        }

        int opcao;

        try {
            opcao = Integer.parseInt(scanner.nextLine());
            
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida.");
            return;
        }

                if (opcao < 1 || opcao > funcionarios.size()) {
                    System.out.println("Opção inválida.");
                    return;
                }

                this.funcionarioAtual = funcionarios.get(opcao - 1);

                System.out.println("Funcionário selecionado: " + funcionarioAtual.getNome());
            }

    public Funcionario getFuncionarioAtual() {
        return this.funcionarioAtual;
    }

   
        
    }
