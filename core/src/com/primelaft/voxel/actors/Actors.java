package com.primelaft.voxel.actors;

import com.primelaft.voxel.world.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Actors {
    public static List<Actor> actors = new ArrayList<Actor>();
    public static Map<String, Integer> actorsNames = new HashMap<String, Integer>();

    public static void addToRegistry(Actor actor, String actorName)
    {
        actorsNames.put(actorName, actors.size());
        actors.add(actor);
    }
    /*
    Remove actor
    */
    public static void removeActor(String actorName)
    {
        actors.remove(actorsNames.get(actorName));
        Models.removeFromRender(actorsNames.get(actorName));
        actorsNames.remove(actorName);
    }
    /*
    Get actor
    */
    public static Actor getActor(String actorName)
    {
        return actors.get(actorsNames.get(actorName));
    }
}
