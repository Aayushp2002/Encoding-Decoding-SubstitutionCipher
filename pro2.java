import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.io.FileNotFoundException;

public class pro2 {

	public static void main(String[] args) throws IOException {
		// TODO code application logic here
		char charac = 'Y';
		while (charac == 'Y') {
			System.out.println("Welcome To Cipher Program");
			System.out.println("Type 1 For Substitution Cipher");
			System.out.println("Type 2 For Shuffle Cipher");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();

			if (option == 1) {
				System.out.println("What is the key for your code?");
				int shift = sc.nextInt();
				SubstitutionCipher subscipher = new SubstitutionCipher(shift);
				System.out.println("Substitution Cipher-Shift Amount = " + shift);
				System.out.println("Enter Input File Name");
				String userInpFile = sc.next();
				System.out.println("Enter Output File Name");
				String userOutputFile = sc.next();
				System.out.println("Encode(E) or Decode(D)");
				char ch = sc.next().charAt(0);
				if (ch == 'E') {
					System.out.println("Encoded Text is Saved in " + userOutputFile);
					File file = new File(userInpFile);
					try {
						FileInputStream x = new FileInputStream(file);
						byte[] data = new byte[(int) file.length()];
						x.read(data);
						x.close();
						String str;
						str = new String(data, "UTF-8");

						String encodedThing = subscipher.encode(str);
						FileWriter barDekh = new FileWriter(userOutputFile);

						barDekh.write(encodedThing);
						barDekh.close();
						System.out.println("Do You Want To Do Another Message(Y) or (N)?");
						charac = sc.next().charAt(0);

					} catch (FileNotFoundException ex) {
						Logger.getLogger(Cipher.class.getName()).log(Level.SEVERE, null, ex);
					}
				} else if (ch == 'D') {
					System.out.println("Decoded Text is Saved in " + userOutputFile);
					File file = new File(userInpFile);
					try {
						FileInputStream x = new FileInputStream(file);
						byte[] data = new byte[(int) file.length()];
						x.read(data);
						x.close();
						String str;
						str = new String(data, "UTF-8");

						String decoded = subscipher.Decode(str);
						FileWriter output = new FileWriter(userOutputFile);

						output.write(decoded);
						output.close();
						System.out.println("Do You Want To Do Another Message(Y) or (N)?");
						charac = sc.next().charAt(0);

					} catch (FileNotFoundException ex) {
						Logger.getLogger(Cipher.class.getName()).log(Level.SEVERE, null, ex);
					}
				}

			} else if (option == 2) {
				System.out.println("What is the key for your code?");
				int shuffle = sc.nextInt();

				ShuffleCipher cipher = new ShuffleCipher(shuffle);
				System.out.println("Shuffle Cipher - Shuffle Amount = " + shuffle);
				System.out.println("Enter Input File Name");
				String inputFile = sc.next();
				System.out.println("Enter Output File Name");
				String outputFile = sc.next();
				System.out.println("Encode(E) or Decode(D)");
				char c = sc.next().charAt(0);
				if (c == 'E') {
					System.out.println("Encoded Text is Saved in " + outputFile);
					File file = new File(inputFile);
					try {
						FileInputStream x = new FileInputStream(file);
						byte[] stuff = new byte[(int) file.length()];
						x.read(stuff);
						x.close();
						String str;
						str = new String(stuff, "UTF-8");

						String encoded = cipher.encode(str);
						FileWriter output = new FileWriter(outputFile);

						output.write(encoded);
						output.close();
						System.out.println("Do You Want To Do Another Message(Y) or (N)?");
						charac = sc.next().charAt(0);

					} catch (FileNotFoundException ex) {
						Logger.getLogger(Cipher.class.getName()).log(Level.SEVERE, null, ex);
					}
				} else if (c == 'D') {
					System.out.println("Decoded Text is Saved in " + outputFile);
					File file = new File(inputFile);
					try {
						FileInputStream x = new FileInputStream(file);
						byte[] data = new byte[(int) file.length()];
						x.read(data);
						x.close();
						String str;
						str = new String(data, "UTF-8");

						String decoded = cipher.Decode(str);
						FileWriter output = new FileWriter(outputFile);

						output.write(decoded);
						output.close();
						System.out.println("Do You Want To Do Another Message(Y) or (N)?");
						charac = sc.next().charAt(0);

					} catch (FileNotFoundException ex) {
						Logger.getLogger(Cipher.class.getName()).log(Level.SEVERE, null, ex);
					}
				}

			}

		}

	}
}
