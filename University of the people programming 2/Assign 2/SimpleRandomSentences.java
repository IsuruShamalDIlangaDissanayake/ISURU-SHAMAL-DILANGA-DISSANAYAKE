package Assignment;
import java.util.*;

public class SimpleRandomSentences {
	
	private static final String[] conjunctions = { "and", "or", "but", "because", "since", "when"};
	
	private static final String[] properNouns = { "Fred", "Jane", "Richard Nixon", "Miss America", "Donald Trump", "Hillary clinton"};
	
	private static final String[] commonNouns = { "man", "woman", "fish", "elephant", "unicorn", "lamp", "trident", "stunt-man" };
	
	private static final String[] determiners = { "a", "the", "every", "some", "each", "neither", "either" };
	
	private static final String[] adjectives = { "big", "tiny", "pretty", "bald", "strange", "wacky", "gross", "cool", "silly", "careless" };
	
	private static final String[] intransitiveVerbs = { "runs", "jumps", "talks", "sleeps", "agrees", "lies", "laughs" };
	
	private static final String[] transitiveVerbs = { "loves", "hates", "sees", "knows", "looks for", "finds", "admires", "bathes" };

	private static Random r = new Random();
	
	private static final double S_CH = 0.1;
	private static final double M_CH = 0.5;
	private static final double L_CH = 0.75;
	
	private static final double CH_F_INT = 0.4;
	private static final double CH_F_TRA = 0.1;
	private static final double CH_F_ADJ = 0.4;
	
	private static final int MIL_T_SL = 2000;
	
	public static void main(String[] args) {
		while (true) {
			randomSentence();
			System.out.println(".\n\n" );
			try {
				Thread.sleep(MIL_T_SL);
			}catch(InterruptedException e) {
				
			}
			
		}
	}
	
	private static void randomSentence() {
		
		simpleSentence();
		if(chanceToBeTrue(S_CH)) {
			randomItem(conjunctions);
			System.out.println( " " );
			randomSentence();
		}
	}

	private static void simpleSentence() {
		makeItInteresting();
		nounPhrase();
		verbPhrase();
	}
	
	private static void makeItInteresting() {
		System.out.println(" this is a ");
		randomItem(adjectives);
		System.out.println(" project ");
		randomItem(conjunctions);
	}
	
	private static void nounPhrase() {
		if(chanceToBeTrue(M_CH)) {
			randomItem(properNouns);
		}
		else {
			randomItem(commonNouns);
			if(chanceToBeTrue(S_CH)) {
				System.out.println(" who ");
				verbPhrase();
			}
		}
	}
	
	private static void verbPhrase() {
		
		double chance = r.nextDouble();
		if(chance < CH_F_INT) {
			randomItem(intransitiveVerbs);
		}
		else if (chance < (CH_F_INT + CH_F_TRA))
		{
			randomItem(transitiveVerbs);
			nounPhrase();
		}
		else if (chance < (CH_F_INT + CH_F_TRA + CH_F_ADJ)) {
			System.out.print(" is ");
			randomItem(adjectives);
		}
		else {
			System.out.print("belives that");
			simpleSentence();
		}
	}
	
	private static void randomItem(String[] listOfStrings) {
		int choice = r.nextInt(listOfStrings.length);
		System.out.print( " " + listOfStrings[choice]);
	}
	
	private static boolean chanceToBeTrue(double precentChance) {
		
		double number = r.nextDouble();
		if(number < precentChance) {
			return true;
		}
		else
		{
			return false;
		}
	}
}

