public class ShuffleCipher extends Cipher implements MessageEncoder, MessageDecoder {
	
	
	private int NoShuffle;

	public ShuffleCipher(int NoShuffle) {
		this.NoShuffle = NoShuffle;
	}

	@Override
	String cipherType() {
		return "Shuffle Cipher";
	}

	@Override
	public String encode(String emptyTxt) {
		String encodedString = "";
		encodedString = performShuffle(emptyTxt);
		for (int i = 0; i < this.NoShuffle - 1; i += 1) {
			encodedString = performShuffle(encodedString);

		}

		return encodedString;

	}

	private String performShuffle(String txt) {
		StringBuilder sb = new StringBuilder();
		int half = -1;
		if (txt.length() % 2 == 0) {
			half = txt.length() / 2;

		} else {
			half = txt.length() / 2 + 1;
		}
		int j = half + 1;
		for (int i = 0; i <= half; i++) {
			sb.append(txt.charAt(i));

			if (j < txt.length()) {
				sb.append(txt.charAt(j));
				j++;
			}

		}
		return sb.toString();

	}

	private String performUnshuffle(String txt) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < txt.length(); i += 2) {
			sb.append(txt.charAt(i));
		}
		for (int i = 1; i < txt.length(); i += 2) {
			sb.append(txt.charAt(i));
		}
		return sb.toString();
	}

	@Override
	public String Decode(String encodedText) {

		String decodedText = performUnshuffle(encodedText);

		for (int i = 0; i < this.NoShuffle - 1; i += 1) {
			decodedText = performUnshuffle(decodedText);
		}

		return decodedText;

	}
}