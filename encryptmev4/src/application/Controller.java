package application;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.ResourceBundle;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller implements Initializable {
	 Key pubkey, pubks;
	 String fs;
	 String answer = ""; 
	Optional<String> content;
	 @FXML	
	 Button aesbtn, desbtn, rsabtn, choosefile, savefile, stop, encryptfile, decryptfile, desencryptbutton, desdecryptbutton, rsaencrypbutton, rsadecryptbutton;
	 @FXML
	 MenuBar mymenubar;
	 @FXML
	 Menu options, algorithms, info;
	 @FXML
	 MenuItem mainpage, exitpage, aespage, despage, rsapage, hashpage, whatpage, whypage;
	 @FXML
	 private Parent root;
	 @FXML
	 TextField textfield, textfield1, textfield2;
	 @FXML
	 TextArea textarea1, textarea2;
	 @FXML
	 File chosenfile, savedfile;
	 
	
	 //Initialization 
	 
	 public void initialize(URL url, ResourceBundle resourceBundle) {

	    }
	 
	 //Below are the button actions events that are present on the welcome page
	 
	public void aesbtnaction(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/256AES.fxml"));
		 
		Stage newwindow = (Stage) aesbtn.getScene().getWindow();
		newwindow.setScene(new Scene(root));
	 }
	 
	
	public void desbtnaction(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/3DES.fxml"));
	 
		Stage newwindow = (Stage) desbtn.getScene().getWindow();
		newwindow.setScene(new Scene(root));
	 }
	
	
	 public void rsabtnaction(ActionEvent event) throws IOException {
		 Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/RSA.fxml"));
		 
		 Stage newwindow = (Stage) rsabtn.getScene().getWindow();
		 newwindow.setScene(new Scene(root)); 
	 }
	 
	 
	 //Below are the menuitem action events throughout the application.
	 //These actions events were particularly difficult to get working as MenuItem is not a subclass of node.

	 
	 public void mainmenu(ActionEvent event) throws IOException {
		 Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/welcomepage.fxml"));
		 
		    
		        Scene newscene = new Scene(root);
		        Stage newstage = (Stage) mymenubar.getScene().getWindow();
		        newstage.setScene(newscene);
		        newstage.show();          
	 }
	 
	 //Exit application via menuitem: exit.
	 
	 public void exit(ActionEvent event) throws IOException {	
		 Platform.exit();
	 }
		 
	 
	 public void aesmenu(ActionEvent event) throws IOException {
		 Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/256AES.fxml"));
		 
		    
		        Scene newscene = new Scene(root);
		        Stage newstage = (Stage) mymenubar.getScene().getWindow();
		        newstage.setScene(newscene);
		        newstage.show();     	 
	}
			 
	
	 public void desmenu(ActionEvent event) throws IOException {
		 Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/3DES.fxml"));
		 
		    
		        Scene newscene = new Scene(root);
		        Stage newstage = (Stage) mymenubar.getScene().getWindow();
		        newstage.setScene(newscene);
		        newstage.show(); 
	 }	        
	 
	 
	 public void rsamenu(ActionEvent event) throws IOException {
		 Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/RSA.fxml"));
		 
		    
		        Scene newscene = new Scene(root);
		        Stage newstage = (Stage) mymenubar.getScene().getWindow();
		        newstage.setScene(newscene);
		        newstage.show(); 
	 }	        
	 
	 
	 public void hashmenu(ActionEvent event) throws IOException {
		 Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/hash.fxml"));
		 
		    
		        Scene newscene = new Scene(root);
		        Stage newstage = (Stage) mymenubar.getScene().getWindow();
		        newstage.setScene(newscene);
		        newstage.show(); 
	 }	   
	 
	 
	 public void whatmenu(ActionEvent event) throws IOException {
		 Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/info1.fxml"));
		 
		    
		        Scene newscene = new Scene(root);
		        Stage newstage = (Stage) mymenubar.getScene().getWindow();
		        newstage.setScene(newscene);
		        newstage.show(); 
	 }	        
	 
	 
	 public void whymenu(ActionEvent event) throws IOException {
		 Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/info2.fxml"));
		 
		    
		        Scene newscene = new Scene(root);
		        Stage newstage = (Stage) mymenubar.getScene().getWindow();
		        newstage.setScene(newscene);
		        newstage.show(); 
	 }
	 
	 //File explorer button actions are below
	 
	 public void fileexplorer(ActionEvent event) {
	        FileChooser chosenfile = new FileChooser();
	        chosenfile.getExtensionFilters().addAll(
	                new FileChooser.ExtensionFilter("Text Files", "*.txt")
	           
	        );
	        File f = chosenfile.showOpenDialog(null);
	        if (f != null) {
	            fs = f.toString();
	            Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.setTitle("Information Dialog");
	            alert.setHeaderText(null);
	            alert.setContentText("File Successfully selected" + fs);
	            alert.showAndWait();
	        }

	 }
	 
	 //Save explorer button actions are below
	 
	 public void saveexplorer(ActionEvent event) {
	        FileChooser savedfile = new FileChooser();
	        savedfile.getExtensionFilters().addAll(
	                new FileChooser.ExtensionFilter("File Folder", ".folder")
	           
	        );
	        File f = savedfile.showSaveDialog(null);
	        if (f != null) {
	            Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.setTitle("Save File Explorer");
	            alert.setHeaderText(null);
	            alert.setContentText("File Directory Saved" + fs);
	            alert.showAndWait();
	        }
	 }
	 
	 //AES Encryption & Decryption actions below - TODO: Figure out how to encrypt files that aren't text files. File to string issue.
	 //User input key could be a good upgrade. 
	 
	 public void encryptbutton(ActionEvent event) {
	        try {
	            FileInputStream chosenfile = new FileInputStream(fs);
	            FileOutputStream savedfile = new FileOutputStream("EncryptedFile.txt");
	            byte key[] = "7Mke29453MlpQ2hZ".getBytes();
	            SecretKeySpec ks = new SecretKeySpec(key, "AES");
	            
	            Cipher encryptfile = Cipher.getInstance("AES");
	            encryptfile.init(Cipher.ENCRYPT_MODE, ks);
	            CipherOutputStream cipherOutputStream = new CipherOutputStream(savedfile, encryptfile);
	            byte[] buf = new byte[1024];
	            int read;

	            while ((read = chosenfile.read(buf)) != -1) {
	                cipherOutputStream.write(buf, 0, read);
	            }
	            chosenfile.close();
	            savedfile.flush();
	            cipherOutputStream.close();
	            Alert successpopup = new Alert(Alert.AlertType.INFORMATION);
	            successpopup.setTitle(null);
	            successpopup.setHeaderText(null);
	            successpopup.setContentText("Your file has been encrypted.");
	            successpopup.showAndWait();
	        } catch (Exception e) {
	            Alert errorpopup = new Alert(Alert.AlertType.INFORMATION);
	            errorpopup.setTitle(null);
	            errorpopup.setHeaderText(null);
	            errorpopup.setContentText("Error" + e);
	            errorpopup.showAndWait();
	        }
	 }


	    public void decryptbutton(ActionEvent actionEvent) {
	        try {
	            FileInputStream chosenfile = new FileInputStream(fs);
	            FileOutputStream savedfile = new FileOutputStream("DecryptedFile.txt");
	            byte key[] = "7Mke29453MlpQ2hZ".getBytes();
	            SecretKeySpec ks = new SecretKeySpec(key, "AES");
	            Cipher decryptfile = Cipher.getInstance("AES");
	            decryptfile.init(Cipher.DECRYPT_MODE, ks);
	            CipherOutputStream cipherOutputStream = new CipherOutputStream(savedfile, decryptfile);
	            byte[] buf = new byte[1024];
	            int read;

	            while ((read = chosenfile.read(buf)) != -1) {
	                cipherOutputStream.write(buf, 0, read);
	            }
	            chosenfile.close();
	            savedfile.flush();
	            cipherOutputStream.close();
	            Alert successpopup = new Alert(Alert.AlertType.INFORMATION);
	            successpopup.setTitle(null);
	            successpopup.setHeaderText(null);
	            successpopup.setContentText("Your file has been decrypted.");
	            successpopup.showAndWait();
	        } catch (Exception e) {
	            Alert errorpopup = new Alert(Alert.AlertType.INFORMATION);
	            errorpopup.setTitle(null);
	            errorpopup.setHeaderText(null);
	            errorpopup.setContentText("Error" + e);
	            errorpopup.showAndWait();
	        }
	}
	  
	    //3DES Encryption & Decryption actions below - TODO: Figure out how to encrypt files that aren't text files. File to string issue.
	    //User input key could be a good upgrade.  
	    
	    public void desencryptbutton(ActionEvent event) {
	        try {
	        	FileInputStream chosenfile = new FileInputStream(fs);
	        	FileOutputStream savedfile = new FileOutputStream("EncryptedFile.txt");
	        	byte[] key = "Gj6z7OB1Ny4eZitVArGn45Pz".getBytes();
	        	SecretKeySpec ks = new SecretKeySpec(key, "DESede");
	        	Cipher encryptfile = Cipher.getInstance("DESede");
	            encryptfile.init(Cipher.ENCRYPT_MODE, ks);
	            CipherOutputStream cipherOutputStream = new CipherOutputStream(savedfile, encryptfile);
	            byte[] buf = new byte[1024];
	            int read;
	            while ((read = chosenfile.read(buf)) != -1) {
	                cipherOutputStream.write(buf, 0, read);
	            }
	            chosenfile.close();
	            savedfile.flush();
	            cipherOutputStream.close();
	            Alert successpopup = new Alert(Alert.AlertType.INFORMATION);
	            successpopup.setTitle(null);
	            successpopup.setHeaderText(null);
	            successpopup.setContentText("Your file has been encrypted.");
	            successpopup.showAndWait();
	        } catch (Exception e) {
	            Alert errorpopup = new Alert(Alert.AlertType.INFORMATION);
	            errorpopup.setTitle(null);
	            errorpopup.setHeaderText(null);
	            errorpopup.setContentText("Error" + e);
	            errorpopup.showAndWait();
	        }
	        }
	    public void desdecryptbutton(ActionEvent event) {
	        try {
	        	FileInputStream chosenfile = new FileInputStream(fs);
	        	FileOutputStream savedfile = new FileOutputStream("DecryptedFile.txt");
	        	byte[] key = "Gj6z7OB1Ny4eZitVArGn45Pz".getBytes();
	        	SecretKeySpec ks = new SecretKeySpec(key, "DESede");
	        	Cipher decryptfile = Cipher.getInstance("DESede");
	        	decryptfile.init(Cipher.DECRYPT_MODE, ks);
	            CipherOutputStream cipherOutputStream = new CipherOutputStream(savedfile, decryptfile);
	            byte[] buf = new byte[1024];
	            int read;
	            while ((read = chosenfile.read(buf)) != -1) {
	                cipherOutputStream.write(buf, 0, read);
	            }
	            chosenfile.close();
	            savedfile.flush();
	            cipherOutputStream.close();
	            Alert successpopup = new Alert(Alert.AlertType.INFORMATION);
	            successpopup.setTitle(null);
	            successpopup.setHeaderText(null);
	            successpopup.setContentText("Your file has been decrypted.");
	            successpopup.showAndWait();
	        } catch (Exception e) {
	            Alert errorpopup = new Alert(Alert.AlertType.INFORMATION);
	            errorpopup.setTitle(null);
	            errorpopup.setHeaderText(null);
	            errorpopup.setContentText("Error" + e);
	            errorpopup.showAndWait();
	        }
	        }
	    
	    //Big issue faced regarding RSA encryption, keys can be generated but chosen file or temp file cannot be encrypted/decrypted.
	   
	    public void rsaencryptbutton(ActionEvent event) {
	    try {
            
            
	    	} catch (Exception e) {
         
	    	}
	    
	    }
	  

		

		public void rsadecryptbutton(ActionEvent event) {
			

		    try {


	    		} catch (Exception e) {
	    		}
		}
		
		//MD5 Encryption and Brute force algorithm for decryption. Code for brute force was used during a previous project.
		
		public void md5encrypt(ActionEvent event) throws UnsupportedEncodingException, NoSuchAlgorithmException {
			String inputtext = textarea1.getText();
			 try {
			        java.security.MessageDigest md5 = java.security.MessageDigest.getInstance("MD5");
			        byte[] a = md5.digest(inputtext.getBytes( "UTF-8" ));
			        StringBuffer sbuff = new StringBuffer();
			        for (int i = 0; i < a.length; i++) {
			            sbuff.append( String.format( "%02x", a[i]));
			            }
			        String hashedinputtext = sbuff.toString();
			        
			        textfield1.setText(hashedinputtext);
			    }   catch ( NoSuchAlgorithmException | UnsupportedEncodingException e) {
			               
			    }
			
		}
		
		
		
		public boolean generatestrings(int wordlength, char[] alphabet,String hashedpasswords) {  //code used in brute force action event
	    	final long MAX_WORDS = (long) Math.pow(alphabet.length, wordlength);
	        final int basenumber = alphabet.length;
	        for (long i = 0; i < MAX_WORDS; i++) {   //Method for generating all the strings that need to be hashed and then compared to the original hash.
	        	
	            int[] index = convert(basenumber, i, wordlength);   //Index represents the position of the numerical value
	            char[] word = new char[wordlength];
	            for (int k = 0; k < wordlength; k++) {
	            	word[k] = alphabet[index[k]];
	            }
	            
	            String ss = new String(word);
	            if(comparestrings(encryptstrings(ss),hashedpasswords)) {   //ss represents the string that has been generated, it's then passed into the if statement. Whereby, its encrypted into md5 and compared to original hash to find a match.
	            	answer = ss;
	                return true;
	            }
	       }
	        return false;
	    }
		
		public static String encryptstrings(String str) { //code used in brute force action event
	    	byte[] Bytes = str.getBytes();   //encryptstrings method is using messagedigest to hash the strings in generatestrings method
	        try {
	        	MessageDigest algorithm = MessageDigest.getInstance("MD5");
	            algorithm.reset();
	            algorithm.update(Bytes);
	            byte mD[] = algorithm.digest(); //mD = MessageDigest
	            StringBuffer hex = new StringBuffer();
	            for (int i = 0; i < mD.length; i++) {
	            	hex.append(Integer.toHexString(0xFF & mD[i]));
	           }
	            str = hex + "";
	        }
	        
	        catch(NoSuchAlgorithmException e) {
	        	e.printStackTrace();
	        }
	        return str;
	    }
	
		static int[] convert(int basenumber, long number, int wordlength) { //code used in brute force action event
	    	int[] index = new int[wordlength];
	        for (int i = wordlength - 1; i >= 0; i--) {
	        	if (number > 0) {   //convert method for index
	            	int rest = (int) (number % basenumber);
	                number /= basenumber;
	                index[i] = rest;
	            }
	        	
	            else {
	            	index[i] = 0;
	         }
	      }
	        return index;
	    }
		

	    public static boolean comparestrings(String s2, String s1) { //code used in brute force action event
	    	String a=s1;
	        if(s1.contains(s2))  //comparestrings method compares strings to find a match
	            return true;
	        else {
	        	while(a.indexOf('0')!=-1) {
	        		a=a.substring(0,a.indexOf('0'))+a.substring(a.indexOf('0')+1,a.length());
	                if(a.contains(s2))
	                    return true;
	          }
	       }
	        return false;
	    }
	    
		public static  void generatestrings() {	
		}
	

	    
		public void md5brute(ActionEvent event) { //Code that was used for md5brute in module 2020 CI510 - Security and Dependability, references from this project will be referenced in report.
		
			char[] ar ="abcdefghijklmnopqrstuvwxyz1234567890!£$%^&*-_=+][}{'@#~/?>.,<|".toCharArray(); //Main method for brute force action event.
			String hashedpassword = (textarea2).getText();   //Initialisation.
	        final int MAX_WORDLENGTH = 30;   
	        
	        for(int wordlength = 1; wordlength <= MAX_WORDLENGTH; wordlength++) {
	     
	            if(generatestrings(wordlength,ar,hashedpassword)) {   //If the strings that have been generated match the characteristcs of the hashed password provided, then it will provide the user an answer.
	                textfield2.setText(answer);
	                break;
	            }
	            
	            else {
	            	} 
	            
	        	}
	   
		}
		
}
	    
	    
	    
	   
	   
		

	    
	    

	 
	 
