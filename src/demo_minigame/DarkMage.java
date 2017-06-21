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
public class DarkMage extends GameUnit{

    int castMagicDamage;
        
    public DarkMage(int identifier) {
        
        switch(identifier){
            case 0:
                className = UnitNames.ORC_SHAMAN;
                abilitiesOfUnit.add(UnitAbilities.CAST_PRIORITY);
                abilitiesOfUnit.add(UnitAbilities.CAST_CURSE);
                priority = false;
                break;
            case 1:
                className = UnitNames.UNDEAD_NECROMANT;
                abilitiesOfUnit.add(UnitAbilities.CAST_DISEASE);
                abilitiesOfUnit.add(UnitAbilities.CAST_MAGIC_DAMAGE);
                castMagicDamage = 5;
                priority = false;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error occured while creating a mage of darkness", "InfoBox: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
}
