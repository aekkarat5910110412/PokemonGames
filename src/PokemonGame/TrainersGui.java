package PokemonGame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TrainersGui extends JFrame {
    private String[] pokemonName;

    public TrainersGui (PokemonFarm pokemonFarm) {
        super("TRAINERS");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        pokemonName = new String[pokemonFarm.getPokemonAmount()];

        for (int i = 0; i < pokemonFarm.getPokemonAmount(); i++) {
            pokemonName[i] = pokemonFarm.getPokemon(i);
        }

        JLabel pokemonicon = new JLabel();
        pokemonicon.setHorizontalAlignment(JLabel.CENTER);
        Icon img1 = new ImageIcon(getClass().getResource("International_Pokémon_logo.svg.png"));
        pokemonicon.setIcon(img1);

        JPanel Center = new JPanel();
        Center.setLayout(new GridLayout(0,2));


        //Trainer
        JPanel rightside = new JPanel();
        rightside.setLayout(new GridLayout(0,1));
        JPanel infocom1 = new JPanel();
        infocom1.setLayout(new GridLayout(1,0));
        JLabel name = new JLabel("Name : ");
        JComboBox pokemonList = new JComboBox(pokemonName);

        JPanel infocom2 = new JPanel();
        infocom2.setLayout(new GridLayout(1,0));
        JButton Trainer = new JButton("Trainer");
        JButton back = new JButton("Back");

        JLabel weight = new JLabel("weight : ");


        infocom1.add(name);
        infocom1.add(pokemonList);
        infocom2.add(Trainer);
        infocom2.add(back);
        rightside.add(infocom1);
        rightside.add(infocom2);
        rightside.add(weight);

        JLabel pokemonpic = new JLabel();
        pokemonpic .setHorizontalAlignment(JLabel.CENTER);
        Icon img2 = new ImageIcon(getClass().getResource("Pokeball.png"));
        pokemonpic .setIcon(img2);


        Trainer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = (String) pokemonList.getSelectedItem();
                Pokemon pokemon = pokemonFarm.getPokemonName(name);
                pokemon.LoseWeight();
                switch (name){
                    case "Pikachu": weight.setText("Weight of Pikachu : " + pokemon.getWeight());
                        break;
                    case "Charmander": weight.setText("Weight of Charmander : "+ pokemon.getWeight());
                        break;
                    default : weight.setText("Weight of "+ name + ": "+ pokemon.getWeight());
                        break;
                }

            }
        });
        pokemonList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = (String) pokemonList.getSelectedItem();
                Pokemon pokemon = pokemonFarm.getPokemonName(name);
                switch (name){
                    case "Pikachu": pokemonpic.setIcon(new ImageIcon(getClass().getResource( "./imagefiles/Pikachu.png")));
                        break;
                    case "Charmander": pokemonpic.setIcon(new ImageIcon(getClass().getResource( "./imagefiles/Charmander.png")));
                        break;
                    default : pokemonpic.setIcon(new ImageIcon(getClass().getResource( "./imagefiles/" + name + ".png")));
                        break;
                }

            }
        });

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        c.add(pokemonicon, BorderLayout.PAGE_START);


        Center.add(rightside);
        Center.add(pokemonpic);
        c.add(Center, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setVisible(true);
    }
}
