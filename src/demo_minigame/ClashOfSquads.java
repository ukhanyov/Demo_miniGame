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
    
    Deque<GameUnit> playOrder = new ArrayDeque<>();
    List<GameUnit> generalList = new ArrayList<>();
    List<GameUnit> activeLightSquad = new ArrayList<>();
    List<GameUnit> activeDarkSquad = new ArrayList<>();
    List<Enum> castedAbilities = new ArrayList<>();
    
    GenerateSquads newSquads = new GenerateSquads();
    
    
    
    public ClashOfSquads(){
        //GenerateSquads newSquads = new GenerateSquads();
        
        activeLightSquad.addAll(newSquads.lightSquad);
        activeDarkSquad.addAll(newSquads.darkSquad);
        
    }
    
    private void generateQueue(){
        
        generalList.clear();

        generalList.addAll(activeLightSquad);
        generalList.addAll(activeDarkSquad);
        
        int[] sequence = ThreadLocalRandom.current().ints(0, generalList.size()).distinct().limit(generalList.size()).toArray();
        
        for(int i = 0; i < generalList.size(); i++){
            playOrder.add(generalList.get(sequence[i]));
        }
    }

    public void actionActionAction(){
        
        while(true){

            generateQueue();

            for(GameUnit iterator : playOrder){
                
                UnitAbilities chosenAbility = (UnitAbilities) iterator.abilitiesOfUnit.get(new Random().nextInt(iterator.abilitiesOfUnit.size()));
                int randomTarget = 0;
                
                if(!isDead(iterator)){
                    if(iterator.isDark()){
                        switch(chosenAbility){
                            case ATTACK_MELEE:
                                randomTarget = new Random().nextInt(activeLightSquad.size());
                                activeLightSquad.get(randomTarget).damageHealth(iterator.attackMelee);
                                loggerWriteToTheConsole(iterator, activeLightSquad.get(randomTarget), iterator.attackMelee);
                                if(isDead(activeLightSquad.get(randomTarget))){
                                    activeLightSquad.remove(randomTarget);
                                }
                                break;
                            case ATTACK_RANGED:
                                randomTarget = new Random().nextInt(activeLightSquad.size());
                                activeLightSquad.get(randomTarget).damageHealth(iterator.attackRange);
                                loggerWriteToTheConsole(iterator, activeLightSquad.get(randomTarget), iterator.attackRange);
                                if(isDead(activeLightSquad.get(randomTarget))){
                                    activeLightSquad.remove(randomTarget);
                                }
                                break;
                            case CAST_CURSE:
                                randomTarget = new Random().nextInt(activeLightSquad.size());
                                activeLightSquad.get(randomTarget).healt -= 0;
                                break;
                            case CAST_DISEASE:
                                randomTarget = new Random().nextInt(activeLightSquad.size());
                                activeLightSquad.get(randomTarget).healt -= 0;
                                break;
                            case CAST_MAGIC_DAMAGE:
                                randomTarget = new Random().nextInt(activeLightSquad.size());
                                activeLightSquad.get(randomTarget).damageHealth(iterator.castMagicDamage);
                                loggerWriteToTheConsole(iterator, activeLightSquad.get(randomTarget), iterator.castMagicDamage);
                                if(isDead(activeLightSquad.get(randomTarget))){
                                    activeLightSquad.remove(randomTarget);
                                }
                                break;
                            case CAST_PRIORITY:
                                randomTarget = new Random().nextInt(activeLightSquad.size());
                                activeLightSquad.get(randomTarget).healt -= 0;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Error occured while casting ability", "InfoBox: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
                                break;
                        }

                    }else{
                        if(iterator.isLight()){

                            switch(chosenAbility){
                                case ATTACK_MELEE:
                                    randomTarget = new Random().nextInt(activeDarkSquad.size());
                                    activeDarkSquad.get(randomTarget).damageHealth(iterator.attackMelee);
                                    loggerWriteToTheConsole(iterator, activeDarkSquad.get(randomTarget), iterator.attackMelee);
                                    if(isDead(activeDarkSquad.get(randomTarget))){
                                        activeDarkSquad.remove(randomTarget);
                                    }
                                    break;
                                case ATTACK_RANGED:
                                    randomTarget = new Random().nextInt(activeDarkSquad.size());
                                    activeDarkSquad.get(randomTarget).damageHealth(iterator.attackRange);
                                    loggerWriteToTheConsole(iterator, activeDarkSquad.get(randomTarget), iterator.attackRange);
                                    if(isDead(activeDarkSquad.get(randomTarget))){
                                        activeDarkSquad.remove(randomTarget);
                                    }
                                    break;
                                case CAST_MAGIC_DAMAGE:
                                    randomTarget = new Random().nextInt(activeDarkSquad.size());
                                    activeDarkSquad.get(randomTarget).damageHealth(iterator.castMagicDamage);
                                    loggerWriteToTheConsole(iterator, activeDarkSquad.get(randomTarget), iterator.castMagicDamage);
                                    if(isDead(activeDarkSquad.get(randomTarget))){
                                        activeDarkSquad.remove(randomTarget);
                                    }
                                    break;
                                case CAST_PRIORITY:
                                    activeDarkSquad.get(randomTarget).healt -= 0;
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Error occured while casting ability", "InfoBox: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                            }

                        }else{   
                            JOptionPane.showMessageDialog(null, "Error occured while taking an action", "InfoBox: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
                playOrder.poll();
                if(activeDarkSquad.isEmpty()) break;
                if(activeLightSquad.isEmpty()) break;
            }
            
            for(GameUnit iterator : activeLightSquad){
                System.out.println(iterator.toString());
            }

            System.out.println("");
            
            System.out.println("*******************************");

            for(GameUnit iterator : activeDarkSquad){
                System.out.println(iterator.toString());
            }
            
            System.out.println("");
            
            if(activeLightSquad.isEmpty()){
                System.out.println("DARK FORSES WON!!!");
                break;
            }else{if(activeDarkSquad.isEmpty()){
                    System.out.println("LIGHT FORSES WON!!!");
                    break;                
                }
            }

        }
    }
    
    private boolean isDead(GameUnit unitTested){
        return unitTested.healt <= 0;
    }
    
    private void loggerWriteToTheFile(){
        //TODO this method must write battle events into the file
    }
    
    private void loggerWriteToTheConsole(GameUnit attacker, GameUnit deffender, int damage){
        System.out.print(attacker.toString());
        System.out.print("Delt (" + damage + ") damage to ");
        System.out.print(deffender.toString() + "\n");
        System.out.println("-------------------------------------------");
    }
    
}