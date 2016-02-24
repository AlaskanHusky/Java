package twitter;
import java.io.*;
import java.util.*;
public class Twitter 
{
    public static void main(String[] args) throws FileNotFoundException {
        String s;
        ArrayList strs = new ArrayList();
        int number = 0;
        BufferedReader reader;
        File f;
        f = new File(args[0]);
	if (!f.canRead()) {
            throw new FileNotFoundException("Файл '" + f.getAbsolutePath() + "' - не найден!");
		}
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        try {
                while ((reader.readLine()) != null) {
                    number++;
                    if (number == Integer.parseInt(args[1])) {
			for (int i = 0; i < Integer.parseInt(args[2]); i++)
                            if ((s=reader.readLine())!=null)
                            strs.add(s);
                        }
                    }
                reader.close();
		} catch (IOException e) {
                    System.out.println("Ошибка чтения файла: " + f.getAbsolutePath() + "!");
		}
        strs.forEach((k)->System.out.println("String: " + k +"\n"));
    }
}
