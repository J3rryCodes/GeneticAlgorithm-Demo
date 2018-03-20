/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//GENETIC ALGORITHM DATE : 2/FEB/2018
package genetic;

/**
 *
 * @author j3rry
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String target = "hay can you solve it? yes";
        int mutation = 3;

        Population p = new Population(target, 200, mutation);
        while (p.findFitness()) {
            p.selection();
            System.out.println(p.best);
        }
        System.out.println(p.best);
    }
}
