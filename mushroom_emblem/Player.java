Players:
-team
-Map
    -matrix of Heroes

what does the player do?
    moves heroes (aka must check legality of moves too)
        both on map
        and on hero
    makes heroes attack (check legality of attack) (heroes have these methods, player just calls them)
    remove heroes
    end turn
    
what do heroes do?
    heroes perform attack
    
Game:
    -initiates players (team) and map
    -initiates heroes
    -sets heroes to specific coordinates
    -sets turns
    -
    
public class Game {

    public Player redPlayer;
    public Player bluePlayer;
    public Map gameMap;
    
    public Game(Player player1, Player player2, Map map) {
        redPlayer = player1;
        bluePlayer = player2;
        gameMap = map;
        redPlayer.isTurn = true;
    }
    
}
    
public class Player {

    private Boolean isTurn;
    private String _team;
    private Map _map;
    private Hero[][] heroes;
    private int numUnits;
    
    public Player(String team, Map m) {
        isTurn = false;
        _team = team;
        _map = m;
        heroes = m.getHeroes()
    }
    
    
    public void makeAttack(Hero mushroom, Hero enemy) {
        mushroom.attack(enemy);
        if (enemy.isAlive() == false) {
            remove(enemy);
        }
    }

    public void remove(Hero mushroom) {
        
    }

    public void endTurn() {
        isTurn = false;
        
    }
    
    public String[] move(Hero mushroom, int newX, int newY) {
        int oldX = mushroom.getX();
        int oldY = mushroom.getY();
        mushroom.updatePos(newX, newY);
        int eastWest = newX - oldX;
        int northSouth = 
        
        
        
    }
}