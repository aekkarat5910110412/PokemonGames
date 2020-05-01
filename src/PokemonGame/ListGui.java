package PokemonGame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ListGui extends JFrame{
    private String[] pokemonName;

    public ListGui(PokemonFarm pokemonFarm) {
        super("LIST");
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


        //center
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(0,1));
        JPanel inofcom = new JPanel();
        inofcom .setLayout(new FlowLayout());
        JComboBox pokemonList = new JComboBox(pokemonName);

        JButton status = new JButton("Status");
        JButton back = new JButton("Back");

        //status
        //lift list
        JPanel leftside = new JPanel();
        leftside.setLayout(new GridLayout(1,0));
        JLabel pokemonpic = new JLabel();
        pokemonpic.setHorizontalAlignment(JLabel.CENTER);
        Icon img2 = new ImageIcon(getClass().getResource("Pokeball.png"));
        pokemonpic .setIcon(img2);



        //right list
        JPanel rightside = new JPanel();
        rightside.setLayout(new GridLayout(0,1));

        JLabel name = new JLabel("");
        name.setHorizontalAlignment(JLabel.CENTER);
        JLabel type = new JLabel("");
        type.setHorizontalAlignment(JLabel.CENTER);
        JLabel weight = new JLabel("");
        weight.setHorizontalAlignment(JLabel.CENTER);
        JLabel skill = new JLabel("");
        skill.setHorizontalAlignment(JLabel.CENTER);
        JLabel Hp = new JLabel("");
        Hp.setHorizontalAlignment(JLabel.CENTER);
        JLabel Mp = new JLabel("");
        Mp.setHorizontalAlignment(JLabel.CENTER);

        rightside.add(name);
        rightside.add(type);
        rightside.add(weight);
        rightside.add(skill);
        rightside.add(Hp);
        rightside.add(Mp);



        status.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Names = (String) pokemonList.getSelectedItem();
                Pokemon pokemon = pokemonFarm.getPokemonName(Names);
                switch (Names){
                    case "Pikachu": pokemonpic.setIcon(new ImageIcon(getClass().getResource( "./imagefiles/Pikachu.png")));
                        break;
                    case "Charmander": pokemonpic.setIcon(new ImageIcon(getClass().getResource( "./imagefiles/Charmander.png")));
                        break;
                    default : pokemonpic.setIcon(new ImageIcon(getClass().getResource( "./imagefiles/" + Names + ".png")));
                        break;
                }

                name.setText("Name : " + pokemon.getName());
                type.setText("Type : " + pokemon.getTypes());
                weight.setText("Weight : " + pokemon.getWeight());
                skill.setText("Skill : " + pokemon.getSkill());
                Hp.setText("HP : " + pokemon.getHp());
                Mp.setText("MP : " + pokemon.getMp());
            }
        });

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        inofcom.add(pokemonList);
        inofcom.add(status);
        inofcom.add(back);

        leftside.add(pokemonpic);
        leftside.add(rightside);

        center.add(inofcom);
        center.add(leftside);

        c.add(pokemonicon,BorderLayout.PAGE_START);
        c.add(center,BorderLayout.CENTER);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setVisible(true);
    }

}
