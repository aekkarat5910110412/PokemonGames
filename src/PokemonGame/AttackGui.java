package PokemonGame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AttackGui extends JFrame{
    private String[] pokemonName;

    public AttackGui(PokemonFarm pokemonFarm){
        super("Attack");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        pokemonName = new String[pokemonFarm.getPokemonAmount()];
        for (int i = 0; i < pokemonFarm.getPokemonAmount(); i++) {
            pokemonName[i] = pokemonFarm.getPokemon(i);
        }

        //pokemon1
        JPanel start = new JPanel();
        start.setLayout(new FlowLayout());
        JLabel jName1 = new JLabel("Pokemon Name1: ");
        JComboBox pokemon1 = new JComboBox(pokemonName);
        JButton enter1 = new JButton("Enter");
        JLabel pokemonpic1 = new JLabel();
        pokemonpic1 .setHorizontalAlignment(JLabel.CENTER);
        Icon img1 = new ImageIcon(getClass().getResource("Pokeball.png"));
        pokemonpic1 .setIcon(img1);

        //pokemon2
        JPanel center = new JPanel();
        center.setLayout(new FlowLayout());
        JLabel jName2 = new JLabel("Pokemon Name2: ");
        JComboBox pokemon2 = new JComboBox(pokemonName);
        JButton enter2 = new JButton("Enter");
        JLabel pokemonpic2 = new JLabel();
        pokemonpic2 .setHorizontalAlignment(JLabel.CENTER);
        Icon img2 = new ImageIcon(getClass().getResource("Pokeball.png"));
        pokemonpic2 .setIcon(img2);

        //attack&&exit
        JPanel end = new JPanel();
        end.setLayout(new GridLayout(0,2));
        JLabel Hp1 = new JLabel("HP of 1");
        JLabel Hp2 = new JLabel("HP of 2");
        JLabel Mp1 = new JLabel("MP of 1");
        JLabel Mp2 = new JLabel("MP of 2");
        JLabel Damage1 = new JLabel("Damage of 1");
        JLabel Damage2 = new JLabel("Damage of 2");
        JButton attack = new JButton("Battle");
        JButton exit = new JButton("Exit");


        attack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name1 = (String) pokemon1.getSelectedItem();
                String name2 = (String) pokemon2.getSelectedItem();

                Pokemon pokemon2 = pokemonFarm.getPokemonAttack(name1, name2);
                Pokemon pokemon1= pokemonFarm.getPokemonMana(name1,name2);

                switch (name1){
                    case "Pikachu": Hp1.setText("HP of Pikachu : " +pokemon1.getHp());
                        Mp1.setText("MP of Pikachu : " +pokemon1.getMp());
                        break;
                    case "Charmander": Hp1.setText("HP of Charmander : "+pokemon1.getHp());
                        Mp1.setText("MP of Charmander : "+pokemon1.getMp());
                        break;
                    default : Hp1.setText("HP of "+ name1 + " : "+pokemon1.getHp());
                        Mp1.setText("MP of "+ name1 + " : "+pokemon1.getMp());
                        break;
                }

                switch (name2){
                    case "Pikachu": Hp2.setText("HP of Pikachu : "+pokemon2.getHp());
                        Mp2.setText("MP of Pikachu : " +pokemon2.getMp());
                        break;
                    case "Charmander": Hp2.setText("HP of Charmander : "+pokemon2.getHp());
                        Mp2.setText("MP of Charmander : "+pokemon2.getMp());
                        break;
                    default : Hp2.setText("HP of "+ name2 + ": "+pokemon2.getHp());
                        Mp2.setText("MP of "+ name2 + " : "+pokemon2.getMp());
                        break;
                }
            }
        });


        enter1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = (String) pokemon1.getSelectedItem();
                Pokemon pokemon= pokemonFarm.getPokemonName(name);
                PokemonSkill skill = new PokemonSkill(pokemon.getSkill());

                switch (name){
                    case "Pikachu": Hp1.setText("HP of Pikachu : " +pokemon.getHp());
                        Mp1.setText("MP of Pikachu : " +pokemon.getMp());
                        Damage1.setText("Damage of Pikachu : " +skill.getDamage(pokemon.skill));
                        pokemonpic1.setIcon(new ImageIcon(getClass().getResource( "./imagefiles/Pikachu.png")));
                        break;
                    case "Charmander": Hp1.setText("HP of Charmander : "+pokemon.getHp());
                        Mp1.setText("MP of Charmander : "+pokemon.getMp());
                        Damage1.setText("Damage of Charmander : " +skill.getDamage(pokemon.skill));
                        pokemonpic1.setIcon(new ImageIcon(getClass().getResource( "./imagefiles/Charmander.png")));
                        break;
                    default : Hp1.setText("HP of "+ name + " : "+pokemon.getHp());
                        Mp1.setText("MP of "+ name + " : "+pokemon.getMp());
                        Damage1.setText("Damage of "+ name + " : " +skill.getDamage(pokemon.skill));
                        pokemonpic1.setIcon(new ImageIcon(getClass().getResource( "./imagefiles/" + name +".png")));
                        break;
                }
            }
        });


        enter2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = (String) pokemon2.getSelectedItem();
                Pokemon pokemon= pokemonFarm.getPokemonName(name);
                PokemonSkill skill = new PokemonSkill(pokemon.getSkill());

                switch (name){
                    case "Pikachu": Hp2.setText("HP of Pikachu : "+pokemon.getHp());
                        Mp2.setText("MP of Pikachu : " +pokemon.getMp());
                        Damage2.setText("Damage of Pikachu : " +skill.getDamage(pokemon.skill));
                        pokemonpic2.setIcon(new ImageIcon(getClass().getResource( "./imagefiles/Pikachu.png")));
                        break;
                    case "Charmander": Hp2.setText("HP of Charmander : "+pokemon.getHp());
                        Mp2.setText("MP of Charmander : "+pokemon.getMp());
                        Damage2.setText("Damage of Charmander : " +skill.getDamage(pokemon.skill));
                        pokemonpic2.setIcon(new ImageIcon(getClass().getResource( "./imagefiles/Charmander.png")));
                        break;
                    default : Hp2.setText("HP of "+ name + ": "+pokemon.getHp());
                        Mp2.setText("MP of "+ name + " : "+pokemon.getMp());
                        Damage2.setText("Damage of "+ name + " : " +skill.getDamage(pokemon.skill));
                        pokemonpic2.setIcon(new ImageIcon(getClass().getResource( "./imagefiles/" + name +".png")));
                        break;
                }
            }
        });

        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });

        start.add(jName1);
        start.add(pokemon1);
        start.add(enter1);
        start.add(pokemonpic1);
        c.add(start,BorderLayout.PAGE_START);

        center.add(jName2);
        center.add(pokemon2);
        center.add(enter2);
        center.add(pokemonpic2);
        c.add(center,BorderLayout.CENTER);

        end.add(Hp1);
        end.add(Hp2);
        end.add(Mp1);
        end.add(Mp2);
        end.add(Damage1);
        end.add(Damage2);


        end.add(attack);
        end.add(exit);
        c.add(end, BorderLayout.PAGE_END);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setVisible(true);
    }
}
