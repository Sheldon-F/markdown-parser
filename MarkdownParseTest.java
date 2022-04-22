import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void mdtest() throws IOException{
        //Path fileName = Path.of("test-file.md");
        String fileName = "C:\\Users\\sheld\\OneDrive\\Documents\\GitHub\\mdpTEST\\markdown-parser\\test-file.md";
        String content = Files.readString(Path.of(fileName));
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://something.com","some-thing.html"), links);
    }

    /**
     * test when md has an image
     * @throws IOException
     */
    @Test
    public void mdtest2() throws IOException{
        String fileName = "test-file2.md";
        String content = Files.readString(Path.of(fileName));
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://something.com","some-thing.html"), links);
    }

    /**
     * tests md with empty last line
     * @throws IOException
     */
    @Test
    public void mdtest3() throws IOException{
        String fileName = "test-file3.md";
        String content = Files.readString(Path.of(fileName));
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://something.com","some-thing.html","clickMe.com"), links);
    }


}
