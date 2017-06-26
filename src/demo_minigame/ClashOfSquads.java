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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;

/**
 *
 * @author Oleg
 */
public class ClashOfSquads {
    
    Deque<GameUnit> playOrder = new ArrayDeque<>();
    Deque<GameUnit> priorityDeque = new ArrayDeque<>();
    
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

    LocalDateTime loggLocalDateTime;
    
    public ClashOfSquads(){

        loggLocalDateTime = LocalDateTime.now();
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
    
    private void useAbility(GameUnit unit, List<GameUnit> unitsTeam, List<GameUnit> enemyTeam, UnitAbilities chosenAbility){
        
        int randomTarget;
        
        switch(chosenAbility){
            
            case ATTACK_MELEE:
                randomTarget = new Random().nextInt(enemyTeam.size());
                if(unit.priorityStatus && priorityDeque.contains(unit)){ 
                    enemyTeam.get(randomTarget).damageHealth(unit.attackMelee * 1.5);
                    loggerWriteToTheConsole(unit, enemyTeam.get(randomTarget), ATTACK_MELEE_P, unit.attackMelee * 1.5);
                }
                else{ 
                    enemyTeam.get(randomTarget).damageHealth(unit.attackMelee);
                    loggerWriteToTheConsole(unit, enemyTeam.get(randomTarget), ATTACK_MELEE, unit.attackMelee);
                }
                if(isDead(enemyTeam.get(randomTarget))){
                    loggerWriteToTheFile("----->UNIT DIED: " + enemyTeam.get(randomTarget) + "\n");
                    System.out.println("----->UNIT DIED: " + enemyTeam.get(randomTarget));
                    enemyTeam.remove(randomTarget);
                }
                break;
                
            case ATTACK_RANGED:
                randomTarget = new Random().nextInt(enemyTeam.size());
                if(unit.priorityStatus && priorityDeque.contains(unit)){ 
                    enemyTeam.get(randomTarget).damageHealth(unit.attackRange * 1.5);
                    loggerWriteToTheConsole(unit, enemyTeam.get(randomTarget), ATTACK_RANGED_P, unit.attackRange * 1.5);
                }
                else{ 
                    enemyTeam.get(randomTarget).damageHealth(unit.attackRange);
                    loggerWriteToTheConsole(unit, enemyTeam.get(randomTarget), ATTACK_RANGED, unit.attackRange);
                }
                if(isDead(enemyTeam.get(randomTarget))){
                    loggerWriteToTheFile("----->UNIT DIED: " + enemyTeam.get(randomTarget) + "\n");
                    System.out.println("----->UNIT DIED: " + enemyTeam.get(randomTarget));
                    enemyTeam.remove(randomTarget);
                }
                break;
                
            case CAST_CURSE:
                randomTarget = new Random().nextInt(enemyTeam.size());
                enemyTeam.get(randomTarget).priorityStatus = false;
                loggerWriteToTheConsole(unit, enemyTeam.get(randomTarget), CAST_CURSE, 0);
                break;
                
            case CAST_DISEASE:
                randomTarget = new Random().nextInt(enemyTeam.size());
                enemyTeam.get(randomTarget).diseaseStatus = true;
                loggerWriteToTheConsole(unit, enemyTeam.get(randomTarget), CAST_DISEASE, 0);
                break;
                
            case CAST_MAGIC_DAMAGE:
                randomTarget = new Random().nextInt(enemyTeam.size());
                if(unit.priorityStatus && priorityDeque.contains(unit)){ 
                    enemyTeam.get(randomTarget).damageHealth(unit.castMagicDamage * 1.5);
                    loggerWriteToTheConsole(unit, enemyTeam.get(randomTarget), CAST_MAGIC_DAMAGE_P, unit.castMagicDamage * 1.5);                }
                else{ 
                    enemyTeam.get(randomTarget).damageHealth(unit.castMagicDamage);
                    loggerWriteToTheConsole(unit, enemyTeam.get(randomTarget), CAST_MAGIC_DAMAGE, unit.castMagicDamage);
                }
                if(isDead(enemyTeam.get(randomTarget))){
                    loggerWriteToTheFile("----->UNIT DIED: " + enemyTeam.get(randomTarget) + "\n");
                    System.out.println("----->UNIT DIED: " + enemyTeam.get(randomTarget));
                    enemyTeam.remove(randomTarget);
                }
                break;
                
            case CAST_PRIORITY:
                randomTarget = new Random().nextInt(unitsTeam.size());
                loggerWriteToTheConsole(unit, unitsTeam.get(randomTarget), CAST_PRIORITY, 0);
                if(unitsTeam.get(randomTarget).priorityStatus == false){
                    unitsTeam.get(randomTarget).priorityStatus = true;
                }
                break;
                
            default:
                    JOptionPane.showMessageDialog(null, "Error occured while casting ability", "InfoBox: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
    
    public void actionActionAction(){
        
        loggerWriteToTheFile("*********************************");
        loggerWriteToTheFile("The Light team is:\n");
        loggerWriteToTheFile("\n");
        System.out.println("*********************************");
        System.out.println("The Light team is:\n");
        
        for(GameUnit iterator : activeLightSquad){
            loggerWriteToTheFile(iterator.toString());
            System.out.println(iterator.toString());
        }
        
        loggerWriteToTheFile("*********************************");
        loggerWriteToTheFile("The Dark team is: \n");
        loggerWriteToTheFile("\n");
        System.out.println("*********************************");
        System.out.println("The Dark team is:\n");
        
        
        for(GameUnit iterator : activeDarkSquad){
            loggerWriteToTheFile(iterator.toString());
            System.out.println(iterator.toString());
        }
        
        loggerWriteToTheFile("*********************************");
        System.out.println("*********************************");
        
        while(true){

            generateQueue();
            
            loggerTurnDisplayer(numberOfRounds);
            
            if(!priorityDeque.isEmpty()){
                
                loggerWriteToTheFile(">----------Start of Priority rond----------<\n");
                System.out.println(">----------Start of Priority rond----------<");
                
                for(GameUnit iterator : priorityDeque){
                        if(iterator.priorityStatus){
                        performAllNecessaryChecksAnsStepsForCurrentUnit(iterator);
                        iterator.priorityStatus = false;
                        priorityDeque.poll();
                        if(activeDarkSquad.isEmpty()) break;
                        if(activeLightSquad.isEmpty()) break;
                    }else{
                        priorityDeque.poll();
                    }
                }
                
                loggerWriteToTheFile(">----------End   of Priority rond---------<\n");
                System.out.println(">----------End   of Priority rond---------<");
            }
            
            if(activeLightSquad.isEmpty()){ 
                loggerWriteToTheFile("DARK FORSES WON!!!");
                System.out.println("DARK FORSES WON!!!"); break;}
            if(activeDarkSquad.isEmpty()){ 
                loggerWriteToTheFile("LIGHT FORSES WON!!!");
                System.out.println("LIGHT FORSES WON!!!"); break;}

            for(GameUnit iterator : playOrder){
                performAllNecessaryChecksAnsStepsForCurrentUnit(iterator);
                playOrder.poll();
                if(activeDarkSquad.isEmpty()) break;
                if(activeLightSquad.isEmpty()) break;
            }
            
            for(GameUnit iterator : generalList){
                if(iterator.priorityStatus){
                    priorityDeque.add(iterator);
                }
            }
            
            if(activeLightSquad.isEmpty()){ 
                loggerWriteToTheFile("DARK FORSES WON!!!");
                System.out.println("DARK FORSES WON!!!"); break;}
            if(activeDarkSquad.isEmpty()){ 
                 loggerWriteToTheFile("LIGHT FORSES WON!!!");
                System.out.println("LIGHT FORSES WON!!!"); break;}
            
            numberOfRounds++;
        }
        
        loggerWriteToTheFile("*********************************");
        System.out.println("*********************************");
        
        if(!activeLightSquad.isEmpty()){
            loggerWriteToTheFile("Winning team:\n");
            System.out.println("Winning team:");
            for(GameUnit iterator : activeLightSquad){
                loggerWriteToTheFile(iterator.toString()+ "\n");
                System.out.println(iterator.toString());
            }
        }
        
        loggerWriteToTheFile("*********************************");
        System.out.println("*********************************");
        
        if(!activeDarkSquad.isEmpty()){
            loggerWriteToTheFile("Winning team:\n");
            System.out.println("Winning team:");
            for(GameUnit iterator : activeDarkSquad){
                loggerWriteToTheFile(iterator.toString()+ "\n");
                System.out.println(iterator.toString());
            }
        }

        loggerWriteToTheFile("*********************************");
        System.out.println("*********************************");
        
    }
    
    private void performAllNecessaryChecksAnsStepsForCurrentUnit(GameUnit iterator){
        UnitAbilities chosenAbility = (UnitAbilities) iterator.abilitiesOfUnit.get(new Random().nextInt(iterator.abilitiesOfUnit.size()));
                applyDisease(iterator);
                if(!isDead(iterator)){
                    if(iterator.isDark()){
                        useAbility(iterator, activeDarkSquad, activeLightSquad, chosenAbility);
                    }
                    if(iterator.isLight()){
                        useAbility(iterator, activeLightSquad, activeDarkSquad, chosenAbility);
                    }
                }       
        freeFromDisease(iterator);
    }
    
    //Disease cuts damage
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
    
    private void loggerWriteToTheFile(String infoToLog){
        
        String specifiedPath = "logFile " + loggLocalDateTime.toString() + ".txt";
        try(FileWriter fw = new FileWriter(specifiedPath.replace(':', '-'), true);
            BufferedWriter writer = new BufferedWriter(fw)){
            writer.write(infoToLog);
            writer.newLine();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString(), "InfoBox at main method: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void loggerWriteToTheConsole(GameUnit attacker, GameUnit deffender, Enum skill, double damage){
        if(attacker.diseaseStatus){
            String infoToLog = String.format("|%-30s|->|%-20s|->|%-5s*|->|%-30s|", attacker.toString(), skill, damage, deffender.toString());
            System.out.println(infoToLog);
            loggerWriteToTheFile(infoToLog+ "\n");
        }else{
            String infoToLog = String.format("|%-30s|->|%-20s|->|%-6s|->|%-30s|", attacker.toString(), skill, damage, deffender.toString());
            System.out.println(infoToLog);
            loggerWriteToTheFile(infoToLog + "\n");
        }
    }
    
    private void loggerTurnDisplayer(int numberOfRounds){
        loggerWriteToTheFile("***************" + numberOfRounds + "***************");
        System.out.println("***************" + numberOfRounds + "***************");
    }
    
}