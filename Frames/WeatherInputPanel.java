package com.twizted.Frames;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ComponentUI;
import java.awt.*;

/**
 * WeatherQuest input panel.
 *
 * Speed and weather input panel for each trip section.
 *
 * @author Ian Weeks (29/07/2015)
 */
public class WeatherInputPanel extends JPanel
{
    private JSlider speedLimit;

    /**
     * WeatherInputPanel constructor.
     */
    public WeatherInputPanel()
    {
        this.setPreferredSize(new Dimension(335, 130));
        this.setLayout(null);

        JLabel speedLabel = new JLabel("Speed:");
        speedLabel.setBounds(5, 5, 140, 15);
        this.add(speedLabel);

        JLabel speedLimitLabel = new JLabel("Area limit:");
        speedLimitLabel.setBounds(40, 30, 140, 15);
        speedLimitLabel.setToolTipText("The speed limit in knots for vessels in this area.");
        this.add(speedLimitLabel);

        speedLimit = new JSlider(JSlider.HORIZONTAL, 1, 31, 1);
        speedLimit.setBounds(40, 50, 250, 50);
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
        g.drawRect(0, 0, 330, 115);
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
}
