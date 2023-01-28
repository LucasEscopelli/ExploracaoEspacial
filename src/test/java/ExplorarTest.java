import Nave.Nave;
import Planeta.Planeta;
import org.junit.Assert;
import org.junit.Test;
import reecursos.*;

import java.util.ArrayList;
import java.util.List;

public class ExplorarTest {

    @Test
    public void deveFicarADerivaQuandoFaltarCombustivelParaIrAteUmPlaneta(){
        List<Recursos> recursos = new ArrayList<>();
        recursos.add(new Agua());
        recursos.add(new Oxigenio());
        recursos.add(new Ferro());
        Planeta planeta = new Planeta(2, recursos);
        Planeta planeta2 = new Planeta(3, recursos);
        List<Planeta> planetas = new ArrayList<>();
        planetas.add(planeta);
        planetas.add(planeta2);
        Nave nave = new Nave(18);

        nave.explorar(planetas);


        int posicao = nave.getPosicao();

        System.out.println(nave.getQuantidadeDeCombustivel());

        Assert.assertEquals(0, posicao);

    }

    @Test
    public void explorandoSoUmPlaneta(){
        List<Recursos> recursos = new ArrayList<>();
        recursos.add(new Agua());
        recursos.add(new Oxigenio());
        recursos.add(new Ouro());
        Planeta planeta = new Planeta(2, recursos);
        Nave nave = new Nave(200);
        int posicaoEsperada = 0;

        nave.explorar(planeta);

        int posicao = nave.getPosicao();

        Assert.assertEquals(posicaoEsperada, posicao);
    }

    @Test
    public void deveTerValorTotalZeradoQuandoNaoExistirNenhumRecurso(){
        List<Recursos> recursos = new ArrayList<>();
        Planeta planeta = new Planeta(2, recursos);
        int valorEsperado = 0;

        int valor = planeta.valorTotal();

        Assert.assertEquals(valorEsperado, valor);
    }

    @Test
    public void deveTerValorTotalQuandoExistirRecursosNoPlaneta(){
        List<Recursos> recursos = new ArrayList<>();
        recursos.add(new Agua());
        recursos.add(new Oxigenio());
        recursos.add(new Ouro());
        Planeta planeta = new Planeta(2, recursos);
        int valorEsperado = 600;

        int valor = planeta.valorTotal();

        Assert.assertEquals(valorEsperado, valor);
    }

    @Test
    public void deveTerValorPorPesoZeradoQuandoNaoExistirNenhumRecurso(){
        List<Recursos> recursos = new ArrayList<>();
        Planeta planeta = new Planeta(2, recursos);
        int valorEsperado = 0;

        int valor = planeta.valorPorPeso();

        Assert.assertEquals(valorEsperado, valor);
    }

    @Test
    public void deveTerValorPorPesoQuandoExistirRecursosNoPlaneta(){
        List<Recursos> recursos = new ArrayList<>();
        recursos.add(new Agua());
        recursos.add(new Oxigenio());
        recursos.add(new Ouro());
        Planeta planeta = new Planeta(2, recursos);
        int valorEsperado = (int) 172.8;

        int valor = planeta.valorPorPeso();

        Assert.assertEquals(valorEsperado, valor);
    }

    @Test
    public void deveRetornarListaDeRecursosDaExploracaoCerta(){
        List<Recursos> recursos = new ArrayList<>();
        List<Recursos> recursosExplorados = new ArrayList<>();
        recursos.add(new Agua());
        recursos.add(new Oxigenio());
        recursos.add(new Ferro());
        recursos.add(new Silicio());
        Planeta planeta = new Planeta(1, recursos);
        Planeta planeta2 = new Planeta(2, recursos);
        List<Planeta> planetas = new ArrayList<>();
        planetas.add(planeta);
        planetas.add(planeta2);
        Nave nave = new Nave(100);
        int posicaoEsperada = 0;
        int valortotalEsperado = 510 + 510 + 120;

        int valor = 0;

        recursosExplorados = nave.explorar(planetas);

        for(int i = 0; i < recursosExplorados.size(); i++){
            valor += recursosExplorados.get(i).getValor();
        }

        Assert.assertEquals(valortotalEsperado, valor);
    }

}
