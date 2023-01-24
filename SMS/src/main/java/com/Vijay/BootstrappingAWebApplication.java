package com.Vijay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

@SpringBootApplication
public class BootstrappingAWebApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(BootstrappingAWebApplication.class, args);
	}

}
