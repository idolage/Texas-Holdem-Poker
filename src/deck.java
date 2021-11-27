/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author IsoraDolage
 */
public class deck {
    
    private card[] cards;
    int cardNo;
    
    public deck() { //default constructor 
        cards = new card[52]; 
        createPack(); 
        cardNo= 0;
    } 
    
    private void createPack() {//creates the card pack
        for (int i = 0; i < 52; i++) { //there are 52 cards in the card pack 
            cards[i] = new card(i / 4 + 2, card.Suits.values()[i % 4]); //create the cards and store them to the array
        }
    }   
    
        public List<card> deal(int NoOfCards) {//deals cards to players
        List<card> hand = new ArrayList<>();
        for (int i = 0; i < NoOfCards; i++) {
            hand.add(cards[cardNo]);
            cardNo++;
        }
        return hand;
    }
        
    public void shuffle() {//shuffles the deck
        cardNo = 0;
        swap(51);
    }   
    
    private void swap(int i) {//swap cards randomly to shuffle
        if (i != 0) {
            swap(i - 1);
            //swap(i, ThreadLocalRandom.current().nextInt(0, i + 1));
            card card_temp = cards[i];
            cards[i] = cards[ThreadLocalRandom.current().nextInt(0, i + 1)];
            cards[ThreadLocalRandom.current().nextInt(0, i + 1)] = card_temp;
        }
    }    
}
