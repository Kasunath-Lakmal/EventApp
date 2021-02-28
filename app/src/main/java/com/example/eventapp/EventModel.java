package com.example.eventapp;
// 4. Generate constructors , Getters and Setters
public class EventModel {

    private int id;
    private String title;
    private String description;
    private long started, finished;

    EventModel(){

    }

    public EventModel(String title, String description, long started, long finished) {
        this.title = title;
        this.description = description;
        this.started = started;
        this.finished = finished;
    }



    public EventModel(int id, String title, String description, long started, long finished) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.started = started;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public long getStarted() {
        return started;
    }

    public long getFinished() {
        return finished;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStarted(long started) {
        this.started = started;
    }

    public void setFinished(long finished) {
        this.finished = finished;
    }






}
