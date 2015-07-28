package com.twizted.Frames;

import com.esri.client.local.LocalMapService;
import com.esri.client.local.WorkspaceInfo;
import com.esri.client.local.WorkspaceInfoSet;
import com.esri.core.geometry.*;
import com.esri.core.geometry.Point;
import com.esri.core.map.*;
import com.esri.core.renderer.SimpleRenderer;
import com.esri.core.symbol.PictureMarkerSymbol;
import com.esri.core.symbol.SimpleLineSymbol;
import com.esri.map.*;
import com.esri.runtime.ArcGISRuntime;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *
 *
 * @author Ian Weeks
 */
public class MapFrame extends JFrame
{
    private JMap map;
    private int pointerID, lineID;
    private boolean firstUpdate = true, mouseOne = false, mouseTwo = false, mouseThree = false;
    private Timer timer;
    private com.esri.core.geometry.Point point;
    private SimpleLineSymbol simpleLineSymbol;
    private Polyline polyline;
    private SpatialReference sr, mySpat;
    private SimpleRenderer simpleRenderer = new SimpleRenderer(new SimpleLineSymbol(new Color(0, 100, 250), 3));
    private final int TRANSPARENCY = 20; // 0 is opaque, 100 is transparent
    private final String FSP = System.getProperty("file.separator");

