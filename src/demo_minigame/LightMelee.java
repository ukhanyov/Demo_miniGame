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
public class LightMelee extends GameUnit{
    
    int attackMelee;
    
    public LightMelee(int identifier){
        switch(identifier){
            case 0:
                className = UnitNames.ELVEN_WARRIOR;
                abilitiesOfUnit.add(UnitAbilities.ATTACK_MELEE);
                attackMelee = 15;
                priority = false;
                break;
            case 1:
                className = UnitNames.HUMAN_WARRIOR;
                abilitiesOfUnit.add(UnitAbilities.ATTACK_MELEE);
                attackMelee = 18;
                priority = false;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error occured while creating a melee unit of light", "InfoBox: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
    
    @Override
    public boolean isLight(){
        return true;
    }
}
