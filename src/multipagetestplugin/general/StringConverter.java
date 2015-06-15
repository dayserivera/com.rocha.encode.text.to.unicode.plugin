package multipagetestplugin.general;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringConverter {

	private static Set<Character> caracteresEspeciais = new HashSet<Character>(
			Arrays.asList('�', '�', '�', '�', '�', '�', '�', '�', '�', '�',
					'�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�',
					'�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�',
					'�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�',
					'�', '&', '\''));

	public static String convertToUnicode(String input) {
		StringBuilder result = new StringBuilder();
		for (char caracter : input.toCharArray()) {
			if (caracteresEspeciais.contains(caracter)) {
				result.append(geraCodigoUnicode(caracter));
				continue;
			}
			result.append(caracter);
		}
		return result.toString();
	}

	public static String geraCodigoUnicode(char letra) {
		String hexa = Integer.toHexString((int) letra);

		String prefix;
		if (hexa.length() == 1) {
			prefix = "\\u000";
		} else if (hexa.length() == 2) {
			prefix = "\\u00";
		} else if (hexa.length() == 3) {
			prefix = "\\u0";
		} else {
			prefix = "\\u";
		}

		return prefix + hexa;
	}
}
