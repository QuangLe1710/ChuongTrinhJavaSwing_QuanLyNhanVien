package execute;

import controller.MainListen;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class QLNVMain extends javax.swing.JFrame {
    public Component component;
    
    public QLNVMain(Component component) {
        this.init();
        this.setLocationRelativeTo(null);
        this.setProperty();
        this.component = component;    
        this.setLayout(new BorderLayout());      
        this.add(this.component, BorderLayout.CENTER);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void setProperty() {
        MainListen mainListen = new MainListen(this);
        menuItem_Logout.addActionListener(mainListen);
        menuItem_ShowStaff.addActionListener(mainListen);
        menuItem_ShowDepartment.addActionListener(mainListen);
        menuItem_ShowAccount.addActionListener(mainListen);
        menuItem_About.addActionListener(mainListen);
        menuItem_Exit.addActionListener(mainListen);
        
        ImageIcon img = new ImageIcon(getClass().getResource("/icon/QLNV24px.png"));
        this.setIconImage(img.getImage());
        this.setTitle("Employee Manager");
    }
    
                       
    private void init() {
        menuBar = new JMenuBar();
        menu_Edit = new JMenu();
        menuItem_Logout = new JMenuItem();
        menuView = new JMenu();
        menuItem_ShowStaff = new JMenuItem();
        menuItem_ShowDepartment = new JMenuItem();
        menuItem_ShowAccount = new JMenuItem();
        menu_Help = new JMenu();
        menuItem_About = new JMenuItem();
        menuItem_Exit = new JMenuItem();

        menu_Edit.setText("Edit");

        menuItem_Logout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        menuItem_Logout.setIcon(new ImageIcon(getClass().getResource("/icon/LogOut16px.png"))); 
        menuItem_Logout.setText("Log Out");
        menu_Edit.add(menuItem_Logout);

        menuBar.add(menu_Edit);

        menuView.setText("View");

        menuItem_ShowStaff.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        menuItem_ShowStaff.setIcon(new ImageIcon(getClass().getResource("/icon/showsaff16px.png"))); 
        menuItem_ShowStaff.setText("Show Staff");
        menuView.add(menuItem_ShowStaff);

        menuItem_ShowDepartment.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
        menuItem_ShowDepartment.setIcon(new ImageIcon(getClass().getResource("/icon/department16px.png"))); 
        menuItem_ShowDepartment.setText("Show Department");
        menuView.add(menuItem_ShowDepartment);

        menuItem_ShowAccount.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        menuItem_ShowAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/savefile16px.png"))); 
        menuItem_ShowAccount.setText("Show Account");
        menuView.add(menuItem_ShowAccount);

        menuBar.add(menuView);

        menu_Help.setText("Help");

        menuItem_About.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
        menuItem_About.setIcon(new ImageIcon(getClass().getResource("/icon/About16px.png"))); 
        menuItem_About.setText("About");
        menu_Help.add(menuItem_About);

        menuItem_Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
        menuItem_Exit.setIcon(new ImageIcon(getClass().getResource("/icon/exit16px.png"))); 
        menuItem_Exit.setText("Exit");
        menu_Help.add(menuItem_Exit);

        menuBar.add(menu_Help);

        setJMenuBar(menuBar);

        GroupLayout layout = new GroupLayout(getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addGap(0, 1000, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 602, Short.MAX_VALUE));
        pack();
    }                        
                    
    private JMenuBar menuBar;
    private JMenuItem menuItem_About, menuItem_Exit, menuItem_Logout, menuItem_ShowAccount, menuItem_ShowDepartment, menuItem_ShowStaff;
    public JMenu menuView;
    private JMenu menu_Edit, menu_Help;

    public void editPanel(Component component) {
        if(component.getClass() != this.component.getClass()) {
            this.remove(this.component);
            this.add(component);
            this.component = component;
            this.revalidate();
            this.repaint();
        }
    }
}
