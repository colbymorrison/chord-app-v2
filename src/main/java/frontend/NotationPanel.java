package frontend;

import javax.swing.*;
import java.awt.*;

public class NotationPanel extends Panel {
    private UI userInterface;
    private String title;
    //private ArrayList<DrawnChord> drawnChordList;
    private JPanel panel1;
    private JTable TrackerTable;
    private JScrollPane scrollPane;
    private final String[] COL_NAMES = new String[]{"Root", "Extension", "Duration"};


    public NotationPanel(UI userInterface) {
        super(userInterface);
        $$$setupUI$$$();
        panel1.setPreferredSize(new Dimension(500, 500));

    }


    //JTable TrackerTable = new JTable(ChordChart.chordList);
    public void draw(Object arg) {
        // uhhh
    }

    /*
        // if this sucks just delete it:
        public void updateDrawnChordList(){
            ArrayList<DrawnChord> retlist = new ArrayList<>();
            for (Useable chord : userInterface.chordChart.getChordList()){
                retlist.add(new DrawnChord((Chordy) chord));
            }
            this.drawnChordList = retlist;
        }
    */
    public void updateTable() {
        this.TrackerTable = new JTable(
                userInterface.getChordChart().toTableArray(),
                COL_NAMES
        );
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        scrollPane = new JScrollPane();
        panel1.add(scrollPane, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        TrackerTable = new JTable();
        scrollPane.setViewportView(TrackerTable);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
