/*
 * Donavie Ordonez, Dennis Tye, Kenneth Doan
 * Final Project - Enneagram Test
 * This program is an Enneagram test that 
 * allows users to select one of two choices
 * depending on which statement they relate 
 * to the most. This program calculates the percent
 * match the user is to each Enneagram type 
 * and provides the user with descriptions 
 * of each enneagram type.
 */
 
 /*
   Copyright 2020 Donavie Ordonez, Dennis Tye, Kenneth Doan

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class enneagramTest extends JFrame implements ActionListener, ItemListener {

	// dimensions for the JFrame
	final int FRAME_WIDTH = 700, FRAME_HEIGHT = 700;
	
	// Fonts used for JLabels and JButtons
	Font courierNewFont = new Font("Courier New", Font.BOLD, 21), 
		 courierNewFontMed = new Font("Courier New", Font.BOLD, 17),
		 courierNewItalic = new Font("Courier New", Font.ITALIC, 14);
	
	// Initializing Buttons 
	JButton takeTest = new JButton("Take the Test"),
			
			// Next Buttons
			next1 = new JButton ("Next"), next2 = new JButton ("Next"), next3 = new JButton ("Next"),
			next4 = new JButton ("Next"), next5 = new JButton ("Next"), next6 = new JButton ("View My Results"),
			
			// Previous Buttons
			prev1 = new JButton ("Previous"), prev2 = new JButton ("Previous"), prev3 = new JButton ("Previous"),
			prev4 = new JButton ("Previous"), prev5 = new JButton ("Previous"), prev6 = new JButton ("Previous"),
			prev7 = new JButton ("Go Back to Results Page"), prev8 = new JButton ("Go Back to Results Page"),
			prev9 = new JButton ("Go Back to Results Page"), prev10 = new JButton ("Go Back to Results Page"),
			prev11 = new JButton ("Go Back to Results Page"), prev12 = new JButton ("Go Back to Results Page"),
			prev13 = new JButton ("Go Back to Results Page"), prev14 = new JButton ("Go Back to Results Page"),
			prev15 = new JButton ("Go Back to Results Page"), prev16 = new JButton ("Cancel"),
			
			// email panel buttons
			email1 = new JButton ("Send Results by E-Mail"),
			email2 = new JButton ("Send Results by E-Mail"),
			email3 = new JButton ("Send Results by E-Mail"),
			email4 = new JButton ("Send Results by E-Mail"),
			email5 = new JButton ("Send Results by E-Mail"),
			email6 = new JButton ("Send Results by E-Mail"),
			email7 = new JButton ("Send Results by E-Mail"),
			email8 = new JButton ("Send Results by E-Mail"),
			email9 = new JButton ("Send Results by E-Mail"),
			
			// send email button
			sendEmail = new JButton ("Send E-Mail"),
			
			// Buttons to go to type description
			reformer = new JButton("The Reformer"), helper = new JButton("The Helper"), 
			achiever = new JButton("The Achiever"), individualist = new JButton("The Individualist"),
			investigator = new JButton("The Investigator"), loyalist = new JButton("The Loyalist"),
			enthusiast = new JButton("The Enthusiast"), challenger = new JButton("The Challenger"), 
			peacemaker = new JButton("The Peacemaker");
	
	// Initializing intro label
	JLabel intro;
	
	// Initializing intro textArea
	JTextArea desc = new JTextArea();
	
	// Initialing JPanels
	JPanel introPage = new JPanel(), 
		   introPageNorth = new JPanel(new FlowLayout()), introPageCenter = new JPanel(new GridLayout(2,1)),
		   introPageSouth = new JPanel(new GridLayout(1,1)), introPageImage = new JPanel(new FlowLayout()),
		   
		   // Panels to add the questions to 
		   page1 = new JPanel(), page2 = new JPanel(), page3 = new JPanel(),
		   page4 = new JPanel(), page5 = new JPanel(), page6 = new JPanel(),
		   
		   // Panels to add descriptions to each enneagram type
		   type1 = new JPanel(new FlowLayout()), type2 = new JPanel(new FlowLayout()), type3 = new JPanel(new FlowLayout()),
		   type4 = new JPanel(new FlowLayout()), type5 = new JPanel(new FlowLayout()), type6 = new JPanel(new FlowLayout()),
		   type7 = new JPanel(new FlowLayout()), type8 = new JPanel(new FlowLayout()), type9 = new JPanel(new FlowLayout()),
		   
		   // Panel to add results to
		   resultPanel = new JPanel(),
		   
		   // email panel
		   emailPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, (int)(FRAME_WIDTH/3), (int)(FRAME_HEIGHT/4))),
		   // panel to incorporate the "Send E-mail" and "Cancel" buttons together for emailPanel
		   emailOptionsPanel = new JPanel(new GridLayout(1,2,(int)(FRAME_WIDTH/10)-5,0)),
		   
		   // Panels to add to resultPanel
		   oneResult = new JPanel(new GridLayout(2,1)), twoResult = new JPanel(new GridLayout(2,1)), 
		   threeResult = new JPanel(new GridLayout(2,1)), fourResult = new JPanel(new GridLayout(2,1)), 
		   fiveResult = new JPanel(new GridLayout(2,1)), sixResult = new JPanel(new GridLayout(2,1)),
		   sevenResult = new JPanel(new GridLayout(2,1)), eightResult = new JPanel(new GridLayout(2,1)), 
		   nineResult = new JPanel(new GridLayout(2,1));
	
	// Initializing images of the enneagram type descriptions
	ImageIcon one_reformer = new ImageIcon("resources/Images/type_1_reformer.png"),
			  two_helper = new ImageIcon("resources/Images/type_2_helper.png"),
			  three_achiever = new ImageIcon("resources/Images/type_3_achiever.png"),
			  four_individualist = new ImageIcon("resources/Images/type_4_individualist.png"),
			  five_investigator = new ImageIcon("resources/Images/type_5_investigator.png"),
			  six_loyalist = new ImageIcon("resources/Images/type_6_loyalist.png"),
			  seven_enthusiast = new ImageIcon("resources/Images/type_7_enthusiast.png"),
			  eight_challenger = new ImageIcon("resources/Images/type_8_challenger.png"),
			  nine_peacemaker = new ImageIcon("resources/Images/type_9_peacemaker.png"),
			  enneagram_map = new ImageIcon("resources/Images/enneagram_map.jpg");
	
	// Initilizing labels that will hold the percent 
	// match of the user's enneagram type
	JLabel oneLabel = new JLabel(), twoLabel = new JLabel(), threeLabel = new JLabel(), 
		   fourLabel = new JLabel(), fiveLabel = new JLabel(), sixLabel = new JLabel(),
		   sevenLabel = new JLabel(), eightLabel = new JLabel(), nineLabel = new JLabel(),
		   
	       // Initializing label for Enneagram Map image
		   enneagramMapLabel = new JLabel(),
		   
		   // Initializing labels for holding the % match
		   // results of each type
		   typeOnePercentage, typeTwoPercentage, typeThreePercentage, 
	       typeFourPercentage, typeFivePercentage, typeSixPercentage, 
	       typeSevenPercentage, typeEightPercentage, typeNinePercentage;
	
	// Initializing doubles
	double typeOnePercent, typeTwoPercent, typeThreePercent, 
	       typeFourPercent, typeFivePercent, typeSixPercent,
	       typeSevenPercent, typeEightPercent, typeNinePercent,
	       type1Total = 0.0, type2Total = 0.0, type3Total = 0.0, 
		   type4Total = 0.0, type5Total = 0.0, type6Total = 0.0,
		   type7Total = 0.0, type8Total = 0.0, type9Total = 0.0;
	
	// Initializing integers that will parse 
	// the doubles to ints
	int t1, t2, t3, t4, t5, t6, t7, t8, t9;
	
	// Initializing JCheckBoxes
	JCheckBox a1 = new JCheckBox("A"), a2 = new JCheckBox("A"), a3 = new JCheckBox("A"),
			  a4 = new JCheckBox("A"), a5 = new JCheckBox("A"), a6 = new JCheckBox("A"),
			  a7 = new JCheckBox("A"), a8 = new JCheckBox("A"), a9 = new JCheckBox("A"),
			  a10 = new JCheckBox("A"), a11 = new JCheckBox("A"), a12 = new JCheckBox("A"),
			  a13 = new JCheckBox("A"), a14 = new JCheckBox("A"), a15 = new JCheckBox("A"),
			  a16 = new JCheckBox("A"), a17 = new JCheckBox("A"), a18 = new JCheckBox("A"),
			  a19 = new JCheckBox("A"), a20 = new JCheckBox("A"), a21 = new JCheckBox("A"), 
			  a22 = new JCheckBox("A"), a23 = new JCheckBox("A"), a24 = new JCheckBox("A"),
			  a25 = new JCheckBox("A"), a26 = new JCheckBox("A"), a27 = new JCheckBox("A"),
			  a28 = new JCheckBox("A"), a29 = new JCheckBox("A"), a30 = new JCheckBox("A"),
			  a31 = new JCheckBox("A"), a32 = new JCheckBox("A"), a33 = new JCheckBox("A"),
			  a34 = new JCheckBox("A"), a35 = new JCheckBox("A"), a36 = new JCheckBox("A"),
			  b1 = new JCheckBox("B"), b2 = new JCheckBox("B"), b3 = new JCheckBox("B"),
			  b4 = new JCheckBox("B"), b5 = new JCheckBox("B"), b6 = new JCheckBox("B"),
			  b7 = new JCheckBox("B"), b8 = new JCheckBox("B"), b9 = new JCheckBox("B"),
			  b10 = new JCheckBox("B"), b11 = new JCheckBox("B"), b12 = new JCheckBox("B"),
			  b13 = new JCheckBox("B"), b14 = new JCheckBox("B"), b15 = new JCheckBox("B"),
			  b16 = new JCheckBox("B"), b17 = new JCheckBox("B"), b18 = new JCheckBox("B"),
			  b19 = new JCheckBox("B"), b20 = new JCheckBox("B"), b21 = new JCheckBox("B"), 
			  b22 = new JCheckBox("B"), b23 = new JCheckBox("B"), b24 = new JCheckBox("B"),
			  b25 = new JCheckBox("B"), b26 = new JCheckBox("B"), b27 = new JCheckBox("B"),
			  b28 = new JCheckBox("B"), b29 = new JCheckBox("B"), b30 = new JCheckBox("B"),
			  b31 = new JCheckBox("B"), b32 = new JCheckBox("B"), b33 = new JCheckBox("B"),
			  b34 = new JCheckBox("B"), b35 = new JCheckBox("B"), b36 = new JCheckBox("B");
	
	// Initializing ButtonGroups
	ButtonGroup q1 = new ButtonGroup(), q2 = new ButtonGroup(), q3 = new ButtonGroup(),
			    q4 = new ButtonGroup(), q5 = new ButtonGroup(), q6 = new ButtonGroup(),
			    q7 = new ButtonGroup(), q8 = new ButtonGroup(), q9 = new ButtonGroup(),
			    q10 = new ButtonGroup(), q11 = new ButtonGroup(), q12 = new ButtonGroup(),
			    q13 = new ButtonGroup(), q14 = new ButtonGroup(), q15 = new ButtonGroup(),
			    q16 = new ButtonGroup(), q17 = new ButtonGroup(), q18 = new ButtonGroup(),
			    q19 = new ButtonGroup(), q20 = new ButtonGroup(), q21 = new ButtonGroup(), 
			    q22 = new ButtonGroup(), q23 = new ButtonGroup(), q24 = new ButtonGroup(),
			    q25 = new ButtonGroup(), q26 = new ButtonGroup(), q27 = new ButtonGroup(),
			    q28 = new ButtonGroup(), q29 = new ButtonGroup(), q30 = new ButtonGroup(),
			    q31 = new ButtonGroup(), q32 = new ButtonGroup(), q33 = new ButtonGroup(),
			    q34 = new ButtonGroup(), q35 = new ButtonGroup(), q36 = new ButtonGroup();
	
	// Initializing JTextField for user-inputted email
    JTextField recipientField = new JTextField("Enter your email here.", 25);
	
    JTextArea emailButtonStatus = new JTextArea();
    
	// Creating my own colors for backgrounds
	Color lavender = new Color(230,230,250), darkPurple = new Color(148,0,211),
		  cornFlowerBlue = new Color(100,149,237), hotPink = new Color(255,105,180);
	
	// Initializing CardLayout
	CardLayout cards = new CardLayout();
	
	public enneagramTest() {
		
		// Settings for the JFrame
		super("What's My Enneagram Type?");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		// Scaling the images 
		Image oneTransform = one_reformer.getImage().getScaledInstance(600, 600, java.awt.Image.SCALE_SMOOTH),
			  twoTransform = two_helper.getImage().getScaledInstance(600, 600, java.awt.Image.SCALE_SMOOTH),
			  threeTransform = three_achiever.getImage().getScaledInstance(600, 600, java.awt.Image.SCALE_SMOOTH),
			  fourTransform = four_individualist.getImage().getScaledInstance(600, 600, java.awt.Image.SCALE_SMOOTH),
			  fiveTransform = five_investigator.getImage().getScaledInstance(600, 600, java.awt.Image.SCALE_SMOOTH),
			  sixTransform = six_loyalist.getImage().getScaledInstance(600, 600, java.awt.Image.SCALE_SMOOTH),
			  sevenTransform = seven_enthusiast.getImage().getScaledInstance(600, 600, java.awt.Image.SCALE_SMOOTH),
			  eightTransform = eight_challenger.getImage().getScaledInstance(600, 600, java.awt.Image.SCALE_SMOOTH),
			  nineTransform = nine_peacemaker.getImage().getScaledInstance(600, 600, java.awt.Image.SCALE_SMOOTH),
			  mapTransform = enneagram_map.getImage().getScaledInstance(400, 290, java.awt.Image.SCALE_SMOOTH);
		
		// Setting the images into labels
		oneLabel.setIcon(new ImageIcon(oneTransform));
		twoLabel.setIcon(new ImageIcon(twoTransform));
		threeLabel.setIcon(new ImageIcon(threeTransform));
		fourLabel.setIcon(new ImageIcon(fourTransform));
		fiveLabel.setIcon(new ImageIcon(fiveTransform));
		sixLabel.setIcon(new ImageIcon(sixTransform));
		sevenLabel.setIcon(new ImageIcon(sevenTransform));
		eightLabel.setIcon(new ImageIcon(eightTransform));
		nineLabel.setIcon(new ImageIcon(nineTransform));
		enneagramMapLabel.setIcon(new ImageIcon(mapTransform));
		
		// Label and text to add to intro panel
		intro = new JLabel("The Enneagram Test");
		intro.setFont(new Font("Courier New", Font.BOLD, 20));
		desc.setText("The Enneagram is a system of personality typing that describes patterns in how "
				   + "\npeople conceptualize the world and manage their emotions. The Enneagram "
				   + "\ndescribes nine different personality types and maps each of these types on "
				   + "\na nine-pointed diagram. According to Enneagram, every personality has a "
				   + "\nparticular world view, looking at the world through their own lens. This makes "
				   + "\nit possible to explain why people behave in specific ways. By describing "
				   + "\nhow the basic personality adapts and responds to both stressful and "
				   + "\nsupportive situations, the Enneagram shows opportunities for "
				   + "\npersonal development.\r\n\n"
				   + "This test consists of a total of 36 questions. You'll select one statement "
				   + "\nbetween two that describes you the most. After completing the test, you will be "
				   + "\nable to view the results of how much percent match you are to each Enneagram "
				   + "\ntype. You then can browse around and look at the descriptions of each type.\r\n\n" 
				   + "To receive the most accurate results, select one answer once and be as honest "
				   + "\nas possible with your answers!!");
		desc.setEditable(false);
		desc.setFont(courierNewItalic);
		
		emailButtonStatus.setText("Status: Ready to send");
		emailButtonStatus.setEditable(false);
		emailButtonStatus.setFont(courierNewItalic);

		// Default JLabels for the type percentages 
		typeOnePercentage = new JLabel("Type 1: % match");
		typeTwoPercentage = new JLabel("Type 2: % match");
		typeThreePercentage = new JLabel("Type 3: % match");
		typeFourPercentage = new JLabel("Type 4: % match");
		typeFivePercentage = new JLabel("Type 5: % match");
		typeSixPercentage = new JLabel("Type 6: % match");
		typeSevenPercentage = new JLabel("Type 7: % match");
		typeEightPercentage = new JLabel("Type 8: % match");
		typeNinePercentage = new JLabel("Type 9: % match");
		
		// Setting the font for type percentages
		typeOnePercentage.setFont(courierNewFont);
		typeTwoPercentage.setFont(courierNewFont);
		typeThreePercentage.setFont(courierNewFont);
		typeFourPercentage.setFont(courierNewFont);
		typeFivePercentage.setFont(courierNewFont);
		typeSixPercentage.setFont(courierNewFont);
		typeSevenPercentage.setFont(courierNewFont);
		typeEightPercentage.setFont(courierNewFont);
		typeNinePercentage.setFont(courierNewFont);
		
		// Adding ActionListener to the buttons 
		takeTest.addActionListener(this);
		next1.addActionListener(this);
		next2.addActionListener(this);
		next3.addActionListener(this);
		next4.addActionListener(this);
		next5.addActionListener(this);
		next6.addActionListener(this);
		prev1.addActionListener(this);
		prev2.addActionListener(this);
		prev3.addActionListener(this);
		prev4.addActionListener(this);
		prev5.addActionListener(this);
		prev6.addActionListener(this);
		
		// Buttons to go back to result page
		prev7.addActionListener(this);
		prev8.addActionListener(this);
		prev9.addActionListener(this);
		prev10.addActionListener(this);
		prev11.addActionListener(this);
		prev12.addActionListener(this);
		prev13.addActionListener(this);
		prev14.addActionListener(this);
		prev15.addActionListener(this);
		prev16.addActionListener(this);
		
		// Buttons to go to the email panel
		email1.addActionListener(this);
		email2.addActionListener(this);
		email3.addActionListener(this);
		email4.addActionListener(this);
		email5.addActionListener(this);
		email6.addActionListener(this);
		email7.addActionListener(this);
		email8.addActionListener(this);
		email9.addActionListener(this);
		
		// Button for sending an email
		sendEmail.addActionListener(this);
		
		// Field for receiving recipient email
		recipientField.addActionListener(this);
		
		// Buttons that lead to type descriptions 
		reformer.addActionListener(this);
		helper.addActionListener(this);
		achiever.addActionListener(this);
		individualist.addActionListener(this);
		investigator.addActionListener(this);
		loyalist.addActionListener(this);
		enthusiast.addActionListener(this);
		challenger.addActionListener(this);
		peacemaker.addActionListener(this);
		
		// Setting font for buttons 
		takeTest.setFont(courierNewFont);
		next1.setFont(courierNewFont);
		next2.setFont(courierNewFont);
		next3.setFont(courierNewFont);
		next4.setFont(courierNewFont);
		next5.setFont(courierNewFont);
		next6.setFont(courierNewFont);
		prev1.setFont(courierNewFont);
		prev2.setFont(courierNewFont);
		prev3.setFont(courierNewFont);
		prev4.setFont(courierNewFont);
		prev5.setFont(courierNewFont);
		prev6.setFont(courierNewFont);
		prev7.setFont(courierNewFont);
		prev8.setFont(courierNewFont);
		prev9.setFont(courierNewFont);
		prev10.setFont(courierNewFont);
		prev11.setFont(courierNewFont);
		prev12.setFont(courierNewFont);
		prev13.setFont(courierNewFont);
		prev14.setFont(courierNewFont);
		prev15.setFont(courierNewFont);
		prev16.setFont(courierNewFont);
		email1.setFont(courierNewFont);
		email2.setFont(courierNewFont);
		email3.setFont(courierNewFont);
		email4.setFont(courierNewFont);
		email5.setFont(courierNewFont);
		email6.setFont(courierNewFont);
		email7.setFont(courierNewFont);
		email8.setFont(courierNewFont);
		email9.setFont(courierNewFont);
		sendEmail.setFont(courierNewFont);
		reformer.setFont(courierNewFont);
		helper.setFont(courierNewFont);
		achiever.setFont(courierNewFont);
		individualist.setFont(courierNewFontMed);
		investigator.setFont(courierNewFontMed);
		loyalist.setFont(courierNewFont);
		enthusiast.setFont(courierNewFont);
		challenger.setFont(courierNewFont);
		peacemaker.setFont(courierNewFont);
		
		// Setting layout of introPage panel
		introPage.setLayout(new BorderLayout());
		
		// adding elements into panels that'll be
		// added into introPage panel
		introPageNorth.add(intro);
		introPageCenter.setLayout(new GridLayout(2,1,1,1));
		introPageCenter.add(desc);
		introPageImage.add(enneagramMapLabel);
		introPageImage.setBackground(Color.WHITE);
		introPageCenter.add(introPageImage);
		introPageSouth.add(takeTest);
		
		// Setting the card layout so cards can be used
		setLayout(cards);
		
		// Adding elements into introPage panel to 
		// specific areas. Then adding to card "introP"
		introPage.add(introPageNorth, BorderLayout.NORTH);
		introPage.add(introPageCenter, BorderLayout.CENTER);
		introPage.add(introPageSouth, BorderLayout.SOUTH);
		introPage.setBackground(Color.WHITE);
		add(introPage, "introP");
		
		// Making object of typeAnswers 
		// class so it can be used
		typeAnswers ans = new typeAnswers();
		
		// Setting layout of page1 panel
		// and adding elements into panel
		page1.setLayout(new GridLayout(13,2,2,2));
		page1.add(typeAnswers.type4_1);
		page1.add(typeAnswers.type6_1);
		page1.add(a1);
		page1.add(b1);
		page1.add(typeAnswers.type8_1);
		page1.add(typeAnswers.type9_1);
		page1.add(a2);
		page1.add(b2);
		page1.add(typeAnswers.type3_1);
		page1.add(typeAnswers.type1_1);
		page1.add(a3);
		page1.add(b3);
		page1.add(typeAnswers.type5_1);
		page1.add(typeAnswers.type7_1);
		page1.add(a4);
		page1.add(b4);
		page1.add(typeAnswers.type2_1);
		page1.add(typeAnswers.type4_2);
		page1.add(a5);
		page1.add(b5);
		page1.add(typeAnswers.type6_2);
		page1.add(typeAnswers.type9_2);
		page1.add(a6);
		page1.add(b6);
		page1.add(prev1);
		page1.add(next1);
		page1.setBackground(Color.YELLOW);
		add(page1, "questionsPage1");
		
		// Setting layout of page2 panel
		// and adding elements into panel
		page2.setLayout(new GridLayout(13,2,2,2));
		page2.add(typeAnswers.type8_2);
		page2.add(typeAnswers.type1_2);
		page2.add(a7);
		page2.add(b7);
		page2.add(typeAnswers.type2_2);
		page2.add(typeAnswers.type5_2);
		page2.add(a8);
		page2.add(b8);
		page2.add(typeAnswers.type3_2);
		page2.add(typeAnswers.type7_2);
		page2.add(a9);
		page2.add(b9);
		page2.add(typeAnswers.type4_3);
		page2.add(typeAnswers.type9_3);
		page2.add(a10);
		page2.add(b10);
		page2.add(typeAnswers.type5_3);
		page2.add(typeAnswers.type8_3);
		page2.add(a11);
		page2.add(b11);
		page2.add(typeAnswers.type6_3);
		page2.add(typeAnswers.type1_3);
		page2.add(a12);
		page2.add(b12);
		page2.add(prev2);
		page2.add(next2);
		page2.setBackground(darkPurple);
		add(page2,"questionsPage2");
		
		// Setting layout of page3 panel
		// and adding elements into panel
		page3.setLayout(new GridLayout(13,2,2,2));
		page3.add(typeAnswers.type2_3);
		page3.add(typeAnswers.type3_3);
		page3.add(a13);
		page3.add(b13);
		page3.add(typeAnswers.type4_4);
		page3.add(typeAnswers.type7_3);
		page3.add(a14);
		page3.add(b14);
		page3.add(typeAnswers.type5_4);
		page3.add(typeAnswers.type1_4);
		page3.add(a15);
		page3.add(b15);
		page3.add(typeAnswers.type6_4);
		page3.add(typeAnswers.type8_4);
		page3.add(a16);
		page3.add(b16);
		page3.add(typeAnswers.type9_4);
		page3.add(typeAnswers.type2_4);
		page3.add(a17);
		page3.add(b17);
		page3.add(typeAnswers.type3_4);
		page3.add(typeAnswers.type4_5);
		page3.add(a18);
		page3.add(b18);
		page3.add(prev3);
		page3.add(next3);
		page3.setBackground(Color.GREEN.darker());
		add(page3, "questionsPage3");
		
		// Setting layout of page4 panel
		// and adding elements into panel
		page4.setLayout(new GridLayout(13,2,2,2));
		page4.add(typeAnswers.type6_5);
		page4.add(typeAnswers.type7_4);
		page4.add(a19);
		page4.add(b19);
		page4.add(typeAnswers.type2_5);
		page4.add(typeAnswers.type1_5);
		page4.add(a20);
		page4.add(b20);
		page4.add(typeAnswers.type8_5);
		page4.add(typeAnswers.type3_5);
		page4.add(a21);
		page4.add(b21);
		page4.add(typeAnswers.type5_5);
		page4.add(typeAnswers.type9_5);
		page4.add(a22);
		page4.add(b22);
		page4.add(typeAnswers.type6_6);
		page4.add(typeAnswers.type2_6);
		page4.add(a23);
		page4.add(b23);
		page4.add(typeAnswers.type7_5);
		page4.add(typeAnswers.type8_6);
		page4.add(a24);
		page4.add(b24);
		page4.add(prev4);
		page4.add(next4);
		page4.setBackground(Color.ORANGE);
		add(page4,"questionsPage4");
		
		// Setting layout of page5 panel
		// and adding elements into panel
		page5.setLayout(new GridLayout(13,2,2,2));
		page5.add(typeAnswers.type4_6);
		page5.add(typeAnswers.type1_6);
		page5.add(a25);
		page5.add(b25);
		page5.add(typeAnswers.type9_6);
		page5.add(typeAnswers.type7_6);
		page5.add(a26);
		page5.add(b26);
		page5.add(typeAnswers.type6_7);
		page5.add(typeAnswers.type3_6);
		page5.add(a27);
		page5.add(b27);
		page5.add(typeAnswers.type5_6);
		page5.add(typeAnswers.type4_7);
		page5.add(a28);
		page5.add(b28);
		page5.add(typeAnswers.type8_7);
		page5.add(typeAnswers.type2_7);
		page5.add(a29);
		page5.add(b29);
		page5.add(typeAnswers.type7_7);
		page5.add(typeAnswers.type1_7);
		page5.add(a30);
		page5.add(b30);
		page5.add(prev5);
		page5.add(next5);
		page5.setBackground(hotPink);
		add(page5,"questionsPage5");
		
		// Setting layout of page6 panel
		// and adding elements into panel
		page6.setLayout(new GridLayout(13,2,2,2));
		page6.add(typeAnswers.type9_7);
		page6.add(typeAnswers.type3_7);
		page6.add(a31);
		page6.add(b31);
		page6.add(typeAnswers.type5_7);
		page6.add(typeAnswers.type6_8);
		page6.add(a32);
		page6.add(b32);
		page6.add(typeAnswers.type4_8);
		page6.add(typeAnswers.type8_8);
		page6.add(a33);
		page6.add(b33);
		page6.add(typeAnswers.type9_8);
		page6.add(typeAnswers.type1_8);
		page6.add(a34);
		page6.add(b34);
		page6.add(typeAnswers.type7_8);
		page6.add(typeAnswers.type2_8);
		page6.add(a35);
		page6.add(b35);
		page6.add(typeAnswers.type3_8);
		page6.add(typeAnswers.type5_8);
		page6.add(a36);
		page6.add(b36);
		page6.add(prev6);
		page6.add(next6);
		page6.setBackground(cornFlowerBlue);
		add(page6, "questionsPage6");
		
		// Adding the percentage match the user is to the 
		// specific type, a button of the type, and 
		// setting the background to the panels
		oneResult.add(typeOnePercentage);
		oneResult.setBackground(Color.GRAY);
		oneResult.add(reformer);
		
		twoResult.add(typeTwoPercentage);
		twoResult.setBackground(lavender);
		twoResult.add(helper);
		
		threeResult.add(typeThreePercentage);
		threeResult.setBackground(darkPurple);
		threeResult.add(achiever);
		
		fourResult.add(typeFourPercentage);
		fourResult.setBackground(cornFlowerBlue);
		fourResult.add(individualist);
		
		fiveResult.add(typeFivePercentage);
		fiveResult.setBackground(Color.GREEN.darker());
		fiveResult.add(investigator);
		
		sixResult.add(typeSixPercentage);
		sixResult.setBackground(Color.YELLOW);
		sixResult.add(loyalist);
		
		sevenResult.add(typeSevenPercentage);
		sevenResult.setBackground(Color.ORANGE);
		sevenResult.add(enthusiast);
		
		eightResult.add(typeEightPercentage);
		eightResult.setBackground(Color.RED);
		eightResult.add(challenger);
		
		nineResult.add(typeNinePercentage);
		nineResult.setBackground(hotPink);
		nineResult.add(peacemaker);
		
		// Setting layout of result panel
		// adding the type result panels to resultPanel
		resultPanel.setLayout(new GridLayout(3,3,1,1));
		resultPanel.add(oneResult);
		resultPanel.add(twoResult);
		resultPanel.add(threeResult);
		resultPanel.add(fourResult);
		resultPanel.add(fiveResult);
		resultPanel.add(sixResult);
		resultPanel.add(sevenResult);
		resultPanel.add(eightResult);
		resultPanel.add(nineResult);
		add(resultPanel, "results");
		
		// Adding the result labels to type 1-9 panels 
		// and setting the background for each
		type1.add(oneLabel);
		type1.add(prev7);
		type1.add(email1);
		type1.setBackground(Color.GRAY);
		add(type1, "type1Result");
		
		type2.add(twoLabel);
		type2.add(prev8);
		type2.add(email2);
		type2.setBackground(lavender);
		add(type2, "type2Result");
		
		type3.add(threeLabel);
		type3.add(prev9);
		type3.add(email3);
		type3.setBackground(darkPurple);
		add(type3, "type3Result");
		
		type4.add(fourLabel);
		type4.add(prev10);
		type4.add(email4);
		type4.setBackground(cornFlowerBlue);
		add(type4, "type4Result");
		
		type5.add(fiveLabel);
		type5.add(prev11);
		type5.add(email5);
		type5.setBackground(Color.GREEN.darker());
		add(type5, "type5Result");
		
		type6.add(sixLabel);
		type6.add(prev12);
		type6.add(email6);
		type6.setBackground(Color.YELLOW);
		add(type6, "type6Result");
		
		type7.add(sevenLabel);
		type7.add(prev13);
		type7.add(email7);
		type7.setBackground(Color.ORANGE);
		add(type7, "type7Result");
		
		type8.add(eightLabel);
		type8.add(prev14);
		type8.add(email8);
		type8.setBackground(Color.RED);
		add(type8, "type8Result");
		
		type9.add(nineLabel);
		type9.add(prev15);
		type9.add(email9);
		type9.setBackground(hotPink);
		add(type9, "type9Result");
		
		//emailPanel.add(label);
		emailOptionsPanel.add(sendEmail);
		emailOptionsPanel.add(prev16);
		emailOptionsPanel.setBackground(Color.WHITE); // makes the default horizontal gap colour (i.e. grey) between the two buttons to match with the rest of the email panel 
		emailPanel.add(recipientField);
		emailPanel.add(emailOptionsPanel);
		emailPanel.add(emailButtonStatus);
		emailPanel.setBackground(Color.WHITE);
		add(emailPanel, "emailResult");
		
		// Adding itemListener for each checkbox
		a1.addItemListener(this);
		a2.addItemListener(this);
		a3.addItemListener(this);
		a4.addItemListener(this);
		a5.addItemListener(this);
		a6.addItemListener(this);
		a7.addItemListener(this);
		a8.addItemListener(this);
		a9.addItemListener(this);
		a10.addItemListener(this);
		a11.addItemListener(this);
		a12.addItemListener(this);
		a13.addItemListener(this);
		a14.addItemListener(this);
		a15.addItemListener(this);
		a16.addItemListener(this);
		a17.addItemListener(this);
		a18.addItemListener(this);
		a19.addItemListener(this);
		a20.addItemListener(this);
		a21.addItemListener(this);
		a22.addItemListener(this);
		a23.addItemListener(this);
		a24.addItemListener(this);
		a25.addItemListener(this);
		a26.addItemListener(this);
		a27.addItemListener(this);
		a28.addItemListener(this);
		a29.addItemListener(this);
		a30.addItemListener(this);
		a31.addItemListener(this);
		a32.addItemListener(this);
		a33.addItemListener(this);
		a34.addItemListener(this);
		a35.addItemListener(this);
		a36.addItemListener(this);
		
		b1.addItemListener(this);
		b2.addItemListener(this);
		b3.addItemListener(this);
		b4.addItemListener(this);
		b5.addItemListener(this);
		b6.addItemListener(this);
		b7.addItemListener(this);
		b8.addItemListener(this);
		b9.addItemListener(this);
		b10.addItemListener(this);
		b11.addItemListener(this);
		b12.addItemListener(this);
		b13.addItemListener(this);
		b14.addItemListener(this);
		b15.addItemListener(this);
		b16.addItemListener(this);
		b17.addItemListener(this);
		b18.addItemListener(this);
		b19.addItemListener(this);
		b20.addItemListener(this);
		b21.addItemListener(this);
		b22.addItemListener(this);
		b23.addItemListener(this);
		b24.addItemListener(this);
		b25.addItemListener(this);
		b26.addItemListener(this);
		b27.addItemListener(this);
		b28.addItemListener(this);
		b29.addItemListener(this);
		b30.addItemListener(this);
		b31.addItemListener(this);
		b32.addItemListener(this);
		b33.addItemListener(this);
		b34.addItemListener(this);
		b35.addItemListener(this);
		b36.addItemListener(this);
		
		// Adding specific checkboxes to ButtonGroups
		q1.add(a1);
		q1.add(b1);
		
		q2.add(a2);
		q2.add(b2);
		
		q3.add(a3);
		q3.add(b3);
		
		q4.add(a4);
		q4.add(b4);
		
		q5.add(a5);
		q5.add(b5);
		
		q6.add(a6);
		q6.add(b6);
		
		q7.add(a7);
		q7.add(b7);
		q8.add(a8);
		q8.add(b8);
		q9.add(a9);
		q9.add(b9);
		
		q10.add(a10);
		q10.add(b10);
		
		q11.add(a11);
		q11.add(b11);
		
		q12.add(a12);
		q12.add(b12);
		
		q13.add(a13);
		q13.add(b13);
		
		q14.add(a14);
		q14.add(b14);
		
		q15.add(a15);
		q15.add(b15);
		
		q16.add(a16);
		q16.add(b16);
		
		q17.add(a17);
		q17.add(b17);
		
		q18.add(a18);
		q18.add(b18);
		
		q19.add(a19);
		q19.add(b19);
		
		q20.add(a20);
		q20.add(b20);
		
		q21.add(a21);
		q21.add(b21);
		
		q22.add(a22);
		q22.add(b22);
		
		q23.add(a23);
		q23.add(b23);
		
		q24.add(a24);
		q24.add(b24);
		
		q25.add(a25);
		q25.add(b25);
		
		q30.add(a30);
		q30.add(b30);
		
		q31.add(a31);
		q31.add(b31);
		
		q32.add(a32);
		q32.add(b32);
		
		q33.add(a33);
		q33.add(b33);
		
		q34.add(a34);
		q34.add(b34);
		
		q35.add(a35);
		q35.add(b35);
		
		q36.add(a36);
		q36.add(b36);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		// parsing the doubles to integers
		int t1 = (int)typeOnePercent;
		int t2 = (int)typeTwoPercent;
		int t3 = (int)typeThreePercent;
		int t4 = (int)typeFourPercent;
		int t5 = (int)typeFivePercent;
		int t6 = (int)typeSixPercent;
		int t7 = (int)typeSevenPercent;
		int t8 = (int)typeEightPercent;
		int t9 = (int)typeNinePercent;
		
		// If user selects one of these buttons, it leads to 
		// next or previous page
		if(source == takeTest) {
			cards.show(getContentPane(), "questionsPage1");
		}
		else if(source == next1) {
			cards.show(getContentPane(), "questionsPage2");
		}
		else if(source == prev1) {
			cards.show(getContentPane(), "introP");
		}
		else if(source == next2) {
			cards.show(getContentPane(), "questionsPage3");
		}
		else if(source == prev2) {
			cards.show(getContentPane(), "questionsPage1");
		}
		else if(source == next3) {
			cards.show(getContentPane(), "questionsPage4");
		}
		else if(source == prev3) { 
			cards.show(getContentPane(),"questionsPage2");
		}
		else if(source == next4) {
			cards.show(getContentPane(), "questionsPage5");
		}
		else if(source == prev4) { 
			cards.show(getContentPane(),"questionsPage3");
		}
		else if(source == next5) {
			cards.show(getContentPane(), "questionsPage6");
		}
		else if(source == prev5) { 
			cards.show(getContentPane(),"questionsPage4");
		}
		else if(source == prev6) {
			cards.show(getContentPane(), "questionsPage5");
		}
		else if(source == next6) {
			// overriding the text of the labels for % match results
			typeOnePercentage.setText("Type 1: " + t1 + "% match");
			typeTwoPercentage.setText("Type 2: " + t2 + "% match");
			typeThreePercentage.setText("Type 3: " + t3 + "% match");
			typeFourPercentage.setText("Type 4: " + t4 + "% match");
			typeFivePercentage.setText("Type 5: " + t5 + "% match");
			typeSixPercentage.setText("Type 6: " + t6 + "% match");
			typeSevenPercentage.setText("Type 7: " + t7 + "% match");
			typeEightPercentage.setText("Type 8: " + t8 + "% match");
			typeNinePercentage.setText("Type 9: " + t9 + "% match");	
			cards.show(getContentPane(), "results");
		}
		// If user selects one of these buttons, leads the user 
		// to info about the Enneagram type
		else if(source == reformer) {
			cards.show(getContentPane(), "type1Result");
		}
		
		else if(source == helper) {
			cards.show(getContentPane(), "type2Result");
		}
		
		else if(source == achiever) {
			cards.show(getContentPane(), "type3Result");
		}
		
		else if(source == individualist) {
			cards.show(getContentPane(), "type4Result");
		}
		
		else if(source == investigator) {
			cards.show(getContentPane(), "type5Result");
		}
		
		else if(source == loyalist) {
			cards.show(getContentPane(), "type6Result");
		}
		
		else if(source == enthusiast) {
			cards.show(getContentPane(), "type7Result");
		}
		
		else if(source == challenger) {
			cards.show(getContentPane(), "type8Result");
		}
		
		else if(source == peacemaker) {
			cards.show(getContentPane(), "type9Result");
		}
		else if(source == prev7 || source == prev8 || source == prev9 
		     || source == prev10 || source == prev11 || source == prev12 
		     || source == prev13 || source == prev14 || source == prev15
		     || source == prev16 ) {
			cards.show(getContentPane(), "results");
			recipientField.setText("Enter your email here.");
			emailButtonStatus.setForeground(Color.gray);
			emailButtonStatus.setText("Status: Ready to send.");
		}
		else if(source == email1 || source == email2 || source == email3
			 || source == email4 || source == email5 || source == email6
			 || source == email7 || source == email8 || source == email9) {
			cards.show(getContentPane(), "emailResult");
		}
		else if(source == sendEmail) {
			InputValidation obj = new InputValidation();
			VerifyEmail obj2 = new VerifyEmail();
			String recipientText = recipientField.getText();
			boolean ans = obj.valEmail(recipientText);
			boolean ans2 = false;
			try {
				 ans2 = obj2.checkEmail(recipientText);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			if(ans == true){
			  if(ans2 == true) {
			  	String resultsSummary = "Type 1 (The Reformer): " + t1 + "% match"
								   +"\nType 2 (The Helper): " + t2 + "% match"
								   +"\nType 3 (The Achiever): " + t3 + "% match"
								   +"\nType 4 (The Individualist): " + t4 + "% match"
								   +"\nType 5 (The Investigator): " + t5 + "% match"
								   +"\nType 6 (The Loyalist): " + t6 + "% match"
								   +"\nType 7 (The Enthusiast): " + t7 + "% match"
								   +"\nType 8 (The Challenger): " + t8 + "% match"
								   +"\nType 9 (The Peacemaker): " + t9 + "% match";
			SendEmail.send(recipientText, resultsSummary);
			emailButtonStatus.setForeground(Color.GREEN);
			emailButtonStatus.setText("Status: Email has been sent.");
			
			// When user selects send email button, their email and test results get saved to the database
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
				PreparedStatement ps = conn.prepareStatement("insert into enneagramdb(user_email,type1_result,type2_result,type3_result,type4_result,"
								+ "type5_result,type6_result,type7_result,type8_result,type9_result) values(?,?,?,?,?,?,?,?,?,?);");
				ps.setString(1, recipientField.getText());
				ps.setInt(2, t1);
				ps.setInt(3, t2);
				ps.setInt(4, t3);
				ps.setInt(5, t4);
				ps.setInt(6, t5);
				ps.setInt(7, t6);
				ps.setInt(8, t7);
				ps.setInt(9, t8);
				ps.setInt(10, t9);
				ps.executeUpdate();
			
				}catch (Exception e2) {
					System.out.println(e2);
				}
			}
				else {
					emailButtonStatus.setForeground(Color.RED);
					emailButtonStatus.setText("Status: Invalid email try again.");
				}
			
			}
			else {
				emailButtonStatus.setForeground(Color.RED);
				emailButtonStatus.setText("Status: Invalid email try again.");
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItem();
		int select = e.getStateChange();
		
		// If a specific type is selected, that type increases 
		// its' count by one 
		if(source == b3 || source == b7 || source == b12 
				|| source == b15 || source == b20 || source == b25
				|| source == b30 || source == b34) {
			select = ItemEvent.SELECTED;
			type1Total += 1;
		}
		else if(source == a5 || source == a8 || source == a13 
				|| source == b17 || source == a20 || source == b23
				|| source == b29 || source == b35) {
			select = ItemEvent.SELECTED;
			type2Total +=1;
		}
		else if(source == a3 || source == a9 || source == b13 
				|| source == a18 || source == b21 || source == b27
				|| source == b31 || source == a36) {
			select = ItemEvent.SELECTED;
			type3Total +=1;
		}
		else if(source == a1 || source == b5 || source == a10
				|| source == a14 || source == b18 || source == a25 
				|| source == b28 || source == a33) {
			select = ItemEvent.SELECTED;
			type4Total += 1;
		}
		else if(source == a4 || source == b8 || source == a11 
				|| source == a15 || source == a22 || source == a28
				|| source == a32 || source == b36) {
			select = ItemEvent.SELECTED;
			type5Total +=1;
		}
		else if (source == b1 || source == a6 || source == a12 
				|| source == a16 || source == a19 || source == a23
				|| source == a27 || source == b32) {
			select = ItemEvent.SELECTED;
			type6Total += 1;
		}
		else if(source == b4 || source == b9 || source == b14 
				|| source == b19 || source == a24 || source == b26
				|| source == a30 || source == a35) {
			select = ItemEvent.SELECTED;
			type7Total +=1;
		}
		else if(source == a2 || source == a7 || source == b11 
				|| source == b16 || source == a21 || source == b24
				|| source == a29 || source == b33) {
			select = ItemEvent.SELECTED;
			type8Total += 1;
		}
		else if(source == b2 || source == b6 || source == b10 
				|| source == a17 || source == b22 || source == a26
				|| source == a31 || source == a34) {
			select = ItemEvent.SELECTED;
			type9Total +=1;
		}
		
		// Calculation of the percent match for the Enneagram types
		typeOnePercent = ((type1Total / 8) * 100);
		typeTwoPercent = ((type2Total / 8) * 100);
		typeThreePercent = ((type3Total / 8) * 100);
		typeFourPercent = ((type4Total / 8) * 100);
		typeFivePercent = ((type5Total / 8) * 100);
		typeSixPercent = ((type6Total / 8) * 100);
		typeSevenPercent = ((type7Total / 8) * 100);
		typeEightPercent = ((type8Total / 8) * 100);
		typeNinePercent = ((type9Total / 8) * 100);
	}
}