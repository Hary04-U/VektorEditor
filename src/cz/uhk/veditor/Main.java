package cz.uhk.veditor;

import cz.uhk.veditor.gui.MainWindow;
import javax.swing.SwingUtilities;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> (new MainWindow()).setVisible(true));
    }
}
