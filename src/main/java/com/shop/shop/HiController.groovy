package com.shop.shop

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
@Controller
@EnableAutoConfiguration
class HiController {
    private static String src = "TestAES";
    @RequestMapping("/login")
    String login(){
        return 'login'
    }
    static void AES(){
        //生成Key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES")
        keyGenerator.init(128, new SecureRandom('123'.getBytes()));
        //使用上面这种初始化方法可以特定种子来生成密钥，这样加密后的密文是唯一固定的。
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] keyBytes = secretKey.getEncoded();

        //Key转换
        Key key = new SecretKeySpec(keyBytes, "AES");
        println 'Key:'+  Hex.toHexString(new String(key.encoded).getBytes())
        //加密
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encodeResult = cipher.doFinal(src.getBytes());
        System.out.println("AESencode : " + Hex.toHexString(encodeResult) );

        //解密
//        Key key1 = new SecretKeySpec('539114eee1bffe2a054c4991bed59fd4'?.getBytes(),'AES')
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodeResult = cipher.doFinal(encodeResult);
        System.out.println("AESdecode : " + new String (decodeResult));

    }

    static void main(String[] args){
        AES()
    }
}
