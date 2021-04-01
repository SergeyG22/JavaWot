package com.world_of_tanks.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;


public class Main extends ApplicationAdapter {
    SpriteBatch batch;
    private float delta_time;
    private LinkedList<Tanks> techniks = new LinkedList<>();
    private TechnicFactory tanks_factory = new TanksFactory();
    //	private WeaponInitializer weapon_a = new GunTypeA_Initializer();
    private WeaponInitializer weapon_b = new GunTypeB_Initializer();


    @Override
    public void create() {
        batch = new SpriteBatch();
        techniks.add(tanks_factory.create_tank_version1(weapon_b));
        System.out.println(Gdx.graphics.getWidth());
        System.out.println(Gdx.graphics.getHeight());
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        delta_time = Gdx.graphics.getDeltaTime();

        batch.begin();

        for (Tanks t : techniks) {
            t.getSprite().draw(batch);
            t.move_automatically(delta_time);
            for (Weapon w : t.getWeapon()) {
                w.bullet_movements(delta_time);
                w.getSprite().draw(batch);
            }
        }


        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            for (Tanks t : techniks) {
                t.shot();
            }
        }


        for (Iterator<Tanks> it = techniks.iterator(); it.hasNext(); ) {
            for (Iterator<Weapon> iter = it.next().getWeapon().iterator(); iter.hasNext(); ) {

                Weapon weapon = iter.next();
                Vector2 position = weapon.getPosition_sprite();

                if (position.x <= 0 || position.x >= 1280 || position.y <= 0 || position.y >= 1024) {
                    iter.remove();
                }

            }
        }


        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}


