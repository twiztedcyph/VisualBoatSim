package com.twizted;

import com.twizted.Frames.JobInputPanel;
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

        JOptionPane.showConfirmDialog(null,
                                      new JobInputPanel(),
                                      "Job parameter input",
                                      JOptionPane.OK_CANCEL_OPTION,
                                      JOptionPane.PLAIN_MESSAGE);

//        SwingUtilities.invokeLater(new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                try
//                {
//                    // Init and start the program.
//                    MapFrame mapFrame = new MapFrame();
//                    mapFrame.setVisible(true);
//                    mapFrame.startTimer();
//
//                } catch (IOException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//        });
    }
}
