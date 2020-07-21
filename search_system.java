import java.util.*;

public class search_system {
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> answer = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 1; i <= searchWord.length(); ++i) {
            String cur = searchWord.substring(0, i);
            int k = Arrays.binarySearch(products, cur);
            while (k > 0 && cur.equals(products[k - 1])) // in case there are more than 1 cur in products.
                --k; // find the first one. 
            if (k < 0) // no cur in products. 
                k = -(k + 1); // find the first one larger than cur.
            System.out.println(k);
            List<String> suggestion = new ArrayList<>();
            for (int j = k + 3; k < products.length && k < j && products[k].startsWith(cur); ++k)
                suggestion.add(products[k]);
            answer.add(suggestion);
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousfpad"};
        String searchword = "mouse";
        System.out.println(suggestedProducts(products, searchword));
    }
}