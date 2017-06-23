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
        
        Enum aEnum = UnitAbilities.ATTACK_MELEE;
        
        ClashOfSquads clash = new ClashOfSquads();
        clash.actionActionAction();
        
        for(GameUnit iterator : clash.playOrder){
            System.out.println(iterator.toString());
        }
        
        System.out.println("*******************************");
        
        for(Enum iterator : clash.castedAbilities){
            System.out.println(iterator.toString());
        }

    }
}
