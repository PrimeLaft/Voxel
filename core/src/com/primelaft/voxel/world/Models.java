package com.primelaft.voxel.world;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;
import java.util.List;

public class Models {
    public static AssetManager assets;
    public static List<ModelInstance> instances = new ArrayList<ModelInstance>();
    public static List<Integer> instancesId = new ArrayList<Integer>();

    public static void loadModel(String modelName)
    {
        assets = new AssetManager();
        assets.load(modelName, Model.class);
        assets.finishLoading();
    }
    public static ModelInstance addToRender(String modelName, Integer id) {
        Model model = assets.get(modelName, Model.class);
        ModelInstance modelInstance = new ModelInstance(model);

        id = id - 1;

        try {
            instancesId.get(id);
            instances.get(id);
        } catch ( IndexOutOfBoundsException e ) {
            instancesId.add(id);
            instances.add(modelInstance);
        }

        return modelInstance;
    }
    public static void removeFromRender(Integer id)
    {
        id = id - 1;
        try {
            instances.remove((int) id);
            instancesId.remove((int) id);
            System.out.println("ok");
        } catch ( IndexOutOfBoundsException e ) {
            System.out.println("error");
        }
        Models.getInstance(3).transform.scale(2.5f, 2.5f, 2.5f);
    }
    public static ModelInstance getInstance(Integer id)
    {
        Integer instanceId = 0;
        for (int i = 0; i < instancesId.size(); i++)
        {
            if (instancesId.get(i) == id) {
                instanceId = i;
            }
        }
        return instances.get(instanceId);
    }
}


