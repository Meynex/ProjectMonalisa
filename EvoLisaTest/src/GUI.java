
import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.swing.Icon;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

//import /src/StretchIcon.java;

public class GUI extends JPanel {

	private JFrame frame;
	private static JTextField textFieldOpen;
	private static Thread t1;
	
	private static double OldFitness = 0;
    private static double NewFitness = 0;
    private static boolean interupt=false;
	
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
	private void start() 
	{
		t1 = new Thread(){
			@Override
			public void run(){
			try {
				Compare(textFieldOpen.getText());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			};
		};
		t1.start();
		
	}
	private void stop()
	{
		t1.stop();
	}
		
		
	 
	private void initialize() {
				
	
		frame = new JFrame();
		frame.setBounds(100, 100, 828, 553);					// Set the Size of the Window
		frame.setMinimumSize(new Dimension(828,553));			// Set a fixed MinSize of the Window
		frame.setLocationRelativeTo( null );					// Set Window in the Middle
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Do Exit on the Window Cross
		
		JPanel panel = new JPanel();
		JPanel panel_1 = new JPanel();
		JPanel panel_3 = new JPanel();
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
		splitPane.setResizeWeight(1.0);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel.add(splitPane);
		
		JLayeredPane panel_2 = new JLayeredPane();
		splitPane.setRightComponent(panel_2);
		
		JLabel lblimage1 = new JLabel("Text");
		lblimage1.setHorizontalAlignment(SwingConstants.CENTER);
		lblimage1.setVerticalAlignment(SwingConstants.CENTER);
		
		JLabel lblImage2 = new JLabel("");
		lblImage2.setIcon(null);
		lblImage2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//interupt=false;
				System.out.println("BtnStart Clicked");
				start();
				//frame.add(panel_2.add(new paint()));
				//event start
			}
		});
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stop();
			}
});
			
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
				if(textFieldOpen.getText().isEmpty())System.err.println("\nTextfield is empty.");
				else 
				{
					textFieldOpen.setEditable(false);
					String AbsImg = textFieldOpen.getText();
					//lblimage1.setIcon(Image.ResizeImg(AbsImg,panel_1));
					//StretchIcon StretchImg1 = new StretchIcon(AbsImg);
					//lblimage1.setIcon(new ImageIcon(AbsImg));
					lblimage1.setPreferredSize(panel_1.getPreferredSize());
					lblimage1.setIcon(new StretchIcon(AbsImg,true));
					
				}
			}

		});
		
		JButton btnSave = new JButton("Save");
		
		//panel_1.addComponentListener(new ComponentAdapter());
		
		panel_1.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				lblimage1.setAlignmentY(CENTER_ALIGNMENT);
				lblimage1.setPreferredSize(panel_1.getSize());
				lblimage1.setVerticalAlignment(SwingConstants.CENTER);
				lblimage1.setHorizontalAlignment(SwingConstants.CENTER);
				//lblimage1.setSize(panel_1.getPreferredSize());
				//lblimage1.
			
			}
		});
		
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
						.addComponent(textFieldOpen, GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(42, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(23, Short.MAX_VALUE)
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
					.addGap(30))
		);
		panel_2.setLayout(gl_panel_2);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(.5d);
		splitPane.setLeftComponent(splitPane_1);
		
		
		splitPane_1.setLeftComponent(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 200));
		
						
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(200);
		flowLayout.setHgap(200);
		splitPane_1.setRightComponent(panel_3);
		
		panel_1.add(lblimage1);
		panel_3.add(lblImage2);
		splitPane.setEnabled(false);	// set SPlitPane Divider Fixed //
		splitPane_1.setEnabled(false);	// ****************************//
		
		
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
		//SaveFilePath
		JFileChooser input = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Bilder", "gif", "png", "jpg"); 
       
        //input.setCurrentDirectory();
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
        input.setCurrentDirectory(new File("C:\\Users\\Jan\\git\\ProjectMonalisa\\EvoLisaTest\\src"));
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
        public static void Compare(String PathOri) throws IOException 
  	  {
  		  
  		
  		  //loads the images => should go to external class for final product
//  	      BufferedImage OriImage = ImageIO.read(Main.class.getResource("CompanionCubeOri.png"));
  		  //BufferedImage OriImage = ImageIO.read(new File ("C:\\Users\\Robin\\git\\Meynex\\ProjectMonalisa\\EvoLisaTest\\src\\CompanionCubeOri.png"));
  		  BufferedImage OriImage = ImageIO.read(new File (PathOri));
  		  	  
  	  
  	      // maybe add to Fitness class?
  	      
  	      //initialises the new and old fitness for comparison
  	      //double OldFitness = 0;
  	      //double NewFitness = 0;
  	      
  	      // gets the starting fitness
  	      Fitness f = new Fitness(OriImage);
  	      
  	      f.setImage("C:\\Users\\Jan\\git\\ProjectMonalisa\\EvoLisaTest\\src\\CompanionCubeComp2.png");
  	      NewFitness = f.getFitness();
  	      OldFitness = NewFitness;
  	      System.out.println(NewFitness);

  	      Mutation M = new Mutation();
  	      // gets the fitness for the new image => will be looped in the final version
  	      do{
  	      

  	  
  	    
  	      f.setImage("C:\\Users\\Jan\\git\\ProjectMonalisa\\EvoLisaTest\\src\\CompanionCubeComp.png");
  	      NewFitness = f.getFitness();
  	      
  	      System.out.println(NewFitness);
  	      
  	      // checks if the new fitness is better than the old and if so replaces it.
  	      if(NewFitness < OldFitness)
  	      {
  	    	  System.out.println("improvement.");
  	    	  OldFitness = NewFitness;
  	      }
  	      
  	      
  	      M.Mutate();
  	      }while(!interupt);
  	      
  	    
    }
}