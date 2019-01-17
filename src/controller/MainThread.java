package controller;

import graphics.Map;

public class MainThread extends Thread {

    protected volatile boolean ejecutar;
    protected Map map;

    public MainThread(Map m) {
        map = m;
        ejecutar = true;
    }

    public void run() {
        long lastTime = System.nanoTime();
        final double ns = 1000000000.0 / 30.0;
        double delta = 0.0;

        while (ejecutar) {

            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                map.update();
                delta--;
            }
            map.render();
        }
    }

    public void pausar() {
        ejecutar = false;
    }

    public void reiniciar() {
        ejecutar =  true;
        run();
    }
}
