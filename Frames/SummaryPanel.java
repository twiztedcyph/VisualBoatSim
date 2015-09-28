package com.twizted.Frames;

import com.twizted.Journey;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ian Weeks
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
        g.drawString("Small Vessel", 60, 25);
        g.drawString("Dart Fisher", 339, 25);
        g.drawString("Large Vessel", 595, 25);

        g.setFont(oldFont);
        g.setColor(Color.BLACK);
        g.drawString("Time taken: ", 10, 105);
        g.drawString("Time taken: ", 276, 105);
        g.drawString("Time taken: ", 542, 105);

        g.setColor(Color.red);
        g.drawString("2,52 hours", 110, 105);
        g.drawString("2.80 hours", 376, 105);
        g.drawString("3,39 hours", 642, 105);

        g.setColor(Color.BLACK);
        g.drawString("Fuel used: ", 10, 205);
        g.drawString("Fuel used: ", 276, 205);
        g.drawString("Fuel used: ", 542, 205);

        g.setColor(Color.red);
        g.drawString("802 liters", 110, 205);
        g.drawString("1196.78 liters", 376, 205);
        g.drawString("1243 liters", 642, 205);

        g.setColor(Color.BLACK);
        g.drawString("Fuel cost: ", 10, 305);
        g.drawString("Fuel cost: ", 276, 305);
        g.drawString("Fuel cost: ", 542, 305);

        g.setColor(Color.red);
        g.drawString("\u00a3" + "449.12", 110, 305);
        g.drawString("\u00a3"+"670.20", 376, 305);
        g.drawString("\u00a3" + "696.08", 642, 305);

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
