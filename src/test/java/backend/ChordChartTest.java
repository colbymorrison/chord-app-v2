package backend;

import org.jfugue.player.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ChordChartTest {

    private ChordChart chordChart;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

     @Mock
     private Chordy chordy;
     private Chordy chordyB;
     private Resty resty;
     private Duration duration;

     @Before
     public void setUP(){
         chordChart = new ChordChart();
         chordChart.insertUseable(chordy);
     }

     @After
     public void tearDown(){
         chordChart = null;
     }

    @Test
    public void insertUseable() {
        chordChart.insertUseable(resty);
        chordChart.insertUseable(1, chordy);


        ArrayList<Useable> testArray = new ArrayList<>();

        testArray.add(chordy);
        testArray.add(chordy);
        testArray.add(resty);

        assertEquals(testArray, chordChart.getChordList());
    }

    @Test
    public void play(){
        Player player = mock(Player.class);
        chordChart.setPlayer(player);
        chordChart.play();
        verify(player).play(anyString());
    }

    @Test
    public void tempoTest(){
        ChordChart chordChart = new ChordChart(12);
        chordChart.incTempo();
        assertEquals(13, chordChart.getTempo());
        chordChart.decTempo();
        assertEquals(12, chordChart.getTempo());
    }

    @Test
    public void getChordListParam() {
        chordChart.insertUseable(chordyB);
        ArrayList<Chordy> testList = new ArrayList<>();
        testList.add(chordyB);
        assertEquals(testList, chordChart.getChordList(1));
    }

    @Test
    public void restChord(){
        when(chordy.getDuration()).thenReturn(Duration.QUARTER);
        chordChart.restChord(0);
        assertTrue(chordChart.getChordList().get(0).isRest());

        chordChart.restChord(0);
        assertTrue(chordChart.getChordList().get(0).isRest());

        chordChart.insertUseable(chordy);
        chordChart.restChord(1);
        assertTrue(chordChart.getChordList().get(0).isRest());
    }

    @Test
    public void getChord() throws Exception {
        chordChart.insertUseable(resty);
        chordChart.insertUseable(chordy);

        assertEquals(chordy, (chordChart.getChord(0)));
        assertEquals(null, (chordChart.getChord(1)));
        assertEquals(chordy, (chordChart.getChord(2)));
    }

    @Test
    public void getUseable() throws Exception {
        chordChart.insertUseable(resty);
        chordChart.insertUseable(chordy);


        assertEquals(chordy, (chordChart.getUseable(0)));
        assertEquals(resty, (chordChart.getUseable(1)));
        assertEquals(chordy, (chordChart.getUseable(2)));
    }

    @Test
    public void delChord() throws Exception {
        chordChart.insertUseable(resty);
        chordChart.insertUseable(chordy);

        chordChart.delChord(1);

        assertEquals(chordy, chordChart.getChordList().get(1));
    }

    @Test
    public void moveChord() throws Exception {
        chordChart.insertUseable(chordy);
        chordChart.insertUseable(resty);
        chordChart.insertUseable(resty);
        chordChart.insertUseable(chordy);

        chordChart.moveChord(1,2);

        assertEquals(chordy, chordChart.getChord(2));
    }

    @Test
    public void toTableArray() throws Exception {
        Chordy cChord = new Chordy("C","maj",Duration.QUARTER);
        Resty zestyResty = new Resty(Duration.QUARTER);
        Chordy gChord = new Chordy("G","maj",Duration.QUARTER);
        ChordChart chartyBOI = new ChordChart();
        chartyBOI.insertUseable(cChord);
        chartyBOI.insertUseable(zestyResty);
        chartyBOI.insertUseable(gChord);

        String[][] testArray = new String[3][3];
        testArray[0] = cChord.getRow();
        testArray[1] = zestyResty.getRow();
        testArray[2] = gChord.getRow();

        assertArrayEquals(testArray, chartyBOI.toTableArray());
    }

    @Test
    public void toMIDIFile(){
        ChordChart chordChart = new ChordChart();
        chordChart.insertUseable(new Chordy("C","maj",Duration.QUARTER));
        chordChart.toMIDIFile();
        assertTrue(new File("yourMidi.midi").exists());
    }

    @Test
    public void saveFile() {
        ChordChart chordChart = new ChordChart();
        chordChart.insertUseable(new Chordy("C","maj",Duration.QUARTER));
        String fileName = "test";
        chordChart.saveFile(fileName);
        assertTrue(new File("test.chordface").exists());
    }

    @Test
    public void fileToChart() {
        assertTrue(ChordChart.fileToChart("test.chordface") != null);
    }

}