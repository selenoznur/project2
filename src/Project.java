import java.util.Random;
import java.util.Scanner;


public class Project {
    private String[] rank;
    private String[] suit;
    private String[] deck;
    private String[] playerHand;
    private String[] computerHand;
    private String[] board;

    public String[] getD() {
        return deck;
    }

    public String[] getP() {
        return playerHand;
    }

    public String[] getC() {
        return computerHand;
    }

    public String[] getB() {
        return board;
    }


    public Project() {
        rank = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J", "A"};
        suit = new String[]{"♠", "♦", "♣", "♥"};
        deck = new String[52];

        playerHand = new String[4];
        computerHand = new String[4];
        board = new String[52];

        for (int i = 0; i < deck.length; i++) {
            deck[i] = suit[i / 13] + rank[i % 13];
        }
    }


    public void Shuffle() {
        Random rd = new Random(System.currentTimeMillis());


        // shuffle the deck
        for (int i = 0; i < deck.length; i++) {
            int index = rd.nextInt(deck.length);

            String temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }
    }

    public void cut() {
        Random rd = new Random(System.currentTimeMillis());
        int cutP = rd.nextInt(48) + 2;
        String[] firstHalf = new String[cutP];
        String[] secondHalf = new String[deck.length - cutP];
        System.arraycopy(deck, 0, firstHalf, 0, firstHalf.length);
        System.arraycopy(deck, firstHalf.length, secondHalf, 0, secondHalf.length);

        System.arraycopy(secondHalf, 0, deck, 0, secondHalf.length);
        System.arraycopy(firstHalf, 0, deck, secondHalf.length, firstHalf.length);

        for (String s : deck) {
            System.out.println(s);
        }

    }


    public void dealing() {
        int index = 0;
        for (int i = 0; i < deck.length; i++) {
            if (deck[i] != null) {
                if (index == 4) {
                    break;
                }
                playerHand[index++] = deck[i];
                deck[i] = null;

            }
        }
        index = 0;
        for (int i = 0; i < deck.length; i++) {
            if (deck[i] != null) {
                if (index == 4) {
                    break;
                }
                computerHand[index++] = deck[i];
                deck[i] = null;

            }
        }
    }

    public void Printer() {
        System.out.println("player's hand: ");
        for (int i = 0; i < playerHand.length; i++) {
            System.out.println(playerHand[i]);
        }
        System.out.println("computer's hand: ");
        for (int i = 0; i < computerHand.length; i++) {
            System.out.println(computerHand[i]);
        }
    }


    public void dealToBoard() {
        int index = 0;

        for (int i = 0; i < deck.length; i++) {
            if (deck[i] != null) {
                if (index == 4) {
                    break;

                }
                board[index++] = deck[i];
                deck[i] = null;

            }
        }
    }

    public void throwCard() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter an index");
                int index = sc.nextInt();
                if (playerHand[index - 1] == null) {
                    System.out.println("Played card");
                    continue;
                }
                for (int i = 0; i < board.length; i++) {
                    if (board[i] == null) {
                        board[i] = playerHand[index - 1];
                        playerHand[index - 1] = null;
                        break;

                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("Something went wrong");
                sc.nextLine();
            }
        }
    }


    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            if (board[i] != null) {
                System.out.println("Board's " + (i + 1) + ". Card:" + board[i]);
            }

        }
    }


    public void clear_board(String[] zula) {
        for (int i = board.length - 1; i > -1; i--) {
            if (board[i] != null) {
                if (i > 0) {
                    if (board[i].substring(1).equals(board[i - 1].substring(1))) {

                        for (int j = 0; j < board.length; j++) {
                            if (board[j] != null) {
                                for (int k = 0; k < zula.length; k++) {
                                    if (zula[k] == null) {
                                        zula[k] = board[j];
                                        board[j] = null;
                                        break;
                                    }
                                }
                            }
                        }
                    } else if (board[i].substring(1).equals("J")) {
                        for (int j = 0; j < board.length; j++) {
                            if (board[j] != null) {
                                for (int k = 0; k < zula.length; k++) {
                                    if (zula[k] == null) {
                                        zula[k] = board[j];
                                        board[j] = null;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void cmpPlay() {
        Random rd = new Random(System.currentTimeMillis());
        for (int i = board.length - 1; i > -1; i--) {
            if (board[i] != null) {
                for (int j = 0; j < computerHand.length; j++) {
                    if (computerHand[j] != null) {
                        if (computerHand[j].substring(1).equals(board[i].substring((1)))) {
                            board[i + 1] = computerHand[j];
                            computerHand[j] = null;
                            break;
                        } else if (computerHand[j].substring(1).equals("J")) {
                            board[i + 1] = computerHand[j];
                            computerHand[j] = null;
                            break;

                        } else {
                            int rdi = rd.nextInt(4);
                            board[i + 1] = computerHand[rdi];
                            computerHand[rdi] = null;
                            break;
                        }
                    }
                }
                break;
            }
        }
    }
}





