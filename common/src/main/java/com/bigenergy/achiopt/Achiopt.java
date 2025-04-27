package com.bigenergy.achiopt;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

public final class Achiopt {
    public static final String MOD_ID = "achiopt";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static void init() {
        LOGGER.info("Enabling Achievement Optimizer");
    }
}
