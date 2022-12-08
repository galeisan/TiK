import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Books {
    public static void main(String[] args){
        List<String> alp = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j"));

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