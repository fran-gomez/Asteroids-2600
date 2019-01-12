package graphics;

import asteroids.Asteroid;
import controller.Visitor;
import resources.Constantes;
import resources.RotatedIcon;
import shoots.Shoot;
import weapons.BaseWeapon;
import weapons.Weapon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class PlayerShip extends GraphicObject {

    // << Atributos >>
    protected double angulo; // Angulo de rotacion de la nave
    protected final double deltaAngulo = Math.PI / 16; // Arco de rotacion

    protected int lifePoints; // Puntos de vida
    protected int hitPoints;  // Puntos de daño
    protected int shieldPoints; // Puntos de amortiguacion de daño

    protected Weapon weapon; // Arma. Fabrica abstracta de disparos

    // << Constructor >>
    public PlayerShip(int x, int y, int lp,  int hp, int sp) {
        super(x, y);

        // Ajustamos el cuadro del jugador, por el tema de las rotaciones
        this.setSize(Constantes.ALTO_JUGADOR, Constantes.ANCHO_JUGADOR);
        this.hitBox.setSize(Constantes.ALTO_JUGADOR, Constantes.ANCHO_JUGADOR);

        this.angulo = 0;

        this.lifePoints = lp;
        this.hitPoints = hp;
        this.shieldPoints = sp;

        this.weapon = new BaseWeapon(hitPoints, angulo);


        establecerTeclas();
    }

    // << Consultas >>
    public int getLifePoints() {
        return lifePoints;
    }

    // << Comandos >>
    public void receiveDamage(int dmg) {
        int damage = dmg - (dmg * shieldPoints / 100);
        this.lifePoints -= damage;

        if (this.lifePoints <= 0)
            this.lifePoints = 0;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public void shoot() {
        // TODO: EL jugador agrega los disparos al mapa? O los disparos se agregan solos?
        weapon.createShoot(position.x, position.y);
    }

    public String getGraphicsPath() {
        return "src/resources/nave.png";
    }

    public void colisionar(Asteroid a) {
        a.receiveDamage(this.hitPoints / 10);
    }

    public void colisionar(PlayerShip ps){}
    public void colisionar(Shoot s){}

    public void die(){}

    // << Privados >>
    private void establecerTeclas() {
        // Obtengo los mapeos de movimiento
        ActionMap am = getActionMap();
        InputMap  im = getInputMap(WHEN_IN_FOCUSED_WINDOW);

        // Establezco los key binds para las flechas (MovimientoAbajo), y la barra (Disparo)
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "Bajar");
        am.put("Bajar", new MovimientoAtras());

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "Subir");
        am.put("Subir", new MovimientoAdelante());

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "RotarDerecha");
        am.put("RotarDerecha", new RotacionDerecha());

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "RotarIzquierda");
        am.put("RotarIzquierda", new RotacionIzquierda());

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "Disparar");
        am.put("Disparar", new Disparar());
    }

    private class MovimientoAtras extends  AbstractAction {
        public void actionPerformed(ActionEvent actionEvent) {

            deltaX = Math.sin(angulo);
            deltaY = Math.cos(angulo);

            position.x -= 5*deltaX;
            position.y += 5*deltaY;
            move();
        }
    }

    private class MovimientoAdelante extends AbstractAction {
        public void actionPerformed(ActionEvent actionEvent) {

            deltaX = Math.sin(angulo);
            deltaY = Math.cos(angulo);

            position.x += 5*deltaX;
            position.y -= 5*deltaY;
            move();
        }
    }

    private class RotacionDerecha extends AbstractAction {
        public void actionPerformed(ActionEvent actionEvent) {


            angulo += deltaAngulo;

            if (angulo < 0)
                angulo += 2*Math.PI;
            if (angulo > 2*Math.PI)
                angulo -= 2*Math.PI;

            RotatedIcon ri = new RotatedIcon(imageIcon, Math.toDegrees(angulo));
            setIcon(ri);

            weapon.setAngulo(angulo);
            setPosition(position);

            move();
        }
    }

    private class RotacionIzquierda extends AbstractAction {
        public void actionPerformed(ActionEvent actionEvent) {

            angulo -= deltaAngulo;

            if (angulo < 0)
                angulo += 2*Math.PI;
            if (angulo > 2*Math.PI)
                angulo -= 2*Math.PI;

            RotatedIcon ri = new RotatedIcon(imageIcon, Math.toDegrees(angulo));
            setIcon(ri);

            weapon.setAngulo(angulo);
            setPosition(position);

            move();
        }
    }

    private class Disparar extends AbstractAction {
        public void actionPerformed(ActionEvent actionEvent) {
            //shoot();
            System.out.println("Disparo");
        }
    }


}
