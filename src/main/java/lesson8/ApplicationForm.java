package lesson8;

import lesson8.components.NumberJButton;
import lesson8.components.OperatorJButton;
import lesson8.listeners.ButtonListener;
import lesson8.listeners.ClearButtonActionListener;
import lesson8.listeners.EqualsButtonListener;
import lesson8.listeners.ExitButtonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ApplicationForm extends JFrame {

    private JTextField inputField;
    private SimpleCalculator calculator;

    public ApplicationForm(String title) throws HeadlessException {
        super(title);
        setBounds(1900, 200, 250, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

//        testListener();

        setJMenuBar(createMenu());

        setLayout(new BorderLayout());

        add(createTopPannel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");

        menuBar.add(menuFile);

        menuBar.add(new JMenuItem("About"));
        menuBar.add(new JMenuItem("Help"));

        menuFile.add(new JMenuItem("Clear"));
        JMenuItem exitItem = menuFile.add(new JMenuItem("Exit"));
        menuBar.add(exitItem);

        exitItem.addActionListener(new ExitButtonListener());

        return menuBar;
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        ActionListener buttonListener = new ButtonListener(inputField);

        centerPanel.add(createDigitPanel(buttonListener), BorderLayout.CENTER);
        centerPanel.add(createOperatorPanel(buttonListener), BorderLayout.WEST);

        return centerPanel;
    }

    private JPanel createOperatorPanel(ActionListener buttonListener) {
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(4,1));

        JButton minus = new OperatorJButton("-");
        minus.addActionListener(buttonListener);
        panel.add(minus);

        JButton plus = new OperatorJButton("+");
        plus.addActionListener(buttonListener);
        panel.add(plus);

        JButton multiply = new OperatorJButton("*");
        multiply.addActionListener(buttonListener);
        panel.add(multiply);

        JButton divide = new OperatorJButton("/");
        divide.addActionListener(buttonListener);
        panel.add(divide);

        return panel;
    }

    private JPanel createDigitPanel(ActionListener buttonListener) {
        JPanel digitsPanel = new JPanel();

        digitsPanel.setLayout(new GridLayout(4,3));
        for (int i = 0; i < 10 ; i++) {
            String buttonTitle = (i == 9) ? "0" : String.valueOf(i+1);
            JButton btn = new NumberJButton(buttonTitle);
            btn.addActionListener(buttonListener);
            digitsPanel.add(btn);
        }

        JButton calc = new OperatorJButton("=");
        digitsPanel.add(calc);
        calc.addActionListener(new EqualsButtonListener(inputField));
        calc.setEnabled(true);

        JButton clear = new OperatorJButton("C");
        digitsPanel.add(clear);
        clear.addActionListener(new ClearButtonActionListener(inputField));

        return digitsPanel;
    }

    private JPanel createTopPannel() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setEditable(true);
        top.add(inputField);
        inputField.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        inputField.setMargin(new Insets(8,0,8,0));
        inputField.setBackground(new Color(206,236,242));

        inputField.setText("");

        return top;
    }

    private void testListener() {
        Button button = new Button("Кнопка");
        button.addActionListener(System.out::println);
        super.add(button);
    }
}
