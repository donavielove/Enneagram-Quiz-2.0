/*
 * This class holds all the questions used in the 
 * Enneagram Test class
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

import java.awt.Font;
import javax.swing.JTextArea;

public class typeAnswers {
	// Initializing textAreas for each question 
	static JTextArea type1_1 = new JTextArea(), type1_2 = new JTextArea(), type1_3 = new JTextArea(), type1_4 = new JTextArea(), 
			         type1_5 = new JTextArea(), type1_6 = new JTextArea(), type1_7 = new JTextArea(), type1_8 = new JTextArea(),
			         type2_1 = new JTextArea(), type2_2 = new JTextArea(), type2_3 = new JTextArea(), type2_4 = new JTextArea(), 
			         type2_5 = new JTextArea(), type2_6 = new JTextArea(), type2_7 = new JTextArea(), type2_8 = new JTextArea(),
			         type3_1 = new JTextArea(), type3_2 = new JTextArea(), type3_3 = new JTextArea(), type3_4 = new JTextArea(),
			         type3_5 = new JTextArea(), type3_6 = new JTextArea(), type3_7 = new JTextArea(), type3_8 = new JTextArea(),
			         type4_1 = new JTextArea(), type4_2 = new JTextArea(), type4_3 = new JTextArea(), type4_4 = new JTextArea(),
			         type4_5 = new JTextArea(), type4_6 = new JTextArea(), type4_7 = new JTextArea(), type4_8 = new JTextArea(),
			         type5_1 = new JTextArea(), type5_2 = new JTextArea(), type5_3 = new JTextArea(), type5_4 = new JTextArea(),
			         type5_5 = new JTextArea(), type5_6 = new JTextArea(), type5_7 = new JTextArea(), type5_8 = new JTextArea(),
			         type6_1 = new JTextArea(), type6_2 = new JTextArea(), type6_3 = new JTextArea(), type6_4 = new JTextArea(),
			         type6_5 = new JTextArea(), type6_6 = new JTextArea(), type6_7 = new JTextArea(), type6_8 = new JTextArea(),
			         type7_1 = new JTextArea(), type7_2 = new JTextArea(), type7_3 = new JTextArea(), type7_4 = new JTextArea(),
			         type7_5 = new JTextArea(), type7_6 = new JTextArea(), type7_7 = new JTextArea(), type7_8 = new JTextArea(),
			         type8_1 = new JTextArea(), type8_2 = new JTextArea(), type8_3 = new JTextArea(), type8_4 = new JTextArea(),
			         type8_5 = new JTextArea(), type8_6 = new JTextArea(), type8_7 = new JTextArea(), type8_8 = new JTextArea(),
			         type9_1 = new JTextArea(), type9_2 = new JTextArea(), type9_3 = new JTextArea(), type9_4 = new JTextArea(),
			         type9_5 = new JTextArea(), type9_6 = new JTextArea(), type9_7 = new JTextArea(), type9_8 = new JTextArea();
	
	// Setting the font that will be used for each question
	Font courierNewFont = new Font("Courier New", Font.BOLD, 14);
	
	public typeAnswers() {
	
	// Adding in text for each text area
	type1_1.setText("I am typically direct, formal, "
			      + "\nand idealistic");
	
	type1_2.setText("I am more of a \"high-minded\" "
			      + "\nidealist");
	
	type1_3.setText("I come across as being too sure "
			      + "\nof myself");
	
	type1_4.setText("It's difficult for me to take it "
			      + "\neasy and be flexible");
	
	type1_5.setText("I tend to be a serious, reserved person "
			      + "\nwho likes to discuss issues");
	
	type1_6.setText("My habit of telling people what to do "
			      + "\nhas annoyed people");
	
	type1_7.setText("I�m generally an earnest, "
			      + "\nself-disciplined person");
	
	type1_8.setText("I have been too uncompromising and "
		          + "\ndemanding with others");
	
	type2_1.setText("5) I am a hospitable person and I enjoy "
			      + "\nwelcoming new friends into my life");

	type2_2.setText("8) I need to show affection to people");
	
	type2_3.setText("13) I am more relationship-oriented "
			      + "\nthan goal-oriented");
	
	type2_4.setText("My eagerness to have people depend "
			      + "\non me has gotten me into trouble "
			      + "\nwith them");
	
	type2_5.setText("20) I tend to be a supportive, giving "
			      + "\nperson who enjoys the company of others");
	
	type2_6.setText("I am soft-hearted and sentimental");
	
	type2_7.setText("I like to comfort people and "
			      + "\nhelp calm them down");
	
	type2_8.setText("I'm appreciated for my quiet "
			      + "\nstrength and exceptional generosity");
	
	type3_1.setText("3) I am typically diplomatic, charming,"
			      + "\nand ambitious");
	
	type3_2.setText("9) When presented with a new experience "
			      + "\nI usually ask myself if it would be "
			      + "\nuseful to me");
	
	type3_3.setText("I am more goal-oriented than "
			      + "\nrelationship-oriented");
	
	type3_4.setText("18) Usually, I am able to put my "
			      + "\nfeelings aside to get the job done");
	
	type3_5.setText("I often feel the need to perform "
		          + "\nperfectly");
	
	type3_6.setText("I tend to not depended on people; "
			      + "\nI like to do things on my own");
	
	type3_7.setText("I usually like to let people know "
			      + "\nwhat I can do well");
	
	type3_8.setText("36) Much of my success has been due to "
			      + "\nmy talent for making a favorable "
			      + "\nimpression");
	
	type4_1.setText("1) I am romantic and imaginative");
	
	type4_2.setText("I am a private person and tend to "
			      + "\nnot mix much with others");
	
	type4_3.setText("10) I tend to focus too much on myself");
	
	type4_4.setText("14) I do not speak up for myself "
			      + "\nvery well");
	
	type4_5.setText("Usually, I need to work through my "
			      + "\nfeelings before I act");
	
	type4_6.setText("25) My habit of being \"stand-offish\" "
			      + "\nhas annoyed people");
	
	type4_7.setText("I tend to be moody and self-absorbed");
	
	type4_8.setText("33) When I have conflict with others, "
			      + "\nI tend to withdraw");
	
	
	type5_1.setText("4) I tend to be focused and intense");
	
	type5_2.setText("I prefer to maintain a certain "
			      + "\ndistance with people");
	
	type5_3.setText("11) Others depend on my insight "
			      + "\nand knowledge");
	
	type5_4.setText("15) It's difficult for me to stop "
			      + "\nconsidering alternatives and do "
			      + "\nsomething definite");
	
	type5_5.setText("22) I'm interested in asking tough "
			      + "\nquestions and maintaining "
			      + "\nmy independence");
	
	type5_6.setText("28) I tend to be detached and "
			      + "\npreoccupied");
	
	type5_7.setText("32) Pursuing my personal interests is "
			      + "\nmore important to me than having "
			      + "\ncomfort and security");
	
	type5_8.setText("Much of my success has been achieved "
			      + "\ndespite my lack of interest in "
			      + "\ndeveloping interpersonal skills");
	
	type6_1.setText("I am practical and down to earth");
	
	type6_2.setText("6) Usually, it's natural for me to " 
			      + "\nreact angrily.");
	
	type6_3.setText("12) I come across as being too unsure "
			      + "\nof myself");
	
	type6_4.setText("16) I tend to be hesitant and "
			      + "\nprocrastinative");
	
	type6_5.setText("19) Generally, I am methodical "
			      + "\nand cautious");
	
	type6_6.setText("23) I am realistic and sceptical");
	
	type6_7.setText("27) I depend on my friends and they "
			      + "\nknow that they can depend on me");
	
	type6_8.setText("Having comfort and security is more "
			      + "\nimportant to me than pursuing "
			      + "\nmy personal interests");
	
	type7_1.setText("I tend to be spontaneous and "
			      + "\nfun-loving");
	
	type7_2.setText("When presented with a new experience "
			      + "\nI usually ask myself if it would be "
			      + "\nenjoyable");
	
	type7_3.setText("I am outspoken � I say what others "
			      + "\nwished they had the nerve to say");
	
	type7_4.setText("Generally, I am adventurous "
			      + "\nand take risks");
	
	type7_5.setText("24) I often worry that I'm missing out "
			      + "\non something better");
	
	type7_6.setText("Usually, when trouble gets to me, "
			      + "\nI treat myself to something I enjoy");
	
	type7_7.setText("30) I'm generally outgoing and a "
			      + "\nsociable person");
	
	type7_8.setText("35) I'm appreciated for my unsinkable "
			      + "\nspirit and great sense of humor");
	
	type8_1.setText("2) I tend to take on confrontation");
	
	type8_2.setText("7) I am more of a \"street-smart\" "
			      + "\nsurvivor");
	
	type8_3.setText("Others depend on my strength "
			      + "\nand decisiveness");
	
	type8_4.setText("I tend to be bold and domineering");
	
	type8_5.setText("21) I often feel the need to be a "
			      + "\n\"pillar of strength.\"");
	
	type8_6.setText("I often worry that if I let my guard "
			      + "\ndown, someone will take advantage of me");
	
	type8_7.setText("29) I like to challenge people and "
			      + "\n\"shake them up.\"");
	
	type8_8.setText("When I have conflict with others, "
			      + "\nI rarely back down");
	
	type9_1.setText("I tend to avoid confrontation");
	
	type9_2.setText("Usually, it's hard for me " 
				  + "\nto react angrily");
	
	type9_3.setText("I tend to focus too much on others");
	
	type9_4.setText("17) My reluctance to get too involved "
			      + "\ngets me into trouble with people");
	
	type9_5.setText("I'm interested in maintaining my "
			      + "\nstability and peace of mind");
	
	type9_6.setText("26) Usually, when trouble gets to me, "
			      + "\nI am able to \"tune them out.\"");
	
	type9_7.setText("31) I am usually shy about showing my "
			      + "\nabilities");
	
	type9_8.setText("34) I give in too easily and let "
			      + "\nothers push me around");
	
	// Setting the font of each question
	type1_1.setFont(courierNewFont);
	type1_2.setFont(courierNewFont);
	type1_3.setFont(courierNewFont);
	type1_4.setFont(courierNewFont);
	type1_5.setFont(courierNewFont);
	type1_6.setFont(courierNewFont);
	type1_7.setFont(courierNewFont);
	type1_8.setFont(courierNewFont);
	
	type2_1.setFont(courierNewFont);
	type2_2.setFont(courierNewFont);
	type2_3.setFont(courierNewFont);
	type2_4.setFont(courierNewFont);
	type2_5.setFont(courierNewFont);
	type2_6.setFont(courierNewFont);
	type2_7.setFont(courierNewFont);
	type2_8.setFont(courierNewFont);
	
	type3_1.setFont(courierNewFont);
	type3_2.setFont(courierNewFont);
	type3_3.setFont(courierNewFont);
	type3_4.setFont(courierNewFont);
	type3_5.setFont(courierNewFont);
	type3_6.setFont(courierNewFont);
	type3_7.setFont(courierNewFont);
	type3_8.setFont(courierNewFont);
	
	type4_1.setFont(courierNewFont);
	type4_2.setFont(courierNewFont);
	type4_3.setFont(courierNewFont);
	type4_4.setFont(courierNewFont);
	type4_5.setFont(courierNewFont);
	type4_6.setFont(courierNewFont);
	type4_7.setFont(courierNewFont);
	type4_8.setFont(courierNewFont);
	
	type5_1.setFont(courierNewFont);
	type5_2.setFont(courierNewFont);
	type5_3.setFont(courierNewFont);
	type5_4.setFont(courierNewFont);
	type5_5.setFont(courierNewFont);
	type5_6.setFont(courierNewFont);
	type5_7.setFont(courierNewFont);
	type5_8.setFont(courierNewFont);
	
	type6_1.setFont(courierNewFont);
	type6_2.setFont(courierNewFont);
	type6_3.setFont(courierNewFont);
	type6_4.setFont(courierNewFont);
	type6_5.setFont(courierNewFont);
	type6_6.setFont(courierNewFont);
	type6_7.setFont(courierNewFont);
	type6_8.setFont(courierNewFont);
	
	type7_1.setFont(courierNewFont);
	type7_2.setFont(courierNewFont);
	type7_3.setFont(courierNewFont);
	type7_4.setFont(courierNewFont);
	type7_5.setFont(courierNewFont);
	type7_6.setFont(courierNewFont);
	type7_7.setFont(courierNewFont);
	type7_8.setFont(courierNewFont);
	
	type8_1.setFont(courierNewFont);
	type8_2.setFont(courierNewFont);
	type8_3.setFont(courierNewFont);
	type8_4.setFont(courierNewFont);
	type8_5.setFont(courierNewFont);
	type8_6.setFont(courierNewFont);
	type8_7.setFont(courierNewFont);
	type8_8.setFont(courierNewFont);
	
	type9_1.setFont(courierNewFont);
	type9_2.setFont(courierNewFont);
	type9_3.setFont(courierNewFont);
	type9_4.setFont(courierNewFont);
	type9_5.setFont(courierNewFont);
	type9_6.setFont(courierNewFont);
	type9_7.setFont(courierNewFont);
	type9_8.setFont(courierNewFont);
	
	// Setting each text area editable to false
	type1_1.setEditable(false);
	type1_2.setEditable(false);
	type1_3.setEditable(false);
	type1_4.setEditable(false);
	type1_5.setEditable(false);
	type1_6.setEditable(false);
	type1_7.setEditable(false);
	type1_8.setEditable(false);
	
	type2_1.setEditable(false);
	type2_2.setEditable(false);
	type2_3.setEditable(false);
	type2_4.setEditable(false);
	type2_5.setEditable(false);
	type2_6.setEditable(false);
	type2_7.setEditable(false);
	type2_8.setEditable(false);
	
	type3_1.setEditable(false);
	type3_2.setEditable(false);
	type3_3.setEditable(false);
	type3_4.setEditable(false);
	type3_5.setEditable(false);
	type3_6.setEditable(false);
	type3_7.setEditable(false);
	type3_8.setEditable(false);
	
	type4_1.setEditable(false);
	type4_2.setEditable(false);
	type4_3.setEditable(false);
	type4_4.setEditable(false);
	type4_5.setEditable(false);
	type4_6.setEditable(false);
	type4_7.setEditable(false);
	type4_8.setEditable(false);
	
	type5_1.setEditable(false);
	type5_2.setEditable(false);
	type5_3.setEditable(false);
	type5_4.setEditable(false);
	type5_5.setEditable(false);
	type5_6.setEditable(false);
	type5_7.setEditable(false);
	type5_8.setEditable(false);
	
	type6_1.setEditable(false);
	type6_2.setEditable(false);
	type6_3.setEditable(false);
	type6_4.setEditable(false);
	type6_5.setEditable(false);
	type6_6.setEditable(false);
	type6_7.setEditable(false);
	type6_8.setEditable(false);
	
	type7_1.setEditable(false);
	type7_2.setEditable(false);
	type7_3.setEditable(false);
	type7_4.setEditable(false);
	type7_5.setEditable(false);
	type7_6.setEditable(false);
	type7_7.setEditable(false);
	type7_8.setEditable(false);
	
	type8_1.setEditable(false);
	type8_2.setEditable(false);
	type8_3.setEditable(false);
	type8_4.setEditable(false);
	type8_5.setEditable(false);
	type8_6.setEditable(false);
	type8_7.setEditable(false);
	type8_8.setEditable(false);
	
	type9_1.setEditable(false);
	type9_2.setEditable(false);
	type9_3.setEditable(false);
	type9_4.setEditable(false);
	type9_5.setEditable(false);
	type9_6.setEditable(false);
	type9_7.setEditable(false);
	type9_8.setEditable(false);
	}
}
