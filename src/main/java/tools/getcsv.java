package tools;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;

public class getcsv {
	private String firepath;
	private String nextLine[];
	private String value;
	List<String[]> approveList=new ArrayList<String[]>();
	CSVReader reader;
	
	public getcsv(String firepath) {
		this.firepath=firepath;
	}
	
	public String getCsvDate(String column,String row) {
		try {
			reader=new CSVReader(new FileReader(firepath));
			try {
				while((nextLine=reader.readNext()) != null) 
					{
					approveList.add(nextLine);
					}
				} 
			catch (IOException e) 
			{
				// TODO: handle exception
				e.printStackTrace();
			}
			
			//获取某一列
			int col=0;
			int ro=0;			
			for(String j:approveList.get(0)) 
			{
				col++;
				if(j.equals(column)) 
				{
					ro=col-1;
				}
			}			
			//获取某一行			
			for(String[] i:approveList) 
			{
				if(i[0].equals(row)) 
				{
					value=i[ro].toString();
				 }	
			}
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return value;
	}	
	
	public static void main(String[] args) {
		getcsv d=new getcsv("E:\\eclipse-workspace\\EHS\\src\\main\\java\\Lib\\loginPage.csv");
		int i;
		int a;
		System.out.println(d.getCsvDate("xpath","gj"));
//		System.out.println(d.getCsvDate("xpath","yuping_click"));
//		System.out.println(d.getCsvDate("xpath","yanshou_click"));
//		for(i=1; i<6;i++) {
//			System.out.println(d.getCsvDate("username", "t"+i));
//		}		
	}
}
