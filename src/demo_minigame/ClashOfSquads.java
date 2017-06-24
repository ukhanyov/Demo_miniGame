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
import static demo_minigame.UnitAbilities.*;

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
    
    double priorMeleeDamage;
    double priorRangeDamage;
    double priorMagicDamage;
    GameUnit targetPriorityUnit;
    int numberOfRounds = 1;
    
    public ClashOfSquads(){

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
    
    private void performAction(GameUnit unit, List<GameUnit> unitsTeam, List<GameUnit> enemyTeam, UnitAbilities chosenAbility){
        
        int randomTarget = 0;
        
        switch(chosenAbility){
            
            case ATTACK_MELEE:
                randomTarget = new Random().nextInt(enemyTeam.size());
                enemyTeam.get(randomTarget).damageHealth(unit.attackMelee);
                loggerWriteToTheConsole(unit, enemyTeam.get(randomTarget), ATTACK_MELEE, unit.attackMelee);
                if(isDead(enemyTeam.get(randomTarget))){
                    System.out.println("->UNIT DIED: " + enemyTeam.get(randomTarget));
                    enemyTeam.remove(randomTarget);
                }
                break;
                
            case ATTACK_RANGED:
                randomTarget = new Random().nextInt(enemyTeam.size());
                enemyTeam.get(randomTarget).damageHealth(unit.attackRange);
                loggerWriteToTheConsole(unit, enemyTeam.get(randomTarget), ATTACK_RANGED, unit.attackRange);
                if(isDead(enemyTeam.get(randomTarget))){
                    System.out.println("->UNIT DIED: " + enemyTeam.get(randomTarget));
                    enemyTeam.remove(randomTarget);
                }
                break;
                
            case CAST_CURSE:
                randomTarget = new Random().nextInt(enemyTeam.size());
                enemyTeam.get(randomTarget).curseStatus = true;
                loggerWriteToTheConsole(unit, enemyTeam.get(randomTarget), CAST_CURSE, 0);
                if(isDead(enemyTeam.get(randomTarget))){
                    System.out.println("->UNIT DIED: " + enemyTeam.get(randomTarget));
                    enemyTeam.remove(randomTarget);
                }
                break;
                
            case CAST_DISEASE:
                randomTarget = new Random().nextInt(enemyTeam.size());
                enemyTeam.get(randomTarget).diseaseStatus = true;
                loggerWriteToTheConsole(unit, enemyTeam.get(randomTarget), CAST_DISEASE, 0);
                if(isDead(enemyTeam.get(randomTarget))){
                    System.out.println("->UNIT DIED: " + enemyTeam.get(randomTarget));
                    enemyTeam.remove(randomTarget);
                }
                break;
                
            case CAST_MAGIC_DAMAGE:
                randomTarget = new Random().nextInt(enemyTeam.size());
                enemyTeam.get(randomTarget).damageHealth(unit.castMagicDamage);
                loggerWriteToTheConsole(unit, enemyTeam.get(randomTarget), CAST_MAGIC_DAMAGE, unit.castMagicDamage);
                if(isDead(enemyTeam.get(randomTarget))){
                    System.out.println("->UNIT DIED: " + enemyTeam.get(randomTarget));
                    enemyTeam.remove(randomTarget);
                }
                break;
                
            case CAST_PRIORITY:
                randomTarget = new Random().nextInt(unitsTeam.size());
                unitsTeam.get(randomTarget).priorityStatus = true;
                loggerWriteToTheConsole(unit, unitsTeam.get(randomTarget), CAST_PRIORITY, 0);
                targetPriorityUnit = unitsTeam.get(randomTarget);
                break;
                
                default:
                    JOptionPane.showMessageDialog(null, "Error occured while casting ability", "InfoBox: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
    
    public void actionActionAction(){
        
        System.out.println("*********************************");
        for(GameUnit iterator : activeLightSquad){
                System.out.println(iterator.toString());
        }
        System.out.println("*********************************");
        for(GameUnit iterator : activeDarkSquad){
                System.out.println(iterator.toString());
        }
        System.out.println("*********************************");
        
        while(true){

            generateQueue();

            for(GameUnit iterator : playOrder){
                
                UnitAbilities chosenAbility = (UnitAbilities) iterator.abilitiesOfUnit.get(new Random().nextInt(iterator.abilitiesOfUnit.size()));
                applyDisease(iterator);
                
                if(!isDead(iterator)){
                    if(iterator.isDark()){
                        performAction(iterator, activeDarkSquad, activeLightSquad, chosenAbility);
                    }
                    if(iterator.isLight()){
                        performAction(iterator, activeLightSquad, activeDarkSquad, chosenAbility);
                    }
                }
                
                freeFromDisease(iterator);                
                playOrder.poll();
                
                if(chosenAbility == CAST_PRIORITY){              
                    for(GameUnit priorityIterator : playOrder){
                        playOrder.peek();
                        if(priorityIterator.priorityStatus){
                            priorityIterator.priorityStatus = false;
                            playOrder.poll();
                            playOrder.addFirst(targetPriorityUnit);
                            targetPriorityUnit = null;
                            break;
                        }
                    }
                }
                
                if(activeDarkSquad.isEmpty()) break;
                if(activeLightSquad.isEmpty()) break;
            }
            
            numberOfRounds++;
            loggerTurnDisplayer(numberOfRounds);
            
            if(activeLightSquad.isEmpty()){ System.out.println("DARK FORSES WON!!!"); break;}
            if(activeDarkSquad.isEmpty()){ System.out.println("LIGHT FORSES WON!!!"); break;} 
        }
        
        System.out.println("*********************************");
        for(GameUnit iterator : activeLightSquad){
                System.out.println(iterator.toString());
        }
        System.out.println("*********************************");
        for(GameUnit iterator : activeDarkSquad){
                System.out.println(iterator.toString());
        }
        System.out.println("*********************************");
        
    }
    
    private void applyDisease(GameUnit iterator){
        if(iterator.diseaseStatus){
            priorMeleeDamage = iterator.attackMelee;
            priorRangeDamage = iterator.attackRange;
            priorMagicDamage = iterator.castMagicDamage;
                    
            iterator.attackMelee = priorMeleeDamage / 2.0;
            iterator.attackRange = priorRangeDamage / 2.0;
            iterator.castMagicDamage = priorMagicDamage / 2.0;
        }
    }
    
    private void freeFromDisease(GameUnit iterator){
        if(iterator.diseaseStatus){
            iterator.diseaseStatus = false;
            iterator.attackMelee = priorMeleeDamage;
            iterator.attackRange = priorRangeDamage;
            iterator.castMagicDamage = priorMagicDamage;
        }
    }
    
    private boolean isDead(GameUnit unitTested){
        return unitTested.healt <= 0;
    }
    
    private void loggerWriteToTheFile(){
        //TODO this method must write battle events into the file
    }
    
    private void loggerWriteToTheConsole(GameUnit attacker, GameUnit deffender, Enum skill, double damage){
        if(attacker.diseaseStatus){
            System.out.printf("|%-30s|->|%-20s|->|%-4s*|->|%-30s|\n", attacker.toString(), skill, damage, deffender.toString());
        }else{
            System.out.printf("|%-30s|->|%-20s|->|%-5s|->|%-30s|\n", attacker.toString(), skill, damage, deffender.toString());
        }
    }
    
    private void loggerTurnDisplayer(int numberOfRounds){
        System.out.println("***************" + numberOfRounds + "***************");
    }
    
}