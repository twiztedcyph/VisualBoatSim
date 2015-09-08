package com.twizted.Frames;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Cypher on 08/09/2015.
 */
public class SummaryPanel extends JPanel
{
    public SummaryPanel()
    {
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Font oldFont = g.getFont();
        Font bigFont = oldFont.deriveFont(oldFont.getSize() * 2.0f);

        g.setColor(new Color(200, 150, 150));
        g.fillRect(5, 5, 256, 595);
        g.setColor(new Color(150, 200, 150));
        g.fillRect(271, 5, 256, 600);
        g.setColor(new Color(200, 150, 150));
        g.fillRect(537, 5, 256, 600);

        g.setFont(bigFont);
        g.setColor(Color.black);
        g.drawString("VesselOne", 50, 25);
        g.drawString("Dart Fisher", 319, 25);
        g.drawString("VesselTwo", 595, 25);

        g.setFont(oldFont);
        g.setColor(Color.BLACK);
        g.drawString("Time taken: ", 10, 105);
        g.drawString("Time taken: ", 276, 105);
        g.drawString("Time taken: ", 542, 105);

        g.setColor(Color.red);
        g.drawString("3,52 hours", 110, 105);
        g.drawString("3,86 hours: ", 376, 105);
        g.drawString("4,39 hours: ", 642, 105);

        g.setColor(Color.BLACK);
        g.drawString("Fuel used: ", 10, 205);
        g.drawString("Fuel used: ", 276, 205);
        g.drawString("Fuel used: ", 542, 205);

        g.setColor(Color.red);
        g.drawString("802 liters", 110, 205);
        g.drawString("934 liters", 376, 205);
        g.drawString("1103 liters", 642, 205);

        g.setColor(Color.BLACK);
        g.drawString("Fuel cost: ", 10, 305);
        g.drawString("Fuel cost: ", 276, 305);
        g.drawString("Fuel cost: ", 542, 305);

        g.setColor(Color.red);
        g.drawString("\u00a3" +"449.12", 110, 305);
        g.drawString("\u00a3"+"523.04", 376, 305);
        g.drawString("\u00a3"+"617.68", 642, 305);

        g.setColor(Color.black);
        g.drawString("Warnings", 90, 405);
        g.drawString("Warnings", 359, 405);
        g.drawString("Warnings", 635, 405);

        g.setColor(Color.BLACK);
        g.drawString("Pax capacity exceeded.", 10, 450);
        g.drawString("Cargo weight capacity exceeded.", 10, 470);
        g.drawString("None.", 276, 450);
        g.drawString("None.", 542, 450);
    }
}
