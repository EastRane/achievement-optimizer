package com.bigenergy.achiopt.fabric;

import com.bigenergy.achiopt.Achiopt;
import net.fabricmc.api.ModInitializer;

public final class AchioptFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        new Achiopt();
        Achiopt.init();
    }
}
