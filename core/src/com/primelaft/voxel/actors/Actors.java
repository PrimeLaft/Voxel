package com.primelaft.voxel.actors;

import java.util.ArrayList;
import java.util.List;

public class Actors {
    public static List<Actor> actors = new ArrayList<Actor>();

    public static void addToRegistry(Actor actor)
    {
        actors.add(actor);
    }
}
