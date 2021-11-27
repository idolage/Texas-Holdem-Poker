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
public class match {
    enum dealerCards{FLOP, TURN, RIVER;}
    
    private static List<card> ComCards;
    private List<player> players;
    private deck deck;
    

    public match() { //default constructor 
        players = new ArrayList<>();
        createPlayers();
        deck = new deck();
    }
    
    private void createPlayers() { //3 players 
            players.add(new player("User"));
            players.add(new player("Player 01"));
            players.add(new player("Player 02"));            
    }
    
    public int[] Dealer() {
        deck.shuffle(); //shuffle the card pack
        dealCards();
               
        System.out.println("Your Cards : " + players.get(0).getHand());
       
        if (discardHand()==true)// will return true if the user decides to discard the hand before finising one round
            players.remove(0); //user is removed from playerlist
               
        showHand(players); //other 2 players show their hands
        int[] points= score(players); //get the point of each player at end of a round 
        return points; 
    }
    
    private void dealCards() {
        for (player next : players) {
            next.setHand(deck.deal(2)); 
        }
    }
    
    private static void showHand(List<player> players){//showdown       
    
      System.out.println("\n♠   ♦   ♥   ♣   THE SHOWDOWN   ♠   ♦   ♥   ♣"); //remaining players participate in the showdown
      
      for(int i=0;i<players.size();i++){
         System.out.print("\n"+players.get(i).toString()+ " : ");
         System.out.println(players.get(i).getHand());      
      }
      
      System.out.println("\n♠   ♦   ♥   ♣   Poker Hands of Players   ♠   ♦   ♥   ♣");//prints poker hand of each player
      
      for(int i=0;i<players.size();i++){
         System.out.print ("\n"+players.get(i).toString()+" : ");
         System.out.println(players.get(i).getRank().name());
        }
    }
        
    private int[] score( List<player> players){//gets the score of each player at end of a round 
      int [] points ={0,0,0}; 
      player.Ranks pokerHand; //score is updated according to the rank
      int playerID;//User's pid - 0 ; other two player - 1 & 2  
      
      for(int i=0;i<players.size();i++){
          playerID=i;
          
          if(players.size()==2){//If user has discard his hand at one of the stages
              pokerHand=players.get(playerID).getRank(); //get the poker hand of the player
              playerID=i+1;
          }
          else
            pokerHand=players.get(playerID).getRank();
         
           switch(pokerHand){//Poker hands are assigned different points (Source: https://en.wikipedia.org/wiki/Chicago_(poker_card_game)
               case Royal_Flush : points[playerID]+=20;break;
               case Straight_Flush :points[playerID]+=10;break;
               case Four_Of_A_Kind :points[playerID]+=8;break;
               case Full_House:points[playerID]+=7;break;
               case Flush:points[playerID]+=6;break;
               case Straight:points[playerID]+=5;break;
               case Three_Of_A_Kind:points[playerID]+=4;break;
               case Two_Pair:points[playerID]+=3;break;
               case One_Pair:points[playerID]+=2;break;
               case High_Card:points[playerID]+=1;break;
           }
      }
      return points;
    }    
     
    private Boolean discardHand() { //start round         
        ComCards = new ArrayList<>(); //Arraylist to store the community cards
        Boolean discard=false;
        char choice;
        
        Scanner scanner= new Scanner(System.in);        
        
        for (dealerCards next : dealerCards.values()) { //flop,turn,river 
       
            if (next.equals(dealerCards.FLOP)) {//FLOP
                ComCards.addAll(deck.deal(3));
                System.out.println("\n\n♠   ♦   ♥   ♣   THE FLOP   ♠   ♦   ♥   ♣\n");
                for (int c=0;c<3;c++) 
                   System.out.println("Card "+0+(c+1)+" : "+ComCards.get(c).toString()+" "); //first 3 community cards                
               
                System.out.print("\nWill you discard the hand? Enter 'Y' or 'y' to discard or any other key to keep the cards:  ");//player decides whether continuing or not 
                choice=scanner.next().charAt(0);
                if (choice=='Y' || choice=='y')//player discards hand 
                   discard=true;
            }          
            
            else if (next.equals(dealerCards.TURN)) {//TURN
                ComCards.addAll(deck.deal(1));
                System.out.println("\n\n♠   ♦   ♥   ♣   THE TURN   ♠   ♦   ♥   ♣\n");
                System.out.println("Card "+0+(3+1)+" : "+ComCards.get(3).toString()); //the 4th community card
                
                if(discard==false){  
                System.out.print("\nWill you discard the hand? Enter 'Y' or 'y' to discard or any other key to keep the cards: ");
                choice=scanner.next().charAt(0);
                if (choice=='Y' || choice=='y')
                   discard=true;
                }
            }            
            
            else if (next.equals(dealerCards.RIVER)) {//RIVER
                ComCards.addAll(deck.deal(1));
                System.out.println("\n\n♠   ♦   ♥   ♣   THE RIVER   ♠   ♦   ♥   ♣\n");
                System.out.println("Card "+0+(4+1)+" : "+ComCards.get(4).toString()+"\n");//the 5th community card
                
                if(discard==false){
                        System.out.print("\nWill you discard the hand? Enter 'Y' or 'y' to discard or any other key to keep the cards: "); 
                         choice=scanner.next().charAt(0);
                        if (choice=='Y' || choice=='y')
                          discard=true;
                } 
            }
        }
              
       getPokerHand(players.get(0));
       getPokerHand(players.get(1));
       getPokerHand(players.get(2));
    
        return discard; //return false-player keeps the hand ;true- player discarded the hand
    }
    
