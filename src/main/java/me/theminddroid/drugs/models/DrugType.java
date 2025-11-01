package me.theminddroid.drugs.models;

import org.bukkit.Sound;
import java.util.List;

public abstract class DrugType
{
    public static class PsychoActive extends DrugType
    {
        private final Sound consumeSound;
        private final List<DrugEffect> effects;
        private final List<DrugEffect> withdrawalEffects;

        public PsychoActive(Sound consumeSound, List<DrugEffect> effects, List<DrugEffect> withdrawalEffects)
        {
            this.consumeSound = consumeSound;
            this.effects = effects;
            this.withdrawalEffects = withdrawalEffects;
        }

        public Sound getConsumeSound()
        {
            return consumeSound;
        }

        public List<DrugEffect> getEffects()
        {
            return effects;
        }

        public List<DrugEffect> getWithdrawalEffects()
        {
            return withdrawalEffects;
        }
    }

    public static class Narcan extends DrugType
    {

    }
}
