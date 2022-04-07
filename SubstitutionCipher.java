public class SubstitutionCipher extends Cipher implements MessageEncoder, MessageDecoder {

	private int shift;

	public SubstitutionCipher(int shift) {
		this.shift = shift;
	}

	@Override
	String cipherType() {
		return "Substituion Cipher";
	}

	@Override
	public String encode(String plainText) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < plainText.length(); i+=1) {
			sb.append(ShiftChPositive(plainText.charAt(i)));
		}

		return sb.toString();

	}

	private char ShiftChPositive(char ch) {
		int asciiValue = (int) ch;
		asciiValue = asciiValue + this.shift;
		return (char) asciiValue;

	}



	private char ShiftChNegative(char ch) {
		int asciiValue = (int) ch;
		asciiValue = asciiValue - this.shift;
		return (char) asciiValue;
	}
	
	@Override
	public String Decode(String encodedText) {
		StringBuilder sb = new StringBuilder();

		for (int j = 0; j < encodedText.length(); j+=1) {
			sb.append(ShiftChNegative(encodedText.charAt(j)));
		}
		return sb.toString();
	}

}