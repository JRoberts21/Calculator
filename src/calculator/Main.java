package calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener{        //requires action performed
                                                    //this class is just storing creating buttons and formatting them
                                                    //as well as storing any data that I need to


    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];  //array of buttons to store numbers one through ten
    JButton[] functionButtons = new JButton[9];    //array of buttons containing all the function buttons
    JButton addButton,subButton,mulButton,divButton;        //function buttons being implemented
    JButton decButton,equButton,delButton,clrButton, negButton;
                                                            //declare some more operations here once you get the rest of the calc working
    JPanel panel;

    Font myFont = new Font("Ink Free",Font.BOLD,30);

    double num1 = 0, num2=0,result=0;
    char operator;

    Main() {                                        //creates the layout and font for the calc
        frame = new JFrame("Calculator V1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);                          //reusing the font created earlier in myFont
        textField.setEditable(false);

        addButton = new JButton("+");               //creates the symbols for the functions
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;             //stores the buttons in an array
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for(int i =0; i<9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false); //removes the border around buttons

        }

        for(int i =0; i<10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);     //changes the positions of the buttons
        clrButton.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10)); //creates a grid layout for the buttons and the space between them

        panel.add(numberButtons[1]);       //row 1
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);    //row 2
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);    //row 3
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);       //row 4
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);



        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);   //adds in buttons and textfield
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Main calc = new Main();
    }

    public void actionPerformed(ActionEvent e ) {        //requires actionlistener
                                                 //establishes the functionality for the buttons
                                                //this is where all the math is happening

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));        //takes the input and displays as a string
            }
        }

        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));

        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");

        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");

        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = 'x';
            textField.setText("");

        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");

        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case 'x':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
           String string = textField.getText();
           textField.setText("");
           for (int i=0; i<string.length()-1; i++) {
               textField.setText(textField.getText() + string.charAt(i));
           }

        }
        if (e.getSource() == negButton) {
                double temp = Double.parseDouble(textField.getText());
                temp*=-1;
                textField.setText(String.valueOf(temp));
            }



    }

}
