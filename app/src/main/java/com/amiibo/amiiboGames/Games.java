package com.amiibo.amiiboGames;

import java.io.Serializable;

public class Games implements Serializable {

    private String id;
    private String name;
    private String character;
    private String gameSeries;
    private String type;

    //tai yra skirta darbui su json
    public Games(String id, String name, String character, String gameSeries, String type) {
        this.id = id;
        this.name = name;
        this.character = character;
        this.gameSeries = gameSeries;
        this.type = type;
    }
    //skirtas atvaizdavimui duomenu is anketos new_entry_activity
    public Games(String id, String character, String gameSeries, String type) {
        this.id = id;
        this.character = character;
        this.gameSeries = gameSeries;
        this.type = type;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getGameSeries() {
        return gameSeries;
    }

    public void setGameSeries(String gameSeries) {
        this.gameSeries = gameSeries;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}