package backend;
import org.jfugue.theory.*;

public class Chordy extends Chord {

    private Duration duration;
    //For easy reference to root
    private Note root = this.getRoot();


    public Chordy(String rootStr, String extension, Duration duration) {
        super(rootStr + extension);
        if(!root.isOctaveExplicitlySet()) root.setOctaveExplicitlySet(true);
        this.duration = duration;
    }

    void decDur(){
        duration.decDur();
    }

    void incDur(){
        duration.incDur();
    }

    void incOct(){
        if(root.getValue() <= 115) root.changeValue(12);

    }

    void incOct(int n){
        if(root.getValue()+ (12* n) <= 127) root.changeValue(12*n);
    }

    void decOct(){
        if(root.getValue() >= 12) root.changeValue(-12);
    }

    void decOct(int n){
        if(root.getValue()- (12 * n) >= 0) root.changeValue(-12*n);
    }

    //Returns the octave of the chord
    int getOct(){
        return Byte.toUnsignedInt(root.getOctave());
    }

    //helper function to detect the note of a chordy without its octave
    String detNote(){
        return root.toStringWithoutDuration().replaceAll("[\\d.]", "");
    }

    //Raises chord by 1 half step
    void incRoot() {
        if(root.getValue() <= 126) root.changeValue(1);
    }

    //Lowers chord by 1 half step
    void decRoot() {
        if(root.getValue() >= 1) root.changeValue(-1);
    }

    //<editor-fold desc="Getters and Setters">

    String getDuration() {
       return duration.getDur();
    }

    void setDuration(String dur) {
        duration.setDur(dur);
    }
    //</editor-fold>

    public String toString() {
        return super.toString() + duration;
    }

}