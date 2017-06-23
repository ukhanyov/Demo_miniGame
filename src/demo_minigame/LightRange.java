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
public class LightRange extends GameUnit{
    
    int attackRange;
    int attackMelee;
    
    public LightRange(int identifier){
        switch(identifier){
            case 0:
                className = UnitNames.ELVEN_ARCHER;
                abilitiesOfUnit.add(UnitAbilities.ATTACK_RANGED);
                abilitiesOfUnit.add(UnitAbilities.ATTACK_MELEE);
                attackRange = 7;
                attackMelee = 3;
                priority = false;
                break;
            case 1:
                className = UnitNames.HUMAN_CROSSBOWMAN;
                abilitiesOfUnit.add(UnitAbilities.ATTACK_RANGED);
                abilitiesOfUnit.add(UnitAbilities.ATTACK_MELEE);
                attackRange = 5;
                attackMelee = 3;
                priority = false;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error occured while creating a ranged unit of light", "InfoBox: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
    
    @Override
    public boolean isLight(){
        return true;
    }
}
