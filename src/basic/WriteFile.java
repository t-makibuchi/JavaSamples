package basic;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class WriteFile {
	static final Charset utf8 = Charset.forName("UTF-8");
	public static void main ( String[] args ) {
		List<String> lineList = new ArrayList<String>();
		lineList.add("line1");
		lineList.add("line2");
		lineList.add("line3");

		try{
			Path path = Paths.get("C:\\Users\\admin\\Desktop\\output.txt");
			Files.write(path, lineList, utf8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			System.out.println("end");
		} catch (IOException e) {

		}
	}
}
