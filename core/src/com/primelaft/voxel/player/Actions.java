package com.primelaft.voxel.player;


public class Actions {
    public Player player = new Player();

    public void MoveForward(double vielocity)
    {
        player.tmp.set(player.cam.direction).nor().scl((float) (player.deltaTime * vielocity));
        player.tmp.y = 0;
        player.cam.position.add(player.tmp);
    }
    public void MoveBack()
    {
        player.tmp.set(player.cam.direction).nor().scl((float) (-player.deltaTime * player.vielocity));
        player.tmp.y = 0;
        player.cam.position.add(player.tmp);
    }
    public void MoveLeft()
    {
        player.tmp.set(player.cam.direction).nor().crs(player.cam.up).scl((float) (-player.deltaTime * player.vielocity));
        player.tmp.y = 0;
        player.cam.position.add(player.tmp);
    }
    public void MoveRight()
    {
        player.tmp.set(player.cam.direction).nor().crs(player.cam.up).scl((float) (player.deltaTime * player.vielocity));
        player.tmp.y = 0;
        player.cam.position.add(player.tmp);
    }
    public void SpeedUp()
    {
        player.vielocityCurrent = 0.7;
    }
    public void SpeedDown()
    {
        player.vielocityCurrent = player.vielocity;
    }
}
