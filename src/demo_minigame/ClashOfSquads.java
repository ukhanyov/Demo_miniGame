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

/**
 *
 * @author Oleg
 */
public class ClashOfSquads {
    
    Deque<GameUnit> playOrder = new ArrayDeque<>();
    List<GameUnit> generalList = new ArrayList<>();
    Random random; //variable responsible of chosing the target
    
    public ClashOfSquads(){
        GenerateSquads newSquads = new GenerateSquads();
        generalList.addAll(newSquads.lightSquad);
        generalList.addAll(newSquads.darkSquad);
    }
    
    private void generateQueue(){
        
        playOrder.clear();
        
        int[] sequence = ThreadLocalRandom.current().ints(0, 16).distinct().limit(16).toArray();
        
        for(int i = 0; i < 16; i++){
            playOrder.add(generalList.get(sequence[i]));
        }
    }
    
    public void actionActionAction(){
        generateQueue();
        //TODO this method is resposible of course of battle
    }
    
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