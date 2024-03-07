package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JMenuItem;

import sql.QJXTDataBase;

import java.awt.Toolkit;

public class UserRegister extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegister frame = new UserRegister();
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
	public UserRegister() {
		// setIconImage(Toolkit.getDefaultToolkit().getImage(UserRegister.class.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		setResizable(false);
		this.setLocationRelativeTo(null);
		setTitle("账号管理界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 753, 700);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("注册");
		mnNewMenu.setForeground(Color.BLUE);
		mnNewMenu.setFont(new Font("华文楷体", Font.PLAIN, 25));
		menuBar.add(mnNewMenu);

		JMenuItem sr_menuItem = new JMenuItem("注册学生账号");
		sr_menuItem.setFont(new Font("华文楷体", Font.PLAIN, 20));
		sr_menuItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				StuRegister sr = new StuRegister();

				sr.setVisible(true);

			}
		});
		mnNewMenu.add(sr_menuItem);

		JMenuItem tr_menuItem = new JMenuItem("注册教师账号");
		tr_menuItem.setFont(new Font("华文楷体", Font.PLAIN, 20));
		mnNewMenu.add(tr_menuItem);
		tr_menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TeaRegister tr = new TeaRegister();
				tr.setVisible(true);

			}
		});

		JMenu menu_1 = new JMenu("注销");
		menu_1.setForeground(Color.BLUE);
		menu_1.setFont(new Font("华文楷体", Font.PLAIN, 25));
		menuBar.add(menu_1);

		JMenuItem sc_menuItem = new JMenuItem("注销学生账号");
		sc_menuItem.setFont(new Font("华文楷体", Font.PLAIN, 20));
		menu_1.add(sc_menuItem);
		sc_menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Stucancel sc = new Stucancel();
				sc.setVisible(true);
			}
		});

		JMenuItem tc_menuItem = new JMenuItem(
				"\u6CE8\u9500\u6559\u5E08\u8D26\u53F7");
		tc_menuItem.setFont(new Font("华文楷体", Font.PLAIN, 20));
		menu_1.add(tc_menuItem);
		tc_menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Teacancel tc = new Teacancel();
				tc.setVisible(true);
			}
		});

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenu menu_2 = new JMenu("查看");
		menu_2.setForeground(Color.BLUE);
		menu_2.setFont(new Font("华文楷体", Font.PLAIN, 25));
		menuBar.add(menu_2);

		JMenuItem sc_menuItem1 = new JMenuItem("查询学生请假次数");
		sc_menuItem1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		menu_2.add(sc_menuItem1);
		sc_menuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				number c = new number();
				c.setVisible(true);
			}
		});

		ImageIcon ig = new ImageIcon("logo.jpg");
		JLabel label = new JLabel(ig);
		label.setBackground(Color.WHITE);
		label.setBounds(0, 0, 747, 661);
		contentPane.add(label);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
