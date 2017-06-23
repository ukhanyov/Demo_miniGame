/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_minigame;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Oleg
 */
public class ClashOfSquads {
    
    Deque<GameUnit> playOrder = new ArrayDeque<>();
    int[] sequence = ThreadLocalRandom.current().ints(0, 16).distinct().limit(16).toArray();
    Random random; //variable responsible of chosing the target
    
    public ClashOfSquads(){
        GenerateSquads newSquads = new GenerateSquads();
    }
    
    private void generateQueue(){
        //TODO this method generates primary queue of events
        //playOrder.add();
    }
    
    private void actionActionAction(){
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