import java.util.Scanner;

class Guesser
{
	int guessNum;
	
	int guessNum()
	{
		System.out.println("Guesser enter a number from 0 to 100: ");
		Scanner s=new Scanner(System.in);
		guessNum=s.nextInt();
		for(int i=0; i<3; i++)
		{
			if(guessNum>100 || guessNum<0)
			{
				System.out.println("wrong number! you can't enter a wrong number  so, please enter in specified range:");
				
				guessNum=s.nextInt();
			}
		}
		if(guessNum>100 || guessNum<0)
		{
			System.out.println("you have exceeded the wrong number limit and you are terminated from game ");
			guessNum=0;
		}
		return guessNum;
	}
}

class Players
{
	
	
	int[] guessNum()
	{
		Scanner s=new Scanner(System.in);
		//System.out.println("enter how many players are available to play: ");
		
		//int i,n;
		//n=s.nextInt();
		int[] a= new int[3];
		
		for(int i=0; i<a.length; i++)
		{
			System.out.println("player "+(i+1)+" enter a number from 0 to 100: ");
			a[i]=s.nextInt();
			
			for(int j=0; j<3; j++)
			{
				if(a[i]>100 || a[i]<0)
				{
					System.out.println("wrong number, please enter in specified range:");
					a[i]=s.nextInt();
				}
			}
			
			if(a[i]>100 || a[i]<0)
			{
				System.out.println("you have exceeded the wrong number limit and you are terminated from game ");
				a[i]=0;
			}
			
		}
		return a;
		
	}
}

class Umpire
{
	int numFromGuesser;
	int numFromPlayer1;
	int numFromPlayer2;
	int numFromPlayer3;
	
	void collectNumFromGuesser()
	{
		Guesser g=new Guesser();
		numFromGuesser=g.guessNum();
	}
	
	void collectNumFromPlayers()
	{
		Players p=new Players();
		int[] r=p.guessNum();
		numFromPlayer1=r[0];
		numFromPlayer2=r[1];
		numFromPlayer3=r[2];
	}
	
	void compare()
	{
		if(numFromGuesser==numFromPlayer1)
		{
			if((numFromGuesser==numFromPlayer2) && (numFromGuesser==numFromPlayer3))
			{
				System.out.println("All the players are winners"); 
				System.out.println("congratualtions!! all the players moved to next round ");
			}
			else if(numFromGuesser==numFromPlayer2)
			{
				System.out.println("player 1 and player 2 are winners");
				System.out.println("congratulations!! players 1 and 2 moved to next round");
			}
			else if(numFromGuesser==numFromPlayer3)
			{
				System.out.println("player 1 and player 3 are winners");
				System.out.println("congratulations!! players 1 and 3 moved to next round");
			}
			else
			{
				System.out.println("player 1 won the game");
				System.out.println("congratulations!! player 1 moved to next round");
			}
		}
		else if(numFromGuesser==numFromPlayer2)
		{
			if(numFromPlayer2==numFromPlayer3)
			{
				System.out.println("player 2 and player 3 are winners");
				System.out.println("congratulations!! players 2 and 3 moved to next round");
			}	
			else
			{
			System.out.println("player 2 won the game");
			System.out.println("congratulations!! player 2 moved to next round");
			}
		}
		else if(numFromGuesser==numFromPlayer3)
		{ 
			System.out.println("player 3 won the game");
			System.out.println("congratulations!! player 3 moved to next round");
		}
		else
		{
			System.out.println("game over, please try again");
		}
	
	}
}
	
public class GGEnhanced {

	public static void main(String[] args) {
		
	
		Scanner sc= new Scanner(System.in);
		
		
		char choice;
		do
		{
		Umpire ump=new Umpire();
		ump.collectNumFromGuesser();
		ump.collectNumFromPlayers();
		ump.compare();
		System.out.println("do you want to play again. choose(Y/N) ");
		choice=sc.next().charAt(0);
		}while(choice=='Y' | choice=='y');
	}

}
