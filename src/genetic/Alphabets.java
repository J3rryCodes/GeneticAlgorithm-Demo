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
public class Alphabets {
    final int len=95;
    char[] letters=new char[len];
    public Alphabets(){
        int x;
        for(int i=0;i<len;i++){
            x=i+33;
            letters[i]=(char) x;
        }
        letters[94]=' ';
    }
    public char getLetter(){
        return letters[(int) (Math.random()*100)%len];
    }
}
