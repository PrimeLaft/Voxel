package com.primelaft.voxel.actors;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.primelaft.voxel.world.Models;

public class Actor {
    public Integer health;
    public Integer currentHealth;
    public ModelInstance model;
    public boolean actorDead = false;

    /*
    Create a new Actor
    */
    public void createNewActor(String actorName, String model, Integer health, Vector3 location)
    {
        addToRegistry(actorName);
        setModel(model, location);
        setLocation(location);
        setHealth(health);
    }
    /*
    Add actor object to registry
    */
    public void addToRegistry(String actorName)
    {
        Actors.addToRegistry(this, actorName);
    }
    /*
    Play new actor animation
    */
    public void playAnimation()
    {
    }
    /*
    Stop current animation of actor
    */
    public void stopAnimation()
    {

    }
    /*
    Move actor to new location
    */
    public void moveTo(Vector3 location)
    {

    }
    /*
    Set actor model
    */
    public void setModel(String model, Vector3 location)
    {
        Models.loadModel(model);
        Models.addToRender(model, Actors.actors.size()).transform.setToTranslation(location);
    }
    /*
    Set actor health
    */
    public void setHealth(Integer newHealth)
    {
        health = newHealth;
    }
    /*
    Kill actor = remove from world
    */
    public void death()
    {

    }
    /*
    Check if actor is dead
    */
    public boolean checkDead()
    {
        return actorDead;
    }
    /*
    Set actor world location
    */
    public void setLocation(Vector3 location)
    {
        Models.getInstance(Actors.actors.indexOf(this)).transform.translate(location);
    }
    /*
    Get actor world location
    */
    public Vector3 getLocation()
    {
        Vector3 location = new Vector3();

        Models.getInstance(Actors.actors.indexOf(this)).transform.getTranslation(location);
        return location;
    }
}
