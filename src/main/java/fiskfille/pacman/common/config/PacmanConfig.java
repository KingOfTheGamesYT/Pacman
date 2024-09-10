package fiskfille.pacman.common.config;

import net.minecraftforge.common.config.*;

public class PacmanConfig
{
    public static int pacmanHealth;
    public static int pacmanDefense;
    public static float pacmanAttackDamage;
    public static float pacmanEatDamage;
    public static int pacmanExperience;
    public static float pacmanViewDistance;
    public static int pacmanAppetite;
    public static float pacmanHibernationTime;
    
    public static void load(final Configuration config) {
        PacmanConfig.pacmanHealth = config.getInt("Health", "Pacman", 750, 0, Integer.MAX_VALUE, "How much health this mob has");
        PacmanConfig.pacmanDefense = config.getInt("Defense", "Pacman", 20, 0, Integer.MAX_VALUE, "How much defense this mob has");
        PacmanConfig.pacmanAttackDamage = config.getFloat("Attack Damage", "Pacman", 10.0f, 0.0f, Float.MAX_VALUE, "How much damage this mob will deal when attacking");
        PacmanConfig.pacmanEatDamage = config.getFloat("Eat Damage", "Pacman", 8.0f, 0.0f, Float.MAX_VALUE, "How much damage this mob will deal when eating");
        PacmanConfig.pacmanHealth = config.getInt("Experience", "Pacman", 100, 0, Integer.MAX_VALUE, "How much XP this mob will drop when killed");
        PacmanConfig.pacmanViewDistance = config.getFloat("View Distance", "Pacman", 40.0f, 0.0f, Float.MAX_VALUE, "From how far this mob will see you");
        PacmanConfig.pacmanAppetite = config.getInt("Appetite", "Pacman", 250, 0, Integer.MAX_VALUE, "How many blocks this mob has to eat before going into hibernation");
        PacmanConfig.pacmanHibernationTime = config.getFloat("Hibernation Time", "Pacman", 5.0f, 0.0f, Float.MAX_VALUE, "The amount of time (in seconds) this mob will remain hibernating after its appetite has been sated");
    }
}
