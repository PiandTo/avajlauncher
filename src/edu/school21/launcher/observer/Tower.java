package edu.school21.launcher.observer;

import edu.school21.launcher.models.Aircraft;
import edu.school21.launcher.models.Flyable;

import java.io.IOException;
import java.util.ArrayList;

 public abstract class Tower {
	private ArrayList<Flyable> observers = new ArrayList<>();

	public void register (Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister (Flyable flyable) {
		observers.remove(observers.indexOf(flyable));
	}

	protected void conditionsChanged() throws IOException {
		ArrayList<Flyable> arr = new ArrayList<>(observers);
//		for (int i = 0; i < arr.size(); i++)
//			arr.get(i).updateConditions();
		arr.forEach(n -> {
			try {
				n.updateConditions();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	};
}

