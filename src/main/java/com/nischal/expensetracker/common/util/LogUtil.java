package com.nischal.expensetracker.common.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author : Nischal on 7/23/2024
 */

@Slf4j
public class LogUtil {

    public static void exception(String message) {
        log.error("Exception :: {}", message);
    }
}
