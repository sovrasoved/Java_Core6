package FinalProject.forms;


import FinalProject.DataA.City;
import FinalProject.WorkDAO.LogicalDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by sovra on 13.05.2017.
 */
public class frmHotel extends JFrame {
    private JPanel rootPanel;
    private JLabel lbl0;
    private JLabel lbl1;
    private JLabel lbl3;
    private JLabel lbl4;
    private JLabel lbl5;
    private JLabel lbl6;
    private JButton cmdExit;
    private JButton cmdSave;
    private JTextField txtAdress;
    private JComboBox cmbCity;
    private JTextField txtEdrpou;
    public JTextField txtName;
    private JTextField txtNotice;


    public JTextField getTxtAdress() {
        return txtAdress;
    }

    public void setTxtAdress(JTextField txtAdress) {
        this.txtAdress = txtAdress;
    }

    public JComboBox getCmbCity() {
        return cmbCity;
    }

    public void setCmbCity(JComboBox cmbCity) {
        this.cmbCity = cmbCity;
    }

    public JTextField getTxtEdrpou() {
        return txtEdrpou;
    }

    public void setTxtEdrpou(JTextField txtEdrpou) {
        this.txtEdrpou = txtEdrpou;
    }

    public JTextField getTxtNotice() {
        return txtNotice;
    }

    public void setTxtNotice(JTextField txtNotice) {
        this.txtNotice = txtNotice;
    }

    public frmHotel() throws HeadlessException {
        setContentPane(rootPanel);
        setTxtName( new JTextField("Мой 1111отель 1"));
        setTxtNotice( new JTextField("При1111мечание"));

        for (City cit: City.values()) {
        cmbCity.addItem(cit);
        }
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cmdSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(getTxtName().getText());
String name1 = getTxtName().getText();
String notice = getTxtNotice().getText();
String edr = getTxtEdrpou().getText();

            if (LogicalDAO.isName(name1) && LogicalDAO.isNotice(notice) && LogicalDAO.isEdrpou(edr)) {
                //save
                JOptionPane.showMessageDialog(null,
                        "Лог контроль кропшел",
                        "Output",
                        JOptionPane.PLAIN_MESSAGE);
                long lng =Long.valueOf(edr);
                System.out.println(lng);
            }
            else
            {
                JOptionPane.showMessageDialog(null,
                        "Не прошел логический контроль, ошибки при вводе",
                        "Output",
                        JOptionPane.PLAIN_MESSAGE);
            }
                    dispose();
            }
        });
        cmdExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }
}
