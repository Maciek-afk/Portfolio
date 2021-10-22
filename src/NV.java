import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

public class NV extends JFrame implements ActionListener{
    JFrame frame;
    JLabel FoodType, FoodAmount;
    JButton menu, check, addFood;
    JComboBox foodType;
    JTextField foodAmount;

    JFrame frame2;
    JLabel Energy, Fat, SatFat, Carb, Sug, Prt, Sodium, pic, binfo, run, walk, swim, bike;
    public String fd, label;
    public double kcal, FatG, SFatG, CarbG, SugG, ProtG, SodiumMg;
    ImageIcon img;
    public int a, b;


    NV() {
        frame = new JFrame();
        setSize(500, 250);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Nutrient Values");
        getContentPane().setBackground(new Color(206, 205, 203));
        setResizable(false);
        setLocationRelativeTo(null);

        FoodType = new JLabel();
        FoodType.setBounds(5, 15, 125, 30);
        FoodType.setText("Type of food: ");
        FoodType.setVisible(true);
        add(FoodType);

        FoodAmount = new JLabel();
        FoodAmount.setBounds( 5, 65, 175, 30 );
        FoodAmount.setText("Amount of food (in g): ");
        FoodAmount.setVisible(true);
        add(FoodAmount);

        menu = new JButton();
        menu.setText("Return to menu");
        menu.setBounds(10, 150, 150, 50);
        menu.setVisible(true);
        menu.setLayout(null);
        menu.addActionListener(this);
        menu.setBorder(new RoundBtn(10));
        add(menu);

        addFood = new JButton();
        addFood.setText("Add own food");
        addFood.setBounds(190, 150, 150, 50);
        addFood.setVisible(true);
        addFood.setLayout(null);
        addFood.addActionListener(this);
        addFood.setBorder(new RoundBtn(10));
        add(addFood);

        check = new JButton();
        check.setText("Check!");
        check.setBounds(375, 150, 100, 50);
        check.setVisible(true);
        check.setLayout(null);
        check.addActionListener(this);
        check.setBorder(new RoundBtn(10));
        add(check);

        foodAmount = new JTextField();
        foodAmount.setBounds(190, 65, 150, 30);
        foodAmount.setVisible(true);
        foodAmount.setLayout(null);
        add(foodAmount);

        String[] meals = {"Apple", "Croissant", "Salty Sticks", "Peanuts", "Fries"};
        foodType = new JComboBox(meals);
        foodType.addActionListener(this);
        foodType.setVisible(true);
        foodType.setBounds(140, 15, 200, 30);
        add(foodType);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == check) {


            fd = (String) foodType.getSelectedItem();
            double amount = Double.parseDouble(foodAmount.getText());


            if (fd.equalsIgnoreCase("Apple")){
                kcal = 52;
                FatG = 0.17;
                SFatG = 0;
                CarbG = 11.41;
                SugG = 10;
                ProtG = 0.26;
                SodiumMg = 1;
                label = "apple.jpg";
            }else if (fd.equalsIgnoreCase("Croissant")){
                kcal = 406;
                FatG = 21;
                SFatG = 12;
                CarbG = 46;
                SugG = 11;
                ProtG = 8;
                SodiumMg = 467;
                label = "crossaint.jpg";
            }else if (fd.equalsIgnoreCase("Salty Sticks")){
                kcal = 401;
                FatG = 5.9;
                SFatG = 0.7;
                CarbG = 76;
                SugG = 3.9;
                ProtG = 10;
                SodiumMg = 1.79;
                label = "sticks.png";
            }else if(fd.equalsIgnoreCase("Peanuts")) {
                kcal = 617;
                FatG = 51;
                SFatG = 5.6;
                CarbG = 7.3;
                SugG = 6.2;
                ProtG = 29;
                SodiumMg = 18;
                label = "peanuts.jpg";
            }else if(fd.equalsIgnoreCase("Fries")){
                kcal = 289;
                FatG = 14;
                SFatG = 1.3;
                CarbG = 36;
                SugG = 0.3;
                ProtG = 3.4;
                SodiumMg = 0.69;
                label = "fries.png";
            }

            Energy = new JLabel();
            Energy.setBounds(15, 5, 200, 15);
            double enrg = Math.round((kcal*(amount/100)) * 100.0) / 100.0;
            Energy.setText("Energy: " + enrg + " kcal");

            Fat = new JLabel();
            Fat.setBounds(15, 35, 200, 15);
            double fatt = Math.round((FatG*(amount/100)) * 100.0) / 100.0;
            Fat.setText("Fat: " + fatt + " g");

            SatFat = new JLabel();
            SatFat.setBounds(15, 65, 200, 15);
            double FatS = Math.round((SFatG*(amount/100)) * 100.0) / 100.0;
            SatFat.setText("Saturated Fat: " + FatS + " g");

            Carb = new JLabel();
            Carb.setBounds(15, 95, 200, 15);
            double carboh = Math.round((CarbG*(amount/100)) * 100.0) / 100.0;
            Carb.setText("Carbohydrates: " + carboh + " g");

            Sug = new JLabel();
            Sug.setBounds(15, 125, 200, 15);
            double suga = Math.round((SugG*(amount/100)) * 100.0) / 100.0;
            Sug.setText("Sugar: " + suga + " g");

            Prt = new JLabel();
            Prt.setBounds(15, 155, 200, 15);
            double prot = Math.round((ProtG*(amount/100)) * 100.0) / 100.0;
            Prt.setText("Proteins: " + prot  + " g");

            Sodium = new JLabel();
            Sodium.setBounds(15, 185, 200, 15);
            double sod = Math.round((SodiumMg*(amount/100)) * 100.0) / 100.0;
            Sodium.setText("Sodium: " + sod  + " mg");

            img = new ImageIcon(label);
            pic = new JLabel(img);
            pic.setVisible(true);
            pic.setBounds(200, 0, 200, 150);

            class Drawing extends JComponent {
                public void paint(Graphics g) {

                    // draw and display the line
                    g.drawLine(0, 205, 400, 205);
                }
            }

            binfo = new JLabel();
            binfo.setBounds(125, 201, 150, 50);
            binfo.setText("<html>In order to burn it you would have to: </html>");
            binfo.setVisible(true);

            //run, walk, swim, bike;

            int a;
            int b;

            run = new JLabel();
            run.setBounds(30, 260, 175, 15);
            //using if so that there wont be unnecesary 0km and x m
            if (enrg > 62){
                a = (int) enrg / 62;
                b = (int) ((enrg / 62) * 1000) - a * 1000;
                if (b == 0)
                    run.setText("run : " + a + " km");  //getting rid of unnecessary "0 min" part
                else
                    run.setText("run : " + a + " km and " + b + " m");
            }else if (enrg < 62){
                a = (int) ((enrg/62) * 1000);
                run.setText("run : " + a + " m");
            }else
                run.setText("run : 1 km");   //anything left is 62/62 which is equal 1, so there is no point in doing calculations
            run.setVisible(true);

            walk = new JLabel();
            walk.setBounds(30, 295, 185, 15);
            if (enrg > 300){
                a = (int) enrg/300;
                b = (int) ((((enrg/300)*1000 - a*1000) / 1000) * 60);
                if (b == 0)
                    walk.setText("walk : " + a + " h and " + b + " min");
                else
                    walk.setText("walk : " + a + " h and " + b + " min");
            }else if (enrg < 300){
                b = (int) ((((enrg/300)*1000)/1000)*60);
                walk.setText("walk : " + b + " min");
            }else
                walk.setText("walk : 1 h");
            walk.setVisible(true);

            swim = new JLabel();
            swim.setBounds(215, 260, 175, 15);
            if (enrg>350){
                a = (int) enrg / 350;
                b = (int) ((enrg / 350) * 1000) - a * 1000;
                if (b == 0)
                    swim.setText("swim : " + a + " km");
                else
                    swim.setText("swim : " + a + " km and " + b + " m");
            }else if (enrg<350){
                a = (int) ((enrg/350) * 1000);
                swim.setText("swim : " + a + " m");
            }else
                swim.setText("swim : 1 km");
            swim.setVisible(true);

            bike = new JLabel();
            bike.setBounds(215, 295, 175, 15);
            if (enrg > 450){
                a = (int) enrg/450;
                b = (int) ((((enrg/450)*1000 - a*1000) / 1000) * 60);
                if (b == 0)
                    bike.setText("bike : " + a + " h and " + b + " min");
                else
                    bike.setText("bike : " + a + " h and " + b + " min");
            }else if (enrg < 450){
                b = (int) ((((enrg/450)*1000)/1000)*60);
                bike.setText("bike : " + b + " min");
            }else
                bike.setText("bike : 1 h");
            bike.setVisible(true);

            frame2 = new JFrame();
            frame2.setTitle("Nutrition Values - results");
            frame2.setSize(400, 360);
            frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame2.setVisible(true);
            frame2.add(Energy);
            frame2.add(Fat);
            frame2.add(SatFat);
            frame2.add(Carb);
            frame2.add(Sug);
            frame2.add(Prt);
            frame2.add(Sodium);
            frame2.add(pic);
            frame2.add(binfo);
            frame2.add(run);
            frame2.add(walk);
            frame2.add(swim);
            frame2.add(bike);
            frame2.getContentPane().add(new Drawing());
            frame2.setResizable(false);
            frame2.setLocationRelativeTo(null);


        }
        else if (actionEvent.getSource() == menu) {
            Menu backToMenu = new Menu();
            dispose();
        }
    }
}



/*
TODO

adding own food
 */