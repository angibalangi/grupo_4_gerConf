import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Custo implements Comparable<Custo>{
    private CategoriaCusto categoria;
    private Departamento departamentoAssociado;
    private BigDecimal custo;
    private LocalDate data;

    /* A linha debaixo diz qual o formato aceito qndo for informar a data do custo. Outro formato nao vai funcionar
    se nao mudar!! Se for fazer scanner, recomendo pedir o dia, mes e ano separado, depois juntar com stringbuilder */

    private static final DateTimeFormatter dataFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /* Usei BigDecimal por ser dinheiro, e coloquei a entrada como String pois imagino ser
    mais facil doq ter que criar um BigDecimal toda vez, mas posso estar errado - Angelo */

    public Custo(CategoriaCusto categoria, Departamento departamentoAssociado, String custo, String data){
        this.categoria = categoria;
        this.departamentoAssociado = departamentoAssociado;
        this.custo = new BigDecimal(custo);
        this.data = LocalDate.parse(data,dataFormato);
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

    public LocalDate getData() { return this.data; }

    public String getDataAsString() { return this.data.format(dataFormato); }

    @Override
    public String toString() {
        return String.format("Categoria: %s | Custo: R$%s | Departamento: %s | Data de Criacao: %s",
                this.categoria,
                this.custo,
                this.departamentoAssociado.getNome(),
                this.data.format(dataFormato));
    }

    /* Implementei Comparable pra poder dar sort por data */
    @Override
    public int compareTo(Custo c) {
        return this.data.compareTo(c.getData());
    }
}
