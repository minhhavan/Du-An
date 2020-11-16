/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienich;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author SuongNguyen
 */
public class MsgBox {
    public static void show(Component com, String message) {
        JOptionPane.showMessageDialog(com, message,"Thông báo",JOptionPane.WARNING_MESSAGE);
    }
    
    public static String input(Component com, String message) {
        return JOptionPane.showInputDialog(com, message,"Thông báo",JOptionPane.QUESTION_MESSAGE);
    }
    
    public static boolean confirm(Component com, String message) {
        int confirm = JOptionPane.showConfirmDialog(com, message, "Thông báo", JOptionPane.YES_NO_OPTION);
        return confirm == JOptionPane.YES_OPTION;
    }
}
