package com.primelaft.voxel.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Vector3;
import com.primelaft.voxel.Voxel;

public class Player {
    public static PerspectiveCamera cam;
    public final Vector3 tmp = new Vector3();
    public int deltaTime = 1;
    public double vielocity = 0.2;
    public double vielocityCurrent;
    public double vielocityMax = 0.5;
    Keys keys;

    public void initializePlayer()
    {
        camera();
        keys = new Keys();
    }
    public void camera()
    {
        cam = new PerspectiveCamera(45, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.position.set(2f, 2f, 2f);
        cam.lookAt(0, 2, 2);
        cam.near = 1f;
        cam.far = 300f;
        cam.update();
    }
    public void updateCamera() {
        cam.update();
        float deltaX = -Gdx.input.getDeltaX() * 0.5f;
        float deltaY = -Gdx.input.getDeltaY() * 0.5f;
        cam.direction.rotate(cam.up, deltaX);
        tmp.set(cam.direction).crs(cam.up).nor();
        Player.cam.direction.rotate(tmp, deltaY);
        keys.check();
        Voxel.modelBatch.begin(cam);
    }
}


