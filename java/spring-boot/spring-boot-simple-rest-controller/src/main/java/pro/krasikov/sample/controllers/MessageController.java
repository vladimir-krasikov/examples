package pro.krasikov.sample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 19.07.2014.
 */

@RestController
@RequestMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
public class MessageController {

    @Autowired
    private String message;

    @RequestMapping
    public String getMessage() {
        return message;
    }

}
