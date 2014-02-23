public class Game {

    public Player redPlayer;
    public Player bluePlayer;
    public Map gameMap;
    public Hero[][] redHeroes;
    public Hero[][] blueHeroes;
    
    // Game constructor
    public Game() {
        gameMap = new Map(17, 10, /*WALLS*/, /*HEROES*/)
        redPlayer = new Player("red", gameMap);
        bluePlayer = new Player("blue", gameMap);
        redPlayer.isTurn = true;
    }
    
    // Method that is called to switch turns when a player ends turn.
    public void switchTurns() {
        if (redPlayer.isTurn == true) {
            redPlayer.isTurn = false;
            bluePlayer.isTurn = true;
        }
        else {
            redPlayer.isTurn = true;
            bluePlayer.isTurn = false;
        }
    }
    
    // Sets the heroes at their starting coordinates.
    private void setHeroes() {
        redHeroes = new Hero[gameMap.getWidth()][gameMap.getHeight()];
        blueHeroes = new Hero[gameMap.getWidth()][gameMap.getHeight()];
        // Using Kevin's coordinate system
        redHeroes[16][3] = new Hero(16, 3, 5, 1, 2, 10, "red");
        redHeroes[16][4] = new Hero(16, 4, 5, 1, 2, 10, "red");
        redHeroes[16][6] = new Hero(16, 6, 5, 1, 2, 10, "red");
        redHeroes[16][7] = new Hero(16, 7, 5, 1, 2, 10, "red");
        redHeroes[16][2] = new Hero(16, 2, 5, 1, 2, 10, "red");
        redHeroes[16][5] = new Hero(16, 5, 5, 1, 2, 10, "red");       
        blueHeroes[3][1] = new Hero(3, 1, 5, 1, 2, 10, "blue");
        blueHeroes[4][1] = new Hero(3, 1, 5, 1, 2, 10, "blue");
        blueHeroes[6][1] = new Hero(3, 1, 5, 1, 2, 10, "blue");
        blueHeroes[7][1] = new Hero(3, 1, 5, 1, 2, 10, "blue");
        blueHeroes[4][3] = new Hero(3, 1, 5, 1, 2, 10, "blue");
        blueHeroes[7][3] = new Hero(3, 1, 5, 1, 2, 10, "blue"); 
        redPlayer.numEnemyUnits = 6;
        bluePlayer.numEnemyUnits = 6;                                                                
    }

    // Ends the game.
    public void endGame() {
        System.out.println("GAME OVER!");
    }
}