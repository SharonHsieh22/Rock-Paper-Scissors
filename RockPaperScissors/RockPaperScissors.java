import java.util.Scanner;

class RockPaperScissors {
    static Scanner sc = new Scanner(System.in);
    static int player;
    static int comp;
    final static int rock = 1;
    final static int paper = 2;
    final static int scissors = 3;
    static int wins = 0;
    static int losses = 0;
    static int ties = 0;
    static String c;
    static String play = "y";
    public static void main(String[] args) {
        intro();
        while(play.equals("y")) {
            playerChoice();
            compChoice();
            result();
            playAgain();
        } 
        outro();
    }

    public static void intro() {
        System.out.println("RPS 1.0");
        System.out.println("*******************************************************");
        System.out.println("Good luck, human...");    
    }

    public static void playerChoice() {
        do {
            System.out.println(""); 
            System.out.print("What do you throw? [1] Rock, [2] Paper, [3] Scissors? ");
            player = sc.nextInt();
            if(player != 1 && player != 2 && player != 3) {
                System.out.println("Illegal move!"); 
            }
        } while(player != 1 && player != 2 && player != 3);

        if(player == rock) c = "rock";
        else if(player == paper) c = "paper";
        else if(player == scissors) c = "scissors";
        System.out.print("You threw " + c + "! ");
    }

    public static void compChoice() {
        comp = (int) (Math.random()*3) + 1;
        if(comp == rock) c = "rock";
        else if(comp == paper) c = "paper";
        else if(comp == scissors) c = "scissors";
        System.out.println("I threw " + c + "!");
    }

    public static void result() {
        if(player == comp) {
            System.out.println("A draw! Not bad... I demand a rematch!");
            ties++;
        }
        else if(player == rock && comp == scissors || player == scissors && comp == paper || player == paper && comp == rock) {
            System.out.println("YOU BEAT ME? IMPOSSIBLE!");
            wins++;
        }
        else {
            System.out.println("I WIN! HAHAHAHAHA!");
            losses++;
        }
    }

    public static void playAgain() {
        do {
            System.out.println(""); 
            System.out.print("Play again? [y, n] ");
            play = sc.next();
            if(!play.equals("y") && !play.equals("n")) {
                System.out.println("Illegal answer!");
            }
        } while(!play.equals("y") && !play.equals("n"));
    }

    public static void outro() {
        System.out.println(""); 
        System.out.println("Good Game! Thanks for playing.");
        System.out.println("*******************************************************");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Ties: " + ties);
    }

}