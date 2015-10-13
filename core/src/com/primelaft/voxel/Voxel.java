package com.primelaft.voxel;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.primelaft.voxel.player.Player;
import com.primelaft.voxel.world.Models;

public class Voxel implements ApplicationListener {
	public static ModelBatch modelBatch;
	Player player = new Player();
	Environment environment = new Environment();
	Model test;
	ModelInstance test2;
	Models models = new Models();

	@Override
	public void create()
	{
		modelBatch = new ModelBatch();

		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
		player.initializePlayer();

		ModelBuilder modelBuilder = new ModelBuilder();

		FileHandle imageFileHandle = Gdx.files.internal("badlogic.jpg");
		test = modelBuilder.createBox(10f, 1f, 10f, new Material(),
				VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal | VertexAttributes.Usage.TextureCoordinates);
		test2 = new ModelInstance(test);
		test2.materials.first().set(TextureAttribute.createDiffuse(new Texture(imageFileHandle)));
		test2.transform.setToTranslation(0, 0, 0);


		models.loadModel("bearobj.obj", 1);
		models.loadModel("bearobj.obj", 2);
	}

	@Override
	public void render()
	{
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		player.updateCamera();
		modelBatch.render(test2, environment);

		if (models.assets.isLoaded("bearobj.obj") && models.assets.update())
			models.render("bearobj.obj", 1).transform.setToTranslation(0, 0, 0);
			models.render("bearobj.obj", 2).transform.setToTranslation(0, 0, 0);

			models.getInstance(1).transform.setToTranslation(0, 0, 0);
			models.getInstance(2).transform.setToTranslation(0, 5, 0);

		System.out.println(Gdx.graphics.getFramesPerSecond());

		modelBatch.render(models.instances, environment);
		modelBatch.end();
	}

	@Override
	public void dispose()
	{
		modelBatch.dispose();
		models.instances.clear();
		models.assets.dispose();
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
