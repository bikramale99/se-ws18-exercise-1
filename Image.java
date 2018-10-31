import java.io.FileOutputStream;
import java.io.IOException;

public class Image
{
	

	public static int width;
	public static int height;
	public static byte  [] data;   // byte array to stores the binary image data
	static int index;
	static String hexVal = "0x";

//constructor to create image object with height and width	
	public Image(int width, int height) {
		Image.width = width;
		Image.height = height;
		data = new byte[3*height*width];
			
	}
//sets method to set the signle pixel to the RGB values
public static void set(int x-factor, int y-factor, int val) {
		String st = hexVal + Integer.toHexString(val) ;
		System.out.println(st);
		//3 bytes per pixel throughout the width
		index = (y-factor*width+x-factor)*3;
		int count=0; 
		int sub1=2; 
		int sub2=4;
		
		while (count <= 2 )
		{
		String substr = st.substring(sub1, sub2);
		data [index + count] = (byte) Integer.parseInt(substr, 16);		
		count++;
		sub1 = sub2;
		sub2 +=2;
		}
	
}
//a method to write image data into file

public void write(String filename) throws IOException {
	
	FileOutputStream out = new FileOutputStream(filename);
	//writes header file for the image with specified height and width
	byte[] header = ("P3\n" + width + "\n" + height + "\n255\n").getBytes();
	out.write(header);
	//Writes throughout the image for pixel value
	for(int i=0; i<data.length; i++)
			{
				out.write(data[i]);
			}
	out.close();
}
}
