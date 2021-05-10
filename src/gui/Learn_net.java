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

public class Learn_net extends JFrame {

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
               Learn_net frame = new Learn_net();
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
   public Learn_net() {
      setTitle("java.net \uD559\uC2B5");
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

      JButton Datagram_btn = new JButton("DatagramSocket");
      Datagram_btn.setBounds(11, 15, 250, 49);
      contentPane.add(Datagram_btn);

      JButton Socket_btn = new JButton("Socket");
      Socket_btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      Socket_btn.setBounds(365, 15, 250, 49);
      contentPane.add(Socket_btn);

      JButton URLConnection_btn = new JButton("URLConnection");
      URLConnection_btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
         }
      });

      URLConnection_btn.setBounds(711, 15, 250, 49);
      contentPane.add(URLConnection_btn);

      JPanel panel = new JPanel();
      panel.setBounds(11, 83, 950, 390);
      // contentPane.add(panel);
      panel.setLayout(card);
      contentPane.add(panel, BorderLayout.CENTER);

      JPanel Datagram_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("net_DatagramSocket.png"))
               .getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel.add(Datagram_panel, "DatagramSocket");

      JPanel Socket_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("net_Socket.png"))
               .getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel.add(Socket_panel, "Socket");

      JPanel URLConnection_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("net_URLConnection.png"))
               .getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel.add(URLConnection_panel, "URLConnection");

      JPanel panel_1 = new JPanel();
      panel_1.setBounds(11, 476, 950, 410);
      contentPane.add(panel_1, BorderLayout.CENTER);
      panel_1.setLayout(card1);

      JPanel Datagram_method_panel = new JPanel() {
         Image background = new ImageIcon(
               this.getClass().getClassLoader().getResource("DatagramSocket_method.png")).getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel_1.add(Datagram_method_panel, "DatagramSocket_method");

      JPanel Socket_method_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("Socket_method.png"))
               .getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel_1.add(Socket_method_panel, "Socket_method");

      JPanel URLConnection_method_panel = new JPanel() {
         Image background = new ImageIcon(this.getClass().getClassLoader().getResource("URLConnection_method.png"))
               .getImage();

         public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, null);// background를 그려줌

         }
      };
      panel_1.add(URLConnection_method_panel, "URLConnection_method");

      Datagram_btn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            card.show(panel, "DatagramSocket");
            card1.show(panel_1, "DatagramSocket_method");
         }
      });

      Socket_btn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            card.show(panel, "Socket");
            card1.show(panel_1, "Socket_method");
         }
      });

      URLConnection_btn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {

            card.show(panel, "URLConnection");
            card1.show(panel_1, "URLConnection_method");
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