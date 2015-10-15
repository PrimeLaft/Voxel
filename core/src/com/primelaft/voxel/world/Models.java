package com.primelaft.voxel.world;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.utils.Array;

public class Models {
    public static AssetManager assets;
    public static Array<ModelInstance> instances = new Array<ModelInstance>();
    public static Array<Integer> instancesId = new Array<Integer>();

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
            instances.removeIndex(id);
            instancesId.removeIndex(id);
        } catch ( IndexOutOfBoundsException e ) {

        }
    }
    public static ModelInstance getInstance(Integer id)
    {
        id = id - 1;

        Integer instanceId = 0;
        for (int i = 0; i < instancesId.size; i++)
        {
            if (instancesId.get(i) == id) {
                instanceId = i;
            }
        }
        return instances.get(instanceId);
    }
}


