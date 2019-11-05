package com.example.android3.data.entity.weather;

public class Weather {

    private String description;
    private String icon;
    private  String main;
    private  String id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Weather(String description, String icon, String main, String id) {
        this.description = description;
        this.icon = icon;
        this.main = main;
        this.id = id;
    }
}
