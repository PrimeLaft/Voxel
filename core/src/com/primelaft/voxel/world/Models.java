package com.primelaft.voxel.world;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.utils.Array;

public class Models {
    public AssetManager assets;
    public Array<ModelInstance> instances = new Array<ModelInstance>();
    public Array<Integer> instancesId = new Array<Integer>();

    public void loadModel(String modelName, Integer id)
    {
        assets = new AssetManager();
        assets.load(modelName, Model.class);
        assets.finishLoading();
    }
    public ModelInstance render(String modelName, Integer id) {
        Model model = assets.get(modelName, Model.class);
        ModelInstance modelInstance = new ModelInstance(model);

        try {
            instancesId.get(id);
            instances.get(id);
        } catch ( IndexOutOfBoundsException e ) {
            instancesId.add(id);
            instances.add(modelInstance);
        }

        return modelInstance;
    }
    public ModelInstance getInstance(Integer id)
    {
        Integer instanceId = 0;
        for (int i = 0; i < instancesId.size; i++) {
            if (instancesId.get(i) == id) {
                instanceId = i;
            }
        }
        return instances.get(instanceId);
    }
}


