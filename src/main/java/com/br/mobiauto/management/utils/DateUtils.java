package com.br.mobiauto.management.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class DateUtils {

    public static final String AMERICA_SAO_PAULO = "America/Sao_Paulo";

    public static LocalDateTime now() {
        return LocalDateTime.now(ZoneId.of(AMERICA_SAO_PAULO))
                .truncatedTo(ChronoUnit.SECONDS);
    }
}
