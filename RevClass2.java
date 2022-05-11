package test;

import java.util.ArrayList;
import java.sql.Date;

public class RevClass2 {

	private ArrayList<String> fname;
	private ArrayList<String> bid;
	private ArrayList<String> oid;
	private ArrayList<String> odate;
	private ArrayList<String> quantity;
	// total per order
	// sum of all total per order
	private ArrayList<String> fn;
	private ArrayList<String> ln;
	// for historicalprice

	// functions
	RevClass2() {
		bid = new ArrayList<String>();
		oid = new ArrayList<String>();
		odate = new ArrayList<String>();
		quantity = new ArrayList<String>();
		fn = new ArrayList<String>();
		ln = new ArrayList<String>();
	}

	public void addReportdates(String od, String bd, String fin, String lin, String d) {
		bid.add(bd);
		oid.add(od);
		odate.add(d);
		fn.add(fin);
		ln.add(lin);
	}

	public ArrayList<String> getfname() {
		return fname;
	}

	public ArrayList<String> getbid() {
		return bid;
	}

	public ArrayList<String> getoid() {
		return oid;
	}

	public ArrayList<String> getodate() {
		return odate;
	}

	public ArrayList<String> getquantity() {
		return quantity;
	}

	public ArrayList<String> getfn() {
		return fn;
	}

	public ArrayList<String> getln() {
		return ln;
	}

}