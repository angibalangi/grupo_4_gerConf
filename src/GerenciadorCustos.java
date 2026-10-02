import java.util.ArrayList;
import java.util.Collections;
import java.math.BigDecimal;

public class GerenciadorCustos {
    private ArrayList<Custo> custos;

    public GerenciadorCustos(){
        custos = new ArrayList<>();
    }

    public void adicionarCusto(CategoriaCusto categoria, Departamento departamentoAssociado, String custo, String data, String descricao, Funcionario funcionario){
        Custo c = new Custo(categoria, departamentoAssociado, custo, data, descricao, funcionario);
        custos.add(c);
    }

    /* Metodo abaixo so aceita datas no formato dd/MM/yyyy, senao nao vai funcionar!! (data incompleta tbm funciona) */

    public ArrayList<Custo> pesquisaPorData(String dataInformada){
        ArrayList<Custo> custosEncontrados = new ArrayList<>();

        for (Custo c : custos){
            if (c.getDataAsString().contains(dataInformada)){
                custosEncontrados.add(c);
            }
        }

        return custosEncontrados;
    }

    public ArrayList<Custo> pesquisaPorValorMinimo(BigDecimal valorMinimo){
        ArrayList<Custo> custosEncontrados = new ArrayList<>();

        for (Custo c : custos){
            if (c.getCusto().compareTo(valorMinimo) >= 0){
                custosEncontrados.add(c);
            }
        }

        return custosEncontrados;
    }

    public ArrayList<Custo> pesquisaPorValorMaximo(BigDecimal valorMaximo){
        ArrayList<Custo> custosEncontrados = new ArrayList<>();

        for (Custo c : custos){
            if (c.getCusto().compareTo(valorMaximo) <= 0){
                custosEncontrados.add(c);
            }
        }

        return custosEncontrados;
    }

    public void ordenarPorData(){
        Collections.sort(custos);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (Custo c : custos){
            sb.append(c.toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}