package com.twizted.Frames;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ComponentUI;
import java.awt.*;

/**
 * Input panel.
 *
 * Speed and weather input panel for each trip section.
 *
 * @author Ian Weeks (29/07/2015)
 */
public class InputPanel extends JPanel
{
    private JSlider speedLimit, wavMag, wavDir, winMag, winDir, wavPeriod;

    /**
     * InputPanel constructor.
     */
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

    /**
     * Calls the UI delegate's paint method, if the UI delegate
     * is non-<code>null</code>.  We pass the delegate a copy of the
     * <code>Graphics</code> object to protect the rest of the
     * paint code from irrevocable changes
     * (for example, <code>Graphics.translate</code>).
     * <p>
     * If you override this in a subclass you should not make permanent
     * changes to the passed in <code>Graphics</code>. For example, you
     * should not alter the clip <code>Rectangle</code> or modify the
     * transform. If you need to do these operations you may find it
     * easier to create a new <code>Graphics</code> from the passed in
     * <code>Graphics</code> and manipulate it. Further, if you do not
     * invoker super's implementation you must honor the opaque property,
     * that is
     * if this component is opaque, you must completely fill in the background
     * in a non-opaque color. If you do not honor the opaque property you
     * will likely see visual artifacts.
     * <p>
     * The passed in <code>Graphics</code> object might
     * have a transform other than the identify transform
     * installed on it.  In this case, you might get
     * unexpected results if you cumulatively apply
     * another transform.
     *
     * @param g the <code>Graphics</code> object to protect
     * @see #paint
     * @see ComponentUI
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        //Black borders for each section.
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, 115, 330);
        g.drawRect(120, 0, 235, 330);
        g.drawRect(360, 0, 288, 330);
    }

    /**
     * Get the inputted speed limit value.
     *
     * @return The inputted speed limit value.
     */
    public double getSpeedLimit()
    {
        return speedLimit.getModel().getValue();
    }

    /**
     * Get the inputted wave height value.
     *
     * @return The inputted wave height value.
     */
    public double getWavMag()
    {
        return wavMag.getModel().getValue();
    }

    /**
     * Get the inputted wave direction value.
     *
     * @return The inputted wave direction value.
     */
    public double getWavDir()
    {
        return wavDir.getModel().getValue();
    }

    /**
     * Get the inputted wind magnitude value.
     *
     * @return The inputted wind magnitude value.
     */
    public double getWinMag()
    {
        return winMag.getModel().getValue();
    }

    /**
     * Get the inputted wind direction value.
     *
     * @return The inputted wind direction value
     */
    public double getWinDir()
    {
        return winDir.getModel().getValue();
    }

    /**
     * The inputted wave period value.
     * @return The inputted wave period value.
     */
    public double getWavPeriod()
    {
        return wavPeriod.getModel().getValue();
    }
}
