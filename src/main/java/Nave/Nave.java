package Nave;

import Planeta.Planeta;
import reecursos.Recursos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Nave {
    int quantidadeDeCombustivel;
    int posicao;

    public Nave(int quantidadeDeCombustivel) {
        this.quantidadeDeCombustivel = quantidadeDeCombustivel;
        this.posicao = 0;
    }

    public int getQuantidadeDeCombustivel() {
        return quantidadeDeCombustivel;
    }

    public int getPosicao() {
        return posicao;
    }

    public List<Recursos> explorar(Planeta planeta){
        List<Recursos> recursosExploracao = new ArrayList<>();

        if ((planeta.getPosicao() * 3) <= this.quantidadeDeCombustivel) {
            for (int i = 0; i < planeta.getRecursos().size(); i++) {
                recursosExploracao.add(planeta.getRecursos().get(i));
            }
            this.posicao = planeta.getPosicao();
            this.quantidadeDeCombustivel -= (planeta.getPosicao() * 3);
        }
        if ((planeta.getPosicao() * 3) <= this.quantidadeDeCombustivel){
            this.posicao = 0;
        }


        return recursosExploracao;
    }



    public List<Recursos> explorar(List<Planeta> planetas) {
        List<Recursos> recursosExploracao = new ArrayList<>();
        int combustivel = this.quantidadeDeCombustivel;
        int posicaoGuarda = 0;
        int indexGuarda = 0;



        for(int i = 0; i < planetas.size(); i++){
//            posicaoGuarda = this.posicao;
//            combustivel = this.quantidadeDeCombustivel;
            if((this.quantidadeDeCombustivel - ((planetas.get(i).getPosicao()- this.posicao) * 3)) >= 0){
                for (int k = 0; k < planetas.get(i).getRecursos().size(); k++) {
                    recursosExploracao.add(planetas.get(i).getRecursos().get(k));
                }

                this.quantidadeDeCombustivel -= ((planetas.get(i).getPosicao() - this.posicao) * 3);
                this.posicao = planetas.get(i).getPosicao();
                indexGuarda = i;
            }else{
                i = planetas.size();
            }

        }

        for(;indexGuarda > 0; indexGuarda--){
            if((this.quantidadeDeCombustivel - ((this.posicao - planetas.get(indexGuarda - 1).getPosicao())  * 3)) >= 0) {
                this.quantidadeDeCombustivel -= ((this.posicao - planetas.get(indexGuarda - 1).getPosicao()) * 3);
                this.posicao = planetas.get(indexGuarda - 1).getPosicao();
            }

            if((this.quantidadeDeCombustivel - ((this.posicao * 3))) >= 0){
                this.quantidadeDeCombustivel -= this.posicao * 3;
                this.posicao = 0;
            }
        }

        return recursosExploracao;
    }


    }

