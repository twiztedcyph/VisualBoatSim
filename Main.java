package com.twizted;

import com.twizted.Frames.MapFrame;

import javax.swing.*;
import java.io.IOException;

/**
 * Main.
 *
 * Program start.
 *
 * @author Ian Weeks
 */
public class Main
{
    /**
     * Main.
     *
     * @param args Command line arguments. **NOT USED**
     */
    public static void main(String[] args)
    {
        // Set the user directory for ArcGIS.
        System.setProperty("user.dir", "C:\\Program Files (x86)\\ArcGIS SDKs\\java10.2.4\\");

//        //Vessel setup.
//        final DartFisher dartFisher = new DartFisher(2, 30000, 12);
//        final SmallerVessel smallerVessel = new SmallerVessel(1, 5000, 3);
//        final LargerVessel largerVessel = new LargerVessel(4, 50000, 25);
//
//        for (int i = 0; i < 40; i++)
//        {
//            System.out.printf("%d\t%f\t%f\t%f\n", i, smallerVessel.getFPH(smallerVessel.getRPM(i)), dartFisher.getFPH(dartFisher.getRPM(i)), largerVessel.getFPH(largerVessel.getRPM(i)));
//        }

        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    // Init and start the program.
                    MapFrame mapFrame = new MapFrame();
                    mapFrame.setVisible(true);
                    mapFrame.startTimer();

                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
