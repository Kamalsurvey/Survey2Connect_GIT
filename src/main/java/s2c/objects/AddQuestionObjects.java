package s2c.objects;

import org.openqa.selenium.By;

public class AddQuestionObjects {
	
	// Create NPS TEST
	
		public static final  String NPS_Icon = "//div[@class='ques_types_div']//div[@class='ques_types_row'][1]/div[3]";
		public static final  String NPS_QuestionTextArea ="//body[@id='tinymce']";
		public static final  String NPS_Type="//div[@class='nps_options']//select";
		public static final  String NPS_ColorOption = "//span[@class='custom_radio_grp']//span";
		public static final  String NPS_Submit = "//div[@class='left_sidebar_footer']/button[2]";
		public static final  String Toaster_createQuestion = "//div[@id='toast-container'][@class='toast-bottom-right']";
		
	// Single Text	
		public static final  String SingleText = "//div[@class='ques_types_div']//div[@class='ques_types_row'][2]/div[1]";
		public static final  String ST_QuestionTextArea ="//body[@id='tinymce']";
		public static final  String ST_Submit = "//div[@class='left_sidebar_footer']/button[2]";
		
		// Dropdown
		public static final  String dropdown = "//div[@class='ques_types_div']//div[@class='ques_types_row'][2]/div[2]";
		public static final  String dropdown_QuestionTextArea = "//body[@id='tinymce']";
		public static final  String dropdown_Submit = "//div[@class='left_sidebar_footer']/button[2]";
		
		// Ranking
		public static final  String ranking = "//div[@class='ques_types_div']//div[@class='ques_types_row'][2]/div[3]";
		public static final  String ranking_QuestionTextArea = "//body[@id='tinymce']";
		public static final  String ranking_Submit = "//div[@class='left_sidebar_footer']/button[2]";
		
		// Multitext
		public static final  String multiText = "//div[@class='ques_types_div']//div[@class='ques_types_row'][3]/div[1]";
		public static final  String multiText_QuestionTextArea = "//body[@id='tinymce']";
		public static final  String multiText_Submit = "//div[@class='left_sidebar_footer']/button[2]";
		
		//MRS_SC
		public static final  String mrs_sc = "//div[@class='ques_types_div']//div[@class='ques_types_row'][3]/div[2]";	
		public static final  String mrs_QuestionTextArea = "//body[@id='tinymce']";
		public static final  String mrs_Submit = "//div[@class='left_sidebar_footer']/button[2]";
		
		//MRS_DD
		
				public static final  String mrs_dropdown = "//div[@class='ques_types_div']//div[@class='ques_types_row'][3]/div[3]";	
				
				//MRS_Text
				
				public static final  String mrs_text = "//div[@class='ques_types_div']//div[@class='ques_types_row'][4]/div[1]";	
		
//GRS
				
				public static final  String grs_Icon = "//div[@class='ques_types_div']//div[@class='ques_types_row'][5]/div[1]";	
				public static final  String grs_QuestionTextArea = "//body[@id='tinymce']";
				public static final  String grs_Slider="//div[@class='graphical_rating_slider']//div[@role='slider']";
				public static final String  grs_type_dd="//button[contains(@class,'dropdown-toggle') and contains(@class,'rating')]/span[2]";
			
				public static final String  grs_type_stars="//ul[@class='dropdown-menu']/li[1]";
				public static final String  grs_type_heart="//ul[@class='dropdown-menu']/li[2]";
				public static final String  grs_type_gift="//ul[@class='dropdown-menu']/li[3]";
				public static final String  grs_type_users="//ul[@class='dropdown-menu']/li[4]";
				public static final String  grs_type_trophy="//ul[@class='dropdown-menu']/li[5]";
				public static final String  grs_type_likes="//ul[@class='dropdown-menu']/li[6]";
				public static final String  grs_type_dislikes="//ul[@class='dropdown-menu']/li[7]";
				public static final String  grs_type_smily="//ul[@class='dropdown-menu']/li[8]";
				public static final String  grs_type_smily_Grad="//ul[@class='dropdown-menu']/li[9]";
				public static final String  grs_type_slider="//ul[@class='dropdown-menu']/li[10]";
				public static final String  grs_type_emojis="//ul[@class='dropdown-menu']/li[11]";
				
				
				public static final String  enable_rows="//span[@class='custom_checkbox_grp']";
				public static final String  first_row="//span[@class='textarea_expanded']//div[@class='textAreaHeight']";
				
		//Contacts
		
				public static final  String contacts_Icon = "//div[@class='ques_types_div']//div[@class='ques_types_row'][4]/div[3]";	
				
				
				//LongText
				
				public static final  String longText_icon = "//div[@class='ques_types_div']//div[@class='ques_types_row'][5]/div[1]";	

//Statement
				
				public static final  String statement_Icon= "//div[@class='ques_types_div']//div[@class='ques_types_row'][5]/div[2]";	

//DateTime
				public static final  String dateTime_Icon= "//div[@class='ques_types_div']//div[@class='ques_types_row'][5]/div[3]";	

	//File Upload
				public static final  String fileUpload_Icon= "//div[@class='ques_types_div']//div[@class='ques_types_row'][6]/div[1]";	
			
				//File Upload
				public static final  String slider_Icon= "//div[@class='ques_types_div']//div[@class='ques_types_row'][6]/div[2]";	
	
				//Single Choice
				public static final  String singleChoice = "//div[@class='ques_types_div']//div[@class='ques_types_row'][1]/div[1]";
				
				//Single Choice
				public static final  String MultiChoice = "//div[@class='ques_types_div']//div[@class='ques_types_row'][1]/div[2]";
				
}
