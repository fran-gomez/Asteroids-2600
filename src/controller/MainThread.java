package controller;

import graphics.GraphicObject;
import graphics.Map;

import java.util.Collection;

public class MainThread extends Thread {

    protected volatile boolean ejecutar;
    protected Map map;

    public MainThread(Map m) {
        map = m;
        ejecutar = true;
    }

    public void run() {

        int lastFpsTime = 0, fps = 60;
        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

        while (ejecutar) {

            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double)OPTIMAL_TIME);

            // update the frame counter
            lastFpsTime += updateLength;
            fps++;

            // update our FPS counter if a second has passed since
            // we last recorded
            if (lastFpsTime >= 1000000000)
            {
                lastFpsTime = 0;
                fps = 0;
            }

            map.gameLoop();

            try{Thread.sleep(1000 );}
            catch (InterruptedException e) {e.printStackTrace();}
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
