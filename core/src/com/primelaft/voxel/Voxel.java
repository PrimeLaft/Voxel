package com.primelaft.voxel;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.primelaft.voxel.actors.Actor;
import com.primelaft.voxel.actors.Actors;
import com.primelaft.voxel.player.Player;
import com.primelaft.voxel.world.Models;
import com.primelaft.voxel.world.World;

import java.awt.*;

public class Voxel implements ApplicationListener {
	public static ModelBatch modelBatch;
	public Player player = new Player();
	public static Environment environment = new Environment();
	Model test;
	ModelInstance test2;
	public World world = new World();


	SpriteBatch batch;
	BitmapFont font12;

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


		Actor actor1 = new Actor();
		actor1.createNewActor("bearobj.obj", 100, new Vector3(10, 5f, 0f));
		Actor actor2 = new Actor();
		actor2.createNewActor("bearobj.obj", 100, new Vector3(20, 0f, 0f));
		Actor actor3 = new Actor();
		actor3.createNewActor("bearobj.obj", 100, new Vector3(30, 0f, 0f));
		Actor actor4 = new Actor();
		actor4.createNewActor("bearobj.obj", 100, new Vector3(40, 0f, 0f));
		Actor actor5 = new Actor();
		actor5.createNewActor("bearobj.obj", 100, new Vector3(50, 0f, 0f));



		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Roboto.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 12;
		parameter.color = Color.GOLD;
		parameter.borderColor = Color.DARK_GRAY;
		parameter.borderWidth = 1;
		font12 = generator.generateFont(parameter); // font size 12 pixels
		generator.dispose(); // don't forget to dispose to avoid memory leaks!

		batch = new SpriteBatch();
	}

	@Override
	public void render()
	{
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		player.updateCamera();
		modelBatch.render(test2, environment);


		batch.begin();
		font12.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 20, 20);
		batch.end();

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
