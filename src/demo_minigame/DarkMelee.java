/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_minigame;

import javax.swing.JOptionPane;

/**
 *
 * @author Oleg
 */
public class DarkMelee extends GameUnit{
    
    int attackMelee;
    
    public DarkMelee(int identifier){
        switch(identifier){
            case 0:
                className = UnitNames.ORC_GOBLIN;
                abilitiesOfUnit.add(UnitAbilities.ATTACK_MELEE);
                attackMelee = 20;
                priority = false;
                break;
            case 1:
                className = UnitNames.UNDEAD_ZOMBY;
                abilitiesOfUnit.add(UnitAbilities.ATTACK_MELEE);
                attackMelee = 18;
                priority = false;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error occured while creating a melrr unit of darkness", "InfoBox: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
    
}
