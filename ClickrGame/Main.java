import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new MainPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MainPane extends JPanel {
        private BoxPane boxPane;

        public MainPane() {
            setLayout(new BorderLayout());
            boxPane = new BoxPane();
            add(boxPane);

            JButton btn = new JButton("Start");
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (boxPane.isRunning()) {
                        boxPane.stop();
                        btn.setText("Start");
                    } else {
                        boxPane.start();
                        btn.setText("Stop");
                    }
                }
            });

            add(btn, BorderLayout.SOUTH);
        }
    }

    public class BoxPane extends JPanel {
        private Rectangle boxy;
        private Random random = new Random();

        private Timer timer;

        public BoxPane() {
            timer = new Timer(5000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    randomiseLocation();
                }
            });
            timer.setInitialDelay(0);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (boxy == null) {
                        return;
                    }
                    if (!boxy.contains(e.getPoint())) {
                        return;
                    }
                    // Box was clicked
                    randomiseLocation();
                    timer.restart();
                }
            });
        }

        protected void randomiseLocation() {
            int x = random.nextInt(getWidth() - boxy.width);
            int y = random.nextInt(getHeight() - boxy.height);
            boxy.x = x;
            boxy.y = y;
            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        public boolean isRunning() {
            return timer.isRunning();
        }

        public void start() {
            boxy = new Rectangle(0, 0, 20, 20);
            randomiseLocation();
            timer.start();
        }

        public void stop() {
            timer.stop();
            boxy = null;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (boxy == null) {
                return;
            }
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);
            g2d.fill(boxy);
            g2d.setColor(Color.BLUE);
            g2d.draw(boxy);
            g2d.dispose();
        }

    }
}