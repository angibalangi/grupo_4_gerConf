import java.util.ArrayList;

public class ValidadorCusto {

    /* Lança tratamento de exc. no primeiro problema encontrado. */
    public void validar(Custo c, Funcionario logado){
        if (logado == null) {
            throw new IllegalArgumentException("Nenhum funcionário está logado.");
        }
        if (c == null) {
            throw new IllegalArgumentException("O custo não pode ser nulo.");
        }
        if (c.getCusto() == null) {
            throw new IllegalArgumentException("O valor do custo deve ser maior que zero.");
        }
        if (c.getDescricao() == null) {
            throw new IllegalArgumentException("A descrição é obrigatória.");
        }
        if (c.getData() == null) {
            throw new IllegalArgumentException("A data é obrigatória e não pode ser futura.");
        }
        if (c.getCategoria() == null) {
            throw new IllegalArgumentException("A categoria é obrigatória.");
        }
        if (c.getDepartamentoAssociado() == null) {
            throw new IllegalArgumentException("O departamento é obrigatório.");
        }
        if (c.getFuncionario() == null) {
            throw new IllegalArgumentException("O custo deve ser registrado pelo funcionário logado.");
        }
    }

    /* Só o custo mais recente vai ser excluído (em ordem de inserção). */
    public void validarExclusao(Custo alvo, ArrayList<Custo> custos){
        if (custos == null || custos.isEmpty()) {
            throw new IllegalStateException("Não há custos para excluir.");
        }
        Custo maisRecente = custos.get(0);
        for (Custo c : custos) {
            if (!c.getData().isBefore(maisRecente.getData())) {
                maisRecente = c;
            }
        }
        if (alvo != maisRecente) {
            throw new IllegalStateException("Só é permitido excluir o custo mais recente.");
        }
    }
} 