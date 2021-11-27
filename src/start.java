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
public class start {
    
    public start() {
        int[] score={0,0,0}; //stores the score of the 3 players  

        for(int i=0;i<10;i++){ //there are 10 rounds in the game
            int[] points={0,0,0}; //store score in each round
            
            System.out.printf("\n♠   ♦   ♥   ♣   ♠   ♦   ♥   ♣   ♠   ♦   ROUND "+ (i+1)+"   ♠   ♦   ♥   ♣   ♠   ♦   ♥   ♣   ♠   ♦\n\n");
                       
            match Match = new match(); 
            points= Match.Dealer(); 
         
            System.out.println("\n♠   ♦   ♥   ♣   Score of Round " + (i+1)+"   ♠   ♦   ♥   ♣\n");
            
            for (int p=0;p<3;p++)//there are 3 players 
                if (p==0)
                     System.out.println("You : " +points[p]);
                 else
                    System.out.println("Player 0"+p+" : " +points[p]);
                        
            update(points,score);//updates the total score 
             
             
        }
      
       winner(score);//Select the winner after 10 rounds 
    }    
    
  private static void update(int points[],int[] score){//update score
   
     for(int i=0;i<3;i++)
        score[i] = score[i] + points[i]; //points of the current round are added to previous points 
  }
  
  private static void winner(int[] score){//Select winner
        
   System.out.println("\n♠   ♦   ♥   ♣   ♠   ♦   ♥   ♣   ♠   ♦   Final Score   ♠   ♦   ♥   ♣   ♠   ♦   ♥   ♣   ♠   ♦\n");
  
   for(int i=0;i<3;i++){
  if (i==0)
        System.out.println("You : " +score[i]);
   else
        System.out.println("Player "+0+i+" : " +score[i]);
   }
   
    List<String> winner=new ArrayList<>(); //when it's a draw 
    
    if(score[0]==score[1] && score[0]==score[2]){ //comparison to find the winner 
       winner.add("You");
       winner.add("Player 01");
       winner.add("Player 02");
    }
       
    else if (score[0]>=score[1]){
        
        if (score[0]==score[1] && score[0]>score[2]){
           winner.add("You");
           winner.add("Player 01");
        }
        
        else if (score[0]==score[1] && score[0]<score[2]){
            winner.add("Player 02");
        }
        
        else if (score[0]>score[2])
            winner.add("You");
    
        else if (score[0]<score[2])
            winner.add("Player 01");
    }
    
    else{ 
     
         if (score[1]==score[2]){
           winner.add("Player 01");
           winner.add("Player 02");
        }
        else if (score[1]>score[2])
            winner.add("Player 01");
         
        else if (score[1]<score[2])
            winner.add("Player 02"); 
      
   }
    
    System.out.println("\n♠   ♦   ♥   ♣   ♠   ♦   ♥   ♣   ♠   ♦   Winner of The Tournament   ♠   ♦   ♥   ♣   ♠   ♦   ♥   ♣   ♠   ♦");
    for (int i=0;i<winner.size();i++)        
    System.out.println("\n                                                  .__.\n" +
                       "                                                 (|  |)\n" +
                       "                                      "+winner.get(i)+"   (  )\n" +
                       "                                                  _)(_\n\n ");
        
  }
}
