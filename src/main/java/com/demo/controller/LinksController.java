package com.demo.controller;

import com.demo.model.Link;
import com.demo.service.UrlShortener;
import io.swagger.annotations.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.demo.messaging.MessageReceiver.QUEUE;

@RestController
@Api(value = "Hello Bitly",description = "Bitly will return required urls")
public class LinksController {


    private UrlShortener urlShortener;
    private RabbitTemplate rabbitTemplate;

    public LinksController(UrlShortener urlShortener, RabbitTemplate rabbitTemplate) {
        this.urlShortener = urlShortener;
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("shorten")
    @ApiOperation(value = "This will return shorten url")
    @ApiResponses(
            value = {@ApiResponse(code = 100, message = "test message"),
                    @ApiResponse(code = 200, message = "All good")
            })
    @ResponseStatus(value = HttpStatus.CREATED)
    public Link shorten (@RequestParam("fullUrl") String fullUrl) {
        return urlShortener.shorten(fullUrl);
    }

    @GetMapping("expand")
    @ApiOperation(value = "This will return expanded url")
    @ResponseStatus(value = HttpStatus.OK)
    public Link expand (@RequestParam("shortUrl") String shortUrl) {
        rabbitTemplate.convertAndSend(QUEUE, shortUrl);
        return urlShortener.expand(shortUrl);
    }
}
