package com.amiibo.amiiboGames;

public class Games {
    private String id;
    private String name;
    private String character;
    private String gameSeries;
    private String type;

    public Games(String id, String name, String tags, String category, String glass) {
        this.id = id;
        this.name = name;
        this.character = tags;
        this.gameSeries = category;
        this.type = glass;
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