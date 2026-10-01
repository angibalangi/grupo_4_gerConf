import java.math.BigDecimal;
import java.util.*;

public class PesquisaPorCusto{
    public static List<Custo> porCategoria(List<Custo> custos, CategoriaCusto categoria){
        List<Custo> resultado = new ArrayList<>();

        for (Custo custo : custos){
            if (custo.getCategoria() == categoria){
                resultado.add(custo);
            }
        }

        return resultado;
    }

    public static List<Custo> porValorMinimo(List<Custo> custos, BigDecimal valorMinimo){
        List<Custo> resultado = new ArrayList<>();

        for (Custo custo : custos){
            if (custo.getCusto().compareTO(valorMinimo) >= 0){
                resultado.add(custo);
            }
        }

        return resultado;
    }

    public static List<Custo> porValorMaximo(List<Custo> custos, BigDecimal valorMaximo){
        List<Custo> resultado = new ArrayList<>();

        for(Custo custo : custos){
            if (custo.getCusto().compareTo(valorMaximo) <= 0){
                resultado.add(custo);
            }
        }
        
        return resultado;
    }
}