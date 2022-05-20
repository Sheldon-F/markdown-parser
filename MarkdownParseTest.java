import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {

    ArrayList<String> empty = new ArrayList<>();


    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    /**
     * base test for MdParse
     * @throws IOException
     */
    @Test
    public void mdtest() throws IOException{
        //Path fileName = Path.of("test-file.md");
        String fileName = "test-file.md";
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

    @Test
    public void mdtest4() throws IOException{
        String fileName = "test-file4.md";
        String content = Files.readString(Path.of(fileName));
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(empty, links);
    }

    @Test
    public void mdtest5() throws IOException{
        String fileName = "test-file5.md";
        String content = Files.readString(Path.of(fileName));
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("page.com"), links);
    }
    
    @Test
    public void mdtest7() throws IOException{
        String fileName = "test-file7.md";
        String content = Files.readString(Path.of(fileName));
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(empty, links);
    }

    @Test
    public void mdtest8() throws IOException{
        String fileName = "test-file8.md";
        String content = Files.readString(Path.of(fileName));
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("a link on the first line"), links);
    }

    
}
