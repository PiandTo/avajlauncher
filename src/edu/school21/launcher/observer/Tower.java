package edu.school21.launcher.observer;

import edu.school21.launcher.models.Flyable;
import java.util.ArrayList;

 public abstract class Tower {
	ArrayList<Flyable> observers;

	public void register (Flyable flyable) {
		observers.add(flyable);
	}
	public void unregister (Flyable flyable) {
		observers.remove(flyable);
	}
	protected void conditionsChanged(){};
}
