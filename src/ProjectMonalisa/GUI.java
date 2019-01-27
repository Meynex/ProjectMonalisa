package ProjectMonalisa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

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
import java.awt.BorderLayout;
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
	public void run() {
		//frame.
	}
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
				run();
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
				
				//jf
				/*Image StartImg = new Image(textFieldOpen.getText());
				JLabel Jl1 = new JLabel();
				Jl1.setIcon(StartImg);
				
				frame.getContentPane().add(Jl1, BorderLayout.CENTER);
				//TODO/panel.add(StartImg);*/
				String AbsImg = textFieldOpen.getText();
				try {
					Image.DisplayImage(AbsImg);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
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
    public static class Image{

        
        public Image() {
				// TODO Auto-generated constructor stub
        	String AbsPath = null;
        	String Name = "";
        	
			}

		public BufferedImage getBufImg(String AbsPath){
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
		
		public static void DisplayImage(String AbsPath) throws IOException
	    {
	        BufferedImage img=ImageIO.read(new File(AbsPath));
	        ImageIcon icon=new ImageIcon(img);
	        JFrame frame=new JFrame();
	        frame.setLayout(new FlowLayout());
	        frame.setSize(200,300);
	        JLabel lbl=new JLabel();
	        lbl.setIcon(icon);
	        frame.add(lbl);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
		
		public static void ResizeAbs(String inputImagePath,
	            String outputImagePath, int scaledWidth, int scaledHeight)
	            throws IOException {
	        // reads input image
	        File inputFile = new File(inputImagePath);
	        BufferedImage inputImage = ImageIO.read(inputFile);
	 
	        // creates output image
	        BufferedImage outputImage = new BufferedImage(scaledWidth,
	                scaledHeight, inputImage.getType());
	 
	        // scales the input image to the output image
	        Graphics2D g2d = outputImage.createGraphics();
	        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
	        g2d.dispose();
	 
	        // extracts extension of output file
	        String formatName = outputImagePath.substring(outputImagePath
	                .lastIndexOf(".") + 1);
	 
	        // writes to output file
	        ImageIO.write(outputImage, formatName, new File(outputImagePath));
	    }
	 
	    /**
	     * Resizes an image by a percentage of original size (proportional).
	     * @param inputImagePath Path of the original image
	     * @param outputImagePath Path to save the resized image
	     * @param percent a double number specifies percentage of the output image
	     * over the input image.
	     * @throws IOException
	     */
	    public static void ResizePer(String inputImagePath,
	            String outputImagePath, double percent) throws IOException {
	        File inputFile = new File(inputImagePath);
	        BufferedImage inputImage = ImageIO.read(inputFile);
	        int scaledWidth = (int) (inputImage.getWidth() * percent);
	        int scaledHeight = (int) (inputImage.getHeight() * percent);
	        resize(inputImagePath, outputImagePath, scaledWidth, scaledHeight);
	    }
    }
    
}