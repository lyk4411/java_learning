package examples100;

import java.util.ArrayList;

import java.util.List;

/**
 * 
 * @author boss
 * 
 * 
 * 
 *         create on : обнГ10:03:12 2009-5-19
 */

public class MainApp {

	public static void main(String[] args) {

		List<UnitClass> l = new ArrayList<UnitClass>();

		l.add(new UnitClass(2));

		l.add(new UnitClass(4));

		l.add(new UnitClass(10));

		l.add(new UnitClass(7));

		l.add(new UnitClass(20));

		HuffmanTreeFactory<UnitClass> factory = new HuffmanTreeFactory<UnitClass>(
				l);

		// System.out.println(factory.getHuffmanTree());

		factory.getHuffmanTree().printHuffmanCoderString();

	}

}