/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_minigame;

import static demo_minigame.UnitAbilities.ATTACK_MELEE;

/**
 *
 * @author Oleg
 */

public class Demo_miniGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //ClashOfSquads clash = new ClashOfSquads();
        //clash.actionActionAction();
        
        ClashOfSquads squad = new ClashOfSquads();
        squad.actionActionAction();
        
        
        for(GameUnit iterator : squad.activeLightSquad){
            System.out.println(iterator.toString());
        }
        
        System.out.println("*******************************");
        
        for(GameUnit iterator : squad.activeDarkSquad){
            System.out.println(iterator.toString());
        }

    }
}
