import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AffichageGraphique2 {
    public static void main(String[] args) {
        // Création de la fenêtre
        JFrame frame = new JFrame("Graphique en Ligne sans JFreeChart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Ajouter un panneau de graphique personnalisé
        GraphPanel graphPanel = new GraphPanel();
        frame.add(graphPanel);

        // Afficher la fenêtre
        frame.setVisible(true);
    }
}

class GraphPanel extends JPanel {
    // Données pour le graphique (float)
    private float[] data = {1.0f, 4.0f, 3.5f, 5.2f, 2.8f, 7.0f, 4.6f, 6.3f};
    private int[] xPoints;
    private int[] yPoints;

    // Points sélectionnés par l'utilisateur
    private Point point1 = null;
    private Point point2 = null;

    public GraphPanel() {
        // Écouteur pour capturer les clics de souris
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (point1 == null) {
                    point1 = e.getPoint();
                } else {
                    point2 = e.getPoint();
                    calculerVariationPourcentage();
                    point1 = null;  // Réinitialiser pour une nouvelle sélection
                    point2 = null;
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Conversion vers Graphics2D pour des options de dessin avancées
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dimensions du panneau
        int width = getWidth();
        int height = getHeight();

        // Marges et espace pour le graphique
        int margin = 50;
        int graphWidth = width - 2 * margin;
        int graphHeight = height - 2 * margin;

        // Dessiner les axes
        g2.drawLine(margin, height - margin, margin, margin); // Axe Y
        g2.drawLine(margin, height - margin, width - margin, height - margin); // Axe X

        // Dessiner les points et les lignes du graphique
        int numPoints = data.length;
        int xStep = graphWidth / (numPoints - 1); // Espace entre chaque point sur l'axe X

        // Calcul des coordonnées des points
        xPoints = new int[numPoints];
        yPoints = new int[numPoints];

        float maxDataValue = 10.0f;  // Valeur maximale (à ajuster en fonction des données)
        
        for (int i = 0; i < numPoints; i++) {
            xPoints[i] = margin + i * xStep;
            yPoints[i] = height - margin - (int) ((data[i] / maxDataValue) * graphHeight);
        }

        // Dessiner les lignes du graphique
        g2.setColor(Color.BLUE);
        for (int i = 0; i < numPoints - 1; i++) {
            g2.drawLine(xPoints[i], yPoints[i], xPoints[i + 1], yPoints[i + 1]);
        }

        // Dessiner les points du graphique
        g2.setColor(Color.RED);
        for (int i = 0; i < numPoints; i++) {
            g2.fillOval(xPoints[i] - 4, yPoints[i] - 4, 8, 8); // Dessine chaque point comme un petit cercle
        }

        // Ajouter des labels pour l'axe Y (optionnel)
        g2.setColor(Color.BLACK);
        for (int i = 0; i <= 10; i++) {
            int y = height - margin - (i * (graphHeight / 10));
            g2.drawString(Float.toString(i), margin - 25, y + 5); // Valeur de l'axe Y
            g2.drawLine(margin - 5, y, margin + 5, y); // Petits repères sur l'axe Y
        }
    }

    private void calculerVariationPourcentage() {
        if (point1 != null && point2 != null) {
            // Trouver les index des points les plus proches
            int index1 = trouverPointProche(point1);
            int index2 = trouverPointProche(point2);

            if (index1 != -1 && index2 != -1 && data[index1] != 0) {
                // Calculer la variation en pourcentage entre les deux points sélectionnés
                float variationPourcentage = ((data[index2] - data[index1]) / data[index1]) * 100;
                JOptionPane.showMessageDialog(this, "Variation entre les points: " + variationPourcentage + " %");
            }
        }
    }

    private int trouverPointProche(Point point) {
        for (int i = 0; i < xPoints.length; i++) {
            if (Math.abs(point.x - xPoints[i]) < 5 && Math.abs(point.y - yPoints[i]) < 5) {
                return i;
            }
        }
        return -1; // Retourne -1 si aucun point proche n'est trouvé
    }
}
