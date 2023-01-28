package Planeta;

import reecursos.Recursos;

import java.util.List;

public class Planeta{
    private int posicao;
    private List<Recursos> recursos;

    public Planeta(int posicao, List<Recursos> recursos) {
        this.posicao = posicao;
        this.recursos = recursos;
    }

    public List<Recursos> getRecursos() {
        return recursos;
    }

    public int valorTotal(){
        int valorTotal = 0;

        for(Recursos recurso: this.recursos){
            valorTotal += recurso.getValor();
        }

        return valorTotal;
    }

    public int valorPorPeso(){
        int valorTotal = 0;

        for(Recursos recurso: recursos){
            valorTotal += (recurso.getValor()/recurso.getPeso());
        }

        return valorTotal;
    }

    public int getPosicao() {
        return posicao;
    }


}
