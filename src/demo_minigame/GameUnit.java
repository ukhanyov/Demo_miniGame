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
    int attackMelee;
    int attackRange;
    int castMagicDamage;
    boolean priority = false;
    boolean lightTeam = false;
    boolean darkTeam = false;
    
    public GameUnit(Enum className, List<Enum> abilitiesOfUnit, int attackMelee, int attackRange, int castMagicDamage){
        this.className = className;
        this.abilitiesOfUnit.addAll(abilitiesOfUnit);
        this.attackMelee = attackMelee;
        this.attackRange = attackRange;
        this.castMagicDamage = castMagicDamage;
    }
    
    public boolean isLight(){return lightTeam;}
    public boolean isDark(){return darkTeam;}
    
    @Override
    public String toString(){
        return "[Unit type: " + className + "]" + "[Current health: " + healt + "]";
    }
    
    public void damageHealth(int damage){
        healt -= damage;
    }
    
    protected void changeTeamStatusToLight(){
        lightTeam = true;
        darkTeam = false;
    }
    
    protected void changeTeamStatusToDark(){
        lightTeam = false;
        darkTeam = true;
    }
}
