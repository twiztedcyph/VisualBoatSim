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
    private JTabbedPane tabbedPane;

    /**
     *  OutputFrame constructor
     */
    public OutputFrame()
    {
        this.setTitle("Simulation Results");
        this.setLocation(980, 0);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        tabbedPane = new JTabbedPane();

        JPanel panel = (JPanel) this.getContentPane();
        panel.setPreferredSize(new Dimension(800, 600));

        panel.setLayout(null);
        tabbedPane.setBounds(0, 0, 800, 600);
        panel.add(tabbedPane);
    }

    /**
     * Add a tab to the panel in this frame.
     *
     * @param panelName The name of the panel to be added.
     * @param panel The panel to be added.
     */
    public void addTabPanel(String panelName, JPanel panel)
    {
        tabbedPane.add(panelName, panel);
    }
}
