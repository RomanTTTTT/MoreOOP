import java.util.Random;

abstract class Character {
  private int power;
  private int hp;

  public Character(int hp, int power) {
    this.hp = hp;
    this.power = power;
  }
    
  public abstract void kick(Character c);

  public boolean isAlive() {
    return hp > 0;
  }
  
  public int getPower() {
    return this.power;
  }

  public int getHp() {
    return this.hp;
  }

  public void setHp(int new_hp) {
    this.hp = new_hp;
  }

  public void setPower(int new_power) {
    this.power = new_power;
  }
}

class Hobbit extends Character {
  public Hobbit() {
    super(3, 0);
  }

  @Override
  public void kick(Character c) {
    toCry();
  }

  private void toCry() {
    System.out.println("*crying*");
  }

}
class Elf extends Character {
  public Elf() {
    super(10, 10);
  }

  @Override
  public void kick(Character c) {
    if (this.getPower() > c.getPower()) {
      c.setHp(0);
    }
    else {this.setPower(this.getPower() - 1);}
  }

}
abstract class Noble extends Character {
  public static Random random = new Random();
  public Noble(int min, int max) {
    super(random.nextInt(min, max + 1), random.nextInt(min, max + 1));
  }
  @Override
  public void kick(Character c) {
    c.setHp(c.getHp() - this.getPower());
  }
}
class King extends Noble {
  public King() {
    super(5, 15);
  }
}
class Knight extends Noble {
  public Knight() {
    super(2, 12);
  }
}
class CharacterFactory {
  public Character createCharacter() {
  Random rand = new Random();
  int type = rand.nextInt(4);
  switch (type) {
    case 0: return new Hobbit();
    case 1: return new Elf();
    case 2: return new King();
    case 3: return new Knight();
    default: return new Hobbit();
  }
};
}