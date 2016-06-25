package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.Catalog;
import domain.Content;
import domain.User;

public class ContentServiceImple implements ContentService {
	private static List<Content> list = new ArrayList<Content>();
	static{
		Catalog cat1 = new Catalog(1l, "Auto");
		list.add(new Content(1l,"1nghg", cat1, null, null));
		list.add(new Content(2l,"2nghg", cat1, null, null));
		list.add(new Content(3l,"3nghg", cat1, null, null));
		list.add(new Content(4l,"4nghg", cat1, null, null));		

	}
	@Override
	public List<Content> getAllcontents() {
		return list;
	}

}
