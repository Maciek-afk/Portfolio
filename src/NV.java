import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

public class NV extends JFrame implements ActionListener{
    //methods
    Methods button = new Methods();
    Methods lab = new Methods();
    Methods textfield = new Methods();
    Methods combobox = new Methods();

    //defining for the main frame
    JFrame frame;
    JLabel FoodType, FoodAmount;
    JButton menu, check, addFood;
    JComboBox foodType, inputType;
    JTextField foodAmount;

    //defining for the result window
    JFrame frame1;
    JLabel Energy, Fat, SatFat, Carb, Sug, Prt, Sodium, pic, binfo, run, walk, swim, bike;
    public String fd, label;
    public double kcal, FatG, SFatG, CarbG, SugG, ProtG, SodiumMg;
    ImageIcon img;
    public int a, b;

    //defining for adding your own food window
    JFrame frame2;
    JLabel energyIn, fatIn, satFatIn, carbIn, sugIn, protIn, sodIn;
    JTextField enInput, fatInput, satFatInput, carbInput, sugInput, protInput, sodInput;
    JButton add;


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
        lab.setLabel(FoodType, "Type of food: ", 5, 15, 125, 30);

        FoodAmount = new JLabel();
        lab.setLabel(FoodAmount, "Amount of food: ", 5, 65, 175, 30);


        foodAmount = new JTextField();
        textfield.setTextField(foodAmount, 140, 65, 150, 30);


        menu = new JButton();
        button.setButton(menu, "Return to menu", 10, 150, 150, 50);
        menu.addActionListener(this);
        menu.setBorder(new RoundBtn(10));

        addFood = new JButton();
        button.setButton(addFood, "Add own food", 190, 150, 150, 50);
        addFood.addActionListener(this);
        addFood.setBorder(new RoundBtn(10));

        check = new JButton();
        button.setButton(check, "Check!", 375, 150, 100, 50);
        check.addActionListener(this);
        check.setBorder(new RoundBtn(10));


        String[] meals = {"Apple", "Croissant", "Salty Sticks", "Peanuts", "Fries"};
        foodType = new JComboBox(meals);
        combobox.setComboBox(foodType, 140, 15, 200 ,30);

        String[] types = {"kg", "g", "lbs", "oz"};
        inputType = new JComboBox(types);
        combobox.setComboBox(inputType, 295, 65, 45, 30);


