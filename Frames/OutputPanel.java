package com.twizted.Frames;

import javax.swing.*;
import java.awt.*;

/**
 * Output panel for simulation results.
 *
 * @author Ian Weeks
 */
public class OutputPanel extends JPanel
{
    private JTextArea textAreaOne, textAreaTwo, textAreaThree;

    /**
     * Constructor for output panel.
     */
    public OutputPanel()
    {
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);

        textAreaThree = new JTextArea();
        textAreaThree.setFont(new Font("Courier", Font.BOLD, 12));
        textAreaThree.setForeground(Color.RED);
        textAreaThree.setCaretColor(Color.black);
        textAreaThree.setEditable(false);
        textAreaThree.setBounds(15, 150, 800, 50);
        textAreaThree.setBackground(Color.LIGHT_GRAY);
        this.add(textAreaThree);

        textAreaOne = new JTextArea ();
        textAreaOne.setFont(new Font("Courier", Font.PLAIN, 12));
        textAreaOne.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaOne,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 205, 800, 380);
        this.add(scrollPane);

        JLabel totalsLabel = new JLabel("Journey information");
        totalsLabel.setBounds(15, 0, 120, 20);
        this.add(totalsLabel);

        textAreaTwo = new JTextArea();
        textAreaTwo.setFont(new Font("Courier", Font.PLAIN, 12));
        textAreaTwo.setEditable(false);
        textAreaTwo.setBounds(15, 25, 800, 200);
        textAreaTwo.setBackground(Color.LIGHT_GRAY);
        this.add(textAreaTwo);
    }

    /**
     * Set the text for the trip section display.
     *
     * @param input Trip sections information.
     */
    public void setTextAreaOne(String input)
    {
        this.textAreaOne.setText(input);
    }

    /**
     * Set the text for the summary display.
     *
     * @param input Summary information.
     */
    public void setTextAreaTwo(String input)
    {
        this.textAreaTwo.setText(input);
    }

    /**
     * Set the text for the cost display.
     *
     * @param input Summary information.
     */
    public void setTextAreaThree(String input)
    {
        this.textAreaThree.setText(input);
    }
}
