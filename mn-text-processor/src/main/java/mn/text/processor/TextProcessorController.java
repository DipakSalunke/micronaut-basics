package mn.text.processor;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller("/text")
public class TextProcessorController {

    @Get
    public String get() {
        return "OK";
    }

    @Post
    public String processText(@Body String body) {
        List<String> words = Arrays.asList(body.split(","));

        return IntStream.range(0, words.size())
                .filter(n -> n % 2 == 0)
                .mapToObj(words::get)
                .collect(Collectors.joining(","));
    }

}
