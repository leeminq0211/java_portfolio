package portfolio;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class Login {
	boolean login(String id, String pass) {
		Path path = Paths.get("C:\\minq\\id.db");
		try {
			BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
			Iterator<String> userit = reader.lines().iterator();
			while(userit.hasNext()) {
				String[] a = userit.next().split("\t");
				if(a[0].equals(id)&&a[1].equals(pass)) {
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	boolean checkId(String id) throws IOException {
		Path path = Paths.get("C:\\minq\\id.db");
			try {
			BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
			Iterator<String> userit = reader.lines().iterator();
			while(userit.hasNext()) {
				String[] a = userit.next().split("\t");
				if(a[0].equals(id)) {
					return true;
				}
			}
		} catch (IOException e) {
			return false;
		}
		return false;
	}
}

