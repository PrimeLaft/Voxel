package com.primelaft.voxel.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;
import com.primelaft.voxel.actors.Actors;
import com.primelaft.voxel.world.Models;

public class Keys {
    public Actions actions = new Actions();
    public Player player = new Player();

    public Keys()
    {
        Gdx.input.setCursorCatched(true);
    }

    public Integer i = 0;
    public void check()
    {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            actions.MoveForward(player.vielocity);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            actions.MoveBack();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            actions.MoveLeft();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            actions.MoveRight();


            Actors.getActor("julia").setLocation(new Vector3(-10f, 4f, 0f));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            actions.MoveForward(player.vielocityMax);
        }
    }
}
