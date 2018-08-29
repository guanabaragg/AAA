package Util;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Silas
 */
public class HTTPHelper {
    private static final String URL_BASE = "http://localhost:8080/ws";
  
    public static void main(String[] args) throws IOException {

        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", "application/json");
        Gson gson = new Gson();
        
        //System.out.println(gson.toJson(licenca, Licenca.class));
        
        String json = "{\"leads\":\n" +
"  [{\"id\":\"1\",\n" +
"    \"uuid\":\"c2f3d2b3-7250-4d27-97f4-eef38be32f7f\",\n" +
"    \"email\":\"silas@crossystem.com.br\",\n" +
"    \"name\":\"Bruno Ghisi\",\n" +
"    \"company\":\"Resultados Digitais\",\n" +
"    \"job_title\":\"IT\",\n" +
"    \"bio\":\"This is my bio\",\n" +
"    \"public_url\":\"http://rdstation.com.br/leads/public/e8d64a22-17a8-40e3-bb8c-c16af1861708\",\n" +
"    \"created_at\":\"2012-06-04T15:31:35-03:00\",\n" +
"    \"opportunity\":\"false\",\n" +
"    \"number_conversions\":\"3\",\n" +
"    \"user\": \"email@example.com\",\n" +
"    \"first_conversion\": {\n" +
"      \"content\": {\n" +
"        \"identificador\":\"ebook-abc\",\n" +
"        \"nome\":\"Bruno\",\n" +
"        \"email_lead\":\"suporte@resultadosdigitais.com.br\",\n" +
"        \"telefone\":\"99999999\",\n" +
"        \"empresa\":\"Resultados Digitais\",\n" +
"        \"cargo\":\"IT\"\n" +
"      },\n" +
"      \"created_at\":\"2012-06-04T15:31:35-03:00\",\n" +
"      \"cumulative_sum\":\"1\",\n" +
"      \"source\":\"source 1\",\n" +
"      \"conversion_origin\": {\n" +
"            \"source\": \"source 1\",\n" +
"            \"medium\": \"medium 1\",\n" +
"            \"value\": \"value 1\",\n" +
"            \"campaign\": \"campaign 1\",\n" +
"            \"channel\": \"channel 1\"\n" +
"          }\n" +
"    },\n" +
"    \"last_conversion\": {\n" +
"      \"content\": {\n" +
"        \"identificador\":\"webinar-abc\",\n" +
"        \"email_lead\":\"suporte@resultadosdigitais.com.br\"\n" +
"      },\n" +
"      \"created_at\":\"2012-06-04T15:31:35-03:00\",\n" +
"      \"cumulative_sum\":\"2\",\n" +
"      \"source\":\"source 2\"\n" +
"    },\n" +
"    \"custom_fields\": {},\n" +
"    \"website\": \"http://www.resultadosdigitais.com.br\",\n" +
"    \"personal_phone\":\"48 30252598\",\n" +
"    \"mobile_phone\":\"48 30252598\",\n" +
"    \"city\":\"Florianópolis\",\n" +
"    \"state\": \"SC\",\n" +
"    \"lead_stage\": \"Lead\",\n" +
"    \"tags\": [\"tag 1\", \"tag 2\"],\n" +
"    \"fit_score\":\"d\",\n" +
"    \"interest\":0\n" +
"  }]\n" +
"}";
        
        System.out.println(sendPost("https://relacionamento.jmn.org.br/JMNWH/webresources/metodo1/metodo1", json, header));
        //System.out.println(sendGet("", header));
        
    }
    
    public String sendGet(String endpoint, Map<String, String> header) throws IOException {
        URL obj = new URL(endpoint);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        StringBuffer response = new StringBuffer();
        
        if (!header.isEmpty()) {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                con.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        con.disconnect();

        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        con.disconnect();

        System.out.println("\nSending 'GET' request to URL : " + endpoint);
        System.out.println("Response Code : " + responseCode);
        return response.toString();
    }

    public static String sendPost(String url, String request, Map<String, String> header) throws MalformedURLException, ProtocolException, IOException {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");

        if (!header.isEmpty()) {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                con.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        con.setDoOutput(true);
        con.setDoInput(true);

        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(request.toString());
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        StringBuffer response = new StringBuffer();

        if (String.valueOf(responseCode).startsWith("20")) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            con.disconnect();

        } else {
            System.out.println("Response: " + responseCode);
            return String.valueOf(responseCode);
        }

        return response.toString();
    }
}