    private static void setHandStats(player player, List<card> rankingList,player.Ranks rankingEnum) {//set the rank and the poker hand of the player
		player.setRank(rankingEnum);//set the rank 
		player.setRankList(rankingList); //set the poker hand
	}
    
    private void getPokerHand(player p) {//Determine the poker hand of each player
       List<card> hand = new ArrayList<card>();
       hand.addAll(ComCards);
       hand.add(p.getHand().get(0));
       hand.add(p.getHand().get(1));       
      
       card topCard=getTopCard(hand);//get the highest card in the hand
         
       List<card> rankList = getRoyalFlush(p);//for Royal_Flush poker hand
       if (rankList!=null){ //set the rank accordingly
          setHandStats(p, rankList, player.Ranks.Royal_Flush); 
	  return;
       }
         
       rankList = getStraightFlush(p);//for Straight_Flush poker hand
       if (rankList != null) {
	   setHandStats(p, rankList, player.Ranks.Straight_Flush);
	   return;
	}
	
       rankList = getFourOfAKind(p);//for Four_Of_A_Kind poker hand
       if (rankList != null) {
           setHandStats(p, rankList, player.Ranks.Four_Of_A_Kind);
	   return;	
	}
	
       rankList = getFullHouse(p);//for Full_House poker hand
       if (rankList != null) {
	  setHandStats(p, rankList, player.Ranks.Full_House);
	  return;
	}
        
       rankList = getFlush(p);//for Flush poker hand
       if (rankList != null) {
           setHandStats(p, rankList, player.Ranks.Flush);
	   return;	
	}
	
       rankList = getStraight(p);//for Straight poker hand
       if (rankList != null) {
            setHandStats(p, rankList, player.Ranks.Straight);
	    return;	
	}
	
       rankList = getThreeOfAKind(p);//for Three_Of_A_Kind poker hand
       if (rankList != null) {
            setHandStats(p, rankList, player.Ranks.Three_Of_A_Kind);
	    return;		
	}
	
       rankList = getTwoPair(p);//for Two_Pair poker hand
       if (rankList != null) {
            setHandStats(p, rankList, player.Ranks.Two_Pair);
	    return;
	}
	
       rankList = getOnePair(p);//for One_Pair poker hand
       if (rankList != null) {
             setHandStats(p, rankList, player.Ranks.One_Pair);
	     return;	
	}       
        
	p.setRank(player.Ranks.High_Card); //for High_Card        
	List<card> topRankedList = new ArrayList<card>();
	topRankedList.add(topCard);
	p.setRankList(topRankedList); //set the poker hand
        
        return;   
    }
    
    private static List<card> getRoyalFlush(player p) {//Five cards of the same suit
      List<card> hand = combine(p); 
      List<card> RoyalFlushCards = new ArrayList<card>(); //to store the cards ranked A to 10

       int count=0;
       for (int j=0;j<hand.size();j++){
           card card=hand.get(j);
          if (card.getFaceValue()==10 || card.getFaceValue()==11|| card.getFaceValue()==12|| card.getFaceValue()==13||card.getFaceValue()==14){
               int val=card.getFaceValue(); //save card value
               count++;
               RoyalFlushCards.add(card); //add to the arraylist
               
               for (int i=0;i<hand.size();i++){
                   if(hand.get(i).getFaceValue()== val && !hand.isEmpty())
                       hand.remove(i);    
               }
            }
       }      
       if (count==5){//there should be 5 cards 
           if (sameSuit(RoyalFlushCards)==true)
                return RoyalFlushCards; //return poker hand
           else
               return null;
       }       
       else
           return null;
    }
    
    private static List<card> getStraightFlush(player p) {//Five consecutively ranked cards of the same suit
        List<card> hand = combine(p); 
	return getSequence(hand, true, 5);
    }
    
    private static List<card> getFourOfAKind(player p) {//Four cards having the same face value
       List<card> hand = combine(p); 
       return comparison(4,hand);
    }
    
