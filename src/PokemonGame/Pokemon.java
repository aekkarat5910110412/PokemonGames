package PokemonGame;

abstract class Pokemon{

    protected float hp;
    protected float mp;
    protected String name;
    protected String[] types;
    protected String skill;
    protected float weight;
    protected float gainweight;
    protected float loseweight;

    public Pokemon(String name, float weight, float gainweight , float loseweight, float hp, float mp, String skill, String[] types){
        this.name = name;
        this.weight = weight;
        this.hp = hp;
        this.mp = mp;
        this.skill = skill;
        this.types = types;
        this.gainweight = gainweight;
        this.loseweight = loseweight;
    }

    public String getName(){
        return this.name;
    }
    public void eat(){
        weight += gainweight;
    }

    public void LoseWeight() {
        weight -= loseweight;
    }

    public void Addblood(){
        hp += 50;
    }
    public float getWeight() {
        return weight;
    }
    public String getTypes() {
        String ty = "";
        for(String type: types){
            ty += type+ "";
        }
        return ty;
    }
    public float getHp() {
        return hp;
    }
    public float getMp() {
        return mp;
    }
    public void Attack(float damage) {
        hp = hp - damage;
    }
    public void Mana(float damage) {
        mp = mp - (damage/2);
    }
    public String getSkill() {
        return this.skill;
    }
    public void print(){
        System.out.println("Pokemon name: " + name);
        System.out.print("        Type: ");
        for(String type: types){
            System.out.print(type+",");
        }
        System.out.println();
        System.out.println("      Weight: " + weight);
        System.out.println(" Skill: " + skill);
        System.out.println("  CP: " + hp);
        System.out.println("------------------------------------------");
    }
}
