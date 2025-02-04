package io.jenkins.plugins.extensionlisttest;

import java.io.IOException;
import java.util.logging.Logger;

import hudson.Extension;
import hudson.model.AperiodicWork;
import hudson.model.AsyncAperiodicWork;
import hudson.model.TaskListener;

@Extension
public class CustomAsyncWorker extends AsyncAperiodicWork {

    private static final Logger LOGGER = Logger.getLogger(CustomAsyncWorker.class.getName());

    public CustomAsyncWorker() {
        super("custom-async-worker");
        LOGGER.info("CustomAsyncWorker created");
    }

    @Override
    protected void execute(TaskListener listener) throws IOException, InterruptedException {
        LOGGER.info(() -> "CustomAsyncWorker started");
    }

    @Override
    public long getRecurrencePeriod() {
        LOGGER.info(() -> "CustomAsyncWorker recurring period");
        CustomSimpleExtension.get();
        return 120;
    }

    @Override
    public AperiodicWork getNewInstance() {
        LOGGER.info(() -> "CustomAsyncWorker new instance");
        return new CustomAsyncWorker();
    }
}
