import java.math.BigDecimal;

public class Custo {
    private CategoriaCusto categoria;
    private Departamento departamentoAssociado;
    private BigDecimal custo;

    /* Usei BigDecimal por ser dinheiro, e coloquei a entrada como String pois imagino ser
    mais facil doq ter que criar um BigDecimal toda vez, mas posso estar errado - Angelo */

    public Custo(CategoriaCusto categoria, Departamento departamentoAssociado, String custo){
        this.categoria = categoria;
        this.departamentoAssociado = departamentoAssociado;
        this.custo = new BigDecimal(custo);
    }

    public CategoriaCusto getCategoria(){
        return this.categoria;
    }

    public Departamento getDepartamentoAssociado(){
        return this.departamentoAssociado;
    }

    public BigDecimal getCusto(){
        return this.custo;
    }

    @Override
    public String toString() {
        return String.format("Categoria: %s | Custo: %s | Departamento: %s",
                this.categoria,
                this.custo,
                this.departamentoAssociado.getNome());
    }
}
