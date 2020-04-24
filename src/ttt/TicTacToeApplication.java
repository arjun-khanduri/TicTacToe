package ttt;
import java.util.*;
public class TicTacToeApplication {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean wish=true;
		while(wish) {
			System.out.println("Welcome");
			System.out.println("Please pick a character");
			System.out.println("Enter a single character");
			char playerToken=sc.next().charAt(0);
			System.out.println("Enter a single character for opponent");
			char opponentToken=sc.next().charAt(0);
			TicTacToe game=new TicTacToe(playerToken,opponentToken);
			AI ai=new AI();
			TicTacToe.printIndexBoard();
			System.out.println();
			while(game.gameOver().equals("Game not over yet")) {
				if(game.currentMarker==game.userMarker) {
					System.out.println("It's your turn");
					int spot=sc.nextInt();
					while(!game.playTurn(spot)) {
						System.out.println("Invalid spot");
						spot=sc.nextInt();
					}
					System.out.println("You picked: "+spot);
				}else {
					System.out.println("Computer's turn");
					int aiSpot=ai.pickSpot(game);
					game.playTurn(aiSpot);
					System.out.println("I picked: "+aiSpot);
				}
				System.out.println();
				game.printBoard();
			}
			System.out.println(game.gameOver());
			System.out.println();
			System.out.println("Do you want to play again? (Y/N)");
			char response=sc.next().charAt(0);
			wish=response=='Y';
			System.out.println("\n");
		}
		sc.close();
	}
}
