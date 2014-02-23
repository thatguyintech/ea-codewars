public class Player {

    private Boolean isTurn;
    private String _team;
    private Map _map;
    private Hero[][] heroes;
    private int numEnemyUnits;
    
    // Player constructor.
    public Player(String team, Map m) {
        isTurn = false;
        _team = team;
        _map = m;
        heroes = m.getHeroes()
    }
    
    // Player commands a hero to attack enemy hero
    public void makeAttack(Hero mushroom, Hero enemy) {
        mushroom.attack(enemy);
        if (enemy.isAlive() == false) {
            remove(enemy);
            numEnemyUnits--;
            if (numEnemyUnits == 0) {
                Game.endGame();
            }
        }
    }

    // Player removes his/her hero from the map.
    public void remove(Hero mushroom) {
        Map.removeHero(mushroom.getX(), mushroom.getY());
    }

    // Player ends his/her turn.
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