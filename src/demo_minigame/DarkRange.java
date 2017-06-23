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
public class DarkRange extends GameUnit{
    
    int attackRange;
    int attackMelee;
    
    public DarkRange(int identifier){
        switch(identifier){
            case 0:
                className = UnitNames.ORC_ARCHER;
                abilitiesOfUnit.add(UnitAbilities.ATTACK_RANGED);
                abilitiesOfUnit.add(UnitAbilities.ATTACK_MELEE);
                attackRange = 3;
                attackMelee = 2;
                priority = false;
                break;
            case 1:
                className = UnitNames.UNDEAD_HUNTER;
                abilitiesOfUnit.add(UnitAbilities.ATTACK_RANGED);
                abilitiesOfUnit.add(UnitAbilities.ATTACK_MELEE);
                attackRange = 4;
                attackMelee = 2;
                priority = false;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error occured while creating a ranged unit of darkness", "InfoBox: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
    
    @Override
    public boolean isDark(){
        return true;
    }
}
