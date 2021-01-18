package com.amiibo.amiiboGames;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class JSON {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    //apsirasom sarasus, perduodam visa valstybiu sarasa ir ta valstybe pagal kuria nori filtruoti sarasa klientas
    //graziname tos valstybes sarasa su atitinkamais duomenimis, kurio pageidavo klientas

    public static JSONArray getJSONArray(JSONObject json) throws JSONException {

        //JSONObject to JSONArray
        JSONArray jsonArray = json.getJSONArray("amiibo");
        return jsonArray;
    }

    public static ArrayList<Games> getList(JSONArray jsonArray) throws JSONException {
        ArrayList<Games> gamesList = new ArrayList<Games>();
        // Extract data from json and store into ArrayList as class objects
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json_data = jsonArray.getJSONObject(i);
            Games games = new Games(
                    json_data.getString("tail"),
                    json_data.getString("name"),
                    json_data.getString("character"),
                    json_data.getString("gameSeries"),
                    json_data.getString("type")
            );
            gamesList.add(games);
        }
        return gamesList;
    }

    public static ArrayList<Games> getGamesListByQuery(ArrayList<Games> gamesList, String gameName) {
        ArrayList<Games> gamesListByQuery = new ArrayList<Games>();
        for (Games games : gamesList) {
            if (games.getName().contains(gameName)) {
                gamesListByQuery.add(games);
            }
        }
        return gamesListByQuery;
    }

}
