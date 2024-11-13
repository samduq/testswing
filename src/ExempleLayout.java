import javax.swing.*;
import java.awt.*;

public class ExempleLayout {
    public static void main(String[] args) {
        // Création de la fenêtre
        JFrame frame = new JFrame("Exemple de Layouts sans boutons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Utilisation de BorderLayout pour organiser les panneaux principaux
        frame.setLayout(new BorderLayout());

        // Panneau haut avec FlowLayout (par défaut)
        JPanel panelTop = new JPanel(new FlowLayout());
        panelTop.add(new JLabel("Label Haut 1"));
        panelTop.add(new JLabel("Label Haut 2"));
        panelTop.add(new JLabel("Label Haut 3"));
        frame.add(panelTop, BorderLayout.NORTH);

        // Panneau central avec GridLayout (2 lignes, 2 colonnes)
        JPanel panelWest = new JPanel(new GridLayout(2, 2));
        panelWest.add(new JLabel("West"));
        frame.add(panelWest, BorderLayout.WEST);

        // Panneau bas avec FlowLayout
        JPanel panelBottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBottom.add(new JLabel("Label Bas 1"));
        panelBottom.add(new JLabel("Label Bas 2"));
        frame.add(panelBottom, BorderLayout.SOUTH);

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }
}
