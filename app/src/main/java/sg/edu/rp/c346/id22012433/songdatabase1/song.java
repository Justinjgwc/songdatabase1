package sg.edu.rp.c346.id22012433.songdatabase1;

import androidx.annotation.NonNull;

public class song {
    private String title;
    private String singer;
    private int year;
    private int star;
    private int id;

    public song(int id, String title, String singer, Integer year, Integer star) {
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.star = star;
        this.id = id;
    }

    public int getId() { return id; }

    public String getTitle() { return title; }

    public String getSinger() { return singer;}
    public int getYear() {return year;}
    public int getStar() {return star;}
    @NonNull
    @Override
    public String toString() {
        return  id + "\n" + title + "\n" + singer + "\n"+ year + "\n" + star;
    }

}

