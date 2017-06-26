/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_minigame;

import static demo_minigame.UnitNames.*;
import static demo_minigame.UnitAbilities.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author Oleg
 */
public class GenerateSquads {
    
    static int numberOfMagesInSquad = 1;
    static int numberOfRangeUnitsInSquad = 3;
    static int numberOfMeleeUnitsInSquad = 4;
    
    Random random = new Random();
    List<Enum> abilitiesDumper = new ArrayList<>();
    Enum nameDumper;
    Random picker = new Random();
    
    List<GameUnit> lightSquad = new ArrayList<>();
    List<GameUnit> darkSquad = new ArrayList<>();
    
    /**
     * Class constructor which generates two squads of specified size, with randomized squad members
     */
    public GenerateSquads(){
        
        for(int i = 0; i < numberOfMagesInSquad; i++){
            createLigtMage(new Random().nextInt(2));
            createDarkMage(new Random().nextInt(2));
        }
        
        for(int i = 0; i < numberOfRangeUnitsInSquad; i++){
            createLigtRangeUnit(new Random().nextInt(2));
            createDarkRangeUnit(new Random().nextInt(2));
        }
        
        for(int i = 0; i < numberOfMeleeUnitsInSquad; i++){
            createLigtMeleeUnit(new Random().nextInt(2));
            createDarkMeleeUnit(new Random().nextInt(2));
        }
    }
    
    /**
     * Crates a mage GameUnit for the Light team
     * 
     * @param seed is randomly chosen
     */
    private void createLigtMage(int seed){
        switch(seed){
            case 0:
                abilitiesDumper.add(CAST_PRIORITY);
                abilitiesDumper.add(CAST_MAGIC_DAMAGE);
                lightSquad.add(new GameUnit(ELVEN_MAGE, abilitiesDumper, 0, 0, 10, true));
                abilitiesDumper.clear();
                break;
            case 1:
                abilitiesDumper.add(CAST_PRIORITY);
                abilitiesDumper.add(CAST_MAGIC_DAMAGE);
                lightSquad.add(new GameUnit(HUMAN_MAGE, abilitiesDumper, 0, 0, 4, true));
                abilitiesDumper.clear();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error occured while creating light mage", "InfoBox: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
    
    /**
     * Crates a range GameUnit for the Light team
     * 
     * @param seed is randomly chosen
     */
    private void createLigtRangeUnit(int seed){
        switch(seed){
            case 0:
                abilitiesDumper.add(ATTACK_MELEE);
                abilitiesDumper.add(ATTACK_RANGED);
                lightSquad.add(new GameUnit(ELVEN_ARCHER, abilitiesDumper, 3, 7, 0, true));
                abilitiesDumper.clear();
                break;
            case 1:
                abilitiesDumper.add(ATTACK_MELEE);
                abilitiesDumper.add(ATTACK_RANGED);
                lightSquad.add(new GameUnit(HUMAN_CROSSBOWMAN, abilitiesDumper, 3, 5, 0, true));
                abilitiesDumper.clear();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error occured while creating light range unit", "InfoBox: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
    
    /**
     * Crates a melee GameUnit for the Light team
     * 
     * @param seed is randomly chosen
     */
    private void createLigtMeleeUnit(int seed){
        switch(seed){
            case 0:
                abilitiesDumper.add(ATTACK_MELEE);
                lightSquad.add(new GameUnit(ELVEN_WARRIOR, abilitiesDumper, 15, 0, 0, true));
                abilitiesDumper.clear();
                break;
            case 1:
                abilitiesDumper.add(ATTACK_MELEE);
                lightSquad.add(new GameUnit(HUMAN_WARRIOR, abilitiesDumper, 18, 0, 0, true));
                abilitiesDumper.clear();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error occured while creating light melee unit", "InfoBox: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
    
    /**
     * Crates a mage GameUnit for the Dark team
     * 
     * @param seed is randomly chosen
     */
    private void createDarkMage(int seed){
        switch(seed){
            case 0:
                abilitiesDumper.add(CAST_PRIORITY);
                abilitiesDumper.add(CAST_CURSE);
                darkSquad.add(new GameUnit(ORC_SHAMAN, abilitiesDumper, 0, 0, 0, false));
                abilitiesDumper.clear();
                break;
            case 1:
                abilitiesDumper.add(CAST_DISEASE);
                abilitiesDumper.add(CAST_MAGIC_DAMAGE);
                darkSquad.add(new GameUnit(UNDEAD_NECROMANT, abilitiesDumper, 0, 0, 5, false));
                abilitiesDumper.clear();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error occured while creating dark mage", "InfoBox: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
    
    /**
     * Crates a range GameUnit for the Dark team
     * 
     * @param seed is randomly chosen
     */
    private void createDarkRangeUnit(int seed){
        switch(seed){
            case 0:
                abilitiesDumper.add(ATTACK_MELEE);
                abilitiesDumper.add(ATTACK_RANGED);
                darkSquad.add(new GameUnit(ORC_ARCHER, abilitiesDumper, 2, 3, 0, false));
                abilitiesDumper.clear();
                break;
            case 1:
                abilitiesDumper.add(ATTACK_MELEE);
                abilitiesDumper.add(ATTACK_RANGED);
                darkSquad.add(new GameUnit(UNDEAD_HUNTER, abilitiesDumper, 2, 4, 0, false));
                abilitiesDumper.clear();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error occured while creating dark ranged unit", "InfoBox: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
    
    /**
     * Crates a melee GameUnit for the Dark team
     * 
     * @param seed is randomly chosen
     */
    private void createDarkMeleeUnit(int seed){
        switch(seed){
            case 0:
                abilitiesDumper.add(ATTACK_MELEE);
                darkSquad.add(new GameUnit(ORC_GOBLIN, abilitiesDumper, 20, 0, 0, false));
                abilitiesDumper.clear();
                break;
            case 1:
                abilitiesDumper.add(ATTACK_MELEE);
                darkSquad.add(new GameUnit(UNDEAD_ZOMBY, abilitiesDumper, 18, 0, 0, false));
                abilitiesDumper.clear();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error occured while creating melee unit", "InfoBox: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
}
