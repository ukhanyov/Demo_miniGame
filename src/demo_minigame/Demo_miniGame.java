/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_minigame;

import javax.swing.JOptionPane;

/**
 *
 * @author Oleg
 */

public class Demo_miniGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ClashOfSquads squad = new ClashOfSquads();
        try{
            squad.actionActionAction();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString(), "InfoBox at main method: " + "Error Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
