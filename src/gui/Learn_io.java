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

public class Learn_io extends JFrame {

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
               Learn_io frame = new Learn_io();
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
   public Learn_io() {
      setTitle("java.io \uD559\uC2B5");
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

      JButton BufferedInputStream_btn = new JButton("BufferedInputStream");
      BufferedInputStream_btn.setBounds(11, 15, 250, 49);
      contentPane.add(BufferedInputStream_btn);

      JButton InputStream_btn = new JButton("InputStream");
      InputStream_btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      InputStream_btn.setBounds(365, 15, 250, 49);
      contentPane.add(InputStream_btn);

      JButton StreamTokenizer_btn = new JButton("StreamTokenizer");
      StreamTokenizer_btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
         }
      });

      StreamTokenizer_btn.setBounds(711, 15, 250, 49);
      contentPane.add(StreamTokenizer_btn);

      JPanel panel = new JPanel();
      panel.setBounds(11, 83, 950, 378);
      // contentPane.add(panel);
      panel.setLayout(card);
      contentPane.add(panel, BorderLayout.CENTER);

      JPanel BufferedInputStream_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("io_BufferedInputStream.png"))
               .getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel.add(BufferedInputStream_panel, "BufferedInputStream");

      JPanel InputStream_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("io_InputStream.png"))
               .getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel.add(InputStream_panel, "InputStream");

      JPanel StreamTokenizer_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("io_StreamTokenizer.png"))
               .getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel.add(StreamTokenizer_panel, "StreamTokenizer");

      JPanel panel_1 = new JPanel();
      panel_1.setBounds(11, 476, 950, 410);
      contentPane.add(panel_1, BorderLayout.CENTER);
      panel_1.setLayout(card1);

      JPanel BufferedInputStream_method_panel = new JPanel() {
         Image background = new ImageIcon(
               this.getClass().getClassLoader().getResource("BufferedInputStream_method.png")).getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel_1.add(BufferedInputStream_method_panel, "BufferedInputStream_method");

      JPanel InputStream_method_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("InputStream_method.png"))
               .getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel_1.add(InputStream_method_panel, "InputStream_method");

      JPanel StreamTokenizer_method_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("StreamTokenizer_method.png"))
               .getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel_1.add(StreamTokenizer_method_panel, "StreamTokenizer_method");

      BufferedInputStream_btn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            card.show(panel, "BufferedInputStream");
            card1.show(panel_1, "BufferedInputStream_method");
         }
      });

      InputStream_btn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            card.show(panel, "InputStream");
            card1.show(panel_1, "InputStream_method");
         }
      });

      StreamTokenizer_btn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {

            card.show(panel, "StreamTokenizer");
            card1.show(panel_1, "StreamTokenizer_method");
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