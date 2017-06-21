/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_minigame;

import java.util.Random;

/**
 *
 * @author Oleg
 */
public class ClashOfSquads {
    
    //TODO initialize two deque(s)
    Random randomTagret; //variable responsible of chosing the target
    
    public ClashOfSquads(){
        GenerateSquad newSquad = new GenerateSquad();
    }
    
    private void generateQueue(){
        //TODO this method generates primary queue of events
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