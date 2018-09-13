package model;

import java.util.List;

public class PostMutterLogic {

	public void post(List<Mutter> list, Mutter mutter) {
		list.add(0, mutter);
	}

}
