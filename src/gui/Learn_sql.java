package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Panel;

public class Learn_sql extends JFrame {

   private JPanel contentPane;
   CardLayout card = new CardLayout();
   CardLayout card1 = new CardLayout();

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Learn_sql frame = new Learn_sql();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public Learn_sql() {
      setTitle("java.sql \uD559\uC2B5");
      setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      setBounds(100, 100, 1000, 1000);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      JButton back_bt = new JButton("\uB4A4\uB85C\uAC00\uAE30");
      back_bt.setBounds(832, 912, 129, 29);
      back_bt.setActionCommand("Back");
      contentPane.add(back_bt);

      JButton DriverManager_btn = new JButton("DriverManager");
      DriverManager_btn.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      	}
      });
      DriverManager_btn.setBounds(11, 15, 250, 49);
      contentPane.add(DriverManager_btn);

      JButton Statement_btn = new JButton("Statement");
      Statement_btn.setBounds(365, 15, 250, 49);
      contentPane.add(Statement_btn);

      JButton Connection_btn = new JButton("Connection");
      Connection_btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
         }
      });
      Connection_btn.setBounds(711, 15, 250, 49);
      contentPane.add(Connection_btn);

      JPanel panel = new JPanel();
      panel.setBounds(11, 83, 950, 390);
      // contentPane.add(panel);
      panel.setLayout(card);
      contentPane.add(panel, BorderLayout.CENTER);

      JPanel DriverManager_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("sql_DriverManager.png")).getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel.add(DriverManager_panel, "DriverManager");

      JPanel Statement_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("sql_Statement.png")).getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel.add(Statement_panel, "Statement");

      JPanel Connection_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("sql_Connection.png")).getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel.add(Connection_panel, "Connection");
      
      JPanel panel_1 = new JPanel();
      panel_1.setBounds(11, 490, 950, 408);
      contentPane.add(panel_1);
      panel_1.setLayout(card1);
      
      JPanel DriverManager_m_panel = new JPanel() {
          Image background = new ImageIcon(this.getClass().getClassLoader().getResource("sql_DriverManager_m.png")).getImage();

          public void paint(Graphics g) {// 그리는 함수
             g.drawImage(background, 0, 0, null);// background를 그려줌

          }
       };
       panel_1.add(DriverManager_m_panel, "DriverManager_method");

       JPanel Statement_m_panel = new JPanel() {
          Image background = new ImageIcon(this.getClass().getClassLoader().getResource("sql_Statement_m.png")).getImage();

          public void paint(Graphics g) {// 그리는 함수
             g.drawImage(background, 0, 0, null);// background를 그려줌

          }
       };
       panel_1.add(Statement_m_panel, "Statement_method");

       JPanel Connection_m_panel = new JPanel() {
          Image background = new ImageIcon(this.getClass().getClassLoader().getResource("sql_Connection_m.png")).getImage();

          public void paint(Graphics g) {// 그리는 함수
             g.drawImage(background, 0, 0, null);// background를 그려줌

          }
       };
       panel_1.add(Connection_m_panel, "Connection_method");
      
      DriverManager_btn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
        	card.show(panel, "DriverManager");
            card1.show(panel_1, "DriverManager_method");
         }
      });

      Statement_btn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
        	card.show(panel,"Statement");
            card1.show(panel_1, "Statement_method");
         }
      });

      Connection_btn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
        	card.show(panel, "Connection");
            card1.show(panel_1, "Connection_method");
         }
      });

      back_bt.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            dispose();
         }
      });

   }

   class EventHandler implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         if (e.getActionCommand().equals("Back")) {
            dispose();
         }
      }
   }
}