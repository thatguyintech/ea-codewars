public class Hero {
    protected boolean selected;
    protected boolean hasMoved;
    protected boolean hasAttacked;
    protected boolean isTurn;
    protected boolean isAlive;
    protected int team;
    protected int moveRange;
    protected int attackRange;
    protected int damage;
    protected int hp;
    protected int[] pos = new int[2];

    // Hero constructor
    public Hero(int x, int y, int myMoveRange, int myAttackRange, int myDamage, int myHP, int t) {
        moveRange = myMoveRange;
        attackRange = myAttackRange;
        damage = myDamage;
        hp = myHP;
        pos[0] = x; pos[1] = y;
        team = t;
    }

    // See hero's hp
    public int getHP() {
        return hp;
    }

    // Check if the unit is alive; if not, remove it from the map
    public boolean isAlive() {
        if (hp > 0) {
            return true;
        }
        else {
            remove();
            return false;
        }
    }

    // Method that calls the Game Master's remove method to remove the unit from the game.
    private void remove() {
        Player.remove(this);
    }

    // Toggles the hero's movement for the turn.
    public void alreadyMoved() {
        if (hasMoved == true) {
            return;
        }
        hasMoved = false;
    }

    // Checks if the enemy is in attack range.
    public boolean inAttackRange(Hero enemy) {
        if (((Math.abs(enemy.getX() - pos[0]) <= attackRange && enemy.getY() == pos[1]) || ((Math.abs(enemy.getY() - pos[1]) <= attackRange) && enemy.getX() == pos[0]))) {
            return true;
        }
        return false;
    }

    // Checks if the enemy is actually an enemy or not, and if it is in attack range.
    public boolean attackable(Hero enemy) {
        if (enemy.team != team) {
            if (inAttackRange(enemy) == true) {
                return true;
            }
        }
        return false;
    }

    // Hero attacks the enemy by subtracting damage from the enemy's hp, then checking if the enemy is dead or alive afterwards.
    public void attack(Hero enemy) {
        if (attackable(enemy) && hasAttacked == false) {
            enemy.hp -= damage;
            enemy.isAlive();
            hasAttacked = true;
        } else {
            System.out.println("Enemy out of range!");
        }
    }

    public int getX() {
        return pos[0];
    }

    /** Change the old pos[0] to X. */
    public void changeX(int x) {
        pos[0] = x;
    }

    public int getY() {
        return pos[1];
    }

    /** Change the old pos[1] to Y. */
    public void changeY(int y) {
        pos[1] = y;
    }

}
