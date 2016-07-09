import java.util.*;
public class Poker {
    static int is3OfKind = 0;
    public  boolean isStraightFlush(int[] pips, int[] suits) {
        return ((pips[4] - pips[0] == 4) && (suits[4] == suits[0]));
    }
    public  boolean isFlush(int[] pips, int[] suits) {
        for (int i : suits) {
            if(i != suits[0]) {
                return false;
            }
        }
        return true;
    }
    public  boolean isStraight(int[] pips, int[] suits) {
        for (int i = 1; i < pips.length; i++) {
            if (pips[i-1] + 1 != pips[i]) {
                return false;
            }
        }
        return true;
    }
    public  boolean isTwoPair(int[] pips, int[] suits) {
        int c = 0;
        for (int i = 0; i < pips.length-1; i++) {
            if(pips[i] == pips[i+1] ) {
                c++;
            }
        }
        return c == 2;
    }
    public  boolean isPair(int[] pips, int[] suits) {
        int c = 0;
        for (int i = 0; i < pips.length-1; i++) {
            if(pips[i] == pips[i+1] ) {
                c++;
            }
        }
        return c == 1;
    }
    public  boolean isThreeOfAKind(int[] pips, int[] suits) {
	 int c = 0;
        for (int i = 0; i < pips.length-2; i++) {
            if(pips[i] == pips[i+1] && pips[i] == pips[i+2]) {
                c++;
                is3OfKind = pips[i];
            }
           
        }
        return c == 1;
       }
    public  boolean isFourOfAKind(int[] pips, int[] suits) {
   	return ((pips[0] - pips[3] == 0) || (pips[1] - pips[4] == 0) );
    }
    public boolean isFullHouse(int []pips,int[] suits){
        int n=0;
        if(isThreeOfAKind(pips,suits)){
        for (int i = 0; i < pips.length-1; i++) {        
            if(pips[i] != is3OfKind){
                if(pips[i] == pips[i+1]){
                    n++ ;
                }
            }
        }
    }
        return n==1;
    }
    public  int highCard(int[] pips, int[] suits) {
        return pips[pips.length-1];
    }
    public  boolean isRoyalFlush(int[] pips, int[] suits) {
        return (pips[0] == 1 && pips[4] - pips[1] == 4 && suits[0] == suits[4] );

    }
public String checkRank(Card a, Card b, Card c, Card d, Card e) {
		int[] pipValues = {a.pip, b.pip, c.pip, d.pip, e.pip};
		int[] suits= {a.suit, b.suit, c.suit, d.suit, e.suit};
		Arrays.sort(pipValues);
		Arrays.sort(suits);
		String rank = "";
	   if (isRoyalFlush(pipValues, suits)) {
			rank = "RoyalFlush";
		} else if (isStraightFlush(pipValues,suits)) {
			rank = "straightFlush" ;
		} else if (isFourOfAKind(pipValues, suits)) {
			rank = "FourOfAKind";
		} else if (isFullHouse(pipValues, suits)) {
			rank = "FullHouse";
		} else if (isFlush(pipValues, suits)) {
			rank = "Flush";
		} else if (isStraight(pipValues, suits)) {
			rank = "Straight" ;
		} else if (isThreeOfAKind(pipValues,suits)) {
			rank =  "ThreeOfAKind";
		} else if (isTwoPair(pipValues, suits)) {
			rank = "TwoPair";
		} else if (isPair(pipValues, suits)) {
			rank = "Pair";
		}  else {
			rank = ""+highCard(pipValues, suits);
		}		      
		return rank ;
	}
	public String compareHands( Card a1, Card a2, Card a3, Card a4, Card a5 , Card b1, Card b2, Card b3, Card b4, Card b5) {
		String[] ranks = {"Pair", "TwoPair", "ThreeOfAKind", "Straight", "Flush", "FullHouse","FourOfAKind","straightFlush","RoyalFlush"};
		String rankOfA = checkRank(a1, a2, a3, a4, a5);
		String rankOfB = checkRank( b1, b2, b3, b4, b5);
		int ra = 0;
		int rb = 0;
		if(rankOfA.equals(rankOfB)){
			return "It is a draw" ;
			
		} else{
		if(!Arrays.asList(ranks).contains(rankOfA) && !Arrays.asList(ranks).contains(rankOfB)) {
				ra = Integer.parseInt(rankOfA);
				rb = Integer.parseInt(rankOfB);
				return ra > rb ? "A is winner" : "B is winner" ;
			} else if (!Arrays.asList(ranks).contains(rankOfA)) {
				return "B is winner" ;
			} else if (!Arrays.asList(ranks).contains(rankOfB)) {
				return "A is winner" ;
			}
		if(Arrays.asList(ranks).contains(rankOfA)) {
			ra = Arrays.asList(ranks).indexOf(rankOfA);
		} 
		if(Arrays.asList(ranks).contains(rankOfB)) {
			rb = Arrays.asList(ranks).indexOf(rankOfB);
		}
         return ra > rb ? "A is winner" : "B is winner" ;
        }
	}
}

