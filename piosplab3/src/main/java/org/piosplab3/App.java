package org.piosplab3;

import java.io.IOException;

/*import java.util.List;
import java.util.Random;
import java.util.stream.LongStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;*/


public class App 
{
	//private static final File storageFile = new File("serial.data");
	
    public static void main( String[] args ) throws IOException, ClassNotFoundException
    {
    	BigDecimalsRepository bg = new BigDecimalsRepository();
    	bg.options();
    	/*BigInteger fiveThousand = new BigInteger("5000");
    	BigInteger fiftyThousand = new BigInteger("50000");
    	BigInteger fiveHundredThousand =
    	new BigInteger("500000");
    	BigInteger total = BigInteger.ZERO;
    	total = total.add(fiveThousand);
    	total = total.add(fiftyThousand);
    	total = total.add(fiveHundredThousand);
    	System.out.println(total);
    	List<BigDecimal> listofdecimals = new ArrayList<BigDecimal>();
    	listofdecimals.add(0,new BigDecimal("100"));
    	listofdecimals.add(1,new BigDecimal("1000"));
    	listofdecimals.add(2,new BigDecimal("10000"));
    	listofdecimals.add(3,new BigDecimal("100000"));
    	listofdecimals.add(new BigDecimal("1000000"));
    	
    	for(BigDecimal a : listofdecimals) {
    		System.out.println(a);
    	}
    	//BigDecimal bg = ;
    	//Minim 5 elemente
    	//System.out.println(Math.round(0.1*5));
    	
    	listofdecimals.stream().sorted(Comparator.reverseOrder()).limit(Math.round(0.1*listofdecimals.size())).forEach(System.out::println);
    	BigDecimal bg1= listofdecimals.stream().reduce(BigDecimal::add).get();
    	System.out.println(bg1);
    	BigDecimal bg2 = bg1.divide(new BigDecimal(listofdecimals.size()));
    	System.out.println(bg2);
    	
    	File storageFile = new File("C:\\Users\\altex\\\\Desktop\\maven-samples-master\\piosplab3\\ceva.txt");
    	try {
			storageFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//Random random = new Random(listofdecimals.size());
    	 try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(storageFile))) {
             out.writeLong(listofdecimals.size());
             //LongStream.rangeClosed(1, listofdecimals.size())
             listofdecimals.stream()
             		 //.map()
             		 //.map(x -> random.nextLong())
                     //.mapToObj(BigDecimal::valueOf)
                     .forEach(value -> {
                         try {
                             out.writeUnshared(value);
                             out.flush();
                         } catch (IOException e) {
                             e.printStackTrace();
                         }
                     });
         }
    	 
    	 try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(storageFile)))) {
             BigDecimal value;
             long recoveredSize = in.readLong();
             while (recoveredSize-- > 0) {
                 System.out.println((BigDecimal)in.readUnshared());
             }
    	 }*/

    	//System.out.println(listofdecimals.stream().reduce(BigDecimal::add));
    }
}
