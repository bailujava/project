package tv.buka.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class SecurityUtils {
	// AES 加密默认密钥
	public static String AESEncrypt(String plainText) {
		return new AES().runEncryptIntoHex(plainText).toLowerCase(); // 加密成16进制
	}

	// AES 解密默认密钥
	public static String AESDecrypt(String cipherText) {
		String result = null;
		try {
			result = new AES().runDecryptWithHex(cipherText.toUpperCase())
					.trim();
		} catch (Exception e) {
			result = null;
		}
		return result;
	}

	// AES 以字节为单位的字符串为输入，进行明文加密
	public static String AESEncrypt(String plainText, String key) {
		return new AES(key).runEncryptIntoHex(plainText); // 加密成16进制
	}

	// AES 以字节为单位的字符串为输入，进行密文解密
	public static String AESDecrypt(String cipherText, String key) {
		String result = null;
		try {
			result = new AES(key).runDecryptWithHex(cipherText).trim();
		} catch (Exception e) {
			result = null;
		}
		return result;
	}

	// MD5加密
	public static String MD5(String s) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] bytes = md.digest(s.getBytes("utf-8"));
			return toHex(bytes);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static String toHex(byte[] bytes) {
		final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
		StringBuilder ret = new StringBuilder(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
			ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
		}
		return ret.toString();
	}

	// 获取随即数
	public final static String getRandomNumber(int median) {
		Random random = new Random();
		StringBuffer rt = new StringBuffer();
		for (int i = 0; i < median; i++) {
			rt.append(random.nextInt(9));
		}
		return rt.toString();
	}

	// 获取随即数
	public final static String getRandomString(int median) {
		String str = "";
		Random random = new Random();
		for (int i = 0; i < median; i++) {
			boolean b = random.nextBoolean();
			if (b) { // 字符串
				// int choice = random.nextBoolean() ? 65 : 97; 取得65大写字母还是97小写字母
				str += (char) (65 + random.nextInt(26));// 取得大写字母
			} else { // 数字
				str += String.valueOf(random.nextInt(10));
			}
		}
		return str.toLowerCase();
	}



	private static final char[] legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
			.toCharArray();

	private static char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符
	'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f' };

	public static String Base64encode(byte[] data) {
		int start = 0;
		int len = data.length;
		StringBuffer buf = new StringBuffer(data.length * 3 / 2);

		int end = len - 3;
		int i = start;
		int n = 0;

		while (i <= end) {
			int d = ((((int) data[i]) & 0x0ff) << 16)
					| ((((int) data[i + 1]) & 0x0ff) << 8)
					| (((int) data[i + 2]) & 0x0ff);

			buf.append(legalChars[(d >> 18) & 63]);
			buf.append(legalChars[(d >> 12) & 63]);
			buf.append(legalChars[(d >> 6) & 63]);
			buf.append(legalChars[d & 63]);

			i += 3;

			if (n++ >= 14) {
				n = 0;
				buf.append(" ");
			}
		}

		if (i == start + len - 2) {
			int d = ((((int) data[i]) & 0x0ff) << 16)
					| ((((int) data[i + 1]) & 255) << 8);

			buf.append(legalChars[(d >> 18) & 63]);
			buf.append(legalChars[(d >> 12) & 63]);
			buf.append(legalChars[(d >> 6) & 63]);
			buf.append("=");
		} else if (i == start + len - 1) {
			int d = (((int) data[i]) & 0x0ff) << 16;

			buf.append(legalChars[(d >> 18) & 63]);
			buf.append(legalChars[(d >> 12) & 63]);
			buf.append("==");
		}

		return buf.toString();
	}

	public static byte[] Base64decode(String s) {

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			decode(s, bos);
		} catch (IOException e) {
			throw new RuntimeException();
		}
		byte[] decodedBytes = bos.toByteArray();
		try {
			bos.close();
			bos = null;
		} catch (IOException ex) {
			System.err.println("Error while decoding BASE64: " + ex.toString());
		}
		return decodedBytes;
	}

	private static void decode(String s, OutputStream os) throws IOException {
		int i = 0;

		int len = s.length();

		while (true) {
			while (i < len && s.charAt(i) <= ' ')
				i++;

			if (i == len)
				break;

			int tri = (decode(s.charAt(i)) << 18)
					+ (decode(s.charAt(i + 1)) << 12)
					+ (decode(s.charAt(i + 2)) << 6)
					+ (decode(s.charAt(i + 3)));

			os.write((tri >> 16) & 255);
			if (s.charAt(i + 2) == '=')
				break;
			os.write((tri >> 8) & 255);
			if (s.charAt(i + 3) == '=')
				break;
			os.write(tri & 255);

			i += 4;
		}
	}

	private static int decode(char c) {
		if (c >= 'A' && c <= 'Z')
			return ((int) c) - 65;
		else if (c >= 'a' && c <= 'z')
			return ((int) c) - 97 + 26;
		else if (c >= '0' && c <= '9')
			return ((int) c) - 48 + 26 + 26;
		else
			switch (c) {
			case '+':
				return 62;
			case '/':
				return 63;
			case '=':
				return 0;
			default:
				throw new RuntimeException("unexpected code: " + c);
			}
	}
}

