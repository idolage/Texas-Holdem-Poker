/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author IsoraDolage
 */
public class card {
    
    public enum Suits {
    DIAMONDS, CLUBS, HEARTS, SPADES
    }
    
    private int value;
    private Suits suit;
    
    public card(int value, Suits suit) { //parameterized constructor
        this.value = value;
        this.suit = suit;
    }
    public Suits getSuit() { //return the suit
        return suit;
    }
    public int getFaceValue() { //return the face value 
        return value;
    }
    @Override public String toString() { //return card stat 
        String face = null;
        switch (value){
            case 14: face = "ACE";break;
            case 13: face = "KING"; break;
            case 12: face = "QUEEN"; break;
            case 11: face = "JACK"; break;
            default: face = String.valueOf(value); break;
        }        
        String suitString = suit.toString(); //get the suit
        
        return face + " OF " + suitString;
    }
}
