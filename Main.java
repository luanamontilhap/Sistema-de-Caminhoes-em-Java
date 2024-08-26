import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        MainFrameApp mainFrameApp = new MainFrameApp();
        mainFrameApp.setVisible(true);
    });
}}