package com.twizted.Frames;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

/**
 * Created by Cypher on 27/07/2015.
 */
public class InputPanel extends JPanel
{
    private JLabel speedLabel, speedLimitLabel, waveLabel, wavMagLabel,
            wavDirLabel, windLabel, winMagLabel, winDirLabel, wavPeriodLabel;
    private JTextField speedLimitField, wavMagField, wavDirField, winMagField, winDirField, wavPeriodField;
    private Border speedBorder, windBorder, waveBorder;

    public InputPanel()
    {
        this.setPreferredSize(new Dimension(250, 240));
        this.setLayout(null);

        speedLabel = new JLabel("Speed Information");
        speedLabel.setBounds(5, 5, 140, 15);
        this.add(speedLabel);

        speedLimitLabel = new JLabel("Area limit:");
        speedLimitLabel.setBounds(45, 30, 140, 15);
        this.add(speedLimitLabel);

        speedLimitField = new JTextField();
        speedLimitField.setBounds(170, 28, 60, 20);
        this.add(speedLimitField);

        windLabel = new JLabel("Wind Information");
        windLabel.setBounds(5, 63, 140, 15);
        this.add(windLabel);

        winMagLabel = new JLabel("Magnitude:");
        winMagLabel.setBounds(45, 88, 100, 15);
        this.add(winMagLabel);

        winMagField = new JTextField();
        winMagField.setBounds(170, 86, 60, 20);
        this.add(winMagField);

        winDirLabel = new JLabel("Bearing:");
        winDirLabel.setBounds(45, 113, 100, 15);
        this.add(winDirLabel);

        winDirField = new JTextField();
        winDirField.setBounds(170, 111, 60, 20);
        this.add(winDirField);

        waveLabel = new JLabel("Wave Information");
        waveLabel.setBounds(5, 142, 140, 15);
        this.add(waveLabel);

        wavMagLabel = new JLabel("Magnitude:");
        wavMagLabel.setBounds(45, 167, 100, 15);
        this.add(wavMagLabel);

        wavMagField = new JTextField();
        wavMagField.setBounds(170, 165, 60, 20);
        this.add(wavMagField);

        wavDirLabel = new JLabel("Bearing:");
        wavDirLabel.setBounds(45, 192, 100, 15);
        this.add(wavDirLabel);

        wavDirField = new JTextField();
        wavDirField.setBounds(170, 190, 60, 20);
        this.add(wavDirField);

        wavPeriodLabel = new JLabel("Period:");
        wavPeriodLabel.setBounds(45, 217, 100, 15);
        this.add(wavPeriodLabel);

        wavPeriodField = new JTextField();
        wavPeriodField.setBounds(170, 215, 60, 20);
        this.add(wavPeriodField);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawRect(3, 3, 235, 53);
        g.drawRect(3, 61, 235, 73);
        g.drawRect(3, 140, 235, 99);
    }
}