        add(FoodType);
        add(FoodAmount);
        add(menu);
        add(addFood);
        add(check);
        add(foodAmount);
        add(foodType);
        add(inputType);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == check) {


            fd = (String) foodType.getSelectedItem();
            double amount = Double.parseDouble(foodAmount.getText());

            String check = (String) inputType.getSelectedItem();

            if (check.equalsIgnoreCase("kg"))
                amount *= 1000;
            else if (check.equalsIgnoreCase("g"))
                amount = amount;
            else if (check.equalsIgnoreCase("lbs"))
                amount *= 453.59237;
            else  if (check.equalsIgnoreCase("oz"))
                amount *= 28;


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
            double enrg = Math.round((kcal*(amount/100)) * 100.0) / 100.0;
            String energ = "Energy: " + String.valueOf(enrg) + " kcal";
            lab.setLabel(Energy, energ, 15, 5, 200, 15);

            Fat = new JLabel();
            double fatt = Math.round((FatG*(amount/100)) * 100.0) / 100.0;
            String fat = "Fat: " + String.valueOf(fatt) + " g";
            lab.setLabel(Fat, fat, 15, 35, 200, 15);

            SatFat = new JLabel();
            double FatS = Math.round((SFatG*(amount/100)) * 100.0) / 100.0;
            String sfat = "Saturated Fat: " + String.valueOf(FatS) + " g";
            lab.setLabel(SatFat, sfat, 15, 65, 200, 15);

            Carb = new JLabel();
            double carbon = Math.round((CarbG*(amount/100)) * 100.0) / 100.0;
            String carbs = "Carbohydrates: " + String.valueOf(carbon) + " g";
            lab.setLabel(Carb, carbs, 15, 95, 200, 15);

            Sug = new JLabel();
            double suga = Math.round((SugG*(amount/100)) * 100.0) / 100.0;
            String sug = "Sugar: " + String.valueOf(suga) + " g";
            lab.setLabel(Sug, sug, 15, 125, 200, 15);

            Prt = new JLabel();
            double prot = Math.round((ProtG*(amount/100)) * 100.0) / 100.0;
            String prots = "Protein: " + String.valueOf(prot) + " g";
            lab.setLabel(Prt, prots, 15, 155, 200, 15);

            Sodium = new JLabel();
            double sod = Math.round((SodiumMg*(amount/100)) * 100.0) / 100.0;
            String sodium = "Sodium: " + String.valueOf(sod) + " mg";
            lab.setLabel(Sodium, sodium, 15, 185, 200, 15);

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
            lab.setLabel(binfo, "<html>In order to burn it you would have to: </html>", 125, 201, 150, 50);

            int a;
            int b;

            run = new JLabel();
            run.setBounds(30, 260, 175, 15);
            //using if so that there wont be unnecesary "0km and x m"
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

            frame1 = new JFrame();
            frame1.setTitle("Nutrition Values - results");
            frame1.setSize(400, 360);
            frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame1.setVisible(true);

            frame1.add(Energy);
            frame1.add(Fat);
            frame1.add(SatFat);
            frame1.add(Carb);
            frame1.add(Sug);
            frame1.add(Prt);
            frame1.add(Sodium);
            frame1.add(pic);
            frame1.add(binfo);
            frame1.add(run);
            frame1.add(walk);
            frame1.add(swim);
            frame1.add(bike);
            frame1.getContentPane().add(new Drawing());
            frame1.setResizable(false);
            frame1.setLocationRelativeTo(null);


        }
        else if (actionEvent.getSource() == addFood){
            frame2 = new JFrame("Add your own Food!");
            frame2.setSize(400, 350);
            frame2.setVisible(true);;
            frame2.setLayout(null);
            frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame2.getContentPane().setBackground(new Color(206, 205, 203));
            frame2.setResizable(false);
            frame2.setLocationRelativeTo(null);

            energyIn = new JLabel();
            lab.setLabel(energyIn, "Energy: ", 15, 5, 150, 15);

            fatIn = new JLabel();
            lab.setLabel(fatIn, "Fat: ", 15, 35, 150, 15);

            satFatIn = new JLabel();
            lab.setLabel(satFatIn, "Saturated fat: ", 15, 65, 150, 15);

            carbIn = new JLabel();
            lab.setLabel(carbIn, "Carbohydrates: ", 15, 95, 150, 15);

            sugIn = new JLabel();
            lab.setLabel(sugIn, "Sugar: ", 15, 125, 150, 15);

            protIn = new JLabel();
            lab.setLabel(protIn, "Protein: ", 15, 155, 150, 15);

            sodIn = new JLabel();
            lab.setLabel(sodIn, "Sodium: ", 15, 185, 150, 15);


            enInput = new JTextField();
            textfield.setTextField(enInput, 155, 5, 150, 18);

            fatInput = new JTextField();
            textfield.setTextField(fatInput, 155, 35, 150, 18);

            satFatInput = new JTextField();
            textfield.setTextField(satFatInput, 155, 65, 150, 18);

            carbInput = new JTextField();
            textfield.setTextField(carbInput, 155, 95, 150, 18);

            sugInput = new JTextField();
            textfield.setTextField(sugInput, 155, 125, 150, 18);

            protInput = new JTextField();
            textfield.setTextField(protInput, 155, 155, 150, 18);

            sodInput = new JTextField();
            textfield.setTextField(sodInput, 155, 185, 150, 18);


            add = new JButton();
            add.addActionListener(this);
            add.setBorder(new RoundBtn(10));
            button.setButton(add, "Add", 225, 235, 150, 50);


            frame2.add(energyIn);
            frame2.add(fatIn);
            frame2.add(satFatIn);
            frame2.add(carbIn);
            frame2.add(sugIn);
            frame2.add(protIn);
            frame2.add(sodIn);

            frame2.add(enInput);
            frame2.add(fatInput);
            frame2.add(satFatInput);
            frame2.add(carbInput);
            frame2.add(sugInput);
            frame2.add(protInput);
            frame2.add(sodInput);

            frame2.add(add);

            if (actionEvent.getSource() == add){
                dispose();
                //todo
            }

//            nergyIn, fatIn, satFatIn, carbIn, sugIn, protIn, sodIn;


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