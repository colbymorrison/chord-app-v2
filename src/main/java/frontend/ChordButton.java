package frontend;

import org.jfugue.theory.Key;
import org.jfugue.theory.Note;

import javax.swing.*;

public class ChordButton extends JButton {
    private String extension;
    private String chord;

    public String getChord() {
        return chord;
    }

    public void setChord(String chord) {
        this.chord = chord;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public ChordButton(){}

    public ChordButton(String chord, String extension){
        this.chord = chord;
        this.extension = extension;
    }

    /**
     * Updates the button's text
     * @param key Key to interpret
     * @param n Note to interpret
     * @param i Scale degree
     */
    protected void resetText(KeyMore key, Note n, int i){
        this.setChord(key.stringCorrect(n));
        this.setExtension(key.typeFromKey(i));
        this.setText(this.toString());
    }

    /**
     * Updates the button's text
     * @param chord Specific chord name to interpret
     * @param extension Extension
     */
    protected void resetText(String chord, String extension){
        this.setChord(chord);
        this.setExtension(extension);
        this.setText(this.toString());
    }

    /**
     * Formats ChordButton for string
     * @return String representation of ChordButton
     */
    @Override
    public String toString() {
        if(chord.length() > 1)
            if (chord.charAt(1) == 'B') chord = chord.substring(0, 0) + "b";
        String endChord = chord;
        switch(extension){
            case "MAJ":
                endChord = endChord.toUpperCase();
                break;
            case "DIM":
                endChord += "o";
            case "MIN":
                endChord = endChord.toLowerCase();
                break;
        }
        return endChord;
    }

}
