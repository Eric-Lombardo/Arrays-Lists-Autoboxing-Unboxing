package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
//    Create a program that implements a playlist of songs.
//    To start you off, implement the following classes:
//
//    1.Album
//    - It has three fields, two Strings called name and artist, and an ArrayList that holds objects of type Song called songs.
//    - A constructor that accepts two Strings (name of the album and artist). It initialises the fields and instantiates songs.
//    - And three methods, they are:
//    - addSong(), has two parameters of type String (title of song), double (duration of song) and returns a boolean.
//      Returns true if the song was added successfully or false otherwise.
//    - findSong(), has one parameter of type String (title of song) and returns a Song. Returns the Song if it exists,
//      null if it doesn't exists.
//    - addToPlayList(), has two parameters of type int (track number of song in album) and LinkedList (the playlist)
//      that holds objects of type Song, and returns a boolean. Returns true if it exists and it was added successfully
//      using the track number, or false otherwise.
//    - addToPlayList(), has two parameters of type String (title of song) and LinkedList (the playlist) that holds
//      objects of type Song, and returns a boolean. Returns true if it exists and it was added successfully using
//      the name of the song, or false otherwise.
//
//    2. Song
//    - It has two fields, a String called title and a double called duration.
//    - A constructor that accepts a String (title of the song) and a double (duration of the song). It initialises
//      title and duration.
//    - And two methods, they are:
//    - getTitle(), getter for title.
//    - toString(), Songs overriding toString method. Returns a String in the following format: "title: duration"

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String songTitle, double duration) {
        // Returns true if the song was added successfully or false otherwise
        if (findSong(songTitle) == null) {
            songs.add(new Song(songTitle, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String songTitle) {
        // Returns the Song if it exists, null if it doesn't exists.
        for (int i = 0; i < songs.size(); i++) {
            Song targetSong = songs.get(i);
            if (targetSong.getTitle().equals(songTitle)) {
                return targetSong;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        // Returns true if it exists and it was added successfully using the track number, or false otherwise.
        if (trackNumber <= 0 || trackNumber > songs.size()) return false;

        // Track list starts at index 1 not 0
        Song songToAdd = songs.get(trackNumber - 1);
        String songToAddTitle = songToAdd.getTitle();

        ListIterator<Song> playlistIterator = playlist.listIterator();
        while (playlistIterator.hasNext()) {
            if (playlistIterator.next().getTitle().equals(songToAddTitle)) {
                return false;
            }
        }

        playlist.add(songToAdd);
        return true;
    }

    public boolean addToPlayList(String songTitle, LinkedList<Song> playlist) {
        // Returns true if it exists and it was added successfully using the track number, or false otherwise.
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equals(songTitle)) {
                return addToPlayList(i+1, playlist);
            }
        }

        return false;
    }
}
