import java.util.ArrayList;

public class Map {
    private int _width = 0; // # of columns aka x
    private int _height = 0; // # of rows aka y
    private ArrayList<ArrayList<Boolean>> _walls = new ArrayList<ArrayList<Boolean>>(); //mutable grid of true&false values
    private ArrayList<ArrayList<Boolean>> _heroBools = new ArrayList<ArrayList<Boolean>>();
    private ArrayList<ArrayList<Hero>> _heroes = new ArrayList<ArrayList<Hero>>();    

    //_width = 0;
    //_height = 0;
    //_walls = [[false]];
    //_heroes = {{null}};
    //_heroBools = {{false}};

    //Map Constructor
    public Map(int width, int height, ArrayList<ArrayList<Boolean>> walls, ArrayList<ArrayList<Hero>> heroes){
        _width = width;
        _height = height;
        _walls = walls;
        _heroes = heroes;
        
        for (int x = 0; x < width - 1; x++) {
            for (int y = 0; y < height - 1; y++) {
                if (heroes.get(x).get(y) instanceof Hero) {
                    _heroBools.get(x).set(y, true);
                }
            }
        }
    }
        
    private ArrayList<ArrayList<Boolean>> getWalls() {
        return _walls;
    }
    
    private ArrayList<ArrayList<Hero>> getHeroes() {
        return _heroes;
    }
    
    /** Removes the hero object at coordinate (X, Y). Returns false if there
      * wasn't a hero to remove in the first place. */
    private Boolean removeHero(int x, int y) {
        if (_heroBools.get(x).get(y)) {
            _heroes.get(x).set(y, null);
            _heroBools.get(x).set(y, false);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Hero songKing = new Hero(5, 5, 10, 100);
        Hero kevinKoh = new Hero(5, 5, 15, 200);
        songKing.xPos = 1;
        songKing.yPos = 1;
        kevinKoh.xPos = 1;
        kevinKoh.yPos = 0;
        songKing.team = 1; // team 1
        kevinKoh.team = 2; // team 2

        System.out.print("Is Song alive? ");
        System.out.println(songKing.isAlive());
        System.out.print("Song's HP is now: ");
        songKing.seeHP();
        System.out.println("Is Kevin in Song's attack range?: " + songKing.inAttackRange(kevinKoh));
        System.out.println("Is Kevin even attackable?: " + songKing.attackable(kevinKoh));
        songKing.attack(kevinKoh);
        System.out.print("Kevin's HP is now: ");
        kevinKoh.seeHP();
        System.out.println("He took " + songKing.damage + " damage.");

        ArrayList<ArrayList<Hero>> someHeroes = [[songKing, null, null],[null, kevinKoh, null],[null, null, null]];
        ArrayList<ArrayList<Boolean>> someWalls = [[false, true, false], [false, false, false], [false, false, false]];

        Map m = new Map(3, 3, someWalls, someHeroes);
    }
}