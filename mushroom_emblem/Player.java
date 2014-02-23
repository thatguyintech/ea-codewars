import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class Player {

    public Boolean isTurn;
    private String _team;
    private Map _map;
    public Hero[][] heroes;
    public int numEnemyUnits;
    
    // Player constructor.
    public Player(String team, Map m) {
        isTurn = false;
        _team = team;
        _map = m;
        heroes = m.getHeroes();
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
        _map.removeHero(mushroom.getX(), mushroom.getY());
    }
    
    //uses breadthFirstTraversal to find the shortest path to goal location
    //takes in MUSHROOM and coordiates X and Y to the new position
    //if path exists, return an arraylist of strings describing path
    public ArrayList<String> move(Hero mushroom, int newX, int newY) {
        int[] oldPos = {mushroom.getX(), mushroom.getY()};
        Loc startLoc = new Loc(oldPos, new ArrayList<String>());
        
        int[] newPos = {newX, newY};
        
        ArrayList<String> path = breadthFirstTraversal(startLoc, newPos, mushroom.getMoveRange());
        
        if (path.size() != 0) {
            _map.removeHero(oldPos[0], oldPos[1]);
            _map.addHero(newX, newY, mushroom);
            mushroom.updatePos(newX, newY);
            return path;            
        }
        return new ArrayList<String>();
    }

    /** takes in a START location that contains start coordinates and an empty list
      * and returns the list of directions that gets your hero to the FINISH position,
      * as long as the destination can be reached in at most DEPTH steps, else return
      * an empty string array.
      */    
    public ArrayList<String> breadthFirstTraversal(Loc start, int[] finish, int depth) {
        
        Queue q = new LinkedList();
        q.add(start);
        
        //don't forget to import java.util.TreeSet
        Set<int[]> closed = new TreeSet<int[]>();
        closed.add(start._position);
        
        if (start._position.equals(finish)) {
            return new ArrayList<String>();
        }
            
        while(!q.isEmpty()){
            Loc currLoc = (Loc)q.poll(); //pop from the fringe
            if (currLoc._position.equals(finish)) { //check if you made it to where you wanna be!
                return currLoc._directions;
            }
            if (currLoc._directions.size() == depth) { //otherwise if you're at the max depth, no solution
                return new ArrayList<String>();
            }
            String newD = "";
            for (int dx = -1; dx < 2; dx++) { //go left and right first
                if (dx != 0) {
                    int[] newcoord = {currLoc._position[0] + dx, currLoc._position[1]};
                    switch (dx) {
                       case -1: newD = "w";
                                break;
                       case 1:  newD = "e";
                                break;
                    }
                    currLoc._directions.add(newD);
                    Loc newLoc = new Loc(newcoord, currLoc._directions);
                    if (closed.contains(newcoord) == false) {
                        closed.add(newLoc._position);
                        q.add(newLoc);
                    }
                }        
            }
            for (int dy = -1; dy < 2; dy++) { //go up and down next
                if (dy != 0) {
                    int[] newcoord = {currLoc._position[0], currLoc._position[1] + dy};
                    switch (dy) {
                       case -1: newD = "s";
                                break;
                       case 1:  newD = "n";
                                break;
                    }
                    currLoc._directions.add(newD);
                    Loc newLoc = new Loc(newcoord, currLoc._directions);
                    if (!closed.contains(newcoord)) {
                        closed.add(newLoc._position);
                        q.add(newLoc);
                    }
                }        
            }
        }
        return new ArrayList<String>(); 
    }
}