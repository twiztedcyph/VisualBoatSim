package com.twizted.Frames;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * @author Ian Weeks (29/7/15)
 */
public class InputPanel extends JPanel
{
    private JSlider speedLimit, wavMag, wavDir, winMag, winDir, wavPeriod;

    public InputPanel()
    {
        this.setPreferredSize(new Dimension(650, 340));
        this.setLayout(null);

        JLabel speedLabel = new JLabel("Speed Information");
        speedLabel.setBounds(5, 5, 140, 15);
        this.add(speedLabel);

        JLabel speedLimitLabel = new JLabel("Area limit:");
        speedLimitLabel.setBounds(30, 30, 140, 15);
        speedLimitLabel.setToolTipText("The speed limit in knots for vessels in this area.");
        this.add(speedLimitLabel);

        speedLimit = new JSlider(JSlider.VERTICAL, 1, 31, 1);
        speedLimit.setBounds(30, 50, 50, 250);
        speedLimit.setMajorTickSpacing(5);
        speedLimit.setPaintLabels(true);
        speedLimit.setPaintTicks(true);
        speedLimit.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent ce)
            {
                JSlider slider = (JSlider) ce.getSource();
                if (!slider.getValueIsAdjusting())
                {
                    slider.setToolTipText(String.valueOf(speedLimit.getValue()));
                }
            }
        });
        this.add(speedLimit);

        JLabel windLabel = new JLabel("Wind Information");
        windLabel.setBounds(190, 5, 140, 15);
        this.add(windLabel);

        JLabel winMagLabel = new JLabel("Speed:");
        winMagLabel.setBounds(155, 30, 100, 15);
        this.add(winMagLabel);

        winMag = new JSlider(JSlider.VERTICAL, 0, 30, 0);
        winMag.setBounds(155, 50, 50, 250);
        winMag.setMinorTickSpacing(1);
        winMag.setMajorTickSpacing(5);
        winMag.setPaintLabels(true);
        winMag.setPaintTicks(true);
        winMag.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent ce)
            {
                JSlider slider = (JSlider) ce.getSource();
                if (!slider.getValueIsAdjusting())
                {
                    slider.setToolTipText(String.valueOf(winMag.getValue()));
                }
            }
        });
        this.add(winMag);


        JLabel winDirLabel = new JLabel("Bearing:");
        winDirLabel.setBounds(265, 30, 100, 15);
        this.add(winDirLabel);

        winDir = new JSlider(JSlider.VERTICAL, 0, 360, 1);
        winDir.setBounds(265, 50, 50, 250);
        winDir.setMinorTickSpacing(45);
        winDir.setMajorTickSpacing(90);
        winDir.setPaintLabels(true);
        winDir.setPaintTicks(true);
        winDir.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent ce)
            {
                JSlider slider = (JSlider) ce.getSource();
                if (!slider.getValueIsAdjusting())
                {
                    slider.setToolTipText(String.valueOf(winDir.getValue()));
                }
            }
        });
        this.add(winDir);

        JLabel waveLabel = new JLabel("Wave Information");
        waveLabel.setBounds(460, 5, 140, 15);
        this.add(waveLabel);

        JLabel wavMagLabel = new JLabel("Height:");
        wavMagLabel.setBounds(385, 30, 100, 15);
        this.add(wavMagLabel);

        wavMag = new JSlider(JSlider.VERTICAL, 0, 5, 0);
        wavMag.setBounds(385, 50, 50, 250);
        //wavMag.setMinorTickSpacing(1);
        wavMag.setMajorTickSpacing(1);
        wavMag.setPaintLabels(true);
        wavMag.setPaintTicks(true);
        wavMag.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent ce)
            {
                JSlider slider = (JSlider) ce.getSource();
                if (!slider.getValueIsAdjusting())
                {
                    slider.setToolTipText(String.valueOf(wavMag.getValue()));
                }
            }
        });
        this.add(wavMag);


        JLabel wavDirLabel = new JLabel("Bearing:");
        wavDirLabel.setBounds(490, 30, 100, 15);
        this.add(wavDirLabel);

        wavDir = new JSlider(JSlider.VERTICAL, 0, 360, 0);
        wavDir.setBounds(490, 50, 50, 250);
        wavDir.setMinorTickSpacing(45);
        wavDir.setMajorTickSpacing(90);
        wavDir.setPaintLabels(true);
        wavDir.setPaintTicks(true);
        wavDir.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent ce)
            {
                JSlider slider = (JSlider) ce.getSource();
                if (!slider.getValueIsAdjusting())
                {
                    slider.setToolTipText(String.valueOf(wavDir.getValue()));
                }
            }
        });
        this.add(wavDir);

        JLabel wavPeriodLabel = new JLabel("Period:");
        wavPeriodLabel.setBounds(590, 30, 100, 15);
        this.add(wavPeriodLabel);

        wavPeriod = new JSlider(JSlider.VERTICAL, 5, 60, 5);
        wavPeriod.setBounds(590, 50, 50, 250);
        wavPeriod.setMinorTickSpacing(1);
        wavPeriod.setMajorTickSpacing(5);
        wavPeriod.setPaintLabels(true);
        wavPeriod.setPaintTicks(true);
        wavPeriod.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent ce)
            {
                JSlider slider = (JSlider) ce.getSource();
                if (!slider.getValueIsAdjusting())
                {
                    slider.setToolTipText(String.valueOf(wavPeriod.getValue()));
                }
            }
        });
        this.add(wavPeriod);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, 115, 330);
        g.drawRect(120, 0, 235, 330);
        g.drawRect(360, 0, 288, 330);
    }

    public double getSpeedLimit()
    {
        return speedLimit.getModel().getValue();
    }

    public double getWavMag()
    {
        return wavMag.getModel().getValue();
    }

    public double getWavDir()
    {
        return wavDir.getModel().getValue();
    }

    public double getWinMag()
    {
        return winMag.getModel().getValue();
    }

    public double getWinDir()
    {
        return winDir.getModel().getValue();
    }

    public double getWavPeriod()
    {
        return wavPeriod.getModel().getValue();
    }
}
