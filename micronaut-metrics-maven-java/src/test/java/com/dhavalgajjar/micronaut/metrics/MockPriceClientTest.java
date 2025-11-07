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
package com.dhavalgajjar.micronaut.metrics;

import com.dhavalgajjar.micronaut.metrics.crypto.BitcoinPrice;
import com.dhavalgajjar.micronaut.metrics.crypto.PriceClient;
import io.micronaut.context.ApplicationContext;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest(propertySources = "classpath:application-mock.properties")
class MockPriceClientTest {

    @Inject
    PriceClient priceClient;

    @Test
    void testMockClientGeneratesRandomPrices() {
        BitcoinPrice price1 = priceClient.latestInUSD();
        BitcoinPrice price2 = priceClient.latestInUSD();
        
        assertNotNull(price1);
        assertNotNull(price2);
        
        float priceValue1 = price1.getPrice();
        float priceValue2 = price2.getPrice();
        
        assertTrue(priceValue1 >= 20000.0f, "Price should be at least $20,000");
        assertTrue(priceValue1 <= 80000.0f, "Price should be at most $80,000");
        assertTrue(priceValue2 >= 20000.0f, "Price should be at least $20,000");
        assertTrue(priceValue2 <= 80000.0f, "Price should be at most $80,000");
    }
}