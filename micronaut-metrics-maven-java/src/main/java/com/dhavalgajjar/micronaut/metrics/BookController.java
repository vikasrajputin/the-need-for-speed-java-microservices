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
package com.dhavalgajjar.micronaut.metrics;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.annotation.Counted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Controller("/books")
@ExecuteOn(TaskExecutors.BLOCKING)
class BookController {

    private final Logger log = LoggerFactory.getLogger(getClass().getName());

    private final BookRepository bookRepository;

    BookController(BookRepository bookRepository) { // <3>
        this.bookRepository = bookRepository;
    }

    @Get
    @Timed("books.index")
    Iterable<Book> index() {
        log.info("Indexing books");
        return bookRepository.findAll();
    }

    @Get("/{isbn}")
    @Counted("books.find")
    Optional<Book> findBook(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
}