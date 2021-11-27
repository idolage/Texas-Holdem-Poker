/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author IsoraDolage
 */
public class player {
    private String player_name;
    private List<card> player_hand;
    
    enum Ranks {High_Card,One_Pair,Two_Pair,Three_Of_A_Kind,Straight,Flush,Full_House,Four_Of_A_Kind,Straight_Flush,Royal_Flush}
    
    Ranks rank = null;
    private List<card> rankList = null;
    
    public player(){} //Default constructor
   
    public player(String name) { //parameterized constructor
        this.player_name = name;
        player_hand = new ArrayList<>();
    }
    
    public Ranks getRank() {
		return rank;
    }

    public void setRank(Ranks rank) {
		this.rank = rank;
    }

    public List<card> getRankList() {
		return rankList;
    }

    public void setRankList(List<card> rankList) {
		this.rankList = rankList;
     }
    
    public  List<card> getHand(){
        return player_hand;
    }
    
    public void setHand(List<card> hand) {
        this.player_hand = hand;
    }
    
    @Override public String toString() {
        return player_name;
    }
}
