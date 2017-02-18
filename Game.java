import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game() {
        board = new Board();
    }

    public void createPlayer() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Gravitrips game!");
        System.out.println("Select game mode:");
        System.out.println("Computer to Player - press 1 and ENTER ");
        System.out.println("Player to Player - press 2 and ENTER ");

        boolean exit = false;

        while (!exit) {
            try {
                int number = Integer.parseInt(reader.readLine());
                if (number == 2) {
                    player2 = new HumanPlayer(2);
                    exit = true;

                } else if (number == 1) {
                    player2 = new ComputerPlayer();
                    exit = true;
                } else {
                    System.out.println("Wrong!!! Please enter valid number! Valid number range 1 or 2");
                }
            } catch (Exception e) {
                System.out.println("Wrong!!! Please enter valid number! Valid number range 1 or 2");
            }

        }

        player1 = new HumanPlayer(1);

        printPlayers(player1);
        printPlayers(player2);

        board.printField();
        currentPlayer = player1;

        System.out.println("Let's Start! \n");

    }

    public void printPlayers(Player player) {
        System.out.println("Player " + player.getPlayerName() + " set token - " + player.getToken());
    }

    public void runGame() {

        while (chechWinner() && board.checkBord()) {

            changePlayer();

            int hit = 0;
            int freeSlot = 0;
            boolean rightHit = false;

            while (!rightHit) {

                hit = currentPlayer.getHit();
                freeSlot = board.checkHit(hit);
                rightHit = board.checkColum(freeSlot);
            }

            board.addHit(hit, freeSlot, currentPlayer.getToken());
            board.printField();

            System.out.println("\n------------------------------");
        }
    }

    public void changePlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean chechWinner() {
        CheckWinner checkWinner = new CheckWinner();
        if (checkWinner.checkVertical(board, currentPlayer.getToken()) || checkWinner.checkHorizontal(board, currentPlayer.getToken()) || checkWinner.checkDiagonal(board, currentPlayer.getToken())) {

            System.out.println(" \n We have a winner!!! \n Winner is - " + currentPlayer.getPlayerName());
            return false;
        }
        return true;
    }
}