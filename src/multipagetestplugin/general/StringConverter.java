package multipagetestplugin.general;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringConverter {

	private static Set<Character> caracteresEspeciais = new HashSet<Character>(
			Arrays.asList('á', 'à', 'â', 'ã', 'ä', 'Á', 'À', 'Â', 'Ã', 'Ä',
					'é', 'è', 'ê', 'ê', 'É', 'È', 'Ê', 'Ë', 'í', 'ì', 'î', 'ï',
					'Í', 'Ì', 'Î', 'Ï', 'ó', 'ò', 'ô', 'õ', 'ö', 'Ó', 'Ò', 'Ô',
					'Õ', 'Ö', 'ú', 'ù', 'û', 'ü', 'Ú', 'Ù', 'Û', 'ç', 'Ç', 'ñ',
					'Ñ', '&', '\''));

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
