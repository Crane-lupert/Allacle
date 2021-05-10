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

public class Learn_lang extends JFrame {

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
               Learn_lang frame = new Learn_lang();
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
   public Learn_lang() {
      setTitle("java.lang \uD559\uC2B5");
      setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      setBounds(100, 100, 1000, 1000);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      JButton back_bt = new JButton("\uB4A4\uB85C\uAC00\uAE30");
      back_bt.setBounds(832, 900, 129, 29);
      back_bt.setActionCommand("Back");
      contentPane.add(back_bt);

      JButton Double_btn = new JButton("Double");
      Double_btn.setBounds(11, 15, 250, 49);
      contentPane.add(Double_btn);

      JButton Integer_btn = new JButton("Integer");
      Integer_btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      Integer_btn.setBounds(365, 15, 250, 49);
      contentPane.add(Integer_btn);

      JButton String_btn = new JButton("String");
      String_btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
         }
      });

      String_btn.setBounds(711, 15, 250, 49);
      contentPane.add(String_btn);

      JPanel panel = new JPanel();
      panel.setBounds(11, 83, 950, 370);
      // contentPane.add(panel);
      panel.setLayout(card);
      contentPane.add(panel, BorderLayout.CENTER);

      JPanel Double_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("lang_Double.png"))
               .getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel.add(Double_panel, "Double");

      JPanel Integer_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("lang_Integer.png"))
               .getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel.add(Integer_panel, "Integer");

      JPanel String_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("lang_String.png"))
               .getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel.add(String_panel, "String");

      JPanel panel_1 = new JPanel();
      panel_1.setBounds(11, 476, 950, 410);
      contentPane.add(panel_1, BorderLayout.CENTER);
      panel_1.setLayout(card1);

      JPanel Double_method_panel = new JPanel() {
         Image background = new ImageIcon(
               this.getClass().getClassLoader().getResource("Double_method.png")).getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel_1.add(Double_method_panel, "Double_method");

      JPanel Integer_method_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("Integer_method.png"))
               .getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel_1.add(Integer_method_panel, "Integer_method");

      JPanel String_method_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("String_method.png"))
               .getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel_1.add(String_method_panel, "String_method");

      Double_btn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            card.show(panel, "Double");
            card1.show(panel_1, "Double_method");
         }
      });

      Integer_btn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            card.show(panel, "Integer");
            card1.show(panel_1, "Integer_method");
         }
      });

      String_btn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {

            card.show(panel, "String");
            card1.show(panel_1, "String_method");
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