    private static List<card> getFullHouse(player p) {// Three cards of the same rank and two more cards of the same rank
        List<card> hand = combine(p); 
        List<card> list1 = comparison(3,hand);		
                if (list1 != null) {             
			hand.removeAll(list1);
			List<card> list2 = comparison(2,hand); //a list of pairs having the same face value or null
			if (list2 != null) {
				list1.addAll(list2);
				return list1;
			}
		}
		return null;
    }
    
    private static List<card> getFlush(player p) { //Five cards of the same suit 
            List<card> hand = combine(p); 
            List<card> FlushList = new ArrayList<card>();
		for (card card1 : hand) {
			for (card card2 : hand) {
				if (card1.getSuit().equals(card2.getSuit())) { //add to the list if the suits are same
					if (!FlushList.contains(card1)) {
						FlushList.add(card1);
					}
					if (!FlushList.contains(card2)) {
						FlushList.add(card2);
					}
				}
			}
			if (FlushList.size() == 5) {
				return FlushList;
			}
			FlushList.clear();
		}
		return null;
    }    
    
    private static List<card> getStraight(player p) {//Five cards consecutively ranked
           List<card> hand = combine(p); 
           return getSequence(hand, false, 5);
    }   
    
    public static List<card> getThreeOfAKind(player p) {//Three cards with the same face value 
        List<card> hand = combine(p); 
        return comparison(3,hand); 
    }
    
    private static List<card> getTwoPair(player p) {//Two pais with same face value
                List<card> hand = combine(p); 
                List<card> pair1 = comparison(2,hand);  //check whether 2 cards have the same face value
		if (pair1 != null) {
			hand.removeAll(pair1); //remove those 2 cards
			List<card> pair2 = comparison(2,hand); //check again for another pair 
			if (pair2 != null) {
				pair1.addAll(pair2);//combine those 2 pairs 
				return pair1;
                        }
		}
		return null;	
    }
    
    public static List<card> getOnePair(player p) {//single pair with same face value 
            List<card> hand = combine(p); 
            return comparison(2,hand);
    }
    
    private static List<card> combine(player p){
       List<card> hand = new ArrayList<card>();
       hand.addAll(ComCards);
       hand.add(p.getHand().get(0));
       hand.add(p.getHand().get(1));
       return hand;
    }
    private static List<card> comparison(Integer size, List<card> hand) {//return the required no of cards having the same face value
		List<card> pair = new ArrayList<card>();
		for (card c1 : hand) {
			pair.add(c1);
			for (card c2 : hand) {
				if ( !c1.equals(c2) && c1.getFaceValue()==c2.getFaceValue()) {
					pair.add(c2);
				}
			}
			if (pair.size() == size) {
				return pair;
			}
			pair.clear(); //clear arraylist
		}
		return null;
    }
    
    private static List<card> getSequence(List<card> hand, Boolean compareSuit, Integer sequenceSize) {//Return consecutively ranked cards               
                List<card> orderedList = getCardList(hand);
		List<card> sequenceList = new ArrayList<card>();//store the consecutively ranked cards
                card cardPrevious = null;
		for (card card : orderedList) {
			if (cardPrevious != null) {
				if ((card.getFaceValue() - cardPrevious.getFaceValue()) == 1) {
					if (!compareSuit|| cardPrevious.getSuit().equals(card.getSuit())) {
						if (sequenceList.isEmpty()) {
							sequenceList.add(cardPrevious);
						}
						sequenceList.add(card);
					}
				} 
                                else {
					if (sequenceList.size() == sequenceSize) {
						return sequenceList;
					}
					sequenceList.clear(); //remove all the cards; not consecutive 
				}
			}
			cardPrevious = card;
		}
		return (sequenceList.size() == sequenceSize) ? sequenceList : null;
    } 
    
    private static List<card> getCardList(List<card> hand) { //Sort all cards as per their face value        
       Collections.sort(hand, new Comparator<card>() {
                @Override public int compare(card c1, card c2) {
				return c1.getFaceValue() < c2.getFaceValue() ? -1 : 1;
		}
	});
       return hand;
   }
    
    private static card getTopCard(List<card> hand){ //get the card which has the highest face value 
       card highCard = hand.get(0);
       for (card card : hand) {
	    if (card.getFaceValue() > highCard.getFaceValue()) {
		highCard = card;
	    }
	}
      return highCard;
    } 
    
    private static  Boolean sameSuit(List<card> Cards) {//check whether all cards are from the same suit           
        card.Suits suit = Cards.get(0).getSuit();
        for (card card : Cards) {  
	   if (!(card.getSuit().equals(suit))) { 
		return false;
	   }  
        }
        return true;        
    }   
}
