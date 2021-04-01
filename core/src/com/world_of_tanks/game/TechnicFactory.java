package com.world_of_tanks.game;

public interface TechnicFactory {
    public abstract Tanks create_tank_version1(WeaponInitializer weapon_initializer);
}

class TanksFactory implements TechnicFactory {
    @Override
    public Tanks create_tank_version1(WeaponInitializer weaponInitializer) {
        return new TankVersion1(weaponInitializer);
    }
}
