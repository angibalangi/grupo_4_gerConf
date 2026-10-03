import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main (String args[]) {
       
        List<Departamento> departamentos = new ArrayList<>();
        List<Funcionario> funcionarios = new ArrayList<>();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        Departamento rh = new Departamento("RH");
        Departamento compras = new Departamento("Compras");
        Departamento vendas = new Departamento("Vendas");
        Departamento expedicao = new Departamento("Expedição");
        Departamento engenharia = new Departamento("Engenharia");
        Departamento producao = new Departamento("Produção");

        departamentos.add(rh);
        departamentos.add(compras);
        departamentos.add(vendas);
        departamentos.add(expedicao);
        departamentos.add(engenharia);
        departamentos.add(producao);


        Funcionario f1 = new Funcionario("Ana Silva", "MAT001", rh);
        Funcionario f2 = new Funcionario("Bruno Souza", "MAT002", rh);
        Funcionario f3 = new Funcionario("Carla Dias", "MAT003", compras);
        Funcionario f4 = new Funcionario("Daniel Alves", "MAT004", vendas);
        Funcionario f5 = new Funcionario("Eduarda Lima", "MAT005", vendas);
        Funcionario f6 = new Funcionario("Felipe Melo", "MAT006", expedicao);
        Funcionario f7 = new Funcionario("Gabriela Rocha", "MAT007", engenharia);
        Funcionario f8 = new Funcionario("Henrique Costa", "MAT008", engenharia);
        Funcionario f9 = new Funcionario("Isabela Martins", "MAT009", producao);
        Funcionario f10 = new Funcionario("João Pedro", "MAT010", producao);

        //add na lista de funcionarios
        funcionarios.add(f1);
        funcionarios.add(f2);
        funcionarios.add(f3);
        funcionarios.add(f4);
        funcionarios.add(f5);
        funcionarios.add(f6);
        funcionarios.add(f7);
        funcionarios.add(f8);
        funcionarios.add(f9);
        funcionarios.add(f10);

        // adicionando os funcionários aos seus respectivos departamentos
        rh.getFuncionarios().add(f1);
        rh.getFuncionarios().add(f2);

        compras.getFuncionarios().add(f3);

        vendas.getFuncionarios().add(f4);
        vendas.getFuncionarios().add(f5);

        expedicao.getFuncionarios().add(f6);

        engenharia.getFuncionarios().add(f7);
        engenharia.getFuncionarios().add(f8);

        producao.getFuncionarios().add(f9);
        producao.getFuncionarios().add(f10);

        LocalDate hoje = LocalDate.now();
        String dHoje = hoje.format(fmt);                         // data maxima
        String dHojeRepetida = hoje.format(fmt);                 // mesma data maxima
        String d1MesAtras = hoje.minusMonths(1).format(fmt);
        String d2MesesAtras = hoje.minusMonths(2).format(fmt);
        String d5MesesAtras = hoje.minusMonths(5).format(fmt);
        String d10DiasAtras = hoje.minusDays(10).format(fmt);
        String d20DiasAtras = hoje.minusDays(20).format(fmt);

        GerenciadorCustos gerenciador = new GerenciadorCustos();

        // adicionando 25 custos na lista custos do Gerenciador
        gerenciador.adicionarCusto(CategoriaCusto.AQUISICAO_DE_BENS, rh, "1500.00", dHoje, "impressora", f1);
        gerenciador.adicionarCusto(CategoriaCusto.MANUTENCAO_DE_BENS, engenharia, "3500.00", dHojeRepetida, "impressora", f7);
        gerenciador.adicionarCusto(CategoriaCusto.OUTROS_SERVICOS, vendas, "450.00", d1MesAtras, "impressora", f4);

        gerenciador.adicionarCusto(CategoriaCusto.AQUISICAO_DE_BENS, engenharia, "5000.00", d2MesesAtras, "Servidor de Dados", f7);
        gerenciador.adicionarCusto(CategoriaCusto.MANUTENCAO_DE_BENS, rh, "2000.00", d5MesesAtras, "Reforma da Sala", f1);
        gerenciador.adicionarCusto(CategoriaCusto.OUTROS_SERVICOS, vendas, "1200.00", d10DiasAtras, "Licença de Software", f4);
        gerenciador.adicionarCusto(CategoriaCusto.AQUISICAO_DE_BENS, producao, "800.00", d20DiasAtras, "Ferramentas Manuais", f9);
        gerenciador.adicionarCusto(CategoriaCusto.MANUTENCAO_DE_BENS, compras, "300.00", d1MesAtras, "Material de Escritório", f3);

        gerenciador.adicionarCusto(CategoriaCusto.AQUISICAO_DE_BENS, expedicao, "2500.00", d2MesesAtras, "Notebook", f6);
        gerenciador.adicionarCusto(CategoriaCusto.AQUISICAO_DE_BENS, engenharia, "4000.00", d5MesesAtras, "Notebook", f8);
        gerenciador.adicionarCusto(CategoriaCusto.MANUTENCAO_DE_BENS, producao, "150.00", d10DiasAtras, "Manutenção Preventiva", f10);
        gerenciador.adicionarCusto(CategoriaCusto.OUTROS_SERVICOS, rh, "600.00", d20DiasAtras, "Curso de Capacitação", f2);
        gerenciador.adicionarCusto(CategoriaCusto.AQUISICAO_DE_BENS, vendas, "3000.00", d1MesAtras, "Notebook", f5);
        gerenciador.adicionarCusto(CategoriaCusto.MANUTENCAO_DE_BENS, expedicao, "750.00", d2MesesAtras, "Troca de Pneus", f6);
        gerenciador.adicionarCusto(CategoriaCusto.OUTROS_SERVICOS, compras, "120.00", d5MesesAtras, "Cartuchos de Tinta", f3);

        gerenciador.adicionarCusto(CategoriaCusto.AQUISICAO_DE_BENS, producao, "3200.00", d10DiasAtras, "EPIs Industriais", f9);
        gerenciador.adicionarCusto(CategoriaCusto.MANUTENCAO_DE_BENS, engenharia, "900.00", d20DiasAtras, "Ajuste de Maquinário", f7);
        gerenciador.adicionarCusto(CategoriaCusto.OUTROS_SERVICOS, rh, "250.00", d1MesAtras, "Confraternização", f1);
        gerenciador.adicionarCusto(CategoriaCusto.AQUISICAO_DE_BENS, vendas, "1100.00", d2MesesAtras, "Monitor 4K", f4);
        gerenciador.adicionarCusto(CategoriaCusto.MANUTENCAO_DE_BENS, compras, "400.00", d5MesesAtras, "Conserto Ar Condicionado", f3);
        gerenciador.adicionarCusto(CategoriaCusto.OUTROS_SERVICOS, expedicao, "550.00", d10DiasAtras, "Combustível", f6);
        gerenciador.adicionarCusto(CategoriaCusto.AQUISICAO_DE_BENS, engenharia, "1800.00", d20DiasAtras, "Nobreak", f8);
        gerenciador.adicionarCusto(CategoriaCusto.MANUTENCAO_DE_BENS, producao, "650.00", d1MesAtras, "Troca de Correia", f10);
        gerenciador.adicionarCusto(CategoriaCusto.OUTROS_SERVICOS, vendas, "350.00", d2MesesAtras, "Passagens de Viagem", f5);
        gerenciador.adicionarCusto(CategoriaCusto.AQUISICAO_DE_BENS, rh, "950.00", d5MesesAtras, "Cadeira Ergonômica", f2);


        System.out.println("\n------- RANKING DE FUNCIONÁRIOS -------");
        System.out.println(gerenciador.rankingFuncionarios());

    }
}
