package com.twizted.Frames;

import javax.swing.*;
import java.awt.*;

/**
 * OutputFrame
 *
 * Displays the results of the simulation.
 *
 * @author Ian Weeks (30/07/2015)
 */
public class OutputFrame extends JFrame
{
    private JTextArea textAreaOne, textAreaTwo;

    /**
     *  OutputFrame constructor
     *
     * @param vesselName The name of the vessel.
     */
    public OutputFrame(String vesselName)
    {
        this.setTitle(vesselName + " Simulation Results");
        this.setLocation(980, 0);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = (JPanel) this.getContentPane();
        panel.setPreferredSize(new Dimension(800, 600));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);

        textAreaOne = new JTextArea ();
        textAreaOne.setFont(new Font("Courier", Font.PLAIN, 12));
        textAreaOne.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaOne,
                                                 JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                                 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
}
