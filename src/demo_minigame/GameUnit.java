/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_minigame;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oleg
 */
class GameUnit {
    
    Enum className;
    List<Enum> abilitiesOfUnit = new ArrayList<>();
    int healt = 100;
    boolean priority = false;
    
    @Override
    public String toString(){
        return "[Unit type: " + className + "]";
    }
}
