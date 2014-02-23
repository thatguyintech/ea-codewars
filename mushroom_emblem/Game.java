public class Game {

    public static Player redPlayer;
    public static Player bluePlayer;
    public Map gameMap;
    public Hero[][] heroes;
    public Boolean[][] walls;
    
    // Game constructor
    public Game() {
        heroes = setHeroes();
        gameMap = new Map(17, 10, walls, heroes);
        redPlayer = new Player("red", gameMap);
        bluePlayer = new Player("blue", gameMap);
        redPlayer.numEnemyUnits = 6;
        bluePlayer.numEnemyUnits = 6;
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
    private Hero[][] setHeroes() {
        heroes = new Hero[17][10];
        // Using Kevin's coordinate system
        heroes[16][3] = new Hero(16, 3, 5, 1, 2, 10, "red");
        heroes[16][4] = new Hero(16, 4, 5, 1, 2, 10, "red");
        heroes[16][6] = new Hero(16, 6, 5, 1, 2, 10, "red");
        heroes[16][7] = new Hero(16, 7, 5, 1, 2, 10, "red");
        heroes[16][2] = new Hero(16, 2, 5, 1, 2, 10, "red");
        heroes[16][5] = new Hero(16, 5, 5, 1, 2, 10, "red");       
        heroes[3][1] = new Hero(3, 1, 5, 1, 2, 10, "blue");
        heroes[4][1] = new Hero(3, 1, 5, 1, 2, 10, "blue");
        heroes[6][1] = new Hero(3, 1, 5, 1, 2, 10, "blue");
        heroes[7][1] = new Hero(3, 1, 5, 1, 2, 10, "blue");
        heroes[4][3] = new Hero(3, 1, 5, 1, 2, 10, "blue");
        heroes[7][3] = new Hero(3, 1, 5, 1, 2, 10, "blue"); 
        return heroes;                                                               
    }

    // Ends the game.
    public static void endGame() {
        System.out.println("GAME OVER!");
    }

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(redPlayer.move(redPlayer.heroes[16][3], 16, 1));

    }
}