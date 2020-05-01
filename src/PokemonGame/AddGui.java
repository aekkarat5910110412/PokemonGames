
package PokemonGame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

    public class AddGui extends JFrame{
        private PokemonFarm pokemonFarm;
        private String[] pokemonType = {"Normal","Grass","Water","Fire","Electr","Bug"
                ,"Poison","Fighting","Psychic"};
        private String[] pokemonSkill = {"Drill Peck","Body Slam","Dig"                     //Normal
                ,"Power Whip","Sludge Bomb","Petal Blizzard"       //Grass
                ,"Aqua Tail","Hydro Pump","Ice Beam"               //Water
                ,"Flame Burst","Fire Punch","Fire Blast"           //Fire
                ,"Thunder","Thunderbolt","Flash Cannon"            //Electr
                ,"Struggle","Bug Buzz","Signal Beam"               //Bug
                ,"Gunk Shot","Mud Bomb","Earthquake"               //Poison
                ,"Cross Chop","Stone Edge","Ice Punch"             //Fighting
                ,"Hyper Beam","Dazzling Gleam","Psychic" };        //Psychic

        public AddGui(PokemonFarm pokemonFarm){

            super("ADD");
            this.pokemonFarm = pokemonFarm;


            Container c = getContentPane();
            c.setLayout(new GridLayout(0,2));

            //Type
            JLabel Typelabel = new JLabel("Type: ");
            Typelabel.setHorizontalAlignment(JLabel.CENTER);
            JComboBox chooseType = new JComboBox(pokemonType);

            //Name
            JLabel Namelabel = new JLabel("Name: ");
            Namelabel.setHorizontalAlignment(JLabel.CENTER);
            JTextField NameTextField = new JTextField();

            //weight
            JLabel WeightLabel = new JLabel("Weight: ");
            WeightLabel.setHorizontalAlignment(JLabel.CENTER);
            JTextField WeightTextField = new JTextField();

            //skill
            JLabel SkillLabel = new JLabel("Skill: ");
            SkillLabel.setHorizontalAlignment(JLabel.CENTER);
            JComboBox chooseSkll = new JComboBox(pokemonSkill);

            //Hp health point
            JLabel HpLabel = new JLabel("HP (Health point) : ");
            HpLabel.setHorizontalAlignment(JLabel.CENTER);
            JTextField HpTextField = new JTextField();

            //mp mana point
            JLabel MpLabel = new JLabel("MP (Mana point) : ");
            MpLabel.setHorizontalAlignment(JLabel.CENTER);
            JTextField MpTextField = new JTextField();

            JButton EnterButton = new JButton("Enter");
            JButton CancelButton = new JButton("Back");


            EnterButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String type = (String) chooseType.getSelectedItem();
                    String name = NameTextField.getText();
                    float weight = Float.parseFloat(WeightTextField.getText());
                    String skill = (String) chooseSkll.getSelectedItem();
                    float Hp = Float.parseFloat(HpTextField.getText());
                    float Mp = Float.parseFloat(MpTextField.getText());

                    if(type.equals("Grass")){
                        Grass grass = new Grass(name,weight,skill,Hp,Mp);
                        pokemonFarm.AddPokemon(grass);
                    }
                    else if(type.equals("Water")){
                        Water water = new Water(name,weight,skill,Hp,Mp);
                        pokemonFarm.AddPokemon(water);
                    }
                    else if(type.equals("Fire")){
                        Fire fire = new Fire(name,weight,skill,Hp,Mp);
                        pokemonFarm.AddPokemon(fire);
                    }
                    else if(type.equals("Normal")){
                        Normal normal = new Normal(name,weight,skill,Hp,Mp);
                        pokemonFarm.AddPokemon(normal);
                    }
                    else if(type.equals("Electr")){
                        Electr electr = new Electr(name,weight,skill,Hp,Mp);
                        pokemonFarm.AddPokemon(electr);
                    }
                    else if(type.equals("Bug")){
                        Bug bug = new Bug(name,weight,skill,Hp,Mp);
                        pokemonFarm.AddPokemon(bug);
                    }
                    else if(type.equals("Poison")){
                        Poison poison = new Poison(name,weight,skill,Hp,Mp);
                        pokemonFarm.AddPokemon(poison);
                    }
                    else if(type.equals("Fighting")){
                        Fighting fighting = new Fighting(name,weight,skill,Hp,Mp);
                        pokemonFarm.AddPokemon(fighting);
                    }
                    else if(type.equals("Psychic")){
                        Psychic psychic = new Psychic(name,weight,skill,Hp,Mp);
                        pokemonFarm.AddPokemon(psychic);
                    }


                    setVisible(false);

                }
            });
            CancelButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    setVisible(false);
                }
            });

            c.add(Typelabel);
            c.add(chooseType);
            c.add(Namelabel);
            c.add(NameTextField);
            c.add(WeightLabel);
            c.add(WeightTextField);
            c.add(SkillLabel);
            c.add(chooseSkll);
            c.add(HpLabel);
            c.add(HpTextField);
            c.add(MpLabel);
            c.add(MpTextField);
            c.add(EnterButton);
            c.add(CancelButton);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(700,700);
            setVisible(true);
        }
    }
