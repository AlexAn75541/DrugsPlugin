package me.theminddroid.drugs.models;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Drug
{
    Narcan(
            Material.MILK_BUCKET,
            "narcan",
            new DrugType.Narcan(),
            new DrugRecipe.VerticalShaped(Material.ENDER_EYE, Material.DIAMOND, Material.BUCKET)),
    Cocaine(
            Material.SUGAR,
            "speed",
            new DrugType.PsychoActive(Sound.ENTITY_PLAYER_BURP,
                    List.of(new DrugEffect(PotionEffectType.SPEED, "gained a speed buff")),
                    List.of(new DrugEffect(PotionEffectType.SLOWNESS, "gained a speed reduction"))),
            new DrugRecipe.VerticalShaped(Material.SUGAR, Material.COCOA_BEANS, Material.PAPER)),
    Heroin(
            Material.WHITE_DYE,
            "regeneration",
            new DrugType.PsychoActive(Sound.ENTITY_PLAYER_BURP,
                    List.of(new DrugEffect(PotionEffectType.REGENERATION, "gained a regeneration buff")),
                    List.of(new DrugEffect(PotionEffectType.WEAKNESS, "have become weak"))),
            new DrugRecipe.VerticalShaped(Material.SUGAR, Material.WHEAT_SEEDS, Material.PAPER)),
    Adderall(
            Material.GOLD_NUGGET,
            "haste",
            new DrugType.PsychoActive(Sound.ENTITY_PLAYER_BURP,
                    List.of(new DrugEffect(PotionEffectType.HASTE, "gained a digging speed buff")),
                    List.of(new DrugEffect(PotionEffectType.MINING_FATIGUE, "gained a digging speed reduction"))),
            new DrugRecipe.VerticalShaped(Material.SUGAR, Material.HONEYCOMB, Material.PAPER)),
    Steroids(
            Material.PRISMARINE_CRYSTALS,
            "strength",
            new DrugType.PsychoActive(Sound.ENTITY_PLAYER_BURP,
                    List.of(new DrugEffect(PotionEffectType.STRENGTH, "gained a strength buff")),
                    List.of(new DrugEffect(PotionEffectType.WEAKNESS, "are weakened"))),
            new DrugRecipe.VerticalShaped(Material.SUGAR, Material.BONE_MEAL, Material.PAPER)),
    Hennessy(
            Material.HONEY_BOTTLE,
            "luck",
            new DrugType.PsychoActive(Sound.ENTITY_GENERIC_DRINK,
                    List.of(new DrugEffect(PotionEffectType.LUCK, "gained luck")),
                    List.of(new DrugEffect(PotionEffectType.UNLUCK, "are unlucky"))),
            new DrugRecipe.VerticalShaped(Material.WHEAT, Material.SWEET_BERRIES, Material.GLASS_BOTTLE)),
    Ketamine(
            Material.LIGHT_GRAY_DYE,
            "jump boost",
            new DrugType.PsychoActive(Sound.ENTITY_PLAYER_BURP,
                    List.of(new DrugEffect(PotionEffectType.JUMP_BOOST, "gained a jump boost")),
                    List.of(new DrugEffect(PotionEffectType.SLOWNESS, "gained a speed reduction"))),
            new DrugRecipe.VerticalShaped(Material.QUARTZ, Material.GUNPOWDER, Material.PAPER)),
    Marijuana(
            Material.GREEN_DYE,
            "resistance",
            new DrugType.PsychoActive(Sound.ENTITY_PLAYER_BURP,
                    List.of(new DrugEffect(PotionEffectType.RESISTANCE, "gained damage resistance")),
                    List.of(new DrugEffect(PotionEffectType.WEAKNESS, "have become weak"))),
            new DrugRecipe.VerticalShaped(Material.GREEN_DYE, Material.WHEAT, Material.PAPER)),
    LSD(
            Material.PAPER,
            "night vision",
            new DrugType.PsychoActive(Sound.ENTITY_PLAYER_BURP,
                    List.of(new DrugEffect(PotionEffectType.NIGHT_VISION, "gained night vision")),
                    List.of(new DrugEffect(PotionEffectType.BLINDNESS, "have become blind"))),
            new DrugRecipe.VerticalShaped(Material.SPIDER_EYE, Material.BLACK_DYE, Material.PAPER)),
    Ecstasy(
            Material.PHANTOM_MEMBRANE,
            "levitation",
            new DrugType.PsychoActive(Sound.ENTITY_PLAYER_BURP,
                    List.of(new DrugEffect(PotionEffectType.LEVITATION, "gained levitation")),
                    List.of(new DrugEffect(PotionEffectType.SLOW_FALLING, "gained slow falling"))),
            new DrugRecipe.VerticalShaped(Material.CHORUS_FRUIT, Material.PRISMARINE_CRYSTALS, Material.PAPER)),
    Ayahuasca(
            Material.BEETROOT_SOUP,
            "invisibility",
            new DrugType.PsychoActive(Sound.ENTITY_GENERIC_DRINK,
                    List.of(new DrugEffect(PotionEffectType.INVISIBILITY, "gained invisibility")),
                    List.of(new DrugEffect(PotionEffectType.GLOWING, "gained glowing"))),
            new DrugRecipe.VerticalShaped(Material.BEETROOT, Material.VINE, Material.BOWL)),
    Shrooms(
            Material.RED_MUSHROOM,
            "health boost",
                    new DrugType.PsychoActive(Sound.ENTITY_PLAYER_BURP,
                    List.of(new DrugEffect(PotionEffectType.HEALTH_BOOST, "gained health boost")),
                    List.of(new DrugEffect(PotionEffectType.POISON, "gained poison")))
            ),
    Methamphetamine(
            Material.SUGAR,
            "Blue Sky type shit",
            new DrugType.PsychoActive(Sound.ENTITY_PLAYER_BURP,
                    List.of(
                            new DrugEffect(PotionEffectType.LEVITATION, "gained a Blue Sky effect"),
                            new DrugEffect(PotionEffectType.NAUSEA, "gained a nausea effect")
                    ),
                    List.of(
                            new DrugEffect(PotionEffectType.BLINDNESS, "have become blind"),
                            new DrugEffect(PotionEffectType.SLOWNESS, "gained a speed reduction")
                    )
            ),
            new DrugRecipe.VerticalShaped(Material.SUGAR, Material.REDSTONE, Material.GLASS_BOTTLE)
            );

    private static final Map<String, Drug> byDisplayName = new HashMap<>();
    private static final Map<String, Drug> byLowerCaseName = new HashMap<>();

    static {
        for (Drug value : values())
        {
            byDisplayName.put(value.getDisplayName(), value);
            byLowerCaseName.put(value.name().toLowerCase(), value);
        }
    }

    private final Material material;
    private final String effectName;
    private final DrugType drugType;
    private final DrugRecipe recipe;

    Drug(Material material, String effectName, DrugType drugType, DrugRecipe recipe)
    {
        this.effectName = effectName;
        this.drugType = drugType;
        this.recipe = recipe;
        this.material = material;
    }

    public String getDrugName() {
        return this.name();
    }

    public Material getMaterial() {
        return material;
    }

    public String getDisplayName() {
        return ChatColor.RED + name();
    }

    public String getEffectName() {
        return effectName;
    }

    public DrugType getDrugType() {
        return drugType;
    }

    public DrugRecipe getRecipe() {
        return recipe;
    }

    public static Drug getByDisplayName(String name) {
        return byDisplayName.get(name);
    }

    public static Drug getByNameCaseInsensitive(String name) {
        return byLowerCaseName.get(name.toLowerCase());
    }
}