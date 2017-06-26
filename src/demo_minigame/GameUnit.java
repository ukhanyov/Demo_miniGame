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
    boolean diseaseStatus = false; //I have chose to set disease on a one turn
    
    boolean lightTeam = false;
    boolean darkTeam = false;
    
    
    /**
     * Constructor of the Game Unit
     * 
     * @param className is chosen from enum list of pre established names, which are in the class UnitNames
     * @param abilitiesOfUnit list of abilities, which unit possess, list is formed by the abilities from enum class UnitAbilities
     * @param attackMelee sets units strength in melee combat
     * @param attackRange sets units strength in range combat
     * @param castMagicDamage sets units strength of magic damage
     * @param status 
     */
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
    
    /**
     * Returns true, is unit belongs to the team of Light
     * 
     * @return 
     */
    public boolean isLight(){return lightTeam;}
    
    /**
     * Returns true, is unit belongs to the team of Dark
     * 
     * @return 
     */
    public boolean isDark(){return darkTeam;}
    
    @Override
    public String toString(){
        return className + "[HP: " + healt + "]";
    }
    
    
    /**
     * Reduces health of the unit on a specified number
     * 
     * @param damage Specify amount of damage taken by the unit
     */
    public void damageHealth(double damage){
        healt -= damage;
    }
    
    /**
     * Sets unit's allegiance to the Light team 
     * 
     */
    protected void changeTeamStatusToLight(){
        lightTeam = true;
        darkTeam = false;
    }
    
    /**
     * Sets unit's allegiance to the Dark team 
     * 
     */
    protected void changeTeamStatusToDark(){
        lightTeam = false;
        darkTeam = true;
    }
}
