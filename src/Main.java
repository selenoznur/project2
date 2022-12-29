public class Main {
    public static void main(String[] args) {

        System.out.println("*");
        System.out.println("Welcome to pişti!");



        Project prj = new Project();
        String[] zula = new String[52];
        String[] comp_zula = new String[52];
        prj.Shuffle();
        prj.cut();
        prj.dealToBoard();
        for(int i = 0 ; i < 6 ; i ++) {
            prj.dealing();
            for(int j = 0 ; j < 4 ; j++) {
                System.out.println("");
                prj.Printer();
                prj.printBoard();
                prj.throwCard();
                prj.clear_board(zula);
                prj.printBoard();
                System.out.println("------------");


                prj.cmpPlay();
                prj.Printer();
                prj.clear_board(comp_zula);
                prj.printBoard();
            }
        }

        prj.calculatePlayerScore();

    }
}