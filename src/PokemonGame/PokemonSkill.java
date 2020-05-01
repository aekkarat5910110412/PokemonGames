package PokemonGame;

public class PokemonSkill{
    private String name;
    private float damage;

    public PokemonSkill(String name){
        this.name = name;
        this.damage = damage;
    }

    public String getName(){
        return this.name;
    }

    public float getDamage(String name){
        switch(name){
            case "Drill Peck":
                damage = 40;
                break;
            case "Body Slam":
                damage = 40;
                break;
            case "Dig":
                damage = 70;
                break;
            case "Power Whip":
                damage = 70;
                break;
            case "Sludge Bomb":
                damage =  55;
                break;
            case "Petal Blizzard":
                damage =  65;
                break;
            case "Aqua Tail":
                damage =  45;
                break;
            case "Hydro Pump":
                damage =  90;
                break;
            case "Ice Beam":
                damage =  65;
                break;
            case "Flame Burst":
                damage =  30;
                break;
            case "Fire Punch":
                damage =  40;
                break;
            case "Fire Blast":
                damage =  100;
                break;
            case "Thunder":
                damage =  100;
                break;
            case "Thunderbolt":
                damage =  55;
                break;
            case "Flash Cannon":
                damage =  60;
                break;
            case "Struggle":
                damage =  15;
                break;
            case "Signal Beam":
                damage =  45;
                break;
            case "Bug Buzz":
                damage =  75;
                break;
            case "Gunk Shot":
                damage =  65;
                break;
            case "Mud Bomb":
                damage =  30;
                break;
            case "Earthquake":
                damage =  100;
                break;
            case "Cross Chop":
                damage =  60;
                break;
            case "Stone Edge":
                damage =  80;
                break;
            case "Ice Punch":
                damage =  45;
                break;
            case "Dazzling Gleam":
                damage =  55;
                break;
            case "Hyper Beam":
                damage =  120;
                break;
            case "Psychic":
                damage =  55;
                break;
        }
        return this.damage;
    }
}
