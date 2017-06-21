/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_minigame;


/**
 *
 * @author Oleg
 */
public class Demo_miniGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GenerateSquad newSquad = new GenerateSquad();
        
        for(GameUnit iterator : newSquad.lightSquad){
            System.out.println(iterator.toString());
        }
        
        System.out.println("*******************************");
        
        for(GameUnit iterator : newSquad.darkSquad){
            System.out.println(iterator.toString());
        }
    
    }
}
