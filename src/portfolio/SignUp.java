package portfolio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SignUp {
	boolean signUp(Users users) {
		Path path = Paths.get("C:\\minq\\id.db");
		try {
		    BufferedWriter write = Files.newBufferedWriter(path, StandardCharsets.UTF_8,StandardOpenOption.APPEND);
			write.append(users.getId()+"\t"+users.getPass()+"\t"+users.getAge()+"\t"+users.getEmail()+"\t"+users.getAddress());
			write.newLine();
			write.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}

