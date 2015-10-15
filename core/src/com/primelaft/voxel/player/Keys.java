package com.primelaft.voxel.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.primelaft.voxel.world.Models;

public class Keys {
    public Actions actions = new Actions();
    public Player player = new Player();

    public Keys()
    {
        Gdx.input.setCursorCatched(true);
    }

    public void check()
    {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            actions.MoveForward(player.vielocity);
            Models.getInstance(2).transform.setToTranslation(15, 0, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            actions.MoveBack();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            actions.MoveLeft();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            actions.MoveRight();
            Models.removeFromRender(3);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            actions.MoveForward(player.vielocityMax);
        }
    }
}
