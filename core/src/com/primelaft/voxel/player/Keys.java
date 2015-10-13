package com.primelaft.voxel.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Keys {
    Actions actions = new Actions();
    Player player = new Player();

    public Keys()
    {
        Gdx.input.setCursorCatched(true);
    }

    public void check()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            actions.MoveForward(player.vielocity);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            actions.MoveBack();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            actions.MoveLeft();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            actions.MoveRight();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            actions.MoveForward(player.vielocityMax);
        }

    }
}
