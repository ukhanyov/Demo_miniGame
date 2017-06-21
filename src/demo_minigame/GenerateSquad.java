/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_minigame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Oleg
 */
public class GenerateSquad {
    
    Random random = new Random();
    
    List<GameUnit> lightSquad = new ArrayList<>();
    List<GameUnit> darkSquad = new ArrayList<>();
    
    public GenerateSquad(){
        lightSquad.add(new LightMage(random.nextInt(2)));
        
        lightSquad.add(new LightRange(random.nextInt(2)));
        lightSquad.add(new LightRange(random.nextInt(2)));
        lightSquad.add(new LightRange(random.nextInt(2)));
        
        lightSquad.add(new LightMelee(random.nextInt(2)));
        lightSquad.add(new LightMelee(random.nextInt(2)));
        lightSquad.add(new LightMelee(random.nextInt(2)));
        lightSquad.add(new LightMelee(random.nextInt(2)));
        
        darkSquad.add(new DarkMage(random.nextInt(2)));
        
        darkSquad.add(new DarkRange(random.nextInt(2)));
        darkSquad.add(new DarkRange(random.nextInt(2)));
        darkSquad.add(new DarkRange(random.nextInt(2)));
        
        darkSquad.add(new DarkMelee(random.nextInt(2)));
        darkSquad.add(new DarkMelee(random.nextInt(2)));
        darkSquad.add(new DarkMelee(random.nextInt(2)));
        darkSquad.add(new DarkMelee(random.nextInt(2)));
    }
}
