import java.awt.*;

public class Main {

    public static void gameDrawer(Cell[][] gameState){
        StdDraw.clear(StdDraw.BLACK);
        for(int i = 0; i < gameState.length; i++){
            for(int j = 0; j < gameState[i].length; j++){
                gameState[i][j].draw();
            }
        }
        StdDraw.show();
    }

    public static void gameRandomizer(Cell[][] game){
        for(int i = 0; i < game.length; i++){
            for( int j = 1; j < game[i].length-1; j++){
                int diceRollJ = (int)(Math.random()*game[i].length);
                //reroll if about to swap the first cell (left to right), just to give the player some leeway
                while( diceRollJ == 0 || diceRollJ == game[i].length-1){ diceRollJ = (int)(Math.random()*game[i].length); }

                int diceRollI = (int)(Math.random()*game.length);

                game[i][j].switcher(game[diceRollI][diceRollJ]);

            }
        }
    }

    public static boolean gameChecker(Cell[][] gameNow, Cell[][] solvedState){
        boolean isSolved = false;
        int cellCount = gameNow.length * gameNow[0].length;
        int correctCells = 0;

        for(int i = 0; i < gameNow.length; i++){
            for(int j = 0; j < gameNow[i].length; j++){
                if(gameNow[i][j].compareTo(solvedState[i][j])){
                    correctCells++;
                }
                if(correctCells == cellCount){
                    isSolved = true;
                }
            }
        }

        return isSolved;
    }

    public static void winnerWinnerChickenDinner(int swaps){
        StdDraw.setPenColor(255,255,255);
        Font font = new Font("Arial", Font.BOLD, 24);
        StdDraw.setFont(font);

        StdDraw.text(11,19,"You Win");

        Font font1 = new Font("Arial", Font.CENTER_BASELINE, 16);
        StdDraw.setFont(font1);

        StdDraw.text(11,6,"It took you " + swaps +  " moves. Can you do better?");

        StdDraw.show();
    }

