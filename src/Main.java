
import java.awt.*;
        import java.awt.event.*;

public class Main extends Frame implements MouseListener, MouseMotionListener, KeyListener {
    Point p1;
    boolean isSpacePressed;

    class MyEventWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            dispose();
            System.exit(0);
        }
    }

    public void mouseClicked(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseMoved(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {
        p1 = e.getPoint();
        if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
            repaint();
        }
    }

    public void mouseDragged(MouseEvent e) {
        Point p2 = e.getPoint();
        Graphics g = getGraphics();
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
        p1 = p2;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            isSpacePressed = true;
            repaint();
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            isSpacePressed = false;
        }
    }

    public void keyTyped(KeyEvent e) {}



    public Main() {
        super("Draw mouse");
        addWindowListener(new MyEventWindowAdapter());
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
        setSize(900, 600);
        setLocation(20, 30);
        setVisible(true);
    }

    public static void main(String[] args) {
        Main myWindow = new Main();
    }
}