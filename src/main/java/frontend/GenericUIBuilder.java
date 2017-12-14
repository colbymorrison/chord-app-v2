package frontend;

import backend.ChordChart;
import org.jfugue.theory.Key;

import javax.swing.*;
import java.awt.*;

public class GenericUIBuilder implements UIBuilder {
    private UI userInterface;
    private ButtonsPanel buttonsPanel;
    private GlobalParametersPanel globalParamatersPanel;
    private NotationPanel notationPanel;
    private JPanel panel;

    public GenericUIBuilder() {
        $$$setupUI$$$();
    }

    public UI getUI() {
        return this.userInterface;
    }

    public JPanel getPanel() { return this.panel; }

    @Override
    public void makeNotationPanel() {
        this.notationPanel = new NotationPanel(userInterface);
    }

    @Override
    public void makeButtonsPanel() {
        this.buttonsPanel = new ButtonsPanel(userInterface);
    }

    @Override
    public void makeUI(ChordChart chart, KeyMore key) {
        this.userInterface = new UI(chart, key);
    }

    @Override
    public void makeGlobalParamsPanel() {
        this.globalParamatersPanel = new GlobalParametersPanel(userInterface);
    }

    private void createUIComponents() {
        makeUI(new ChordChart(), new KeyMore("Cmaj"));
        makeGlobalParamsPanel();
        makeNotationPanel();
        makeButtonsPanel();
        Panel[] panels = new Panel[]{globalParamatersPanel, notationPanel, buttonsPanel};
        userInterface.setPanels(panels);
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        panel = new JPanel();
        panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel.add(buttonsPanel.$$$getRootComponent$$$(), new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel.add(globalParamatersPanel.$$$getRootComponent$$$(), new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel.add(notationPanel.$$$getRootComponent$$$(), new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }
}
