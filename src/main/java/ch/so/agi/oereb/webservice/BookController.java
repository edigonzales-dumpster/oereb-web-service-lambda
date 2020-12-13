package ch.so.agi.oereb.webservice;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class BookController {

    @Post
    public BookSaved save(@Valid @Body Book book) {
        BookSaved bookSaved = new BookSaved();
        bookSaved.setName(book.getName());
        bookSaved.setIsbn(UUID.randomUUID().toString());
        return bookSaved;
    }
    
    @Get("/ping")
    public String ping() {
        return "{\"pong\":true, \"graal\": true}";
    }
    
    @Get("/pong")
    public String pong() {
        return "{\"ping\":gagag, \"graal\": false}";
    }
    
    //@Get("/getegrid/{format}")
    public String getEgridByXY(String format) {
        System.out.println("format: " + format);
        return "{\"ping\":egrid, \"graal\": fubar}";
    }
    
    @Get(value = "/getegrid/{format}", produces = {MediaType.APPLICATION_XML})
    public HttpResponse<?> sample(@PathVariable("format") String format) {
        System.out.println("format:"+ format);
        
        Book book = new Book();
        book.setName("Unterm Rad");
        
        return HttpResponse.ok(book).contentType(MediaType.APPLICATION_XML_TYPE);
    }
}
