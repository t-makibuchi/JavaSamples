package basic;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class ReadFile {
	static final Charset utf8 = Charset.forName("UTF-8");
	public static void main ( String[] args ) {
		List<String> lineList = new ArrayList<String>();
		try{
			Path path = Paths.get("C:\\Users\\admin\\Desktop\\input.txt");
			lineList = Files.readAllLines(path, utf8);
		} catch (IOException e) {

		}
		for(String line : lineList) {
			System.out.println(line);

		}
	}
}
