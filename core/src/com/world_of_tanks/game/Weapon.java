package com.world_of_tanks.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import java.awt.*;


public interface Weapon {

    public abstract Sprite getSprite();

    public abstract void bullet_movements(float delta_time);

    public abstract Vector2 getPosition_sprite();

    public abstract Vector2 getFinalCoordinates_bullet();

    public  abstract Vector2 getCurrent_position();
}

class GunTypeA implements Weapon {
    public Sprite sprite;
    float power_damage = 50;
    double speed_movement = 450;
    double distance_to_point = 0;
    private Vector2 current_position;
    private Vector2 final_coordinates_bullet;

    GunTypeA(Vector2 final_coordinates_bullet_, Vector2 current_position_techniks) {
        final_coordinates_bullet = final_coordinates_bullet_;
        current_position = current_position_techniks;
        sprite = new Sprite(new Texture(Gdx.files.internal("weapon/weapon_a.png")));
        current_position.x -= sprite.getTexture().getWidth() / 2;
        current_position.y -= sprite.getTexture().getHeight() / 2;
        sprite.setPosition(current_position.x, current_position.y);
    }


    @Override
    public void bullet_movements(float delta_time) {
        distance_to_point = Math.sqrt((final_coordinates_bullet.x - current_position.x) * (final_coordinates_bullet.x - current_position.x) + (final_coordinates_bullet.y - current_position.y) * (final_coordinates_bullet.y - current_position.y));
        if (distance_to_point > 1) {
            current_position.x += speed_movement * delta_time * (final_coordinates_bullet.x - current_position.x) / distance_to_point;
            current_position.y += speed_movement * delta_time * (final_coordinates_bullet.y - current_position.y) / distance_to_point;
            sprite.setPosition(current_position.x - sprite.getTexture().getWidth() / 2, current_position.y - sprite.getTexture().getHeight() / 2);
        }
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public Vector2 getPosition_sprite() {
        Vector2 position_sprite = new Vector2();
        position_sprite.x = sprite.getX();
        position_sprite.y = sprite.getY();
        return position_sprite;
    }
    @Override
    public Vector2 getCurrent_position() {
        return current_position;
    }

    @Override
    public Vector2 getFinalCoordinates_bullet() {
        return final_coordinates_bullet;
    }
}

class GunTypeB implements Weapon {
    public Sprite sprite;
    float power_damage = 50;
    double speed_movement = 450;
    double distance_to_point = 0;
    private Vector2 current_position;
    private Vector2 final_coordinates_bullet;

    GunTypeB(Vector2 final_coordinates_bullet_, Vector2 current_position_techniks) {
        final_coordinates_bullet = final_coordinates_bullet_;
        current_position = current_position_techniks;
        sprite = new Sprite(new Texture(Gdx.files.internal("weapon/weapon_b.png")));
        current_position.x -= sprite.getTexture().getWidth() / 2;
        current_position.y -= sprite.getTexture().getHeight() / 2;
        sprite.setPosition(current_position.x, current_position.y);
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public void bullet_movements(float delta_time) {
        distance_to_point = Math.sqrt((final_coordinates_bullet.x - current_position.x) * (final_coordinates_bullet.x - current_position.x) + (final_coordinates_bullet.y - current_position.y) * (final_coordinates_bullet.y - current_position.y));
        if (distance_to_point > 1) {
            current_position.x += speed_movement * delta_time * (final_coordinates_bullet.x - current_position.x) / distance_to_point;
            current_position.y += speed_movement * delta_time * (final_coordinates_bullet.y - current_position.y) / distance_to_point;
            sprite.setPosition(current_position.x - sprite.getTexture().getWidth() / 2, current_position.y - sprite.getTexture().getHeight() / 2);
        }
    }

    @Override
    public Vector2 getPosition_sprite() {
        Vector2 position_sprite = new Vector2();
        position_sprite.x = sprite.getX();
        position_sprite.y = sprite.getY();
        return position_sprite;
    }

    @Override
    public Vector2 getCurrent_position() {
        return current_position;
    }
    @Override
    public Vector2 getFinalCoordinates_bullet() {
        return final_coordinates_bullet;
    }
}