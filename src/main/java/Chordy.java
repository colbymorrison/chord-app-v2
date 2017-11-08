public class Chordy {

    String root;
    String extension;
    String duration;

    public Chordy(String root, String extension, String duration) {
        this.root = root;
        this.extension = extension;
        this.duration = duration;
    }

    public void toRest() {
        this.root = "R";
        this.extension = "";
    }

    public void decDur(){
        switch (this.duration){
            case "w":
                this.duration = "h";
                break;
            case "h":
                this.duration = "q";
                break;
            case "q":
                this.duration = "i";
                break;
            case "i":
                this.duration = "s";
                break;
            case "s":
                this.duration = "t";
                break;
            case "t":
                this.duration = "x";
                break;
            case "x":
                this.duration = "o";
                break;
            case "o":
                break;
        }
    }

    public void incDur(){
        switch (this.duration){
            case "o":
                this.duration = "x";
                break;
            case "x":
                this.duration = "t";
                break;
            case "t":
                this.duration = "s";
                break;
            case "s":
                this.duration = "i";
                break;
            case "i":
                this.duration = "q";
                break;
            case "q":
                this.duration = "h";
                break;
            case "h":
                this.duration = "w";
                break;
            case "w":
                break;
        }
    }

    public void incOct(){
        this.root = this.detNote() + Integer.toString(this.detOct() + 1);
    }

    public void decOct(){
        this.root = this.detNote() + Integer.toString(this.detOct() - 1);
    }

    //helper function that detects the octave and returns it as an integer
    public int detOct(){
        //the initial if clause exists to catch the instance a chord is registered without an octave listed
        //i.e. this.root = "C" is in the default octave and is read as "C5"
        //therefore it returns 5 to prevent a parseInt exception
        if(this.getRoot().replaceAll("[^\\d.]","").equals("")){
            return 5;
        }
        //parses the int if the string is not empty
        else {
            return Integer.parseInt(this.getRoot().replaceAll("[^\\d.]",""));
        }
    }

    //helper function to detect the note of a chordy
    public String detNote(){
        return this.getRoot().replaceAll("/[0-9]", "");
    }



    //<editor-fold desc="Getters and Setters">
    public String getRoot(){
        return root;
    }

    public String getExtension() {
        return extension;
    }

    public String getDuration() {
        return duration;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    //</editor-fold>

    public String toString() {
        return root + extension + duration;
    }

}