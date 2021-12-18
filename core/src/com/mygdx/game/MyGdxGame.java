package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {

	private Texture dibujo;
	private SpriteBatch batch;
	private TextureRegion region;
	private Sprite midibujo;
	@Override
	public void create () {
		dibujo= new Texture("dibujo.png");
		batch= new SpriteBatch();
		//region = new TextureRegion(dibujo,0,0);
		midibujo= new Sprite(dibujo,0,0,73,80);
		midibujo.setPosition(0,0);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		midibujo.draw(batch);
		teclado();
		batch.end();


	}
	private  void teclado(){
		boolean arriba = Gdx.input.isKeyJustPressed(Input.Keys.UP);
		boolean abajo= Gdx.input.isKeyJustPressed(Input.Keys.DOWN);
		boolean der= Gdx.input.isKeyJustPressed(Input.Keys.RIGHT);
		boolean izq= Gdx.input.isKeyJustPressed(Input.Keys.LEFT);
		float x= midibujo.getX(),y=midibujo.getY();
		if(arriba && !abajo)
			y=y+5;
		else if (abajo && ! arriba)
			y=y-5;
		if (der&& ! izq)
			x=x+5;
		else if(izq && !der)
			x=x-5;
		midibujo.setPosition(x,y);
	}

	@Override
	public void dispose () {

		batch.dispose();


	}
}
