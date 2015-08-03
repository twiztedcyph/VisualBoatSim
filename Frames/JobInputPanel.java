package com.twizted.Frames;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ian Weeks
 */
public class JobInputPanel extends JPanel
{
    private JTextField paxInput, cargoWeightInput;

    public JobInputPanel()
    {
        this.setPreferredSize(new Dimension(120, 80));
        this.setLayout(null);

        JLabel paxLabel, cargoWeightLabel;

        paxLabel = new JLabel("Passengers:");
        paxLabel.setBounds(40, 15, 90, 20);
        this.add(paxLabel);

        paxInput = new JTextField();
        paxInput.setBounds(140, 15, 50, 20);
        this.add(paxInput);

        cargoWeightLabel = new JLabel("Cargo weight:");
        cargoWeightLabel.setBounds(40, 40, 90, 20);
        this.add(cargoWeightLabel);

        cargoWeightInput = new JTextField();
        cargoWeightInput.setBounds(140, 40, 50, 20);
        this.add(cargoWeightInput);

    }
}
