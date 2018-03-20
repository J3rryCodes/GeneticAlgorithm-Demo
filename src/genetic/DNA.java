/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic;

/**
 *
 * @author j3rry
 */
public class DNA {
    private Alphabets alp=new Alphabets();
    private static String target;
    private char gean[];
    private static int len;
    public DNA(){
        gean=new char[len];
        this.gean=new char[len];
        for(int i=0;i<len;i++){
            gean[i]=alp.getLetter();
        }
    }
    public DNA(String target){
        this.target=target;
        this.len=target.length();
    }

    public int getFitness() {
        int fitness=0;
        for(int i=0;i<len;i++){
            if(gean[i]==target.charAt(i))
                fitness++;
        }
        return fitness;
    }
    public DNA crosOver(DNA dna){
        DNA d=new DNA();
        for(int i=0;i<len;i++){
            d.gean[i]=(i<len/2)?this.gean[i]:dna.gean[i];
        }
        return d;
    }
    public void mutate(){
        gean[(int) (Math.random()*100)%len]=alp.getLetter();
    }
    @Override
    public String toString(){
        String str="";
        for(char x:gean){
            str+=x;
        }
        return str;
    }
}
