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
    private JTextField paxInput, crewInput, cargoWeightInput;

    /**
     * JobInputPanel constructor.
     */
    public JobInputPanel()
    {
        this.setPreferredSize(new Dimension(120, 100));
        this.setLayout(null);

        JLabel paxLabel, crewLabel, cargoWeightLabel;

        crewLabel = new JLabel("CREW:");
        crewLabel.setBounds(40, 15, 90, 20);
        this.add(crewLabel);

        crewInput = new JTextField();
        crewInput.setBounds(140, 15, 50, 20);
        this.add(crewInput);

        paxLabel = new JLabel("PAX:");
        paxLabel.setBounds(40, 40, 90, 20);
        this.add(paxLabel);

        paxInput = new JTextField();
        paxInput.setBounds(140, 40, 50, 20);
        this.add(paxInput);

        cargoWeightLabel = new JLabel("CARGO:");
        cargoWeightLabel.setBounds(40, 65, 90, 20);
        this.add(cargoWeightLabel);

        cargoWeightInput = new JTextField();
        cargoWeightInput.setBounds(140, 65, 50, 20);
        this.add(cargoWeightInput);
    }

    /**
     * Get the total number of people for this journey.
     *
     * @return The total number of people for this journey.
     */
    public double getPax()
    {
        return Double.valueOf(paxInput.getText()) + Double.valueOf(crewInput.getText());
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
