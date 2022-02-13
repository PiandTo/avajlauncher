package edu.school21.launcher.observer;

import edu.school21.launcher.models.Aircraft;
import edu.school21.launcher.models.Flyable;
import java.util.ArrayList;

 public abstract class Tower {
	private ArrayList<Flyable> observers = new ArrayList<>();

	public void register (Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister (Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionsChanged(){
		observers.forEach((n) -> n.updateConditions());
	};
}
