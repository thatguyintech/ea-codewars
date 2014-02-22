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
    protected int xPos;
    protected int yPos;

    // Hero constructor
    public Hero(int myMoveRange, int myAttackRange, int myDamage, int myHP) {
        moveRange = myMoveRange;
        attackRange = myAttackRange;
        damage = myDamage;
        hp = myHP;
    }

    // See hero's hp
    public void seeHP() {
        int health = hp;
        System.out.println(health);
    }

    // Check if the unit is alive; if not, remove it from the map
    public boolean isAlive() {
        if (hp > 0) {
            return true;
        }
        else {
            //remove();
            return false;
        }
    }

    // Method that calls the Game Master's remove method to remove the unit from the game.
    /*private void remove() {
        Map.remove(this);
    }*/

    // Toggles the hero's movement for the turn.
    public void move() {
        if (hasMoved == true) {
            return;
        }
        hasMoved = false;
    }

    // Checks if the enemy is in attack range.
    public boolean inAttackRange(Hero enemy) {
        if ((Math.abs(enemy.xPos - xPos) <= attackRange) || (Math.abs(enemy.yPos - yPos) <= attackRange)) {
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
        }
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }
}
