package com.primelaft.voxel;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.primelaft.voxel.player.Player;
import com.primelaft.voxel.world.Models;
import com.primelaft.voxel.world.World;

public class Voxel implements ApplicationListener {
	public static ModelBatch modelBatch;
	public Player player = new Player();
	public static Environment environment = new Environment();
	Model test;
	ModelInstance test2;
	public World world = new World();

	@Override
	public void create()
	{
		modelBatch = new ModelBatch();

		world.setLightOnWorld();
		player.initializePlayer();

		ModelBuilder modelBuilder = new ModelBuilder();

		FileHandle imageFileHandle = Gdx.files.internal("badlogic.jpg");
		test = modelBuilder.createBox(10f, 1f, 10f, new Material(),
				VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal | VertexAttributes.Usage.TextureCoordinates);
		test2 = new ModelInstance(test);
		test2.materials.first().set(TextureAttribute.createDiffuse(new Texture(imageFileHandle)));
		test2.transform.setToTranslation(0, 0, 0);


		Models.loadModel("bearobj.obj");
		Models.loadModel("bearobj.obj");
		Models.loadModel("bearobj.obj");
		Models.addToRender("bearobj.obj", 1);
		Models.addToRender("bearobj.obj", 2).transform.setToTranslation(20, 0, 0);
		Models.addToRender("bearobj.obj", 3).transform.setToTranslation(40, 0, 0);
	}

	@Override
	public void render()
	{
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		player.updateCamera();
		modelBatch.render(test2, environment);


		//System.out.println(Gdx.graphics.getFramesPerSecond());


		modelBatch.render(Models.instances, environment);
		modelBatch.end();
	}

	@Override
	public void dispose()
	{
		modelBatch.dispose();
		Models.instances.clear();
		Models.assets.dispose();
	}

	@Override
	public void resize(int width, int height)
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}
}
