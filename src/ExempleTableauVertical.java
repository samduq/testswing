import javax.swing.*;
import java.awt.*;

public class ExempleTableauVertical {
    public static void main(String[] args) {
        // Création de la fenêtre
        JFrame frame = new JFrame("Exemple de Tableau Vertical avec Graphique au Centre");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Utilisation de BorderLayout pour organiser la fenêtre
        frame.setLayout(new BorderLayout());

        JPanel panelTopLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton buttonLeft = new JButton("Voir profil");
        panelTopLeft.add(buttonLeft);

        // Panneau pour le texte en haut au centre
        JPanel panelTopCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelCenter = new JLabel("Mettre les bénéfices ou les pertes");
        panelTopCenter.add(labelCenter);

        // Panneau principal pour le haut, contenant les deux panneaux
        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.add(panelTopLeft, BorderLayout.WEST);    // Bouton à gauche
        panelTop.add(panelTopCenter, BorderLayout.CENTER); // Texte au centre

        // Ajout du panneau supérieur à la fenêtre principale
        frame.add(panelTop, BorderLayout.NORTH);

        // Création d'un tableau (liste verticale) avec JList pour la partie gauche
        String[] data = {"Élément 1", "Élément 2", "Élément 3", "Élément 4", "Élément 5",
                         "Élément 6", "Élément 2", "Élément 3", "Élément 4", "Élément 5",
                         "Élément 1", "Élément 2", "Élément 3", "Élément 4", "Élément 5",
                         "Élément 1", "Élément 2", "Élément 3", "Élément 4", "Élément 5",
                         "Élément 1", "Élément 2", "Élément 3", "Élément 4", "Élément 5"};
        JList<String> list = new JList<>(data);
        list.setFixedCellHeight(30);
        
        // Ajout du tableau dans un panneau avec un JScrollPane pour un défilement si besoin
        JPanel panelLeft = new JPanel(new BorderLayout());
        panelLeft.add(new JScrollPane(list), BorderLayout.CENTER);
        
        // Ajout du panneau à gauche de la fenêtre
        frame.add(panelLeft, BorderLayout.WEST);

        // Ajout du graphique au centre en utilisant GraphPanel
        frame.add(new GraphPanel(), BorderLayout.CENTER);

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }
}
