package com.example.testsearch;

import com.example.testsearch.customAnnotation.LogExecutionTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class BooksApiController {

    private final BooksApiService booksApiService;

    @ResponseBody
    @LogExecutionTime
    @GetMapping("/search")
    public void getItems(@RequestParam String isbn) throws IOException, ParserConfigurationException, SAXException {
        booksApiService.getItems(isbn);
    }
}
