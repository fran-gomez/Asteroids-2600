package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import asteroids.Asteroid;
import controller.Visitor;
import resources.Constantes;
import shoots.Shoot;

public abstract class GraphicObject extends JLabel {

    // << Atributos >>
    protected ImageIcon imageIcon; // Icono del grafico

    protected Rectangle hitBox; // Caja de colisiones

    protected Point position; // Posicion del centro del grafico
    protected double deltaX; // Variacion en la coordenada x
    protected double deltaY; // Variacion en la coordenada y

    // << Constructor >>
    public GraphicObject(int x, int y) {
        super();

        // Creamos el hitbox, y establecemos la posicion del objeto
        hitBox = new Rectangle(x, y, Constantes.ALTO_GRAFICO, Constantes.ANCHO_GRAFICO);
        position = new Point(x, y);

        // Setear la posicion absoluta y el tamaño del componente grafico
        this.setLocation(position);
        this.setSize(Constantes.ALTO_GRAFICO, Constantes.ANCHO_GRAFICO);
        this.setOpaque(false);

        // Establecer el icono del componente grafico
        setGraphics();
    }

    // << Consultas >>
    public boolean intersects(GraphicObject go) {
        return hitBox.intersects(go.hitBox);
    }

    public abstract String getGraphicsPath();
    public abstract int getLifePoints();

    // << Comandos >>
    public void setPosition(Point p) {
        position = p;
    }

    // Reubica el objeto grafico, y lo pinta
    public void move() {

        // Corroboramos que x no se nos salga del rango (0, ANCHO_VENTANA)
        if (position.x >= Constantes.LIMITE_X_HI)
            position.x -= Constantes.ANCHO_VENTANA;
        if (position.x <= Constantes.LIMITE_X_LOW)
            position.x += Constantes.ANCHO_VENTANA;

        // Corroboramos que y no se nos salga del rango (0, ALTO_VENTANA)
        if (position.y >= Constantes.LIMITE_Y_HI)
            position.y -= Constantes.ALTO_MAPA;
        if (position.y <= Constantes.LIMITE_Y_LOW)
            position.y += Constantes.ALTO_MAPA;

        // Reajustamos la posicion del grafico y su hitbox
        this.setLocation(position);
        hitBox.setLocation(position);

        // Redibujamos el grafico
        repaint();
    }

    public abstract void accept(Visitor v);

    public abstract void colisionar(PlayerShip ps);
    public abstract void colisionar(Asteroid a);
    public abstract void colisionar(Shoot s);

    public abstract void die();


    // Establece el icono del label, ajustando su tamaño previamente
    private void setGraphics() {

        // Cargamos la imagen en un buffer
        BufferedImage icon = null;
        try {
            icon = ImageIO.read(new File(getGraphicsPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ajustamos el tamaño de la imagen buffereada
        Image img = icon.getScaledInstance(Constantes.ANCHO_GRAFICO, Constantes.ALTO_GRAFICO, Image.SCALE_SMOOTH);

        // Creamos la imagen con el tamaño ajustado
        imageIcon = new ImageIcon(img);

        // Seteamos el grafico del objeto con la imagen escalada
        this.setIcon(imageIcon);
    }
}
