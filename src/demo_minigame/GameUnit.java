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
    double attackMelee;
    double attackRange;
    double castMagicDamage;
    
    boolean priorityStatus = false;
    boolean curseStatus = false; //I have chose it to be an oposite to a priority (send to the end of the queue or, if present, dispell priority)
    boolean diseaseStatus = false; //I have chose to set disease on a one turn
    
    boolean lightTeam = false;
    boolean darkTeam = false;
    
    public GameUnit(Enum className, List<Enum> abilitiesOfUnit, int attackMelee, int attackRange, int castMagicDamage, boolean status){
        this.className = className;
        this.abilitiesOfUnit.addAll(abilitiesOfUnit);
        this.attackMelee = attackMelee;
        this.attackRange = attackRange;
        this.castMagicDamage = castMagicDamage;
        if(status){
            changeTeamStatusToLight();
        }else{
            changeTeamStatusToDark();
        }
    }
    
    public boolean isLight(){return lightTeam;}
    public boolean isDark(){return darkTeam;}
    
    @Override
    public String toString(){
        return className + "[HP: " + healt + "]";
    }
    
    public void damageHealth(double damage){
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
