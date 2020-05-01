package PokemonGame;
import java.util.*;

public class PokemonFarm {

    private ArrayList<Pokemon> pokemons;
    public PokemonFarm(){
        pokemons = new ArrayList<Pokemon>();
        pokemons.add(new Electr("Pikachu", 20, "Thunderbolt" , 780, 500));
        pokemons.add(new Fire("Charmander", 30,"Flame Burst",800 , 650));
        pokemons.add(new Water("Squirtle", 45,"Aqua Tail",880 , 600));
    }

    public void AddPokemon(Pokemon pokemon){
        pokemons.add(pokemon);
    }
    public void list(){
        for(Pokemon pokemon: pokemons){
            pokemon.print();
        }
    }

    public void feed(String pokemonName){
        if(pokemonName.equals("all")){
            for(Pokemon pokemon: pokemons){
                pokemon.eat();
            }
        }
        else {
            for(Pokemon pokemon: pokemons){
                if(pokemonName.equals(pokemon.getName())){
                    pokemon.eat();
                }
            }
        }

    }
    public int getPokemonAmount(){
        return pokemons.size();
    }
    public String getPokemon(int i){
        return pokemons.get(i).getName();
    }
    public Pokemon getPokemonName(String name){
        Pokemon now = null;
        for(Pokemon pokemon: pokemons){
            if (pokemon.getName().equals(name)){
                return pokemon;
            }
        }
        return now;
    }
    public Pokemon getPokemonAttack(String name1 ,String name2){
        Pokemon now = null;

        for(Pokemon pokemon1 : pokemons ){
            for(Pokemon pokemon2 : pokemons ){

                if (pokemon1.getName().equals(name1) && pokemon2.getName().equals(name2)){
                    PokemonSkill skill1 = new PokemonSkill(pokemon1.getSkill());
                    PokemonSkill skill2 = new PokemonSkill(pokemon2.getSkill());

                    if(skill1.getDamage(pokemon1.getSkill()) - skill2.getDamage(pokemon2.getSkill()) > 0 ){
                        pokemon2.Attack(skill1.getDamage(pokemon1.getSkill()) - skill2.getDamage(pokemon2.getSkill()));
                        pokemon2.Mana(skill1.getDamage(pokemon1.getSkill()) - skill2.getDamage(pokemon2.getSkill()));
                        return pokemon2;
                    }
                    else if(skill1.getDamage(pokemon1.getSkill()) - skill2.getDamage(pokemon2.getSkill()) < 0 ){
                        pokemon1.Attack(skill2.getDamage(pokemon2.getSkill()) - skill1.getDamage(pokemon1.getSkill()));
                        pokemon1.Mana(skill2.getDamage(pokemon2.getSkill()) - skill1.getDamage(pokemon1.getSkill()));
                        return pokemon2;
                    }
                    else{
                        pokemon2.Mana(skill1.getDamage(pokemon1.getSkill()) - skill2.getDamage(pokemon2.getSkill()));
                        return pokemon2;
                    }
                }

            }
        }
        return now;
    }

    public Pokemon getPokemonMana(String name1 ,String name2){
        Pokemon now = null;

        for(Pokemon pokemon1 : pokemons ){
            for(Pokemon pokemon2 : pokemons ){

                if (pokemon1.getName().equals(name1) && pokemon2.getName().equals(name2)){
                    PokemonSkill skill1 = new PokemonSkill(pokemon1.getSkill());
                    PokemonSkill skill2 = new PokemonSkill(pokemon2.getSkill());

                    if(skill1.getDamage(pokemon1.getSkill()) - skill2.getDamage(pokemon2.getSkill()) > 0 ){
                        pokemon1.Mana(skill1.getDamage(pokemon1.getSkill()) - skill2.getDamage(pokemon2.getSkill()));
                        return pokemon1;
                    }
                    else if(skill1.getDamage(pokemon1.getSkill()) - skill2.getDamage(pokemon2.getSkill()) < 0 ){
                        pokemon2.Mana(skill2.getDamage(pokemon2.getSkill()) - skill1.getDamage(pokemon1.getSkill()));
                        return pokemon1;
                    }
                    else{
                        pokemon2.Mana(skill1.getDamage(pokemon1.getSkill()) - skill2.getDamage(pokemon2.getSkill()));
                        return pokemon2;
                    }
                }

            }
        }
        return now;
    }
}

