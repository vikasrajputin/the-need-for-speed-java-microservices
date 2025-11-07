/*
 * Copyright 2017-2025 original authors
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

import io.micronaut.context.annotation.Requires;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

@Singleton
@Requires(property = "crypto.mock.enabled", value = "true")
public class MockPriceClient implements PriceClient {

    private static final Logger log = LoggerFactory.getLogger(MockPriceClient.class);
    private final Random random = new Random();
    private float currentPrice = 45000.0f;

    @Override
    public BitcoinPrice latest(String symbol) {
        log.info("Generating mock price for symbol: {}", symbol);
        
        float priceChange = (random.nextFloat() - 0.5f) * 2000.0f;
        currentPrice = Math.max(20000.0f, Math.min(80000.0f, currentPrice + priceChange));
        
        log.info("Generated mock Bitcoin price: ${}", currentPrice);
        
        return new BitcoinPrice(new BitcoinPrice.Data(currentPrice));
    }

    @Override
    public BitcoinPrice latestInUSD() {
        return latest("BTC-USDT");
    }
}