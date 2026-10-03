import java.math.BigDecimal;
import java.util.List;

public class DashboardPorDepartamento {

    public static void exibirDashboard(
            Departamento departamento,
            List<Custo> custos) {

        BigDecimal total = BigDecimal.ZERO;

        BigDecimal totalAquisicao = BigDecimal.ZERO;
        BigDecimal totalManutencao = BigDecimal.ZERO;
        BigDecimal totalOutros = BigDecimal.ZERO;

        int quantidadeCustos = 0;

        for (Custo custo : custos) {

            if (custo.getDepartamentoAssociado() == departamento) {

                total = total.add(custo.getCusto());
                quantidadeCustos++;

                switch (custo.getCategoria()) {

                    case AQUISICAO_DE_BENS:
                        totalAquisicao = totalAquisicao.add(custo.getCusto());
                        break;

                    case MANUTENCAO_DE_BENS:
                        totalManutencao = totalManutencao.add(custo.getCusto());
                        break;

                    case OUTROS_SERVICOS:
                        totalOutros = totalOutros.add(custo.getCusto());
                        break;
                }
            }
        }

        System.out.println("==========================================");
        System.out.println("       DASHBOARD POR DEPARTAMENTO");
        System.out.println("==========================================");

        System.out.println("Departamento: " + departamento.getNome());
        System.out.println("Funcionários: " + departamento.getFuncionarios().size());

        System.out.println();
        System.out.println("Quantidade de custos: " + quantidadeCustos);

        System.out.println();
        System.out.println("CUSTOS POR CATEGORIA");
        System.out.println("------------------------------------------");

        System.out.println(
                "Aquisição de bens: R$ " + totalAquisicao
        );

        System.out.println(
                "Manutenção de bens: R$ " + totalManutencao
        );

        System.out.println(
                "Outros serviços: R$ " + totalOutros
        );

        System.out.println("------------------------------------------");
        System.out.println("TOTAL: R$ " + total);
        System.out.println("==========================================");
    }
}