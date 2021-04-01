package com.world_of_tanks.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import java.lang.Math;
import java.util.LinkedList;


public interface Tanks {
    abstract public void shot();
    abstract public Sprite getSprite();
    abstract public void move_automatically(float delta_time);
    abstract public LinkedList<Weapon> getWeapon();
}

class TankVersion1 implements Tanks {
    final double PI = 3.14159265;
    private Sprite sprite;
    private boolean moving_forward = true;
    private int multiplier_dictance = 5;
    private double angle = 0;
    private double speed_rotate = 50;
    private double current_angle = 0;
    private double distance_to_point = 0;
    private double generate_position_x;
    private double generate_position_y;
    private double current_position_x = 500;
    private double current_position_y = 500;
    private double speed_movement = 50;
    private double radius_of_shot = 1000;
    public LinkedList<Weapon> weapon;
    WeaponInitializer weapon_initializer;


    TankVersion1(WeaponInitializer wi) {
        weapon_initializer = wi;
        sprite = new Sprite(new Texture(Gdx.files.internal("technic/tank_v1.png")));
        sprite.setOrigin(sprite.getTexture().getWidth() / 2, sprite.getTexture().getHeight() / 2);
        sprite.setPosition((float) current_position_x, (float) current_position_y);
        generate_position_x = 150.0 + (float) (Math.random() * 1130);
        generate_position_y = 150.0 + (float) (Math.random() * 874);
        sprite.setRotation((float) get_angle());
        angle = get_angle();
        weapon = new LinkedList<>();
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    double get_angle() {
        double delta_x = current_position_x - generate_position_x;
        double delta_y = current_position_y - generate_position_y;
        double angle = (Math.atan2(delta_y, delta_x)) * 180 / PI;
        return angle;
    }

    @Override
    public void move_automatically(float delta_time) {

        if (moving_forward) {
            distance_to_point = Math.sqrt((generate_position_x - current_position_x) * (generate_position_x - current_position_x) + (generate_position_y - current_position_y) * (generate_position_y - current_position_y));
            if (distance_to_point > 1) {
                sprite.setPosition((float) current_position_x, (float) current_position_y);
                current_position_x += speed_movement * delta_time * (generate_position_x - current_position_x) / distance_to_point;
                current_position_y += speed_movement * delta_time * (generate_position_y - current_position_y) / distance_to_point;
            } else {
                generate_position_x = 150.0 + (float) (Math.random() * 1130);
                generate_position_y = 150.0 + (float) (Math.random() * 874);
                current_angle = get_angle();
                moving_forward = false;
            }
        } else {
            if (!moving_forward) {
                rotation(delta_time);
            }
        }
    }

    @Override
    public LinkedList<Weapon> getWeapon() {
        return weapon_initializer.get_weapon();
    }

    public void rotation(float delta_time) {
        if (angle < current_angle) {
            angle += speed_rotate * delta_time;
            sprite.setRotation((float) angle);
            if (angle > current_angle) {
                moving_forward = true;
            }
        } else if (angle > current_angle) {
            angle -= speed_rotate * delta_time;
            sprite.setRotation((float) angle);
            if (angle < current_angle) {
                moving_forward = true;
            }
        }
    }

    @Override
    public void shot() {
        Vector2 final_coordinates_bullet = new Vector2();
        Vector2 current_position_techniks = new Vector2();
        current_position_techniks.x = sprite.getOriginX()+(float) current_position_x+10;  //10 half-width bullet
        current_position_techniks.y = sprite.getOriginY()+(float) current_position_y+10;  //10 half-height bullet
        double x = (radius_of_shot / 2 * multiplier_dictance) * -Math.cos(sprite.getRotation() * PI / 180);
        double y = (radius_of_shot / 2 * multiplier_dictance) * -Math.sin(sprite.getRotation() * PI / 180);
        final_coordinates_bullet.x = (float) x + (float) current_position_x;
        final_coordinates_bullet.y = (float) y + (float) current_position_y;
        weapon_initializer.add_weapon(final_coordinates_bullet,current_position_techniks);
    }

}











