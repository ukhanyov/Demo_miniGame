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
public class LightMage extends GameUnit{

    int castMagicDamage;
        
    public LightMage(int identifier) {
        
        switch(identifier){
            case 0:
                className = UnitNames.ELVEN_MAGE;
                abilitiesOfUnit.add(UnitAbilities.CAST_PRIORITY);
                abilitiesOfUnit.add(UnitAbilities.CAST_MAGIC_DAMAGE);
                castMagicDamage = 10;
                priority = false;
                break;
            case 1:
                className = UnitNames.HUMAN_MAGE;
                abilitiesOfUnit.add(UnitAbilities.CAST_PRIORITY);
                abilitiesOfUnit.add(UnitAbilities.CAST_MAGIC_DAMAGE);
                castMagicDamage = 4;
                priority = false;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error occured while creating a mage of light", "InfoBox: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
    
    @Override
    public boolean isLight(){
        return true;
    }
}
