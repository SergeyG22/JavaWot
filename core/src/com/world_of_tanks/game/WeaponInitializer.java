package com.world_of_tanks.game;

import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;

public interface WeaponInitializer {
    abstract void add_weapon(Vector2 final_coordinates_bullet, Vector2 current_position_techniks);
    abstract LinkedList<Weapon>get_weapon();
}


class GunTypeA_Initializer implements WeaponInitializer {
    private LinkedList<Weapon> weapon;

    GunTypeA_Initializer(){
        weapon = new LinkedList<>();
    }
    @Override
    public void add_weapon(Vector2 final_coordinates_bullet, Vector2 current_position_techniks) {
        weapon.add(new GunTypeA(final_coordinates_bullet, current_position_techniks));
    }
    @Override
    public LinkedList<Weapon>get_weapon(){
        return weapon;
    }
}

class GunTypeB_Initializer implements WeaponInitializer {

    private LinkedList<Weapon>weapon;

    GunTypeB_Initializer(){
        weapon = new LinkedList<>();
    }
    @Override
    public void add_weapon(Vector2 final_coordinates_bullet, Vector2 current_position_techniks) {
        weapon.add(new GunTypeB(final_coordinates_bullet, current_position_techniks));
        System.out.println(weapon.size());
    }

    @Override
    public LinkedList<Weapon> get_weapon() {
        return weapon;
    }
}