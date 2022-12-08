import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MTF {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/file/mtf.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String str = reader.readLine();
        String[] strSplit = str.split(" ");
        List<String> alp = new ArrayList<String>(Arrays.asList(strSplit)).stream().sorted().collect(Collectors.toList());

        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();

        String decoded = decode(message, alp);
        System.out.println(decoded);
    }

    public static String decode(String message, List<String> alp){
        // нумеруем буквы алфавита десятичными числами
        List<String> code = IntStream.range(0, alp.size()).boxed().map(Object::toString).collect(Collectors.toList());

        StringBuilder output = new StringBuilder();
        String str = "";

        for(char letter : message.toCharArray()){
            str = str + letter;
            // если код (послед-ть кодов) содержится в массиве кодов
            if(code.contains(str)) {
                int ind = code.indexOf(str);
                String let = alp.get(ind);
                output.append(let); // записываем букву
                alp.remove(ind);
                alp.add(0, let); // переносим букву наверх
                str = "";
            }
        }
        return output.toString();
    }
}