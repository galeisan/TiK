import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int position = sc.nextInt();

        String[] strSplit = line.split("");
        ArrayList<String> strList = new ArrayList<String>(Arrays.asList(strSplit));

        String decoded = decode(strList, position);
        System.out.println(decoded);
    }

    public static String decode(List<String> mes, int pos){
        List<String> res = mes.stream().sorted().collect(Collectors.toList());

        for (int k = 0; k < mes.size()-1; k++) {
            for (int i = 0; i < mes.size(); i++) {
                res.set(i, mes.get(i) + res.get(i));
            }
            res = res.stream().sorted().collect(Collectors.toList());
        }

        return (res.get(pos));

    }
}