import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

//This class handles the main game logic
public class yahtzee 
{
	public boolean reset = false;
	
	public int rollsRemain = 3;
	private int bonus = 0;
	public int finalScore = 0;

	//2D array to keep track of scores and if they have been selected
	public int[][] scoreTracking;
	public boolean lockDisabled = true;
	public boolean upperSectionBonus = false;
	public boolean gameOver = false;
	
	yahtzee()
	{
		scoreTracking = new int[13][2];
		for(int i = 0; i <= 12; i++)
		{
			scoreTracking[i][0] = 0;
			scoreTracking[i][1] = 0;
		}
	}

	//Function used to roll the dice and return the result
	int rollDice()
	{
		//Initiate random
		Random rand = new Random();
		
		return rand.nextInt(6) + 1;
	}
	
	//Function used to decrement rollsRemain as well as change the lock
	void decrementRolls()
	{
		rollsRemain--;
		lockDisabled = false;
	}
	
	void scoreOnes(Label dice1, Label dice2, Label dice3, Label dice4, Label dice5, Label ones)
	{
		if(scoreTracking[0][1] == 0 && lockDisabled == false)
		{
			if(dice1.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-1.png"))
			{
				scoreTracking[0][0] += 1;
			}
			if(dice2.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-1.png"))
			{
				scoreTracking[0][0] += 1;
			}
			if(dice3.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-1.png"))
			{
				scoreTracking[0][0] += 1;
			}
			if(dice4.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-1.png"))
			{
				scoreTracking[0][0] += 1;
			}
			if(dice5.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-1.png"))
			{
				scoreTracking[0][0] += 1;
			}
			
			ones.setText("Ones: " + scoreTracking[0][0]);
			
			//Set score for ones section has been filled
			scoreTracking[0][1] = 1;
			
			//Reset turn
			resetTurn();
		}
	}
	
	void scoreTwos(Label dice1, Label dice2, Label dice3, Label dice4, Label dice5, Label twos)
	{
		if(scoreTracking[1][1] == 0 && lockDisabled == false)
		{
			if(dice1.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-2.png"))
			{
				scoreTracking[1][0] += 2;
			}
			if(dice2.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-2.png"))
			{
				scoreTracking[1][0] += 2;
			}
			if(dice3.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-2.png"))
			{
				scoreTracking[1][0] += 2;
			}
			if(dice4.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-2.png"))
			{
				scoreTracking[1][0] += 2;
			}
			if(dice5.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-2.png"))
			{
				scoreTracking[1][0] += 2;
			}
			
			twos.setText("Twos: " + scoreTracking[1][0]);
			
			//Set score for ones section has been filled
			scoreTracking[1][1] = 1;
			
			//Reset turn
			resetTurn();
		}
	
	}
	
	void scoreThrees(Label dice1, Label dice2, Label dice3, Label dice4, Label dice5, Label threes)
	{
		if(scoreTracking[2][1] == 0 && lockDisabled == false)
		{
			if(dice1.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-3.png"))
			{
				scoreTracking[2][0] += 3;
			}
			if(dice2.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-3.png"))
			{
				scoreTracking[2][0] += 3;
			}
			if(dice3.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-3.png"))
			{
				scoreTracking[2][0] += 3;
			}
			if(dice4.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-3.png"))
			{
				scoreTracking[2][0] += 3;
			}
			if(dice5.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-3.png"))
			{
				scoreTracking[2][0] += 3;
			}
			
			threes.setText("Threes: " + scoreTracking[2][0]);
			
			//Set score for ones section has been filled
			scoreTracking[2][1] = 1;
			
			//Reset turn
			resetTurn();
		}
		
	}
	
	void scoreFours(Label dice1, Label dice2, Label dice3, Label dice4, Label dice5, Label fours)
	{
		if(scoreTracking[3][1] == 0 && lockDisabled == false)
		{
			if(dice1.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-4.png"))
			{
				scoreTracking[3][0] += 4;
			}
			if(dice2.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-4.png"))
			{
				scoreTracking[3][0] += 4;
			}
			if(dice3.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-4.png"))
			{
				scoreTracking[3][0] += 4;
			}
			if(dice4.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-4.png"))
			{
				scoreTracking[3][0] += 4;
			}
			if(dice5.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-4.png"))
			{
				scoreTracking[3][0] += 4;
			}
			
			fours.setText("Fours: " + scoreTracking[3][0]);
			
			//Set score for ones section has been filled
			scoreTracking[3][1] = 1;
			
			//Reset turn
			resetTurn();
		}
		
	}
	
	void scoreFives(Label dice1, Label dice2, Label dice3, Label dice4, Label dice5, Label fives)
	{
		if(scoreTracking[4][1] == 0 && lockDisabled == false)
		{
			if(dice1.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-5.png"))
			{
				scoreTracking[4][0] += 5;
			}
			if(dice2.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-5.png"))
			{
				scoreTracking[4][0] += 5;
			}
			if(dice3.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-5.png"))
			{
				scoreTracking[4][0] += 5;
			}
			if(dice4.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-5.png"))
			{
				scoreTracking[4][0] += 5;
			}
			if(dice5.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-5.png"))
			{
				scoreTracking[4][0] += 5;
			}
			
			fives.setText("Fives: " + scoreTracking[4][0]);
			
			//Set score for ones section has been filled
			scoreTracking[4][1] = 1;
			
			//Reset turn
			resetTurn();
		}
		
	}
	
	void scoreSixes(Label dice1, Label dice2, Label dice3, Label dice4, Label dice5, Label sixes)
	{
		if(scoreTracking[5][1] == 0 && lockDisabled == false)
		{
			if(dice1.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-6.png"))
			{
				scoreTracking[5][0] += 6;
			}
			if(dice2.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-6.png"))
			{
				scoreTracking[5][0] += 6;
			}
			if(dice3.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-6.png"))
			{
				scoreTracking[5][0] += 6;
			}
			if(dice4.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-6.png"))
			{
				scoreTracking[5][0] += 6;
			}
			if(dice5.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-6.png"))
			{
				scoreTracking[5][0] += 6;
			}
			
			sixes.setText("Sixes: " + scoreTracking[5][0]);
			
			//Set score for ones section has been filled
			scoreTracking[5][1] = 1;
			
			//Reset turn
			resetTurn();
		}
		
	}
	
	//Function to score 3 of a kind
	void scoreThreeKind(Label dice1, Label dice2, Label dice3, Label dice4, Label dice5, Label threeKind)
	{
		if(scoreTracking[6][1] == 0 && lockDisabled == false)
		{
			int duplicate = 0;
			int diceNumbers[];
			diceNumbers = new int[5];
			
			diceNumbers[0] = checkDiceNumber(dice1);
			diceNumbers[1] = checkDiceNumber(dice2);
			diceNumbers[2] = checkDiceNumber(dice3);
			diceNumbers[3] = checkDiceNumber(dice4);
			diceNumbers[4] = checkDiceNumber(dice5);
			
			//Sort the array
			Arrays.sort(diceNumbers);
			duplicate = findDuplicates(diceNumbers, false);
			
			if(duplicate >= 2)
			{
				for(int i = 0; i < diceNumbers.length; i++) 
				{
					//Set score
					scoreTracking[6][0] += diceNumbers[i];
				}
			}
			
			threeKind.setText("3 of a Kind: " + scoreTracking[6][0]);
			
			//Set score for three of a kind section has been filled
			scoreTracking[6][1] = 1;
			
			//Reset turn
			resetTurn();
		}
		
	}
	
	//Function to score 4 of a kind
	//TODO recheck logic. 4 of kind triggering when there are two pair.
	void scoreFourKind(Label dice1, Label dice2, Label dice3, Label dice4, Label dice5, Label fourKind)
	{
		if(scoreTracking[7][1] == 0 && lockDisabled == false)
		{
			int duplicate = 0;
			int diceNumbers[];
			diceNumbers = new int[5];
			
			diceNumbers[0] = checkDiceNumber(dice1);
			diceNumbers[1] = checkDiceNumber(dice2);
			diceNumbers[2] = checkDiceNumber(dice3);
			diceNumbers[3] = checkDiceNumber(dice4);
			diceNumbers[4] = checkDiceNumber(dice5);
			
			//Sort the array
			Arrays.sort(diceNumbers);
			duplicate = findDuplicates(diceNumbers, false);

			if(duplicate >= 3)
			{
				for(int i = 0; i < diceNumbers.length; i++) 
				{
					//Set score
					scoreTracking[7][0] += diceNumbers[i];
				}
			}
			
			fourKind.setText("4 of a Kind: " + scoreTracking[7][0]);
			
			//Set score for three of a kind section has been filled
			scoreTracking[7][1] = 1;
			
			//Reset turn
			resetTurn();
		}
		
	}
	
	void scoreFullHouse(Label dice1, Label dice2, Label dice3, Label dice4, Label dice5, Label fullHouse)
	{
		if(scoreTracking[8][1] == 0 && lockDisabled == false)
		{
			int duplicate = 0;
			int diceNumbers[];
			diceNumbers = new int[5];
			
			diceNumbers[0] = checkDiceNumber(dice1);
			diceNumbers[1] = checkDiceNumber(dice2);
			diceNumbers[2] = checkDiceNumber(dice3);
			diceNumbers[3] = checkDiceNumber(dice4);
			diceNumbers[4] = checkDiceNumber(dice5);
			
			//Sort the array
			Arrays.sort(diceNumbers);
			duplicate = findDuplicates(diceNumbers, true);
			
			if(duplicate == 5)
			{
				for(int i = 0; i < diceNumbers.length; i++) 
				{
					//Set score
					scoreTracking[8][0] = 25;
				}
			}
			
			fullHouse.setText("Full House: " + scoreTracking[8][0]);
			
			//Set score for three of a kind section has been filled
			scoreTracking[8][1] = 1;
			
			//Reset turn
			resetTurn();
		}
		
	}
	
	void scoreChance(Label dice1, Label dice2, Label dice3, Label dice4, Label dice5, Label chance)
	{
		if(scoreTracking[9][1] == 0 && lockDisabled == false)
		{
			int diceNumbers[];
			diceNumbers = new int[5];
			
			diceNumbers[0] = checkDiceNumber(dice1);
			diceNumbers[1] = checkDiceNumber(dice2);
			diceNumbers[2] = checkDiceNumber(dice3);
			diceNumbers[3] = checkDiceNumber(dice4);
			diceNumbers[4] = checkDiceNumber(dice5);
			
			for(int i = 0; i < diceNumbers.length; i++) 
			{
				//Set score
				scoreTracking[9][0] += diceNumbers[i];
			}
			
			chance.setText("Chance: " + scoreTracking[9][0]);
			
			//Set score that it has been used
			scoreTracking[9][1] = 1;
			
			//Reset turn
			resetTurn();
		}
		
	}

	void scoreSmStraight(Label dice1, Label dice2, Label dice3, Label dice4, Label dice5, Label smSt)
	{
		//NOTE: Integer used opposed to int to be able to compare two different sized arrays
		if(scoreTracking[10][1] == 0 && lockDisabled == false)
		{
			//Create arrays of all possible small straights
			Integer smSt1[] = {1, 2, 3, 4};
			Integer smSt2[] = {2, 3, 4, 5};
			Integer smSt3[] = {3, 4, 5, 6};
			Integer diceNumbers[];
			diceNumbers = new Integer[5];
			
			diceNumbers[0] = checkDiceNumber(dice1);
			diceNumbers[1] = checkDiceNumber(dice2);
			diceNumbers[2] = checkDiceNumber(dice3);
			diceNumbers[3] = checkDiceNumber(dice4);
			diceNumbers[4] = checkDiceNumber(dice5);
			
			//Sort the array
			Arrays.sort(diceNumbers);
			//System.out.println(Arrays.toString(diceNumbers));
			
			//Check if array of dice equals a possible straight 
			if(linearIn(diceNumbers, smSt1) || linearIn(diceNumbers, smSt2) || linearIn(diceNumbers, smSt3))
			{
				//Set score
				scoreTracking[10][0] = 30;
			}
			
			smSt.setText("Sm. Straight: " + scoreTracking[10][0]);
			
			//Set score that it has been used
			scoreTracking[10][1] = 1;
			
			//Reset turn
			resetTurn();
		}
		
	}
	
	void scoreLgStraight(Label dice1, Label dice2, Label dice3, Label dice4, Label dice5, Label lgSt)
	{
		//NOTE: Integer used opposed to int to be able to compare two different sized arrays
		if(scoreTracking[11][1] == 0 && lockDisabled == false)
		{
			//Create arrays of all possible small straights
			Integer lgSt1[] = {1, 2, 3, 4, 5};
			Integer lgSt2[] = {2, 3, 4, 5, 6};
			Integer diceNumbers[];
			diceNumbers = new Integer[5];
			
			diceNumbers[0] = checkDiceNumber(dice1);
			diceNumbers[1] = checkDiceNumber(dice2);
			diceNumbers[2] = checkDiceNumber(dice3);
			diceNumbers[3] = checkDiceNumber(dice4);
			diceNumbers[4] = checkDiceNumber(dice5);
			
			//Sort the array
			Arrays.sort(diceNumbers);
			//System.out.println(Arrays.toString(diceNumbers));
			
			//Check if array of dice equals a possible straight 
			if(linearIn(diceNumbers, lgSt1) || linearIn(diceNumbers, lgSt2))
			{
				//Set score
				scoreTracking[11][0] = 40;
			}
			
			lgSt.setText("Lg. Straight: " + scoreTracking[11][0]);
			
			//Set score that it has been used
			scoreTracking[11][1] = 1;
			
			//Reset turn
			resetTurn();
		}
	
	}
	
	void scoreYahtzee(Label dice1, Label dice2, Label dice3, Label dice4, Label dice5, Label yahtzee)
	{
		if(scoreTracking[12][1] == 0 && lockDisabled == false)
		{
			int duplicates = 0;
			int diceNumbers[];
			diceNumbers = new int[5];
			
			diceNumbers[0] = checkDiceNumber(dice1);
			diceNumbers[1] = checkDiceNumber(dice2);
			diceNumbers[2] = checkDiceNumber(dice3);
			diceNumbers[3] = checkDiceNumber(dice4);
			diceNumbers[4] = checkDiceNumber(dice5);
			
			duplicates = findDuplicates(diceNumbers, false);
			
			if(duplicates == 4)
			{
				//Set score
				scoreTracking[12][0] = 50;
			}
			
			yahtzee.setText("Yahtzee: " + scoreTracking[12][0]);
			
			//Set score that it has been used
			scoreTracking[12][1] = 1;
			
			//Reset turn
			resetTurn();
		}
	
	}
	
	//Finds out if an array has any duplicates and counts how many of each.
	//It will return the value that has the higher amount of duplicates
	//Also takes in a flag to check for full house
	public static int findDuplicates(int[] input, boolean fullHouseCheck) {
        Set<Integer> duplicates = new HashSet<Integer>();
        //With 5 dice there can only ever be at most two combos of dupes
        int dupe1 = 0;
        int dupe2 = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = 1; j < input.length; j++) {
                if (input[i] == input[j] && i != j) {
                    // duplicate element found
                    duplicates.add(input[i]);
                    break;
                }
            }
        }
        
        Iterator<Integer> iterator = duplicates.iterator();
        while(iterator.hasNext()) 
        {
	        Integer setElement = iterator.next();
            for(int i = 0; i < input.length; i++)
            {
            	if(input[i] == setElement && dupe1 == 0)
            		dupe1++;
            	else if(input[i] == setElement && dupe1 != 0)
            	{
            		dupe2++;
            	}
            }
        }
        
        //System.out.println((duplicates.toString()));
        //System.out.println("Dupe1: " + dupe1 + " Dupe2: " + dupe2);
        if(dupe1 > dupe2)
        	return dupe1;
        else if(fullHouseCheck)
        	return dupe1 + dupe2;
        else 
        	return dupe2;
    }
	
	//Function tests if a smaller array has all the elements of a larger one.
	//Used for small and large straights
	public static boolean linearIn(Integer[] outer, Integer[] inner) {

		   return Arrays.asList(outer).containsAll(Arrays.asList(inner));
		}
	
	//Reset the turn and check if game end
	void resetTurn()
	{
		rollsRemain = 3;
		lockDisabled = true;
		
		//Counter to see if all scores have been filled
		int count = 0;
		
		for(int i = 0; i < scoreTracking.length; i++)
		{
			if(scoreTracking[i][1] == 1)
				count++;
		}
		
		if(count == 13)
		{
			//Calculate the total score
			for(int i = 0; i <= 12; i++)
			{
				finalScore += scoreTracking[i][0];
			}
			
			//Game over logic
			gameOver = true;
		}
	}

	//This function disables and un-selects the locks
	public void disableLocks(Button btnDice1Lock, Button btnDice2Lock, Button btnDice3Lock, Button btnDice4Lock,
			Button btnDice5Lock) 
	{
		btnDice1Lock.setEnabled(!lockDisabled);
		btnDice2Lock.setEnabled(!lockDisabled);
		btnDice3Lock.setEnabled(!lockDisabled);
		btnDice4Lock.setEnabled(!lockDisabled);
		btnDice5Lock.setEnabled(!lockDisabled);
		
		btnDice1Lock.setSelection(false);
		btnDice2Lock.setSelection(false);
		btnDice3Lock.setSelection(false);
		btnDice4Lock.setSelection(false);
		btnDice5Lock.setSelection(false);
	}
	
	void updateUSTotal(Label total)
	{
		int numberTotal = 0;
		
		for(int i = 0; i < 6; i++)
			numberTotal += scoreTracking[i][0];
		
		//Add 35 bonus points if 
		if(numberTotal >= 63)
		{
			upperSectionBonus = true;
			bonus += 35;
		}
		
		/*if(upperSectionBonus)
			total.setText("Total: " + (numberTotal + 35));
		else*/
			total.setText("Total: " + numberTotal);
	}
	
	void updateLSTotal(Label total)
	{
		int numberTotal = 0;
		
		for(int i = 6; i < 12; i++)
			numberTotal += scoreTracking[i][0];
		
		total.setText("Total: " + numberTotal);
	}

	
	//This function checks if yahtzee bonus happens
	void checkYahtzeeBonus(int diceNumbers[])
	{
		int duplicates = 0;
		duplicates = findDuplicates(diceNumbers, false);
		
		//If a yahtzee and the yahtzee score has been filled with an actual yahtzee and not 0
		if(duplicates == 4 && scoreTracking[12][1] == 1 && scoreTracking[12][0] == 50)
		{
			bonus += 100;
		}
	}
	
	//Function used to check what face the passed dice is and returns it as an int
	int checkDiceNumber(Label dice)
	{
		if(dice.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-1.png"))
		{
			return 1;
		}
		if(dice.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-2.png"))
		{
			return 2;
		}
		if(dice.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-3.png"))
		{
			return 3;
		}
		if(dice.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-4.png"))
		{
			return 4;
		}
		if(dice.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-5.png"))
		{
			return 5;
		}
		if(dice.getImage() == SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-6.png"))
		{
			return 6;
		}
		else
			return 0;
	}
	
	//Function called when starting a new game
	void restartGame(Label Dice1, Label Dice2, Label Dice3, Label Dice4, Label Dice5)
	{
		//Reset score tracking array
		finalScore = 0;
		scoreTracking = new int[13][2];
		for(int i = 0; i <= 12; i++)
		{
			scoreTracking[i][0] = 0;
			scoreTracking[i][1] = 0;
		}
		
		//Reset rolls
		rollsRemain = 3;
		bonus = 0;
		upperSectionBonus = false;
		lockDisabled = true;
		
		gameOver = false;
		
		//Reset Dice Images
		Dice1.setImage(SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-1.png"));
		Dice2.setImage(SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-2.png"));
		Dice3.setImage(SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-3.png"));
		Dice4.setImage(SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-4.png"));
		Dice5.setImage(SWTResourceManager.getImage(Main.class, "/yahtzee/images/dice-5.png"));
	}
}
