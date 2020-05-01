package PokemonGame;

public class Poison extends Pokemon{
    public Poison(String name, float weight,String skill,float hp,float mp){
        super(name, weight,2.2f, 0.5f, hp ,mp ,skill, new String[] {"Poison"});
    }
}