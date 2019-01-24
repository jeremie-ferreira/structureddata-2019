package com.epita.structureddata.converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.epita.structureddata.converter.domain.Station;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {
	
	private final static String DELIMITER = ";";

	public static void main(String[] args) throws IOException {
		// List<Station> stations = readData("C:\\work\\epita\\data\\liste-des-gares.csv");
		
		Gson gson = new Gson();
		
		File file = new File("C:\\work\\epita\\data\\liste-des-gares.json");
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		String json = reader.readLine();
		
		JsonArray array = new JsonParser().parse(json).getAsJsonArray();
		for (int i = 0; i < array.size(); ++i) {
			System.out.println(i);
			JsonObject obj = array.get(i).getAsJsonObject();
			JsonObject jsonStation = obj.get("fields").getAsJsonObject();
			//System.out.println(jsonStation.get("departement"));
			
			Station station = gson.fromJson(jsonStation, Station.class);
			
			System.out.println(station.getCommune());
			
		}
		
		gson.fromJson(json, Station.class);
		
	}
	
	private static List<Station> readData(String filepath) throws IOException {
		List<Station> stations = new ArrayList();
		
		File file = new File(filepath);
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		String line = reader.readLine();
		line = reader.readLine();
		
		
		while (line != null) {
			
			String[] data = line.split(DELIMITER);
			
			Station station = new Station();
			
			station.setCodeUic(Integer.parseInt(data[0]));
			station.setLibelleGare(data[1]);
			station.setFret(stringToBool(data[2]));
			station.setVoyageurs(stringToBool(data[3]));
			station.setCodeLigne(Integer.parseInt(data[4]));
			station.setRang(Integer.parseInt(data[5]));
			station.setPk(data[6]);
			
			stations.add(station);

			line = reader.readLine();
		}
		
		return stations;
	}
	
	private static Integer stringToPk(String s) {
		if(s.contains("+")) {
			String[] split = s.split("\\+");
			return Integer.parseInt(split[0]) * 1000 + Integer.parseInt(split[1]);
		} else {
			String[] split = s.split("\\-");
			return Integer.parseInt(split[0]) * 1000 - Integer.parseInt(split[1]);
		}
	}

	private static Boolean stringToBool(String s) {
		return s.equals("O");
	}
	
}
