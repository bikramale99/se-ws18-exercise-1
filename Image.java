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
public static void set(int x_factor, int y_factor, int val) {
		String st = hexVal + Integer.toHexString(val) ;
		System.out.println(st);
		//3 bytes per pixel throughout the width
		index = (y_factor*width+x_factor)*3;
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
//throws IOException
public void write(String filename) throws IOException {
	
	FileOutputStream fname = new FileOutputStream(filename);
	byte[] header = ("P3\n" + width + "\n" + height + "\n255\n").getBytes();
	fname.write(header);
	for(int i=0; i<data.length; i++)
			{
				out.write(data[i]);
			}
	fname.close();
}
}
