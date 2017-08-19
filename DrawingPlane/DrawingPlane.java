import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import java.awt.event.MouseListener.*;
import java.awt.event.MouseMotionListener.*;
import java.awt.event.MouseEvent.*;
import java.awt.MouseInfo.*;

/*
Draw 2D lines on a plane by clicking the start and end points.

To compile and run the program, enter these two lines in Terminal (mac OS X): 
          javac DrawingPlane.java
          java DrawingPlane
*/
class DrawingPlane {
    private static int DEFAULT_FRAME_WIDTH = 800;
    private static int DEFAULT_FRAME_HEIGHT = 800;
    private static int DEFAULT_WINDOW_WIDTH = 600;
    private static int DEFAULT_WINDOW_HEIGHT = 600;
    private JFrame f = new JFrame("Plane");
    private BufferedImage bi = new BufferedImage(DEFAULT_WINDOW_WIDTH,DEFAULT_WINDOW_HEIGHT,5);

    /*
    * The main method accepts an input from the user that determines the grid numberOfTilesWides
    */
    public static void main(String[] args) {
        DrawingPlane dp = new DrawingPlane();
    }

    DrawingPlane() {
        f.setBounds(0,0,DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);

        JLabel l = new JLabel();
        l.setBounds(0,0,DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
        l.setIcon(new ImageIcon(bi));

        f.setVisible(true);
        l.setVisible(true);
        f.setLocationRelativeTo(l);
        f.add(l);

        MouseEventHandler mouseEvents = new MouseEventHandler();
        l.addMouseMotionListener(mouseEvents);
        l.addMouseListener(mouseEvents);

        drawPlane();
    }

    /*
    * Draw the "Euclidean Plane".
    */
    private BufferedImage drawPlane() {
        Graphics2D g = bi.createGraphics();

        g.setPaint( Color.blue.darker().darker() );
        g.fillRect ( 0, 0, DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT );

        return bi;
    }

    /*
    * Handles mousevents on the plane.
    */ 
    int x1 = -1;
    int y1 = -1;
    private class MouseEventHandler implements MouseListener, MouseMotionListener {
        public void mouseMoved(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) {
            if (withinPlane(e.getX(), e.getY())) {
                if (x1 == -1) {
                    x1 = e.getX();
                    y1 = e.getY();
                    bi.setRGB(x1,y1,Color.red.getRGB());
                } else if (x1 != -1) {
                    int x2 = e.getX();
                    int y2 = e.getY();
                    Vector v = new Vector(x1,y1,x2,y2);
                    bi = v.draw(bi,Color.red.getRGB());
                    f.repaint();
                    x1 = -1;
                    y1 = -1;
                }
            }
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseDragged(MouseEvent e) {
        }
    }

    /*
    * Determine if a point lies within the plane.
    */
    private boolean withinPlane(int x, int y) {
        return x < DEFAULT_WINDOW_WIDTH && y < DEFAULT_WINDOW_HEIGHT;
    }

}
