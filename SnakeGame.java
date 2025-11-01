import javax.swing.*;

public class SnakeGame extends JFrame {
    public SnakeGame() {
        setTitle("Snake Game");
        add(new Board());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SnakeGame());
    }
}
