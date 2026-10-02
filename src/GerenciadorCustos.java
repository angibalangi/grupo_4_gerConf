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

    //Pesquisa os custos por Descrição - S05T05
    public ArrayList<Custo> pesquisaPorDescricao(String descricao){
        ArrayList<Custo> custos = new ArrayList<>();

        for (Custo c : custos){
            if (c.getDescricao().equals(descricao)) {
                custos.add(c);
            }
        }

        return custos;
    }

    //Pesquisa custos por Departamento - S05T08
    public ArrayList<Custo> pesquisaPorDepartamento(String departamento){
        ArrayList<Custo> custos = new ArrayList<>();

        for (Custo c : custos){
            if (c.getDepartamentoAssociado().equals(departamento)){
                custos.add(c);
            }
        }

        return custos;
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

    public boolean excluirUltimoCusto(Custo custo) {
        if (custos.size() == 0) {
            return false;
        }
        Custo maisRecente = custos.get(0);
        for (Custo c : custos) {
            if (!c.getData().isBefore(maisRecente.getData())) {
                maisRecente = c;
            }
        }
        if (custo == maisRecente) {
            custos.remove(custo);
            return true;
        } else {
            return false;
        }
    }

    public BigDecimal totalDoDepartamento(Departamento departamento) {
        BigDecimal total = BigDecimal.ZERO;

        for (Custo c : custos) {
            if (c.getDepartamentoAssociado() == departamento) {
                total = total.add(c.getCusto());
            }
        }

        return total;
    }

    public ArrayList<Departamento> rankingDepartamentos(ArrayList<Departamento> departamentos) {
        ArrayList<Departamento> ranking = new ArrayList<>(departamentos);

        for (int i = 0; i < ranking.size(); i++) {
            int maior = i;

            for (int j = i + 1; j < ranking.size(); j++) {
                if (totalDoDepartamento(ranking.get(j))
                        .compareTo(totalDoDepartamento(ranking.get(maior))) > 0) {
                    maior = j;
                }
            }

            Departamento aux = ranking.get(i);
            ranking.set(i, ranking.get(maior));
            ranking.set(maior, aux);
        }

        return ranking;
    }
}


