package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
        List<Player> finns = new ArrayList<Player>();
        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        System.out.println();
        System.out.println("Finnish top scorers:");

        for (Player player : players) {
            if(player.getNationality().equals("FIN")) {
                finns.add(player);
            }
        }
        Collections.sort(finns, new PlayerComparator());
        Collections.reverse(finns);
        for (Player player : finns){
            System.out.println(player.toString());
        }
    }
  
}