class AES {
	// 16进制字符集
	private char[] charset = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'A', 'B', 'C', 'D', 'E', 'F' };
	// 变换各轮所用常数
	private byte[] constant = { 0x00 - 128, 0x01 - 128, 0x02 - 128, 0x04 - 128,
			0x08 - 128, 0x10 - 128, 0x20 - 128, 0x40 - 128, 0x80 - 128,
			0x1B - 128, 0x36 - 128, };
	// s盒
	private byte[] sBox = { 99 - 128, 124 - 128, 119 - 128, 123 - 128,
			242 - 128, 107 - 128, 111 - 128, 197 - 128, 48 - 128, 1 - 128,
			103 - 128, 43 - 128, 254 - 128, 215 - 128, 171 - 128, 118 - 128,
			202 - 128, 130 - 128, 201 - 128, 125 - 128, 250 - 128, 89 - 128,
			71 - 128, 240 - 128, 173 - 128, 212 - 128, 162 - 128, 175 - 128,
			156 - 128, 164 - 128, 114 - 128, 192 - 128, 183 - 128, 253 - 128,
			147 - 128, 38 - 128, 54 - 128, 63 - 128, 247 - 128, 204 - 128,
			52 - 128, 165 - 128, 229 - 128, 241 - 128, 113 - 128, 216 - 128,
			49 - 128, 21 - 128, 4 - 128, 199 - 128, 35 - 128, 195 - 128,
			24 - 128, 150 - 128, 5 - 128, 154 - 128, 7 - 128, 18 - 128,
			128 - 128, 226 - 128, 235 - 128, 39 - 128, 178 - 128, 117 - 128,
			9 - 128, 131 - 128, 44 - 128, 26 - 128, 27 - 128, 110 - 128,
			90 - 128, 160 - 128, 82 - 128, 59 - 128, 214 - 128, 179 - 128,
			41 - 128, 227 - 128, 47 - 128, 132 - 128, 83 - 128, 209 - 128,
			0 - 128, 237 - 128, 32 - 128, 252 - 128, 177 - 128, 91 - 128,
			106 - 128, 203 - 128, 190 - 128, 57 - 128, 74 - 128, 76 - 128,
			88 - 128, 207 - 128, 208 - 128, 239 - 128, 170 - 128, 251 - 128,
			67 - 128, 77 - 128, 51 - 128, 133 - 128, 69 - 128, 249 - 128,
			2 - 128, 127 - 128, 80 - 128, 60 - 128, 159 - 128, 168 - 128,
			81 - 128, 163 - 128, 64 - 128, 143 - 128, 146 - 128, 157 - 128,
			56 - 128, 245 - 128, 188 - 128, 182 - 128, 218 - 128, 33 - 128,
			16 - 128, 255 - 128, 243 - 128, 210 - 128, 205 - 128, 12 - 128,
			19 - 128, 236 - 128, 95 - 128, 151 - 128, 68 - 128, 23 - 128,
			196 - 128, 167 - 128, 126 - 128, 61 - 128, 100 - 128, 93 - 128,
			25 - 128, 115 - 128, 96 - 128, 129 - 128, 79 - 128, 220 - 128,
			34 - 128, 42 - 128, 144 - 128, 136 - 128, 70 - 128, 238 - 128,
			184 - 128, 20 - 128, 222 - 128, 94 - 128, 11 - 128, 219 - 128,
			224 - 128, 50 - 128, 58 - 128, 10 - 128, 73 - 128, 6 - 128,
			36 - 128, 92 - 128, 194 - 128, 211 - 128, 172 - 128, 98 - 128,
			145 - 128, 149 - 128, 228 - 128, 121 - 128, 231 - 128, 200 - 128,
			55 - 128, 109 - 128, 141 - 128, 213 - 128, 78 - 128, 169 - 128,
			108 - 128, 86 - 128, 244 - 128, 234 - 128, 101 - 128, 122 - 128,
			174 - 128, 8 - 128, 186 - 128, 120 - 128, 37 - 128, 46 - 128,
			28 - 128, 166 - 128, 180 - 128, 198 - 128, 232 - 128, 221 - 128,
			116 - 128, 31 - 128, 75 - 128, 189 - 128, 139 - 128, 138 - 128,
			112 - 128, 62 - 128, 181 - 128, 102 - 128, 72 - 128, 3 - 128,
			246 - 128, 14 - 128, 97 - 128, 53 - 128, 87 - 128, 185 - 128,
			134 - 128, 193 - 128, 29 - 128, 158 - 128, 225 - 128, 248 - 128,
			152 - 128, 17 - 128, 105 - 128, 217 - 128, 142 - 128, 148 - 128,
			155 - 128, 30 - 128, 135 - 128, 233 - 128, 206 - 128, 85 - 128,
			40 - 128, 223 - 128, 140 - 128, 161 - 128, 137 - 128, 13 - 128,
			191 - 128, 230 - 128, 66 - 128, 104 - 128, 65 - 128, 153 - 128,
			45 - 128, 15 - 128, 176 - 128, 84 - 128, 187 - 128, 22 - 128 };
	// 逆s盒
	private byte[] invSBox = { 82 - 128, 9 - 128, 106 - 128, 213 - 128,
			48 - 128, 54 - 128, 165 - 128, 56 - 128, 191 - 128, 64 - 128,
			163 - 128, 158 - 128, 129 - 128, 243 - 128, 215 - 128, 251 - 128,
			124 - 128, 227 - 128, 57 - 128, 130 - 128, 155 - 128, 47 - 128,
			255 - 128, 135 - 128, 52 - 128, 142 - 128, 67 - 128, 68 - 128,
			196 - 128, 222 - 128, 233 - 128, 203 - 128, 84 - 128, 123 - 128,
			148 - 128, 50 - 128, 166 - 128, 194 - 128, 35 - 128, 61 - 128,
			238 - 128, 76 - 128, 149 - 128, 11 - 128, 66 - 128, 250 - 128,
			195 - 128, 78 - 128, 8 - 128, 46 - 128, 161 - 128, 102 - 128,
			40 - 128, 217 - 128, 36 - 128, 178 - 128, 118 - 128, 91 - 128,
			162 - 128, 73 - 128, 109 - 128, 139 - 128, 209 - 128, 37 - 128,
			114 - 128, 248 - 128, 246 - 128, 100 - 128, 134 - 128, 104 - 128,
			152 - 128, 22 - 128, 212 - 128, 164 - 128, 92 - 128, 204 - 128,
			93 - 128, 101 - 128, 182 - 128, 146 - 128, 108 - 128, 112 - 128,
			72 - 128, 80 - 128, 253 - 128, 237 - 128, 185 - 128, 218 - 128,
			94 - 128, 21 - 128, 70 - 128, 87 - 128, 167 - 128, 141 - 128,
			157 - 128, 132 - 128, 144 - 128, 216 - 128, 171 - 128, 0 - 128,
			140 - 128, 188 - 128, 211 - 128, 10 - 128, 247 - 128, 228 - 128,
			88 - 128, 5 - 128, 184 - 128, 179 - 128, 69 - 128, 6 - 128,
			208 - 128, 44 - 128, 30 - 128, 143 - 128, 202 - 128, 63 - 128,
			15 - 128, 2 - 128, 193 - 128, 175 - 128, 189 - 128, 3 - 128,
			1 - 128, 19 - 128, 138 - 128, 107 - 128, 58 - 128, 145 - 128,
			17 - 128, 65 - 128, 79 - 128, 103 - 128, 220 - 128, 234 - 128,
			151 - 128, 242 - 128, 207 - 128, 206 - 128, 240 - 128, 180 - 128,
			230 - 128, 115 - 128, 150 - 128, 172 - 128, 116 - 128, 34 - 128,
			231 - 128, 173 - 128, 53 - 128, 133 - 128, 226 - 128, 249 - 128,
			55 - 128, 232 - 128, 28 - 128, 117 - 128, 223 - 128, 110 - 128,
			71 - 128, 241 - 128, 26 - 128, 113 - 128, 29 - 128, 41 - 128,
			197 - 128, 137 - 128, 111 - 128, 183 - 128, 98 - 128, 14 - 128,
			170 - 128, 24 - 128, 190 - 128, 27 - 128, 252 - 128, 86 - 128,
			62 - 128, 75 - 128, 198 - 128, 210 - 128, 121 - 128, 32 - 128,
			154 - 128, 219 - 128, 192 - 128, 254 - 128, 120 - 128, 205 - 128,
			90 - 128, 244 - 128, 31 - 128, 221 - 128, 168 - 128, 51 - 128,
			136 - 128, 7 - 128, 199 - 128, 49 - 128, 177 - 128, 18 - 128,
			16 - 128, 89 - 128, 39 - 128, 128 - 128, 236 - 128, 95 - 128,
			96 - 128, 81 - 128, 127 - 128, 169 - 128, 25 - 128, 181 - 128,
			74 - 128, 13 - 128, 45 - 128, 229 - 128, 122 - 128, 159 - 128,
			147 - 128, 201 - 128, 156 - 128, 239 - 128, 160 - 128, 224 - 128,
			59 - 128, 77 - 128, 174 - 128, 42 - 128, 245 - 128, 176 - 128,
			200 - 128, 235 - 128, 187 - 128, 60 - 128, 131 - 128, 83 - 128,
			153 - 128, 97 - 128, 23 - 128, 43 - 128, 4 - 128, 126 - 128,
			186 - 128, 119 - 128, 214 - 128, 38 - 128, 225 - 128, 105 - 128,
			20 - 128, 99 - 128, 85 - 128, 33 - 128, 12 - 128, 125 - 128 };
	// E表
	private byte[] eTable = { 1 - 128, 3 - 128, 5 - 128, 15 - 128, 17 - 128,
			51 - 128, 85 - 128, 255 - 128, 26 - 128, 46 - 128, 114 - 128,
			150 - 128, 161 - 128, 248 - 128, 19 - 128, 53 - 128, 95 - 128,
			225 - 128, 56 - 128, 72 - 128, 216 - 128, 115 - 128, 149 - 128,
			164 - 128, 247 - 128, 2 - 128, 6 - 128, 10 - 128, 30 - 128,
			34 - 128, 102 - 128, 170 - 128, 229 - 128, 52 - 128, 92 - 128,
			228 - 128, 55 - 128, 89 - 128, 235 - 128, 38 - 128, 106 - 128,
			190 - 128, 217 - 128, 112 - 128, 144 - 128, 171 - 128, 230 - 128,
			49 - 128, 83 - 128, 245 - 128, 4 - 128, 12 - 128, 20 - 128,
			60 - 128, 68 - 128, 204 - 128, 79 - 128, 209 - 128, 104 - 128,
			184 - 128, 211 - 128, 110 - 128, 178 - 128, 205 - 128, 76 - 128,
			212 - 128, 103 - 128, 169 - 128, 224 - 128, 59 - 128, 77 - 128,
			215 - 128, 98 - 128, 166 - 128, 241 - 128, 8 - 128, 24 - 128,
			40 - 128, 120 - 128, 136 - 128, 131 - 128, 158 - 128, 185 - 128,
			208 - 128, 107 - 128, 189 - 128, 220 - 128, 127 - 128, 129 - 128,
			152 - 128, 179 - 128, 206 - 128, 73 - 128, 219 - 128, 118 - 128,
			154 - 128, 181 - 128, 196 - 128, 87 - 128, 249 - 128, 16 - 128,
			48 - 128, 80 - 128, 240 - 128, 11 - 128, 29 - 128, 39 - 128,
			105 - 128, 187 - 128, 214 - 128, 97 - 128, 163 - 128, 254 - 128,
			25 - 128, 43 - 128, 125 - 128, 135 - 128, 146 - 128, 173 - 128,
			236 - 128, 47 - 128, 113 - 128, 147 - 128, 174 - 128, 233 - 128,
			32 - 128, 96 - 128, 160 - 128, 251 - 128, 22 - 128, 58 - 128,
			78 - 128, 210 - 128, 109 - 128, 183 - 128, 194 - 128, 93 - 128,
			231 - 128, 50 - 128, 86 - 128, 250 - 128, 21 - 128, 63 - 128,
			65 - 128, 195 - 128, 94 - 128, 226 - 128, 61 - 128, 71 - 128,
			201 - 128, 64 - 128, 192 - 128, 91 - 128, 237 - 128, 44 - 128,
			116 - 128, 156 - 128, 191 - 128, 218 - 128, 117 - 128, 159 - 128,
			186 - 128, 213 - 128, 100 - 128, 172 - 128, 239 - 128, 42 - 128,
			126 - 128, 130 - 128, 157 - 128, 188 - 128, 223 - 128, 122 - 128,
			142 - 128, 137 - 128, 128 - 128, 155 - 128, 182 - 128, 193 - 128,
			88 - 128, 232 - 128, 35 - 128, 101 - 128, 175 - 128, 234 - 128,
			37 - 128, 111 - 128, 177 - 128, 200 - 128, 67 - 128, 197 - 128,
			84 - 128, 252 - 128, 31 - 128, 33 - 128, 99 - 128, 165 - 128,
			244 - 128, 7 - 128, 9 - 128, 27 - 128, 45 - 128, 119 - 128,
			153 - 128, 176 - 128, 203 - 128, 70 - 128, 202 - 128, 69 - 128,
			207 - 128, 74 - 128, 222 - 128, 121 - 128, 139 - 128, 134 - 128,
			145 - 128, 168 - 128, 227 - 128, 62 - 128, 66 - 128, 198 - 128,
			81 - 128, 243 - 128, 14 - 128, 18 - 128, 54 - 128, 90 - 128,
			238 - 128, 41 - 128, 123 - 128, 141 - 128, 140 - 128, 143 - 128,
			138 - 128, 133 - 128, 148 - 128, 167 - 128, 242 - 128, 13 - 128,
			23 - 128, 57 - 128, 75 - 128, 221 - 128, 124 - 128, 132 - 128,
			151 - 128, 162 - 128, 253 - 128, 28 - 128, 36 - 128, 108 - 128,
			180 - 128, 199 - 128, 82 - 128, 246 - 128, 1 - 128 };
	// L表
	private byte[] lTable = { 0 - 128, 0 - 128, 25 - 128, 1 - 128, 50 - 128,
			2 - 128, 26 - 128, 198 - 128, 75 - 128, 199 - 128, 27 - 128,
			104 - 128, 51 - 128, 238 - 128, 223 - 128, 3 - 128, 100 - 128,
			4 - 128, 224 - 128, 14 - 128, 52 - 128, 141 - 128, 129 - 128,
			239 - 128, 76 - 128, 113 - 128, 8 - 128, 200 - 128, 248 - 128,
			105 - 128, 28 - 128, 193 - 128, 125 - 128, 194 - 128, 29 - 128,
			181 - 128, 249 - 128, 185 - 128, 39 - 128, 106 - 128, 77 - 128,
			228 - 128, 166 - 128, 114 - 128, 154 - 128, 201 - 128, 9 - 128,
			120 - 128, 101 - 128, 47 - 128, 138 - 128, 5 - 128, 33 - 128,
			15 - 128, 225 - 128, 36 - 128, 18 - 128, 240 - 128, 130 - 128,
			69 - 128, 53 - 128, 147 - 128, 218 - 128, 142 - 128, 150 - 128,
			143 - 128, 219 - 128, 189 - 128, 54 - 128, 208 - 128, 206 - 128,
			148 - 128, 19 - 128, 92 - 128, 210 - 128, 241 - 128, 64 - 128,
			70 - 128, 131 - 128, 56 - 128, 102 - 128, 221 - 128, 253 - 128,
			48 - 128, 191 - 128, 6 - 128, 139 - 128, 98 - 128, 179 - 128,
			37 - 128, 226 - 128, 152 - 128, 34 - 128, 136 - 128, 145 - 128,
			16 - 128, 126 - 128, 110 - 128, 72 - 128, 195 - 128, 163 - 128,
			182 - 128, 30 - 128, 66 - 128, 58 - 128, 107 - 128, 40 - 128,
			84 - 128, 250 - 128, 133 - 128, 61 - 128, 186 - 128, 43 - 128,
			121 - 128, 10 - 128, 21 - 128, 155 - 128, 159 - 128, 94 - 128,
			202 - 128, 78 - 128, 212 - 128, 172 - 128, 229 - 128, 243 - 128,
			115 - 128, 167 - 128, 87 - 128, 175 - 128, 88 - 128, 168 - 128,
			80 - 128, 244 - 128, 234 - 128, 214 - 128, 116 - 128, 79 - 128,
			174 - 128, 233 - 128, 213 - 128, 231 - 128, 230 - 128, 173 - 128,
			232 - 128, 44 - 128, 215 - 128, 117 - 128, 122 - 128, 235 - 128,
			22 - 128, 11 - 128, 245 - 128, 89 - 128, 203 - 128, 95 - 128,
			176 - 128, 156 - 128, 169 - 128, 81 - 128, 160 - 128, 127 - 128,
			12 - 128, 246 - 128, 111 - 128, 23 - 128, 196 - 128, 73 - 128,
			236 - 128, 216 - 128, 67 - 128, 31 - 128, 45 - 128, 164 - 128,
			118 - 128, 123 - 128, 183 - 128, 204 - 128, 187 - 128, 62 - 128,
			90 - 128, 251 - 128, 96 - 128, 177 - 128, 134 - 128, 59 - 128,
			82 - 128, 161 - 128, 108 - 128, 170 - 128, 85 - 128, 41 - 128,
			157 - 128, 151 - 128, 178 - 128, 135 - 128, 144 - 128, 97 - 128,
			190 - 128, 220 - 128, 252 - 128, 188 - 128, 149 - 128, 207 - 128,
			205 - 128, 55 - 128, 63 - 128, 91 - 128, 209 - 128, 83 - 128,
			57 - 128, 132 - 128, 60 - 128, 65 - 128, 162 - 128, 109 - 128,
			71 - 128, 20 - 128, 42 - 128, 158 - 128, 93 - 128, 86 - 128,
			242 - 128, 211 - 128, 171 - 128, 68 - 128, 17 - 128, 146 - 128,
			217 - 128, 35 - 128, 32 - 128, 46 - 128, 137 - 128, 180 - 128,
			124 - 128, 184 - 128, 38 - 128, 119 - 128, 153 - 128, 227 - 128,
			165 - 128, 103 - 128, 74 - 128, 237 - 128, 222 - 128, 197 - 128,
			49 - 128, 254 - 128, 24 - 128, 13 - 128, 99 - 128, 140 - 128,
			128 - 128, 192 - 128, 247 - 128, 112 - 128, 7 - 128 };

	// 密钥 以及默认值
	private byte[] key = { 0x00 - 128, 0x04 - 128, 0x08 - 128, 0x0c - 128,
			0x01 - 128, 0x05 - 128, 0x09 - 128, 0x0d - 128, 0x02 - 128,
			0x06 - 128, 0x0a - 128, 0x0e - 128, 0x03 - 128, 0x07 - 128,
			0x0b - 128, 0x0f - 128, };

	// 混合列矩阵
	private byte[][] matrix = {
			{ 0x02 - 128, 0x03 - 128, 0x01 - 128, 0x01 - 128 },
			{ 0x01 - 128, 0x02 - 128, 0x03 - 128, 0x01 - 128 },
			{ 0x01 - 128, 0x01 - 128, 0x02 - 128, 0x03 - 128 },
			{ 0x03 - 128, 0x01 - 128, 0x01 - 128, 0x02 - 128 } };
	// 混合列逆操作举证
	private byte[][] invMatrix = {
			{ 0x0e - 128, 0x0b - 128, 0x0d - 128, 0x09 - 128 },
			{ 0x09 - 128, 0x0e - 128, 0x0b - 128, 0x0d - 128 },
			{ 0x0d - 128, 0x09 - 128, 0x0e - 128, 0x0b - 128 },
			{ 0x0b - 128, 0x0d - 128, 0x09 - 128, 0x0e - 128 } };

	public AES(String key) {
		setKeyWithStr(key);
	}

	public AES() {
		setKeyWithStr("GB_g_ee_k_b_ea_n");
	}

	// 两个byte类型按位相与，返回结果
	private byte xorByte(byte a, byte b) {
		byte r;
		r = (byte) ((((int) a + 128) ^ ((int) b + 128)) - 128);
		return r;
	}

	// 以下表x，y为参数的s盒变换
	private byte substitute(int x, int y) {
		return sBox[x * 16 + y];
	}

	// 以byte为参数的s盒变换
	private byte substitute(byte inByte) {
		byte outByte;
		int x, y, val;
		val = (int) inByte + 128;
		x = val / 16;
		y = val - x * 16;
		outByte = sBox[x * 16 + y];
		return outByte;
	}

	// s盒逆变换
	private byte invSubstitute(byte inByte) {
		byte outByte;
		int x, y, val;
		val = (int) inByte + 128;
		x = val / 16;
		y = val - x * 16;
		outByte = invSBox[x * 16 + y];
		return outByte;
	}

	// 查E表
	private byte getETable(byte inByte) {
		byte outByte;
		int x, y, val;
		val = (int) inByte + 128;
		x = val / 16;
		y = val % 16;
		outByte = eTable[x * 16 + y];
		return outByte;
	}

	// 查L表
	private byte getLTable(byte inByte) {
		byte outByte;
		int x, y, val;
		val = (int) inByte + 128;
		x = val / 16;
		y = val - x * 16;
		outByte = lTable[x * 16 + y];
		return outByte;
	}

	// 利用伽利略场求乘积
	private byte product(byte a, byte b) {
		if (a == -128 || b == -128) {
			return (byte) (-128);
		}
		byte e, result;
		int val;
		val = getLTable(a) + 128 + getLTable(b) + 128;

		if (val > 255)
			val = val - 255;
		e = (byte) (val - 128);
		result = getETable(e);
		return result;
	}

	// 16进制转为字节
	private String hexToString(String hexStr) {
		int l = hexStr.length();
		byte[] bytes = new byte[l / 2];
		for (int i = 0; i < l / 2; i++) {
			char c1, c2;
			int a, b, v;
			c1 = hexStr.charAt(i * 2);
			c2 = hexStr.charAt(i * 2 + 1);
			if (c1 >= '0' && c1 <= '9') {
				a = c1 - '0';
			} else {
				a = c1 - 'A' + 10;
			}
			if (c2 >= '0' && c2 <= '9') {
				b = c2 - '0';
			} else {
				b = c2 - 'A' + 10;
			}
			v = a * 16 + b;
			bytes[i] = (byte) (v - 128);
		}
		String str = new String(bytes);
		return str;
	}

	// 字节转为16进制
	/*
	 * private String stringToHex(String str){ String hexStr=""; byte[]
	 * bytes=str.getBytes(); int l=bytes.length; for (int i=0;i<l;i++){
	 * hexStr+=charset[(bytes[i]+128)/16]; hexStr+=charset[(bytes[i]+128)%16]; }
	 * return hexStr; }
	 */
	// 16进制转为chars
	private String hexToChars(String hexStr) {
		String str = "";
		int l = hexStr.length();
		for (int i = 0; i < l / 2; i++) {
			char c1, c2;
			int a, b, v;
			c1 = hexStr.charAt(i * 2);
			c2 = hexStr.charAt(i * 2 + 1);
			if (c1 >= '0' && c1 <= '9') {
				a = c1 - '0';
			} else {
				a = c1 - 'A' + 10;
			}
			if (c2 >= '0' && c2 <= '9') {
				b = c2 - '0';
			} else {
				b = c2 - 'A' + 10;
			}
			v = a * 16 + b;
			str += (char) (v);
		}
		return str;
	}

	// chars转为16进制

	private String charsToHex(String str) {
		String hexStr = "";
		int l = str.length();
		int v;
		for (int i = 0; i < l; i++) {
			v = str.charAt(i);
			hexStr += charset[v / 16];
			hexStr += charset[v % 16];
		}
		return hexStr;
	}

	// 用字节导入密钥
	private boolean setKeyWithStr(String s) {
		int l = s.length();
		// 1 检查长度
		if (l != 16) {
			// System.out.println("密钥长度需为128位,即16字节");
			return false;
		}

		// 2 导入密钥
		for (int i = 0; i < 16; i++) {
			key[i] = (byte) (s.charAt(i) - 128);
		}
		return true;
	}

	// 以16字明文块为输入，进行aes加密，输出为加密后的16进制密文
	private String encrypt(byte[] plainText) {
		// 一次性初始化处理
		// 扩展16字节密钥
		String cipherText = "";
		byte[] temp = new byte[4];
		byte[][][] keyEx = new byte[11][4][4];
		byte[][] state, nextState;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					keyEx[0][j][k] = key[j * 4 + k];
				}
			}
		}
		for (int i = 1; i < 11; i++) {
			for (int j = 0; j < 4; j++) {
				// 索引为4的倍数的情况
				if (j == 0) {
					// rotate
					temp[0] = keyEx[i - 1][1][3];
					temp[1] = keyEx[i - 1][2][3];
					temp[2] = keyEx[i - 1][3][3];
					temp[3] = keyEx[i - 1][0][3];
					// Substitute
					for (int si = 0; si < 4; si++) {
						int x, y, val;
						val = (int) temp[si] + 128;
						x = val / 16;
						y = val - x * 16;
						temp[si] = substitute(x, y);

					}
					// xor Constant
					temp[0] = xorByte(temp[0], constant[i]);
				} else {
					// 索引不为4的倍数的情况
					// tmp
					temp[0] = keyEx[i][0][j - 1];
					temp[1] = keyEx[i][1][j - 1];
					temp[2] = keyEx[i][2][j - 1];
					temp[3] = keyEx[i][3][j - 1];
				}
				// w[i-4] xor tmp
				keyEx[i][0][j] = xorByte(keyEx[i - 1][0][j], temp[0]);
				keyEx[i][1][j] = xorByte(keyEx[i - 1][1][j], temp[1]);
				keyEx[i][2][j] = xorByte(keyEx[i - 1][2][j], temp[2]);
				keyEx[i][3][j] = xorByte(keyEx[i - 1][3][j], temp[3]);
			}
		}

		// 16字节明文块的一次性初始化
		state = new byte[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				state[i][j] = plainText[i * 4 + j];
			}
		}

		// state数组与密钥块进行XOR运算
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				state[i][j] = xorByte(state[i][j], keyEx[0][i][j]);
			}
		}

		// 轮次开始
		for (int rounds = 1; rounds <= 10; rounds++) {
			// a 对每个明文字节应用S盒 checked
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					state[i][j] = substitute(state[i][j]);
				}
			}
			// show(state);

			// b 把明文块的k行旋转k个字节 checked
			for (int k = 0; k < 4; k++) {
				byte swapByte;
				for (int l = 0; l < k; l++) {
					swapByte = state[k][0];
					for (int m = 0; m < 3; m++) {
						state[k][m] = state[k][m + 1];
					}
					state[k][3] = swapByte;
				}
			}
			// show(state);
			// c 进行混合列操作 checked
			nextState = new byte[4][4];
			if (rounds != 10) {
				for (int j = 0; j < 4; j++) {
					for (int i = 0; i < 4; i++) {
						nextState[i][j] = xorByte(
								product(state[0][j], matrix[i][0]),
								product(state[1][j], matrix[i][1]));
						nextState[i][j] = xorByte(nextState[i][j],
								product(state[2][j], matrix[i][2]));
						nextState[i][j] = xorByte(nextState[i][j],
								product(state[3][j], matrix[i][3]));
					}
				}
			} else {
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						nextState[i][j] = state[i][j];
					}
				}
			}
			// d 把state数组与密钥块进行XOR运算 checked
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					state[i][j] = xorByte(nextState[i][j], keyEx[rounds][i][j]);
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int x, y, val;
				val = (int) state[i][j] + 128;
				x = val / 16;
				y = val % 16;
				cipherText += charset[x];
				cipherText += charset[y];
			}
		}
		return cipherText;
	}

	// 以16字节密文块为输入，进行aes解密，输出为解密后的16进制明文
	private String decrypt(byte[] cipherText) {
		String plainText = "";
		byte[] temp = new byte[4];
		byte[][][] keyEx = new byte[11][4][4];
		byte[][] state, nextState;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					keyEx[0][j][k] = key[j * 4 + k];
				}
			}
		}
		for (int i = 1; i < 11; i++) {
			for (int j = 0; j < 4; j++) {
				// 索引为4的倍数的情况
				if (j == 0) {
					// rotate
					temp[0] = keyEx[i - 1][1][3];
					temp[1] = keyEx[i - 1][2][3];
					temp[2] = keyEx[i - 1][3][3];
					temp[3] = keyEx[i - 1][0][3];
					// Substitute
					for (int si = 0; si < 4; si++) {
						int x, y, val;
						val = (int) temp[si] + 128;
						x = val / 16;
						y = val - x * 16;
						temp[si] = substitute(x, y);

					}
					// xor Constant
					temp[0] = xorByte(temp[0], constant[i]);
				} else {
					// 索引不为4的倍数的情况
					// tmp
					temp[0] = keyEx[i][0][j - 1];
					temp[1] = keyEx[i][1][j - 1];
					temp[2] = keyEx[i][2][j - 1];
					temp[3] = keyEx[i][3][j - 1];
				}
				// w[i-4] xor tmp
				keyEx[i][0][j] = xorByte(keyEx[i - 1][0][j], temp[0]);
				keyEx[i][1][j] = xorByte(keyEx[i - 1][1][j], temp[1]);
				keyEx[i][2][j] = xorByte(keyEx[i - 1][2][j], temp[2]);
				keyEx[i][3][j] = xorByte(keyEx[i - 1][3][j], temp[3]);
			}
		}

		// 16字节密文块的一次性初始化
		state = new byte[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				state[i][j] = cipherText[i * 4 + j];
			}
		}

		// state数组与密钥块进行XOR运算
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				state[i][j] = xorByte(state[i][j], keyEx[10][i][j]);
			}
		}
		// show(state);
		// 轮次开始
		for (int rounds = 9; rounds >= 0; rounds--) {
			// a 逆旋转
			for (int k = 0; k < 4; k++) {
				byte swapByte;
				for (int l = 0; l < k; l++) {
					swapByte = state[k][3];
					for (int m = 3; m > 0; m--) {
						state[k][m] = state[k][m - 1];
					}
					state[k][0] = swapByte;
				}
			}
			// b 逆s盒变换
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					state[i][j] = invSubstitute(state[i][j]);
				}
			}
			// c 与密钥块xor
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					state[i][j] = xorByte(state[i][j], keyEx[rounds][i][j]);
				}
			}
			// d 混合列逆操作
			nextState = new byte[4][4];
			if (rounds != 0) {
				for (int j = 0; j < 4; j++) {
					for (int i = 0; i < 4; i++) {
						nextState[i][j] = xorByte(
								product(state[0][j], invMatrix[i][0]),
								product(state[1][j], invMatrix[i][1]));
						nextState[i][j] = xorByte(nextState[i][j],
								product(state[2][j], invMatrix[i][2]));
						nextState[i][j] = xorByte(nextState[i][j],
								product(state[3][j], invMatrix[i][3]));
					}
				}
				for (int j = 0; j < 4; j++) {
					for (int i = 0; i < 4; i++) {
						state[i][j] = nextState[i][j];
					}
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int x, y, val;
				val = (int) state[i][j] + 128;
				x = val / 16;
				y = val % 16;
				plainText += charset[x];
				plainText += charset[y];
			}
		}
		return plainText;

	}

	// 以16进制字符串为输入，进行明文加密

	public String runEncryptIntoHex(String plainText) {
		byte[] plainTextByte = plainText.getBytes();
		String cipherText = "";
		int l = plainTextByte.length;
		byte[] plainTextBlock = new byte[16];
		int pos = 0;
		while (pos < l) {
			for (int i = 0; i < 16; i++) {
				if (pos < l) {
					plainTextBlock[i] = plainTextByte[pos];
				} else {
					plainTextBlock[i] = (byte) (' ');
				}
				pos++;
			}
			cipherText += encrypt(plainTextBlock);
		}
		return cipherText;
	}

	/*
	 * String runEncryptIntoHex(String plainText){ String cipherText=""; byte[]
	 * plainTextByte=plainText.getBytes(); int l=plainText.length(); byte[]
	 * plainTextBlock=new byte[16]; int pos=0; while(pos<l){ for (int
	 * i=0;i<16;i++){ if (pos<l){
	 * plainTextBlock[i]=(byte)(plainText.charAt(pos)-128);
	 * System.out.print(plainTextBlock[i]); System.out.print(" ");
	 * System.out.println(plainTextByte[pos]); }else{
	 * plainTextBlock[i]=(byte)(' '-128); } pos++; }
	 * cipherText+=encrypt(plainTextBlock); } return cipherText; }
	 */
	// 以字节为单位的字符串为输入，进行明文加密
	public String runEncryptIntoStr(String plainText) {
		String cipherText;
		String cipherTextStr;
		cipherText = runEncryptIntoHex(plainText);
		cipherTextStr = hexToChars(cipherText);
		return cipherTextStr;
	}

	// 以16进制字符串为输入，进行密文解密
	public String runDecryptWithHex(String cipherText) {
		String plainText = "";
		int l = cipherText.length();
		byte[] cipherTextBlock = new byte[16];
		int pos = 0;
		while (pos < l) {
			for (int i = 0; i < 16; i++) {
				int a, b;
				a = cipherText.charAt(pos);
				b = cipherText.charAt(pos + 1);
				if (a >= '0' && a <= '9') {
					a = a - '0';
				} else {
					a = a - 'A' + 10;
				}
				if (b >= '0' && b <= '9') {
					b = b - '0';
				} else {
					b = b - 'A' + 10;
				}
				cipherTextBlock[i] = (byte) (a * 16 + b - 128);
				pos += 2;
			}
			plainText += hexToString(decrypt(cipherTextBlock));
		}
		return plainText;
	}

	// 以字节为单位的字符串为输入，进行密文解密
	public String runDecryptWithStr(String cipherText) {
		System.out.println(cipherText);
		String cipherTextHex;
		String plainText = "";
		cipherTextHex = charsToHex(cipherText);
		plainText = runDecryptWithHex(cipherTextHex);
		return plainText;
	}

}
