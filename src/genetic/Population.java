/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic;

import java.util.Random;

/**
 *
 * @author j3rry
 */
public class Population {
    String target;
    int popLen,mutRate;
    DNA pop[],newPop[];
    DNA best;
    public Population(){}
    public Population(String target,int popLen,int mutRate){
        this.target=target;
        best=new DNA(target);
        this.popLen=popLen;
        this.mutRate=mutRate;
        pop = new DNA[popLen];
        newPop = new DNA[popLen];
        for(int i=0;i<popLen;i++){
            pop[i]=new DNA();
            newPop[i]=new DNA();
        }
    }
    public void selection(){
        DNA p1,p2;
        for(int i=0;i<popLen;i++){
            p1=acceptReject();
            p2=acceptReject();
            newPop[i]=p1.crosOver(p2);
        }
        for(int i=0;i<popLen;i++){
            int r=new Random().nextInt(100);
            if(mutRate>=r)
                newPop[i].mutate();
            pop[i]=newPop[i];
        }
    }
    public DNA acceptReject(){
        Random r=new Random();
        while(true){
            int index=r.nextInt(popLen);
            int x=r.nextInt(target.length());
            if(pop[index].getFitness()>=x)
                return pop[index];
        }
    }
    public boolean findFitness(){
        DNA f = pop[0];
        for(int i=1;i<popLen;i++){
            if(pop[i].getFitness()>f.getFitness())
            {
                f=pop[i];
            }
        }
        best=f;
        if(best.getFitness()==target.length()){
            return false;
        }
        return true;
        
    }

    public DNA getBest() {
        return best;
    }
    
}
