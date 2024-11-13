import javax.swing.*;
import java.awt.*;

public class AffichageHautGauche {
    public static void main(String[] args) {
        // Création de la fenêtre
        JFrame frame = new JFrame("Affichage de texte en haut à gauche et en haut au centre");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Utilisation de BorderLayout pour organiser la fenêtre
        frame.setLayout(new BorderLayout());

        // Panneau pour le texte en haut à gauche
        JPanel panelTopLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelLeft = new JLabel("Texte en haut à gauche");
        panelTopLeft.add(labelLeft);

        // Panneau pour le texte en haut au centre
        JPanel panelTopCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelCenter = new JLabel("Texte en haut au centre");
        panelTopCenter.add(labelCenter);

        // Panneau principal pour le haut, contenant les deux panneaux
        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.add(panelTopLeft, BorderLayout.WEST);    // Texte à gauche
        panelTop.add(panelTopCenter, BorderLayout.CENTER); // Texte au centre

        // Ajout du panneau supérieur à la fenêtre principale
        frame.add(panelTop, BorderLayout.NORTH);

        // Afficher la fenêtre
        frame.setVisible(true);
    }
}
