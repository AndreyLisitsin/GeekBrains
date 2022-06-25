package lesson8.listeners;

import lesson8.SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EqualsButtonListener implements ActionListener {

    private SimpleCalculator calculator;
    private JTextField inputField;

    public EqualsButtonListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String expression = inputField.getText();
        calculator = new SimpleCalculator(expression);
        String resalt = calculator.calculate().toString();
        inputField.setText(resalt);

    }
}
