package io.jenkins.plugins.extensionlisttest;

import java.util.logging.Logger;

import hudson.Extension;
import hudson.ExtensionList;

@Extension
public class CustomSimpleExtension {
    private static final Logger LOGGER = Logger.getLogger(CustomSimpleExtension.class.getName());

    public CustomSimpleExtension() {
        LOGGER.info(() -> "Instantiating CustomExtension");
    }

    public static CustomSimpleExtension get() {
        return ExtensionList.lookupSingleton(CustomSimpleExtension.class);
    }
}
