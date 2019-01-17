package graphics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.LinkedList;

import javax.swing.*;

import asteroids.MultipleAsteroid;
import asteroids.SimpleAsteroid;
import asteroids.UFO;
import controller.*;
import resources.Constantes;

public class Map extends JPanel implements Agregable {

	// << Atributos >>
	protected Collider colider;  // Controlador de colisiones
	protected MainThread asteroidsThread; // Controlador de movimiento

	protected Collection<GraphicObject> objects; // Coleccion de objetos graficos mostrados en el mapa
	protected GeneradorAsteroides generadorAsteroides; // Generador automatico de asteroides. Trabaja con prototipos

	protected PlayerShip player; // Nave del jugador

	protected Score scorePanel; // Panel de puntos

	protected VisitorContador contadorAsteroides; // Chequeo de cantidad de asteroides

	// << Constructor >>
	public Map(Score score) {
		super();

		// Ajustamos toda la parte grafica referente al mapa
		this.setBackground(Color.black);
		this.setPreferredSize(new Dimension(Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA - 30));
		this.setLayout(null);

		// Creamos al generador de asteroides
		generadorAsteroides = new GeneradorAsteroides(new SimpleAsteroid(20, 5), new MultipleAsteroid(15, 10), new UFO(35, 12));
		objects = new LinkedList<>();
		generadorAsteroides.populateList(objects);

		// Agregamos los objetos graficos al mapa
		for (GraphicObject go: objects)
			this.add(go);

		// Creamos la nave del jugador y la agregamos al mapa
		player = new PlayerShip(Constantes.ANCHO_VENTANA / 2, Constantes.ALTO_VENTANA / 2, 100, 20, 0);
		this.addToMap(player);

		// Inicializamos los objetos de control del juego (Colisiones y movimientos)
		colider = new Collider(objects);
		asteroidsThread = new MainThread(this);

		// Otros...
		contadorAsteroides = new VisitorContador(objects);
		scorePanel = score;

		// Establecemos los oyentes para la pausa, reinicio y salida
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0), "Pausa");
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0), "Retornar");
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "Salir");

        getActionMap().put("Pausa", new Pause());
        getActionMap().put("Retornar", new Resume());
        getActionMap().put("Salir", new Quit());


		// Iniciamos la ejecucion de los threads
		asteroidsThread.start();
	}

	// << Comandos >>
	public void update() {

		// Orgia de colisiones
		colider.checkCollisions();

		// Actualizamos los puntos de vida del jugador
		scorePanel.setPlayerLife(player.getLifePoints());

		// Chequeamos que el jugador siga vivo
		if (player.getLifePoints() <= 0)
			this.endGame();

		contadorAsteroides.reset();
		// No se me ocurre que poner... ya es tarde
		for (GraphicObject o: objects) {
			o.accept(contadorAsteroides);
			o.move();
		}

		// Si ya eliminamos todos los asteroides, le pedimos mas al generador y los agregamos al mapa
		if (contadorAsteroides.cantidadAsteroides() == 0) {
			generadorAsteroides.nextWave(objects);
			for (GraphicObject go: objects)
				this.add(go);
		}

		scorePanel.add(5);
	}

	public void render() {
		for (GraphicObject go: objects)
			go.repaint();
	}

	private void endGame() {

		// Limpiamos el mapa
		for (GraphicObject go: objects)
			this.remove(go);
		this.repaint();

		// Detenemos el thread de movimiento
		this.asteroidsThread.pausar();

		// Guardamos el puntaje del jugador
		scorePanel.saveScore();
	}

	public synchronized void addToMap(GraphicObject go) {
		objects.add(go); // Agrego a la lista de objetos graficos
		this.add(go);    // Agrego el objeto grafico al mapa
	}


	// << Privados >>
    private class Pause extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            asteroidsThread.pausar();
        }
    }

    private class Resume extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            asteroidsThread.reiniciar();
        }
    }

    private class Quit extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
        	endGame();
            System.exit(0);
        }
    }
}
