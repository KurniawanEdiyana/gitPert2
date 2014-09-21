import java.util.*;
import java.io.*;

public class barang
{
	public static void main (String [] args) throws IOException
	{
		{
			System.out.println("\n\n\t\t\t\t+++++SELAMAT DATANG DI PROGRAM PENCATATAN BARANG+++++\n");
			System.out.println("     \t\t\t\t\t     DISUSUN OLEH KELOMPOK IV              \n");
			System.out.println("\t\t\t\t      <<<<<<<==========================>>>>>>>\n\n");
			int pil=0;
			String jwb="";
			
				Scanner input = new Scanner(System.in);
				int bil=0;
				
				do
					{
					String nama;
					nama="Admin";
					int id = 12345;
					int pass = 123;
		
					System.out.print("Masukkan identitas anda = ");
					int identitas = input.nextInt();
					System.out.print("Masukkan Password = ");
					int password = input.nextInt();
						{
						if(id==identitas&&pass==password)
								System.out.println("Selamat Datang "+nama+" di program Pencatatan Barang Pada Gudang");
						else
							{
								System.out.println("Maaf Nomor Identitas atau Password yang anda masukkan salah");
								System.out.println("Ulangi Lagi tekan 1 keluar tekan 0 =");
								bil = input.nextInt();
							}
							
						}
					}while(bil==1);
			
				{
					LinkList theList = new LinkList(); // make list
					BufferedReader in=new BufferedReader (new InputStreamReader(System.in));
					String naber="";String iden="";
					String jum="";String find="";
					String jawab="";
					do
					{
					theList.displayMenu();
					System.out.print("Pilihan Anda : ");
					pil=input.nextInt();
					if(pil==1)
					{
						do
						{
							System.out.print("Masukkan Nama Barang = ");
							naber=in.readLine();
							System.out.print("Masukkan Kode Identitas Barang = ");
							iden=in.readLine();
							int identitas=Integer.parseInt(iden);
							System.out.print("Masukkan Jumlah Barang = ");
							jum=in.readLine();
							int jumlah=Integer.parseInt(jum);
							theList.insertFirst(identitas, jumlah, naber); // insert 4 items
							System.out.println("\n-<TABEL BARANG>-");
							theList.displayList(); // display list
							System.out.print("Apakah ingin Memasukkan Barang Lagi?[y/n] = ");
							jawab = in.readLine();
						}while(jawab.equals("y"));
					}
					else if(pil==2)
					{
						do
						{
							System.out.println("\n-<TABEL BARANG>-");
							theList.displayList(); // display list
							System.out.print("Masukkan ID Barang Untuk Menghapus Barang = ");
							iden=in.readLine();
							int identitas=Integer.parseInt(iden);
							Link f = theList.find(identitas); // find item
							if( f != null)
								{
								System.out.println("Barang dengan identitas "+identitas+" berhasil dihapus");
								Link d = theList.delete(identitas); // delete item
								}
							else
								System.out.println("Maaf Nomer Identitas Barang yang Anda Masukkan Salah");
							System.out.print("Apakah ingin Menghapus Barang Lagi?[y/n] = ");
							jawab = in.readLine();
						}while(jawab.equals("y"));
		
					}
					else if(pil==3)
						theList.displayList();
					else if(pil==4)
						System.exit(0);
				
					System.out.print("Apakah Ingin Mengulangi Program? [y/n]= ");
					jwb = in.readLine();
					}while (jwb.equals("y"));
			
				}
		}
	}
}


class Link
{
	public int iData; // data item (key)
	String dData2;
	public long dData; // data item
	
	public Link next; // next link in list
	// -------------------------------------------------------------
	public Link(int id, long dd, String dd2) // constructor
	{
		iData = id;
		dData = dd;
		dData2= dd2;
	}
	// -------------------------------------------------------------
	public void displayLink() // display ourself
	{
		System.out.println(iData +"\t\t"+ dData2+"\t\t\t"+dData);
	}
} // end class Link
////////////////////////////////////////////////////////////////
class LinkList
{
	private Link first; // ref to first link on list
	// -------------------------------------------------------------
	public LinkList() // constructor
	{
		first = null; // no links on list yet
	}
	// -------------------------------------------------------------
	public void insertFirst(int id, long dd, String dd2)
	{ 
		// make new link
		Link newLink = new Link(id, dd, dd2);
		newLink.next = first; // it points to old first link
		first = newLink; // now first points to this
	}
	// -------------------------------------------------------------
	public Link find(int key) // find link with given key
	{ 
		// (assumes non-empty list)
		Link current = first; // start at ‘first’
		while(current.iData != key) // while no match,
		{
			if(current.next == null) // if end of list,
			return null; // didn’t find it
			else // not end of list,
			current = current.next; // go to next link
		}
		return current; // found it
	}
	// -------------------------------------------------------------
	public Link delete(int key) // delete link with given key
	{ 
		// (assumes non-empty list)
		Link current = first; // search for link
		Link previous = first;
		while(current.iData != key)
		{
			if(current.next == null)
			return null; // didn’t find it
			else
			{
				previous = current; // go to next link
				current = current.next;
			}
		} // found it
		if(current == first) // if first link,
		first = first.next; // change first
		else // otherwise,
		previous.next = current.next; // bypass it
		return current;
	}
	// -------------------------------------------------------------
	public void displayMenu() // display the list
	{
		System.out.println("-<Menu Program>-");
		System.out.println("------------------");
		System.out.println("1. Tambah Barang < Barang Masuk >");
		System.out.println("2. Hapus Barang < Barang Keluar >");
		System.out.println("3. Lihat Barang ");
		System.out.println("4. Keluar Program");
		System.out.println("-----------------------");
		
		
	}
	//---------------------------------------------------------------------
	public void displayList() // display the list
	{
		System.out.print("\nId Barang\tNama Barang\t\tJumlah Barang\n");
		System.out.println("-------------------------------------------------------");
		System.out.println();
		Link current = first; // start at beginning of list
		while(current != null) // until end of list,
		{
			current.displayLink(); // print data
			current = current.next; // move to next link
		}
		System.out.println("");
	}
	// -------------------------------------------------------------
}