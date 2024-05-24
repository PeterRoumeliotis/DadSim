import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DadCharacterScreen extends JFrame {
    private Image dadImage;

    public DadCharacterScreen() {
        // Load the dad character image
        try {
            dadImage = ImageIO.read(new File("src/dadCharacter.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set up the frame
        setTitle("Dad Character");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Make the window fullscreen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true); // Remove window decorations

        // Create the panel with custom painting
        JPanel panel = new CharacterPanel();
        add(panel);
    }

    private class CharacterPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw white background
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());

            if (dadImage != null) {
                // Draw the dad image
                int imageWidth = dadImage.getWidth(this);
                int imageHeight = dadImage.getHeight(this);
                int x = (getWidth() - imageWidth) / 2 - 100; // Adjusting position to fit text bubble
                int y = (getHeight() - imageHeight) / 2;
                g.drawImage(dadImage, x, y, this);

                // Draw text bubble
                int bubbleWidth = 200;
                int bubbleHeight = 100;
                int bubbleX = x + imageWidth + 20;
                int bubbleY = y + (imageHeight - bubbleHeight) / 2;
                g.setColor(Color.WHITE);
                g.fillRoundRect(bubbleX, bubbleY, bubbleWidth, bubbleHeight, 20, 20);
                g.setColor(Color.BLACK);
                g.drawRoundRect(bubbleX, bubbleY, bubbleWidth, bubbleHeight, 20, 20);

                // Draw text inside the bubble
                g.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
                g.drawString("Hi son, what did", bubbleX + 10, bubbleY + 30);
                g.drawString("you want to call", bubbleX + 10, bubbleY + 50);
                g.drawString("me again?", bubbleX + 10, bubbleY + 70);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DadCharacterScreen frame = new DadCharacterScreen();
                frame.setVisible(true);
            }
        });
    }
}
