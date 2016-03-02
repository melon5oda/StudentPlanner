package planner;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class SubmenuEx extends JFrame {
    private JLabel statusbar;

    public SubmenuEx() {
        
        initUI();
    }

    private void initUI() {

        createMenuBar();
        
        statusbar = new JLabel("Ready");
        statusbar.setBorder(BorderFactory.createEtchedBorder());
        add(statusbar, BorderLayout.SOUTH);

        setTitle("Submenu");
        setSize(640, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setTitle("JCheckBoxMenuItem");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void createMenuBar() {
        
        JMenuBar menubar = new JMenuBar();
        
        ImageIcon iconNew = new ImageIcon("new.png");
        ImageIcon iconOpen = new ImageIcon("open.png");
        ImageIcon iconSave = new ImageIcon("save.png");
        ImageIcon iconExit = new ImageIcon("exit.png");

        JMenu fileMenu = new JMenu("File");

        JMenu impMenu = new JMenu("Import");
        JMenuItem newsfMi = new JMenuItem("Existing Gantt Chart");
        JMenuItem bookmMi = new JMenuItem("Existing Pert Chart");
        JMenuItem mailMi = new JMenuItem("Exiting ");

        impMenu.add(newsfMi);
        impMenu.add(bookmMi);
        impMenu.add(mailMi);

        JMenuItem newMi = new JMenuItem("New", iconNew);
        JMenuItem openMi = new JMenuItem("Open", iconOpen);
        JMenuItem saveMi = new JMenuItem("Save", iconSave);
        JMenuItem exitMi = new JMenuItem("Exit", iconExit);
        exitMi.setToolTipText("Exit application");
        
        
        JMenu viewMenu = new JMenu("View");
        JCheckBoxMenuItem sbarMi = new JCheckBoxMenuItem("Show statubar");
        sbarMi.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    statusbar.setVisible(true);
                } else {
                    statusbar.setVisible(false);
                }
                
            }

        });

        viewMenu.add(sbarMi);

        menubar.add(fileMenu);
        menubar.add(viewMenu);

        setJMenuBar(menubar);

        exitMi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        fileMenu.add(newMi);
        fileMenu.add(openMi);
        fileMenu.add(saveMi);
        fileMenu.addSeparator();
        fileMenu.add(impMenu);
        fileMenu.addSeparator();
        fileMenu.add(exitMi);

        menubar.add(fileMenu);

        setJMenuBar(menubar);        
    }
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                SubmenuEx ex = new SubmenuEx();
                ex.setVisible(true);
            }
        });
    }
}