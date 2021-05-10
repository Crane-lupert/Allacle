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

public class Learn_util extends JFrame {

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
               Learn_util frame = new Learn_util();
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
   public Learn_util() {
      setTitle("java.util \uD559\uC2B5");
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

      JButton Arrays_btn = new JButton("Arrays");
      Arrays_btn.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      	}
      });
      Arrays_btn.setBounds(11, 15, 250, 49);
      contentPane.add(Arrays_btn);

      JButton Scanner_btn = new JButton("Scanner");
      Scanner_btn.setBounds(365, 15, 250, 49);
      contentPane.add(Scanner_btn);

      JButton StringTokenizer_btn = new JButton("StringTokenizer");
      StringTokenizer_btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
         }
      });
      StringTokenizer_btn.setBounds(711, 15, 250, 49);
      contentPane.add(StringTokenizer_btn);

      JPanel panel = new JPanel();
      panel.setBounds(11, 83, 950, 380);
      // contentPane.add(panel);
      panel.setLayout(card);
      contentPane.add(panel, BorderLayout.CENTER);

      JPanel Arrays_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("util_Arrays.png")).getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel.add(Arrays_panel, "Arrays");

      JPanel Scanner_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("util_Scanner.png")).getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel.add(Scanner_panel, "Scanner");

      JPanel StringTokenizer_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("util_StringTokenizer.png")).getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel.add(StringTokenizer_panel, "StringTokenizer");
      
      JPanel panel_1 = new JPanel();
      panel_1.setBounds(11, 490, 950, 408);
      contentPane.add(panel_1);
      panel_1.setLayout(card1);
      
      JPanel Arrays_m_panel = new JPanel() {
          Image background = new ImageIcon(this.getClass().getClassLoader().getResource("util_Arrays_m.png")).getImage();

          public void paint(Graphics g) {// 그리는 함수
             g.drawImage(background, 0, 0, null);// background를 그려줌

          }
       };
       panel_1.add(Arrays_m_panel, "Arrays_method");

       JPanel Scanner_m_panel = new JPanel() {
          Image background = new ImageIcon(this.getClass().getClassLoader().getResource("util_Scanner_m.png")).getImage();

          public void paint(Graphics g) {// 그리는 함수
             g.drawImage(background, 0, 0, null);// background를 그려줌

          }
       };
       panel_1.add(Scanner_m_panel, "Scanner_method");

       JPanel StringTokenizer_m_panel = new JPanel() {
          Image background = new ImageIcon(this.getClass().getClassLoader().getResource("util_StringTokenizer_m.png")).getImage();

          public void paint(Graphics g) {// 그리는 함수
             g.drawImage(background, 0, 0, null);// background를 그려줌

          }
       };
       panel_1.add(StringTokenizer_m_panel, "StringTokenizer_method");
      
      Arrays_btn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
        	card.show(panel, "Arrays");
            card1.show(panel_1, "Arrays_method");
         }
      });

      Scanner_btn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
        	card.show(panel,"Scanner");
            card1.show(panel_1, "Scanner_method");
         }
      });

      StringTokenizer_btn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
        	card.show(panel, "StringTokenizer");
            card1.show(panel_1, "StringTokenizer_method");
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