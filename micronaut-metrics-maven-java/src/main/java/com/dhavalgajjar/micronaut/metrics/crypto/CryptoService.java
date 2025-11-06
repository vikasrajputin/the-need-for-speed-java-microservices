/*
 * Copyright 2017-2024 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dhavalgajjar.micronaut.metrics.crypto;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

@Singleton
public class CryptoService {

    private final Logger log = LoggerFactory.getLogger(getClass().getName());

    private final PriceClient priceClient;
    private final Counter checks;
    private final Timer time;
    private final AtomicInteger latestPriceUsd = new AtomicInteger(0);

    CryptoService(PriceClient priceClient,
                  MeterRegistry meterRegistry) {
        this.priceClient = priceClient;

        checks = meterRegistry.counter("bitcoin.price.checks");
        time = meterRegistry.timer("bitcoin.price.time");
        meterRegistry.gauge("bitcoin.price.latest", latestPriceUsd);
    }

    @Scheduled(fixedRate = "${crypto.update-frequency:1h}",
            initialDelay = "${crypto.initial-delay:0s}")
    public void updatePrice() {
        time.record(() -> {
            try {
                checks.increment();
                latestPriceUsd.set((int) priceClient.latestInUSD().getPrice());
            } catch (Exception e) {
                log.error("Problem checking price", e);
            }
        });
    }
}