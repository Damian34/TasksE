package me.pack;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class KanyeManager {
    private List<String> kanyeQuoteList;
    public KanyeManager(){
        kanyeQuoteList = new LinkedList<>();
    }
    public void showKanyeQuoteList(){
        if(!this.kanyeQuoteList.isEmpty()){
            this.kanyeQuoteList.stream()
                    .forEach(quote-> System.out.println(quote));
        }else{
            System.out.println("List of Kanye quotes is empty");
        }
    }
    public void cleanKanyeQuoteList(){
        this.kanyeQuoteList.clear();
    }
    public void nextKanyeQuote(){
        Optional<String> quoteOp = downloadKanyeQuote();
        if(quoteOp.isPresent()){
            String quote = quoteOp.get();
            System.out.println(quote);
            if(this.kanyeQuoteList.contains(quote)){
                System.out.println(String.format("%sthis quote is already on list%s"
                        ,Constants.COLOR_ANSI_CYAN, Constants.COLOR_ANSI_RESET));
            }else{
                this.kanyeQuoteList.add(quote);
            }
        }else{
            System.out.println("Sorry, but it look like You have some problem with connection");
        }
    }
    private Optional<String> downloadKanyeQuote(){
        try {
            URL url = new URL("https://api.kanye.rest/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:97.0) Gecko/20100101 Firefox/97.0");
            connection.connect();
            if (connection.getResponseCode() == 200) {
                String response = readInputStream(connection.getInputStream());
                JSONObject json = new JSONObject(response);
                return Optional.of(json.getString("quote"));
            }
        } catch (IOException e) {
        }
        return Optional.empty();
    }
    private String readInputStream(InputStream inputStream) throws IOException{
        try(BufferedReader in = new BufferedReader(new InputStreamReader(inputStream))){
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            return response.toString();
        }
    }
}