    public MapFrame() throws IOException
    {
        mySpat = SpatialReference.create(SpatialReference.WKID_WGS84);
        final Image pointerImage = ImageIO.read(new File("red_dot.png"));
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                map.dispose();
                System.exit(0);
            }
        });
        this.setTitle("Vessel Location");
        this.setLocation(1020, 0);

        polyline = new Polyline();

        JPanel panel = (JPanel) this.getContentPane();
        panel.setPreferredSize(new Dimension(800, 600));

        MapOptions mapOptions = new MapOptions(MapOptions.MapType.TOPO);
        MapOverlay overlay = new MyOverlay();
        map = new JMap(mapOptions);
        map.addMapOverlay(overlay);
        map.setWrapAroundEnabled(true);
        map.setBounds(0, 0, 800, 600);
        panel.add(map);

        map.setExtent(new Envelope(192627.89248559574, 6883772.075054788, 199142.69342394127, 6888658.175758547));
        sr = map.getSpatialReference();

        final GraphicsLayer graphicsLayer = new GraphicsLayer();
        map.getLayers().add(graphicsLayer);

        simpleLineSymbol = new SimpleLineSymbol(Color.green, 3, SimpleLineSymbol.Style.DASH);

        // create a local map service and enable dynamic layers
        LocalMapService localMapService = new LocalMapService(
                getPathSampleData() + "mpks" + FSP + "mpk_blank.mpk");
        localMapService.setEnableDynamicLayers(true);

        // get dynamic workspaces from service
        WorkspaceInfoSet workspaceInfoSet = localMapService.getDynamicWorkspaces();

        WorkspaceInfo workspaceInfo = WorkspaceInfo.CreateShapefileFolderConnection(
                "WORKSPACE", "C:\\Users\\Twiz\\Dropbox\\Java Projects\\VisualBoatSim");

        // set dynamic workspaces for our local map service
        workspaceInfoSet.add(workspaceInfo);
        localMapService.setDynamicWorkspaces(workspaceInfoSet);

        // now start service...
        localMapService.start();

        // set up a local dynamic layer
        final ArcGISDynamicMapServiceLayer localDynamicLayer = new ArcGISDynamicMapServiceLayer(
                localMapService.getUrlMapService());

        // add the layer to the map
        map.getLayers().add(localDynamicLayer);

        localDynamicLayer
                .addLayerInitializeCompleteListener(new LayerInitializeCompleteListener()
                {
                    @Override
                    public void layerInitializeComplete(LayerInitializeCompleteEvent arg0)
                    {
                        if (arg0.getID() == LayerInitializeCompleteEvent.LOCALLAYERCREATE_ERROR)
                        {
                            String errMsg = "Failed to initialize due to "
                                    + localDynamicLayer.getInitializationError();
                            showErrorMsg(errMsg);
                        }
                        DynamicLayerInfoCollection layerInfos = localDynamicLayer
                                .getDynamicLayerInfos();
                        DynamicLayerInfo layerInfo = layerInfos.get(0);

            /*
             * Apply a renderer for dynamic layers. Note: It is always necessary
             * to provide a renderer, but the renderer provided does not need to
             * be valid with regard to the actual layer and geometry type, it
             * simply needs to be a valid renderer. If the renderer specified
             * here is not appropriate for the geometry type of the layer the
             * symbology will fall back to a default SimpleMarkerSymbol,
             * SimpleLineSymbol or SimpleFillSymbol.
             */
                        DrawingInfo drawingInfo = new DrawingInfo(simpleRenderer,
                                TRANSPARENCY);
                        layerInfo.setDrawingInfo(drawingInfo);

                        // Create the data source
                        TableDataSource dataSource = new TableDataSource();
                        dataSource.setWorkspaceId("WORKSPACE");
                        dataSource.setDataSourceName("GREATER GABBARD.shp");

                        // Set the data source
                        LayerDataSource layerDataSource = new LayerDataSource();
                        layerDataSource.setDataSource(dataSource);
                        layerInfo.setLayerSource(layerDataSource);

                        localDynamicLayer.refresh();
                    }
                });

        map.addMapEventListener(new MapEventListenerAdapter()
        {
            @Override
            public void mapExtentChanged(MapEvent arg0)
            {
                if (map.isReady())
                {

                }
            }

            @Override
            public void mapReady(MapEvent event)
            {
                point = GeometryEngine.project(1.758094, 52.474959, mySpat);
                PictureMarkerSymbol pms = new PictureMarkerSymbol((BufferedImage) pointerImage);
                Graphic pointGraphic = new Graphic(point, pms);
                Graphic lineGraphic = new Graphic(polyline, simpleLineSymbol);

                lineID = graphicsLayer.addGraphic(lineGraphic);
                pointerID = graphicsLayer.addGraphic(pointGraphic);

                System.out.println(event.getMap().getExtent().getCenter());
            }


        });


        this.getContentPane().setLayout(new BorderLayout());
        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                super.windowClosing(e);
                map.dispose();
            }
        });

        ActionListener actionListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                graphicsLayer.updateGraphic(lineID, polyline);
                graphicsLayer.updateGraphic(pointerID, point);
            }
        };

        map.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {

            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_C:
                        System.out.println("Clearing");
                        firstUpdate = true;
                        polyline.setEmpty();
                        break;
                    case KeyEvent.VK_ESCAPE:

                        polyline.setEmpty();
                        map.dispose();
                        System.exit(0);
                    default:
                        System.out.println(e.getKeyCode());
                }
            }

            @Override
            public void keyReleased(KeyEvent e)
            {

            }
        });

        timer = new Timer(10, actionListener);

        this.pack();
    }

    public void startTimer()
    {
        timer.start();
    }

    private String getPathSampleData()
    {
        String dataPath = null;
        String javaPath = ArcGISRuntime.getInstallDirectory();
        if (javaPath != null)
        {
            if (!(javaPath.endsWith("/") || javaPath.endsWith("\\")))
            {
                javaPath += FSP;
            }
            dataPath = javaPath + "sdk" + FSP + "samples" + FSP + "data" + FSP;
        }
        assert dataPath != null;
        File dataFile = new File(dataPath);
        if (!dataFile.exists())
        {
            dataPath = ".." + FSP + "data" + FSP;
        }
        return dataPath;
    }

    private void showErrorMsg(String message)
    {
        JOptionPane.showMessageDialog(null, message, "", JOptionPane.ERROR_MESSAGE);
    }

    private class MyOverlay extends MapOverlay
    {
        @Override
        public void onMouseClicked(MouseEvent event)
        {
            point = map.toMapPoint(event.getX(), event.getY());
            if (firstUpdate)
            {
                polyline.setEmpty();
                polyline.startPath(point);
                firstUpdate = false;
            } else
            {

                //point = GeometryEngine.project(currentLat, currentLong, map.getSpatialReference());
                polyline.lineTo(point);
            }

            Point p1 = (Point) GeometryEngine.project(point, map.getSpatialReference(), mySpat);

            System.out.println(p1.getX() + " " + p1.getY());
        }

        @Override
        public void onMouseDragged(MouseEvent event)
        {
            if (mouseThree)
            {
                point = map.toMapPoint(event.getX(), event.getY());
                polyline.lineTo(point);
            }else
            {
                super.onMouseDragged(event);
            }
        }

        @Override
        public void onMousePressed(MouseEvent event)
        {
            super.onMousePressed(event);
            switch (event.getButton())
            {
                case MouseEvent.BUTTON1:
                    mouseOne = true;
                    break;
                case MouseEvent.BUTTON2:
                    mouseTwo = true;
                    break;
                case MouseEvent.BUTTON3:
                    mouseThree = true;
                    break;
                default:
            }
        }

        @Override
        public void onMouseReleased(MouseEvent event)
        {
            super.onMouseReleased(event);
            switch (event.getButton())
            {
                case MouseEvent.BUTTON1:
                    mouseOne = false;
                    break;
                case MouseEvent.BUTTON2:
                    mouseTwo = false;
                    break;
                case MouseEvent.BUTTON3:
                    mouseThree = false;
                    break;
                default:
            }
        }
    }
}
