import java.util.ArrayList;

public class Map {
    private int _width = 0; // # of columns aka x
    private int _height = 0; // # of rows aka y
    private Boolean[][] _walls; //mutable grid of true&false values
    private Boolean[][] _heroBools;
    private Hero[][] _heroes;

    //_width = 0;
    //_height = 0;
    //_walls = [[false]];
    //_heroes = {{null}};
    //_heroBools = {{false}};

    //Map Constructor
    public Map(int width, int height, Boolean[][] walls, Hero[][] heroes){
        _walls = new Boolean[width][height]; //mutable grid of true&false values
        _heroBools = new Boolean[width][height];
        _heroes = new Hero[width][height];

        _width = width;
        _height = height;
        _walls = walls;
        _heroes = heroes;
        
        for (int x = 0; x < width - 1; x++) {
            for (int y = 0; y < height - 1; y++) {
                if (heroes[x][y] instanceof Hero) {
                    _heroBools[x][y] = true;
                }
            }
        }
    }
        
    private Boolean[][] getWalls() {
        return _walls;
    }
    
    private Hero[][] getHeroes() {
        return _heroes;
    }
    
    /** Removes the hero object at coordinate (X, Y). Returns false if there
      * wasn't a hero to remove in the first place. */
    private Boolean removeHero(int x, int y) {
        if (_heroBools[x][y]) {
            _heroes[x][y] = null;
            _heroBools[x][y] = false;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Hero songKing = new Hero(5, 1, 10, 100);
        Hero kevinKoh = new Hero(5, 1, 15, 200);
        songKing.xPos = 0;
        songKing.yPos = 0;
        kevinKoh.xPos = 1;
        kevinKoh.yPos = 1;
        songKing.team = 1; // team 1
        kevinKoh.team = 2; // team 2

        Hero[][] someHeroes = {{songKing, null, null}, {null, kevinKoh, null}, {null, null, null}};
        Boolean[][] someWalls = {{false, true, false}, {false, false, false}, {false, false, false}};

        //someHeroes.set(0, new ArrayList<Hero>(){songKing, null, null});
        /**
        someHeroes = [[songKing, null, null],[null, kevinKoh, null],[null, null, null]];
        Boolean[][] someWalls = new Hero[][];
        someWalls = [[false, true, false], [false, false, false], [false, false, false]];
    */
        Map m = new Map(3, 3, someWalls, someHeroes);

        System.out.print("Is Song alive? ");
        System.out.println(songKing.isAlive());
        System.out.print("Song's HP is now: ");
        songKing.seeHP();
        System.out.println("Is Kevin in Song's attack range?: " + songKing.inAttackRange(kevinKoh));
        System.out.println("Is Kevin even attackable?: " + songKing.attackable(kevinKoh));

        System.out.print("Kevin's HP is now: ");
        kevinKoh.seeHP();

        songKing.attack(kevinKoh);

        songKing.changeY(1);
        songKing.attack(kevinKoh);

        System.out.print("Kevin's HP is now: ");
        kevinKoh.seeHP();
        System.out.println("He took " + songKing.damage + " damage.");
    }
}