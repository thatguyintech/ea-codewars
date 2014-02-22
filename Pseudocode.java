Class GameAgent:
    
    location;
    player;
    endTurn;
    walls;
    allCharPos = {}
    
Class Map:
    

Class Hero:
    selected = False;
    hasMoved = False;
    hasAttacked = False;
    isTurn = False;
    isAlive = True;
    team = player;
    moveRange;
    attackRange
    damage;
    hp;
    

    Class Warrior inherits from Hero:
        moveRange = 5;
        attackRange = 5;
        damage = 5;
        hp = 10;
        
        // Warrior constructor takes in movement range, attack range, damage, and hp.
        def Warrior(moveRange, attackRange, damage, hp):
            moveRange = moveRange;
            attackRange = attackRange;
            damage = damage;
            hp = hp;
        
        // Check if the unit is alive.
        def isAlive():
            if hp > 0:
                return true;                
            else
                self.remove();
                return False;
                
       // Method that removes the unit from the game.
       def remove():
           KILL YOSELF; // somehow make this unit vanish
    
    
    
        def move(self, newPos):
            if hasMoved == True:
                return
            if newPos in walls:
                return
            if newPos in allCharPos:
                return
            if moveRange < mazeDistance(currPos, newPos):
                return
            currPos = newPos;
            //move graphics
            self.hasMoved = True;
        
        
        /**Takes in ENEMY unit as input, checks if that enemy is attackable, and attacks.*/        
        def attack(enemy):
            if attackable(enemy) && hasAttacked == false:
                enemy.hp -= self.damage;
                enemy.isAlive();
            hasAttacked = True;
        
        /**Takes in ENEMY unit as input, checks if enemy is attackable.*/
        def attackable(enemy):
            if enemy.team <= range:
                if enemy.team != self.team:
                    return True
            return False        
            
