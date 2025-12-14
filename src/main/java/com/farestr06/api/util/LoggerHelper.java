package com.farestr06.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class LoggerHelper {
    public static final Map<String, Logger> LOGGERS = new HashMap<>();

    /**
     * Gets or creates a Logger with the specified mod ID
     * @param modId The mod ID of the logger
     * @return A Logger for the specified ID
     */
    public static Logger get(String modId) {
        if (!LOGGERS.containsKey(modId)) {
            LOGGERS.put(modId, LoggerFactory.getLogger(modId));
        }
        return LOGGERS.get(modId);
    }
}