    public static void main(String[] args) {

        StdDraw.setXscale(-2, 24);
        StdDraw.setYscale(-2, 24);

        Color hue = new Color();
        int hueChanger = 60;
        while(hue.getH()+hueChanger > 360){
            hueChanger--;
        }
        Color hue2 = new Color(hue.getH()+hueChanger);

        Color hue3 = new Color();
        int hueChanger1 = -60;
        while(hue3.getH()+hueChanger1 < 0){
            hueChanger1++;
        }
        Color hue4 = new Color(hue3.getH()+hueChanger1);

        while(Math.abs(hue.getH()-hue3.getH()) < 80 || Math.abs(hue.getH()-hue4.getH()) < 80 || Math.abs(hue2.getH()-hue3.getH()) < 80 || Math.abs(hue2.getH()-hue4.getH()) < 80 ){
            hue = new Color();
            hueChanger = 60;
            while(hue.getH()+hueChanger > 360.0){
                hueChanger--;
            }
            hue2 = new Color(hue.getH()+hueChanger);

            hue3 = new Color();
            hueChanger1 = -60;
            while(hue3.getH()+hueChanger1 < 1.0){
                hueChanger1++;
                if(hue3.getH()-60 < 30){
                    hueChanger1 = 50;
                }
            }
            hue4 = new Color(hue3.getH()+hueChanger1);
        }
        System.out.println("Hue 1 is " + hue.getH());
        System.out.println("Hue 2 is " + hue2.getH());
        System.out.println("Hue 3 is " + hue3.getH());
        System.out.println("Hue 4 is " + hue4.getH());

        //creating the cell array for the game
        Cell[][] game = new Cell[2][11];

        game[0][0] = new Cell(hue, 1, 13);
        for (int i = 1; i < 5; i++){
            game[0][i] = new Cell(hue, 2*i+1, 13);
            game[0][i].lightener(game[0][i-1].getColor());
        }
        game[0][10] = new Cell(hue2, 21, 13);
        for( int i = 9; i >= 5; i--){
            game[0][i] = new Cell(hue2, 2*i+1, 13);
            game[0][i].lightener(game[0][i+1].getColor());
        }

        game[1][0] = new Cell(hue3, 1, 9);
        for (int i = 1; i < 5; i++){
            game[1][i] = new Cell(hue3, 2*i+1, 9);
            game[1][i].lightener(game[1][i-1].getColor());
        }
        game[1][10] = new Cell(hue4, 21, 9);
        for( int i = 9; i >= 5; i--){
            game[1][i] = new Cell(hue4, 2*i+1, 9);
            game[1][i].lightener(game[1][i+1].getColor());
        }


        //Solved version of the game. the correct answer
        Cell[][] solvedState = new Cell[game.length][game[0].length];
        solvedState[0][0] = new Cell(hue, 1, 11);
        for (int i = 1; i < 5; i++){
            solvedState[0][i] = new Cell(hue, 2*i+1, 11);
            solvedState[0][i].lightener(solvedState[0][i-1].getColor());
        }
        solvedState[0][10] = new Cell(hue2, 21, 11);
        for( int i = 9; i >= 5; i--){
            solvedState[0][i] = new Cell(hue2, 2*i+1, 11);
            solvedState[0][i].lightener(solvedState[0][i+1].getColor());
        }
        solvedState[1][0] = new Cell(hue3, 1, 7);
        for (int i = 1; i < 5; i++){
            solvedState[1][i] = new Cell(hue3, 2*i+1, 7);
            solvedState[1][i].lightener(solvedState[1][i-1].getColor());
        }
        solvedState[1][10] = new Cell(hue4, 21, 7);
        for( int i = 9; i >= 5; i--){
            solvedState[1][i] = new Cell(hue4, 2*i+1, 7);
            solvedState[1][i].lightener(solvedState[1][i+1].getColor());
        }


        StdDraw.enableDoubleBuffering();
        gameDrawer(game);
        StdDraw.setPenColor(255,255,255);
        Font font = new Font("Arial", Font.BOLD, 24);
        StdDraw.setFont(font);

        StdDraw.text(11,19,"Take a Good Look");
        StdDraw.show();

        StdDraw.pause(6500);
        Cell[][] realGame = game;
        gameRandomizer(realGame);

        int timesClicked = 0;
        int swaps = 0;
        int[][] cellsClicked = new int[2][2];
        cellsClicked[0] = new int[]{-1, -1};
        cellsClicked[1] = new int[]{0, 0};


        //this is the loop where the game will take place
        while (true) {

            //checking if the moused clicked a cell, and changing variables as necessary to show/store that
            double[] coords = new double[2];
            if (StdDraw.isMousePressed() == true) {
                coords[0] = StdDraw.mouseX();
                coords[1] = StdDraw.mouseY();
            }

            double x = coords[0];
            double y = coords[1];

            for (int i = 0; i < realGame.length; i++) {
                for(int j = 0; j < realGame[i].length; j++){
                    if (x < realGame[i][j].getxValue() + 1 && x > realGame[i][j].getxValue() - 1) {
                        if (y < realGame[i][j].getyValue() + 1 && y > realGame[i][j].getyValue() - 1) {
                            while(StdDraw.isMousePressed()==true){
                                if(StdDraw.isMousePressed()==false){
                                    break;
                                }
                                StdDraw.setPenColor(StdDraw.WHITE);
                                StdDraw.filledCircle(coords[0], coords[1], .2);
                                StdDraw.show();
                            }

                            timesClicked++;
                            realGame[i][j].setClicked(true);
                            if(cellsClicked[0][0] ==-1){
                                cellsClicked[0][0] = i;
                                cellsClicked[0][1]= j;
                            } else{
                                cellsClicked[1][0]=i;
                                cellsClicked[1][1]=j;
                            }
                        }
                    }
                }

            }

            if(timesClicked%2 ==0 && timesClicked > 0){
                realGame[cellsClicked[0][0]][cellsClicked[0][1]].switcher(realGame[cellsClicked[1][0]][cellsClicked[1][1]]);
                cellsClicked[0] = new int[]{-1, -1};
                cellsClicked[1] =  new int[]{0, 0};
                timesClicked = 0;
                swaps++;
            }


            StdDraw.pause(5);
            gameDrawer(realGame);

            if(gameChecker(realGame, solvedState) == true){
                break;}
        }
        System.out.println("Done");
        winnerWinnerChickenDinner(swaps);

    }
}