package dev.winsomeguy.cascadescoolbiomes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CascadesCoolBiomesCommon {
    public static final Logger LOG = LoggerFactory.getLogger(Constants.MOD_NAME);

    public static void init() {
        LOG.info("{} common init complete.", Constants.MOD_NAME);
    }
}
