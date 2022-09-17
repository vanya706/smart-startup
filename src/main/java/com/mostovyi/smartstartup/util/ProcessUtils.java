package com.mostovyi.smartstartup.util;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class ProcessUtils {

    @SneakyThrows
    public static void destroyByFileName(String fileName) {
        Runtime runtime = Runtime.getRuntime();
        Process p = runtime.exec("tasklist.exe /fo csv /nh /fi \"imagename eq " + fileName + "\"");
        p.inputReader()
                .lines()
                .filter(StringUtils::isNotBlank)
                .findFirst()
                .ifPresent(processInfoString -> {
                    String[] infos = processInfoString.split(",");
                    if (infos.length < 5) {
                        log.warn("Got unexpected string from input: {}", processInfoString);
                        return;
                    }
                    String processId = StringUtils.substringBetween(infos[1], "\"");
                    destroy(Long.parseLong(processId));
                });
    }

    private static void destroy(long processId) {
        ProcessHandle.of(processId).ifPresent(processHandle -> {
            log.info("process destroyed: {} pid", processHandle.pid());
            processHandle.destroy();
        });
    }

    @SneakyThrows
    public static void runByPath(String path) {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec(path);
    }

}
