import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class StartMenu extends JFrame {
    private Image backgroundImage;

    public StartMenu() {
        // Load the background image
        try {
            backgroundImage = ImageIO.read(new File("src/background.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set up the frame
        setTitle("Dad Simulator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the panel with custom painting
        JPanel panel = new BackgroundPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create the title label
        JLabel titleLabel = new JLabel("Dad Simulator", JLabel.CENTER);
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(Color.BLUE); // Set text color to blue for better contrast

        // Add a white border around the title
        Border border = BorderFactory.createLineBorder(Color.WHITE, 3);
        titleLabel.setBorder(border);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(255, 255, 255, 180)); // Semi-transparent white background

        // Create the start button
        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setMaximumSize(new Dimension(100, 40)); // Set the button size
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new DadCharacterScreen().setVisible(true);
                    }
                });
            }
        });

        // Add components to the panel
        panel.add(Box.createVerticalGlue()); // Add space before title
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Add space between title and button
        panel.add(startButton);
        panel.add(Box.createVerticalGlue()); // Add space after button

        // Add panel to the frame
        add(panel);
    }

    private class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StartMenu().setVisible(true);
            }
        });
    }
}
