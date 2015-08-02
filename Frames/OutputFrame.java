package com.twizted.Frames;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ian Weeks (30/7/15)
 */
public class OutputFrame extends JFrame
{
    private JTextArea textAreaOne, textAreaTwo;
    private JScrollPane scrollPane;

    public OutputFrame()
    {
        this.setTitle("Simulation Results");
        this.setLocation(980, 0);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = (JPanel) this.getContentPane();
        panel.setPreferredSize(new Dimension(800, 600));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);

        textAreaOne = new JTextArea ();
        textAreaOne.setFont(new Font("Courier", Font.PLAIN, 12));
        textAreaOne.setEditable(false);
        scrollPane = new JScrollPane (textAreaOne, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, 800, 400);
        panel.add(scrollPane);

        JLabel totalsLabel = new JLabel("Journey information");
        totalsLabel.setBounds(15, 410, 120, 20);
        panel.add(totalsLabel);

        textAreaTwo = new JTextArea();
        textAreaTwo.setFont(new Font("Courier", Font.PLAIN, 12));
        textAreaTwo.setEditable(false);
        textAreaTwo.setBounds(15, 430, 800, 200);
        textAreaTwo.setBackground(Color.LIGHT_GRAY);
        panel.add(textAreaTwo);

        this.pack();
    }

    public void setTextAreaOne(String input)
    {
        this.textAreaOne.setText(input);
    }

    public void setTextAreaTwo(String input)
    {
        this.textAreaTwo.setText(input);
    }
}
