/**
 * 
 */
package com.flipkart.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Dell
 *
 */
public class ArrayListImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		to avoid typesave
//		List al = new ArrayList();
		List<String> a1 = new ArrayList<String>();
		a1.add("Mumbai");
		a1.add("Delhi");
		a1.add("Pune");
		a1.add("Pune");
		System.out.println("Print the size of collection " + a1.size());

		// remove the element from the collection
		a1.remove("Mumbai");
		System.out.println(a1.size());

		a1.remove(1);
		System.out.println(a1.size());

		// Iterate the collection
		// Iterator is interface which is using to iterate the Collection
		Iterator<String> i = a1.iterator();
		while (i.hasNext()) {

			String test = i.next();
			System.out.println("detals of Capital------>" + test);
		}

		// Another way to iterate the collection using for loop

		// Loop through elements.
		for (String value : a1) {
			System.out.println("Element: " + value);
		}

	}

}
