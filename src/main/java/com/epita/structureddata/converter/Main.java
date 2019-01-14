package com.epita.structureddata.converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.epita.structureddata.converter.domain.Station;

public class Main {
	
	private final static String DELIMITER = ";";

	public static void main(String[] args) throws IOException {
		List<Station> stations = readData("C:\\work\\epita\\data\\liste-des-gares.csv");
		
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
			station.setPk(stringToPk(data[6]));
			
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
