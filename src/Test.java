public class Test {
    public static void main(String[] args){
//        Player player = new Player();
//        player.play("C D E F G A B C6");
        ChordChart chordChart = new ChordChart();

        chordChart.insertChord(new Chordy("C", "maj7", "q"));
        chordChart.insertChord(new Chordy("D", "min7", "q"));
        chordChart.insertChord(new Chordy("G", "dom7", "q"));
        chordChart.insertChord(new Resty("q"));

        chordChart.insertChord(new Chordy("C", "maj7", "q"));
        chordChart.insertChord(new Chordy("D", "min7", "q")); // rested

        chordChart.insertChord(new Chordy("G", "dom7", "q"));
        chordChart.insertChord(new Chordy("B", "dom9", "q")); // deleted
        chordChart.insertChord(new Chordy("C", "maj7", "q"));

        chordChart.insertChord(new Resty("w")); // note how it still cuts off sharply at the end...

        chordChart.restChord(5);
        chordChart.delChord(7);

        chordChart.play();
    }
}
