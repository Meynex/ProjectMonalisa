package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TimerTask;

import javax.swing.JLayeredPane;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JFormattedTextField;


public class GUI extends JPanel {

	private JFrame frame;
	private JTextField textFieldOpen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 828, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
		);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel.add(splitPane);
		
		JLayeredPane panel_2 = new JLayeredPane();
		splitPane.setRightComponent(panel_2);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("BtnStart Clicked");
				
				//frame.add(panel_2.add(new paint()));
				//event start
			}
		});
		
		JButton btnStop = new JButton("Stop");
		
		textFieldOpen = new JTextField();
		textFieldOpen.setColumns(10);
		
		JButton btnPause = new JButton("Pause");
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldOpen.setText(FileOpenDialog());
				Image StartImg = new Image(textFieldOpen.getText());
				//TODO/panel.add(StartImg);
				
			}
		});
		
		JButton btnSave = new JButton("Save");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnPause, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnStart, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnStop, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnOpen)
						.addComponent(btnSave))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldOpen, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(42, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnStart)
						.addComponent(textFieldOpen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOpen)
						.addComponent(btnStop))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPause)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSave))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.0);
		splitPane.setLeftComponent(splitPane_1);
		
		JPanel panel_1 = new JPanel();
		splitPane_1.setLeftComponent(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 200));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(200);
		flowLayout.setHgap(200);
		splitPane_1.setRightComponent(panel_3);
		frame.getContentPane().setLayout(groupLayout);
	}
	public void paint(Graphics g) {
	    super.paint(g);
	    Graphics2D g2d = (Graphics2D) g;
	    for (int i = 1; i <= 10; i++) {
	      g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, i * 0.1f));
	      g2d.fillRect(50 * i, 20, 50, 50);
	    }
	  }
	public static String FileSaveDialog()
    {
		//TODO////
		/////////
		JFileChooser input = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Bilder", "gif", "png", "jpg"); 
       
        input.setFileFilter(filter);
        input.setAcceptAllFileFilterUsed(false);
        int result1 = input.showOpenDialog(input);
        if (result1 == JFileChooser.APPROVE_OPTION) {
        	System.out.println("Apply was Selected");
            return input.getSelectedFile().getAbsolutePath();
        } else if (result1 == JFileChooser.CANCEL_OPTION) {
            System.out.println("Cancel was selected");
            return null;
        }
        else {
        	
        	return null;
        }
    }
	public static String FileOpenDialog()
    {
		/*
        // Erstellung unseres FileFilters für Bilddateien
        FileFilter filter = new FileNameExtensionFilter("Bilder", "gif", "png", "jpg");         
        JFileChooser chooser = new JFileChooser("c:/programmierung/beispieldateien");
        // Filter wird unserem JFileChooser hinzugefügt
        chooser.addChoosableFileFilter(filter);
        JFileChooser.setDefaultLocale(getDefaultLocale());
        int result = chooser.
        // Erzeugung eines neuen Frames mit dem Titel "Dateiauswahl"
        JFrame meinJFrame = new JFrame("Dateiauswahl");
        // Wir setzen die Breite auf 450 und die Höhe auf 300 Pixel
        meinJFrame.setSize(450,300);
        // Hole dir den ContentPane und füge diesem unseren JColorChooser hinzu
        meinJFrame.getContentPane().add(chooser);
        // Wir lassen unseren Frame anzeigen
        meinJFrame.setVisible(true);*/
        //chooser.		
        JFileChooser input = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Bilder", "gif", "png", "jpg"); 
        input.setFileFilter(filter);
        input.setAcceptAllFileFilterUsed(false);
        int result1 = input.showOpenDialog(input);
        if (result1 == JFileChooser.APPROVE_OPTION) {
        	System.out.println("Apply was Selected");
            return input.getSelectedFile().getAbsolutePath();
        } else if (result1 == JFileChooser.CANCEL_OPTION) {
            System.out.println("Cancel was selected");
            return null;
        }
        else {
        	
        	return null;
        }
    }
        public class Image{
        
        public Image(String text) {
				// TODO Auto-generated constructor stub
			}

		public BufferedImage Read(String AbsPath){
        try
        {
            BufferedImage picture = ImageIO.read(new File(AbsPath));
        
            return picture;
        }
        catch (IOException e)
        {
            String workingDir = System.getProperty("user.dir");
            System.out.println("Current working directory : " + workingDir);
            e.printStackTrace();
        }
        return null;
        }
    }
	}
