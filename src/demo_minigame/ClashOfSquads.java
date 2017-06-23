/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_minigame;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;
import demo_minigame.UnitAbilities;

/**
 *
 * @author Oleg
 */
public class ClashOfSquads {
    
//    Deque<GameUnit> playOrder = new ArrayDeque<>();
//    List<GameUnit> generalList = new ArrayList<>();
//    List<GameUnit> activeLightSquad = new ArrayList<>();
//    List<GameUnit> activeDarkSquad = new ArrayList<>();
//    List<Enum> castedAbilities = new ArrayList<>();
//    
//    public ClashOfSquads(){
//        GenerateSquads newSquads = new GenerateSquads();
//        
//        activeLightSquad.addAll(newSquads.lightSquad);
//        activeDarkSquad.addAll(newSquads.darkSquad);
//        
//        generalList.addAll(newSquads.lightSquad);
//        generalList.addAll(newSquads.darkSquad);
//    }
//    
//    private void generateQueue(){
//        
//        playOrder.clear();
//        
//        int[] sequence = ThreadLocalRandom.current().ints(0, generalList.size()).distinct().limit(generalList.size()).toArray();
//        
//        for(int i = 0; i < generalList.size(); i++){
//            playOrder.add(generalList.get(sequence[i]));
//        }
//    }
//    
//    public void actionActionAction(){
//        
//        generateQueue();
//        
//        for(GameUnit iterator : playOrder){
//            UnitAbilities chosenAbility = (UnitAbilities) iterator.abilitiesOfUnit.get(new Random().nextInt(iterator.abilitiesOfUnit.size()));
//            int randomTarget = 0;
//            
//            if(iterator.isDark()){
//                
//                switch(chosenAbility){
//                    case ATTACK_MELEE:
//                        randomTarget = new Random().nextInt(activeLightSquad.size());
//                        activeLightSquad.get(randomTarget).healt -= iterator.attackMelee;
//                        break;
//                    case ATTACK_RANGED:
//                        randomTarget = new Random().nextInt(activeLightSquad.size());
//                        activeLightSquad.get(randomTarget).healt -= iterator.attackRange;
//                        break;
//                    case CAST_CURSE:
//                        randomTarget = new Random().nextInt(activeLightSquad.size());
//                        activeLightSquad.get(randomTarget).healt -= 0;
//                        break;
//                    case CAST_DISEASE:
//                        randomTarget = new Random().nextInt(activeLightSquad.size());
//                        activeLightSquad.get(randomTarget).healt -= 0;
//                        break;
//                    case CAST_PRIORITY:
//                        randomTarget = new Random().nextInt(activeLightSquad.size());
//                        activeLightSquad.get(randomTarget).healt -= 0;
//                        break;
//                    default:
//                        JOptionPane.showMessageDialog(null, "Error occured while casting ability", "InfoBox: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
//                        break;
//                }
//                
//            }else{
//                if(iterator.isLight()){
//                    
//                    switch(chosenAbility){
//                        case ATTACK_MELEE:
//                            randomTarget = new Random().nextInt(activeDarkSquad.size());
//                            activeDarkSquad.get(randomTarget).healt -= iterator.attackMelee;
//                            break;
//                        case ATTACK_RANGED:
//                            randomTarget = new Random().nextInt(activeDarkSquad.size());
//                            activeDarkSquad.get(randomTarget).healt -= iterator.attackRange;
//                            break;
//                        case CAST_MAGIC_DAMAGE:
//                            randomTarget = new Random().nextInt(activeDarkSquad.size());
//                            activeDarkSquad.get(randomTarget).healt -= iterator.castMagicDamage;
//                            break;
//                        case CAST_PRIORITY:
//                            activeDarkSquad.get(randomTarget).healt -= 0;
//                            break;
//                        default:
//                            JOptionPane.showMessageDialog(null, "Error occured while casting ability", "InfoBox: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
//                            break;
//                    }
//                    
//                }else{   
//                    JOptionPane.showMessageDialog(null, "Error occured while taking an action", "InfoBox: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
//                }
//            }
//        }
//    }
//    
    private boolean isDead(GameUnit unitTested){
        return unitTested.healt <= 0;
    }
    
    private void loggerWriteToTheFile(){
        //TODO this method must write battle events into the file
    }
    
    private void loggerWriteToTheConsole(){
        //TODO this method must write battle events to the console
    }
    
}