import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


/**
 * 
 * @author Alone
 *
 */
public class AESCryptoSecurity 
{

	public AESCryptoSecurity() 
	{
		
	}

	/**
	 * 加密
	 * @param content 需要加密的内容
	 * @param keyWord  加密密钥
	 * @return byte[] 加密后的字节数组
	 */
	public static byte[] encrypt(final byte[] content, final String keyWord)
	{
		try 
		{
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(keyWord.getBytes());
			kgen.init(128, secureRandom);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(content);
			return result; // 加密
		} 
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		} 
		catch (NoSuchPaddingException e)
		{
			e.printStackTrace();
		} 
		catch (InvalidKeyException e)
		{
			e.printStackTrace();
		} 
		catch (IllegalBlockSizeException e)
		{
			e.printStackTrace();
		} 
		catch (BadPaddingException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param content 需要加密的内容
	 * @param password 加密密钥
	 * @return String 加密后的字符串
	 */
	public static String encrypt(final String content, final String password)
	{
		String encryptStr = null;
		try 
		{
			encryptStr = AESCryptoSecurity.parseByte2HexStr(AESCryptoSecurity.encrypt(content.getBytes("utf-8"), password));
		} 
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return encryptStr;
	}


	/**
	 * 解密
	 * @param content 待解密内容
	 * @param keyWord 解密密钥
	 * @return byte[]
	 */
	public static byte[] decrypt(final byte[] content, final String keyWord)
	{
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(keyWord.getBytes());
			kgen.init(128, secureRandom);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(content);
			return result; // 加密
		} 
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		} 
		catch (NoSuchPaddingException e)
		{
			e.printStackTrace();
		} 
		catch (InvalidKeyException e)
		{
			e.printStackTrace();
		}
		catch (IllegalBlockSizeException e)
		{
			e.printStackTrace();
		} 
		catch (BadPaddingException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param content 待解密内容(字符串)
	 * @param keyWord 解密密钥
	 * @return byte[]
	 */
	public static String decrypt(final String content, final String keyWord)
	{
		byte[] btVals = AESCryptoSecurity.decrypt(AESCryptoSecurity.parseHexStr2Byte(content), keyWord);
		if (btVals != null)
		{
			return new String(btVals);
		}
		return null;
	}

	/**
	 * 将二进制转换成16进制
	 * @param buf
	 * @return String
	 */
	public static String parseByte2HexStr(final byte buf[])
	{
		StringBuffer sb = new StringBuffer();
		for (byte element : buf) 
		{
			String hex = Integer.toHexString(element & 0xFF);
			if (hex.length() == 1) 
			{
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 将16进制转换为二进制
	 * @param hexStr
	 * @return byte[]
	 */
	public static byte[] parseHexStr2Byte(final String hexStr)
	{
		if (hexStr.length() < 1) 
		{
            return null;
        }
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) 
		{
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
					16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		String encryptStr = AESCryptoSecurity.encrypt("1", "abd4f551bccc4dc3b7887edb8cdcb2dc");
		System.out.println(encryptStr.toLowerCase());
		System.out.println(encryptStr.length());
		String result = AESCryptoSecurity.decrypt(encryptStr, "abd4f551bccc4dc3b7887edb8cdcb2dc");
		System.out.println(result);
	}
}