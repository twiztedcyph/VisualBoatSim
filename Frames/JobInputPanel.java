package com.twizted.Frames;

import javax.swing.*;
import java.awt.*;

/**
 * Basic input for the job specifications
 *
 * @author Ian Weeks
 */
public class JobInputPanel extends JPanel
{
    private JTextField paxInput, cargoWeightInput;

    /**
     * JobInputPanel constructor.
     */
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

    /**
     * Get the number of pax for this journey.
     *
     * @return The number of pax for this journey.
     */
    public double getPax()
    {
        return Double.valueOf(paxInput.getText());
    }

    /**
     * Get the cargo weight for this journey.
     *
     * @return The cargo weight for this journey.
     */
    public double getCargoWeight()
    {
        return Double.valueOf(cargoWeightInput.getText());
    }
}
